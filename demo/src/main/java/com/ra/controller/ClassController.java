package com.ra.controller;

import com.ra.model.entity.ClassRoom;
import com.ra.model.service.classroom.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClassController {
    @Autowired
    private IClassRoomService classRoomService;

    @GetMapping("/classroom")
    public String getClassroom(Model model) {
        List<ClassRoom> classRoomList = classRoomService.findAll();
        model.addAttribute("list", classRoomList);
        return "/class-room";
    }
}
