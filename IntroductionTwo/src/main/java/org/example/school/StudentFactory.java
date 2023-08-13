package org.example.school;

import java.util.*;

public class StudentFactory {

    private final Map<Integer, Student> studentsDirectory;
    private int currentStudentId;

    public StudentFactory() {
        this.studentsDirectory = new HashMap<>();
        this.currentStudentId = 0;
    }

    public Map<Integer, Student> getStudentsDirectory() {
        return studentsDirectory;
    }

    public Student createStudent(String name, String grade) {
        int id = currentStudentId;
        Student newStudent = new Student(name, id, grade);
        studentsDirectory.put(id, newStudent);
        currentStudentId++;
        return newStudent;
    }

    public void updateStudentGrade(Integer id, String updatedGrade) {
        if (studentsDirectory.containsKey(id)){
            studentsDirectory.get(id).setGrade(updatedGrade);
        } else{
            System.out.println("Student with id: " + id + " not found" );
        }
    }

    public void deleteStudent(Integer id){
        studentsDirectory.remove(id);
        System.out.println("Student with id: " + id + " removed" );
    }

    public void clearStudentDirectory(){
        studentsDirectory.clear();
    }
}
