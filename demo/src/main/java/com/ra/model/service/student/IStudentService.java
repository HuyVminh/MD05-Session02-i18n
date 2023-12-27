package com.ra.model.service.student;

import com.ra.model.entity.ClassRoom;
import com.ra.model.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Boolean saveOrUpdate(Student student);
    void deleteStudent(int studentId);
}
