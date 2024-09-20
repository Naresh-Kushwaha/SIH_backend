package com.example.SIH1613.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document
public class EvalutationModel {
    @Id
    private String username;
    private  String AcademicYear;

    private String post;
    private String payScale;
    private String institution;
    private String workingInThisInstitution;
    private String sectionalHead;
    private String institutionHead;
    private String departmentHead;
    private String principalSecretary;

    private ArrayList<LecturesModel>Lecture=new ArrayList<>();


    private ArrayList<AttendenceModel> Attendence=new ArrayList<>();

    public ArrayList<AttendenceModel> getAttendence() {
        return Attendence;
    }

    public void setAttendence(ArrayList<AttendenceModel> attendenceModel) {
        Attendence = attendenceModel;
    }

    public ArrayList<LecturesModel> getLecture() {
        return Lecture;
    }

    public void setLecture(ArrayList<LecturesModel> lecture) {
        Lecture = lecture;
    }



    public String getAcademicYear() {
        return AcademicYear;
    }

    public void setAcademicYear(String academicYear) {
        AcademicYear = academicYear;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<AttendenceModel> getAttendenceMode() {
        return Attendence;
    }

    public void setAttendenceMode(ArrayList<AttendenceModel> attendenceModel) {
        Attendence = attendenceModel;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPayScale() {
        return payScale;
    }

    public void setPayScale(String payScale) {
        this.payScale = payScale;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getWorkingInThisInstitution() {
        return workingInThisInstitution;
    }

    public void setWorkingInThisInstitution(String workingInThisInstitution) {
        this.workingInThisInstitution = workingInThisInstitution;
    }

    public String getSectionalHead() {
        return sectionalHead;
    }

    public void setSectionalHead(String sectionalHead) {
        this.sectionalHead = sectionalHead;
    }

    public String getInstitutionHead() {
        return institutionHead;
    }

    public void setInstitutionHead(String institutionHead) {
        this.institutionHead = institutionHead;
    }

    public String getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(String departmentHead) {
        this.departmentHead = departmentHead;
    }

    public String getPrincipalSecretary() {
        return principalSecretary;
    }

    public void setPrincipalSecretary(String principalSecretary) {
        this.principalSecretary = principalSecretary;
    }
}
