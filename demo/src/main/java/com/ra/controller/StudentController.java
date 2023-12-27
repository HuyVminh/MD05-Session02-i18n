package com.ra.controller;

import com.ra.model.entity.Student;
import com.ra.model.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping("/student")
    public String getStudent(Model model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("list", studentList);
        return "/student";
    }
}
