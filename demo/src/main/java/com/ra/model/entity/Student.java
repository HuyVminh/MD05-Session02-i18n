package com.ra.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String studentName;
    @Column(name = "age")
    private int age;
    @ManyToOne
    @JoinColumn(name = "classroom_id",referencedColumnName = "id")
    private ClassRoom classRoom;
    @Column(name = "status")
    private boolean status;

    public Student() {
    }

    public Student(int id, String studentName, int age, ClassRoom classRoom, boolean status) {
        this.id = id;
        this.studentName = studentName;
        this.age = age;
        this.classRoom = classRoom;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
