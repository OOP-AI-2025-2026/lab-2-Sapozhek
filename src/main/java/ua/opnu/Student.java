package ua.opnu;

import java.util.ArrayList;

public class Student {
    private String name;
    private int year;
    private ArrayList<String> courses;

    // Конструктор
    public Student(String name, int year) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Ім'я не може бути порожнім");
        }
        if (year < 1 || year > 4) {
            throw new IllegalArgumentException("Рік навчання повинен бути від 1 до 4");
        }
        this.name = name;
        this.year = year;
        this.courses = new ArrayList<>();
    }

    // Додає дисципліну до списку
    public void addCourse(String courseName) {
        if (courseName != null && !courseName.isEmpty()) {
            courses.add(courseName);
        }
    }

    // Видаляє всі дисципліни
    public void dropAll() {
        courses.clear();
    }

    // Повертає кількість дисциплін
    public int getCourseCount() {
        return courses.size();
    }

    // Повертає ім'я студента
    public String getName() {
        return name;
    }

    // Повертає рік навчання
    public int getYear() {
        return year;
    }

    // Повертає суму грошей, яку студент заплатив за навчання
    public int getTuition() {
        return year * 20000;
    }

    // Тестування в main
    public static void main(String[] args) {
        Student student = new Student("Іра", 2);
        student.addCourse("Об'єктно-орієнтоване програмування");
        student.addCourse("Бази даних");
        student.addCourse("Фізика");

        System.out.println(student.getName() + ": кількість вивчаємих дисциплін - " + student.getCourseCount());
        System.out.println(student.getName() + ": рік навчання - " + student.getYear());
        System.out.println(student.getName() + ": заплатив за навчання - " + student.getTuition());
    }
}
