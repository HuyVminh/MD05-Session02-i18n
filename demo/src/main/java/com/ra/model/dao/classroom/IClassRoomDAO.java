package com.ra.model.dao.classroom;

import com.ra.model.entity.ClassRoom;

import java.util.List;

public interface IClassRoomDAO {
    List<ClassRoom> findAll();
    Boolean saveOrUpdate(ClassRoom classRoom);
    void deleteClassRoom(int classRoomId);
}
