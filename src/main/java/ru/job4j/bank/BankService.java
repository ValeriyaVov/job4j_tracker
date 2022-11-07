package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковских переводов
 * @author Valeriya Vovnenko
 */
public class BankService {
    /**
     * Хранение пользователей осуществляется в коллекции типа HashMap
     * Это поле содержит всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему
     * @param user пользватель, который записывается в массив
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый счет к пользователю
     * Находим пользователя по паспорту, получаем список всех счетов пользователя
     * и добавляем к ним новый счет, в случае, если у пользователя такого счета еще нет
     * @param passport паспорт пользователя
     * @param account аккаунт представляет из себя реквизиты и баланс
     */
    public void addAccount(String passport, Account account) {
       User user = findByPassport(passport);
       if (user != null) {
           List<Account> accounts = users.get(user);
           if (!accounts.contains(account)) {
               accounts.add(account);
           }
       }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * @param passport паспорт пользователя
     * @return возвращает пользвателя или null если пользователь не был найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     * @param passport паспорт пользователя
     * @param requisite реквизиты пользователя
     * @return возвращает счет пользвателя или null если счет не был найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }

        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт
     * @param srcPassport паспорт отправителя
     * @param srcRequisite реквизиты отправителя
     * @param destPassport паспорт получателя
     * @param destRequisite реквизиты получателя
     * @param amount сумма перевода
     * @return возвращает true если транзакция прошла успешно, или
     * false если счёт не найден или не хватает денег на счёте srcAccount(с которого переводят)
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, destRequisite);
        boolean rsl = false;
        if (accountSrc != null && accountDest != null && accountSrc.getBalance() >= amount) {
            accountSrc.setBalance(accountSrc.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод предназначен для получения списка счетов пользователя
     * @param user пользователь
     * @return возвращает список счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
