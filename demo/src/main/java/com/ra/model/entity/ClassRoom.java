package com.ra.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "classroom")
public class ClassRoom {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String classroomName;
    @Column(name = "status")
    private boolean status;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.PERSIST)
    private Set<Student> students;

    public ClassRoom() {
    }

    public ClassRoom(int id, String classroomName, boolean status) {
        this.id = id;
        this.classroomName = classroomName;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
