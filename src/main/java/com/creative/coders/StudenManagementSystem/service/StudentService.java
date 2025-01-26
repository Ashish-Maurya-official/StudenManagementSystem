package com.creative.coders.StudenManagementSystem.service;

import com.creative.coders.StudenManagementSystem.entity.Student;

import java.util.List;

public interface StudentService{
    public void saveStudent(Student student);
    public Student getStudentById(int id);
    public List<Student> getAllStudent();
    public void removeStudentById(int id);
}
