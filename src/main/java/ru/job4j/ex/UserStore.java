package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (User i : users) {
            if (i.getUsername().equals(login)) {
                rsl = i;
                break;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("User not found");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean rsl;
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User is not valid");
        }
        return true;
    }

    public static void main(String[] args) throws UserNotFoundException {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException iv) {
            System.out.println("Пользователь не валидный");
        } catch (UserNotFoundException nf) {
            System.out.println("Пользователя не найдено");
        }
    }
}
