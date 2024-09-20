package com.example.SIH1613.Model;

import org.springframework.data.annotation.Id;

public class LecturesModel {
@Id
    private int semester;
    private String course;
    private int periodsAllotted;
    private int periodsEngaged;
    private int  targetAchieved;

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getPeriodsAllotted() {
        return periodsAllotted;
    }

    public void setPeriodsAllotted(int periodsAllotted) {
        this.periodsAllotted = periodsAllotted;
    }

    public int getPeriodsEngaged() {
        return periodsEngaged;
    }

    public void setPeriodsEngaged(int periodsEngaged) {
        this.periodsEngaged = periodsEngaged;
    }

    public int getTargetAchieved() {
        return targetAchieved;
    }

    public void setTargetAchieved(int targetAchieved) {
        this.targetAchieved =targetAchieved;
    }





}
