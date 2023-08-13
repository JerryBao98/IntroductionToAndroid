package org.example.school;

public class Student {

    private String name;

    private final Integer id;

    private String grade;

    private boolean isExpelled;

    public Student(String name, Integer id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
        this.isExpelled = false;
    }

    public Student(String name, Integer id, String grade, boolean isExpelled) {
        this.name = name;
        this.id = id;
        this.grade = grade;
        this.isExpelled = isExpelled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public boolean isExpelled() {
        return isExpelled;
    }

    public void setExpelled(boolean expelled) {
        isExpelled = expelled;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", grade='" + grade + '\'' +
                ", isExpelled=" + isExpelled +
                '}';
    }
}
