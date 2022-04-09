package com.example.midterm;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "name")
    private String name;

    @Column(name = "course")
    private String course;

    @Column(name = "GPA")
    private String GPA;

    @Column(name = "sex")
    private String sex;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", GPA='" + GPA + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
