package com.creative.coders.StudenManagementSystem.serviceImpl;

import com.creative.coders.StudenManagementSystem.entity.Student;
import com.creative.coders.StudenManagementSystem.repository.StudentRepository;
import com.creative.coders.StudenManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public void removeStudentById(int id) {
        studentRepository.deleteById(id);
    }
}
