package ru.job4j.inheritance;

import ru.job4j.inheritance.JSONReport;

public class ReportUsage {
    public static void main(String[] args) {
        JSONReport report = new JSONReport();
        String text = report.generate("name", "body");
        System.out.println(text);
    }
}
