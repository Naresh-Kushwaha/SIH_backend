package com.example.SIH1613.Model;

import org.springframework.data.annotation.Id;

public class AttendenceModel {

    @Id
    private int Semester;
    private String course;
    private int studentPresent;
    private int engagedLecture;
    private int onRoll;
    private Double averageAttendece;

    public int getStudentPresent() {
        return studentPresent;
    }

    public void setStudentPresent(int studentPresent) {
        this.studentPresent = studentPresent;
    }

    public int getSemester() {
        return Semester;
    }

    public void setSemester(int semester) {
        Semester = semester;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getEngagedLecture() {
        return engagedLecture;
    }

    public void setEngagedLecture(int engagedLecture) {
        this.engagedLecture = engagedLecture;
    }

    public Double getAverageAttendece() {
        return averageAttendece;
    }

    public void setAverageAttendece(Double averageAttendece) {
        this.averageAttendece = averageAttendece;
    }

    public int getOnRoll() {
        return onRoll;
    }

    public void setOnRoll(int onRoll) {
        this.onRoll = onRoll;
    }
}
