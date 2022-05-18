package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Акимов Борис Леонидович");
        student.setGroup(413);
        student.setDate(new Date());

        System.out.println(student.getFullName() + " studying in a group: " + student.getGroup());
    }
}
