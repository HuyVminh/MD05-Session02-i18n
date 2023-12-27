package com.ra.model.service.classroom;

import com.ra.model.entity.ClassRoom;

import java.util.List;

public interface IClassRoomService {
    List<ClassRoom> findAll();
    Boolean saveOrUpdate(ClassRoom classRoom);
    void deleteClassRoom(int classRoomId);
}
