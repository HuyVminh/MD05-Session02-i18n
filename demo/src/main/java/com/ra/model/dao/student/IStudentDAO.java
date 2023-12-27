package com.ra.model.dao.student;

import com.ra.model.entity.ClassRoom;
import com.ra.model.entity.Student;

import java.util.List;

public interface IStudentDAO {
    List<Student> findAll();
    Boolean saveOrUpdate(Student student);
    void deleteStudent(int studentId);
}
