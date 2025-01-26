package com.creative.coders.StudenManagementSystem.controller;

import com.creative.coders.StudenManagementSystem.entity.Student;
import com.creative.coders.StudenManagementSystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudent());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student()); // Corrected attribute name
        return "create-student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit-student";
    }

    @PostMapping("/students/edit/{id}")
    public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student) {
        // Fetch and update existing student
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        studentService.saveStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteById(@PathVariable int id) {
        studentService.removeStudentById(id);
        return "redirect:/students";
    }
}
