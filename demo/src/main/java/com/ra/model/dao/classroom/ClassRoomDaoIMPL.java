package com.ra.model.dao.classroom;

import com.ra.model.entity.ClassRoom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClassRoomDaoIMPL implements IClassRoomDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ClassRoom> findAll() {
        Session session = null;
        List<ClassRoom> classRoomList = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            classRoomList = session.createQuery("from ClassRoom ", ClassRoom.class).list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return classRoomList;
    }

    @Override
    public Boolean saveOrUpdate(ClassRoom classRoom) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(classRoom);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.isActive();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public void deleteClassRoom(int classRoomId) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            ClassRoom classRoom = session.get(ClassRoom.class,classRoomId);
            session.delete(classRoom);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.isActive();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
