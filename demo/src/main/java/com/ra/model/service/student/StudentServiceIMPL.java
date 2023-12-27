package com.ra.model.service.student;

import com.ra.model.dao.student.IStudentDAO;
import com.ra.model.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceIMPL implements IStudentService {
    @Autowired
    private IStudentDAO studentDAO;

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Boolean saveOrUpdate(Student student) {
        return studentDAO.saveOrUpdate(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        studentDAO.deleteStudent(studentId);
    }
}
