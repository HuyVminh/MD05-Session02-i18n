package com.ra.model.dao.student;

import com.ra.model.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoIMPL implements IStudentDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> findAll() {
        Session session = null;
        List<Student> studentList = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            studentList = session.createQuery("from Student ", Student.class).list();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return studentList;
    }

    @Override
    public Boolean saveOrUpdate(Student student) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(student);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            if (transaction!=null){
                transaction.rollback();
            }
        }finally {
            if (session!=null){
                session.close();
            }
        }
        return false;
    }

    @Override
    public void deleteStudent(int studentId) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Student student = session.get(Student.class,studentId);
            session.delete(student);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (transaction!=null){
                transaction.rollback();
            }
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }
}
