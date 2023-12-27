package com.ra.model.service.classroom;

import com.ra.model.dao.classroom.IClassRoomDAO;
import com.ra.model.entity.ClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassRoomServiceIMPL implements IClassRoomService{
   @Autowired
   private IClassRoomDAO classRoomDAO;
    @Override
    public List<ClassRoom> findAll() {
        return classRoomDAO.findAll();
    }

    @Override
    public Boolean saveOrUpdate(ClassRoom classRoom) {
        return classRoomDAO.saveOrUpdate(classRoom);
    }

    @Override
    public void deleteClassRoom(int classRoomId) {
        classRoomDAO.deleteClassRoom(classRoomId);
    }
}
