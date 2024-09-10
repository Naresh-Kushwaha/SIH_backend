package com.example.SIH1613.Model;


import com.mongodb.lang.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Document(collection = "FacultyData")
public class facultyModel {
    @Id
    private String username;
    private String password;
    private int experience;
    private ArrayList<Map<String, Object>> seminarAttended=new ArrayList<>();
    private ArrayList<Map<String, Object>> seminarDelivered=new ArrayList<>();

    private List<paperModel>papers=new ArrayList<>();
    private List<paperModel> projects=new ArrayList<>();
    private Map<Integer, Integer> rating =new HashMap<>();

    public List<paperModel> getPapers() {
        return papers;
    }

    public void setPapers(MultipartFile papersData) throws IOException {
        paperModel paper=new paperModel();
        paper.setFileName(papersData.getOriginalFilename());
        paper.setFiletype(papersData.getContentType());
        paper.setData(papersData.getBytes());
        papers.add(paper);
    }

    public List<paperModel> getProject() {
        return projects;
    }
    public void setProject(MultipartFile papersData) throws IOException {
        paperModel project=new paperModel();
        project.setFileName(papersData.getOriginalFilename());
        project.setFiletype(papersData.getContentType());
        project.setData(papersData.getBytes());
        projects.add(project);
    }

//    public void setProject(projectModel projectData) {
//        project.add(projectData);
//    }

    public ArrayList<Map<String, Object>> getSeminarAttended() {
        return seminarAttended;
    }

    public void setSeminarAttended(ArrayList<Map<String, Object>> seminarAttended) {
        this.seminarAttended = seminarAttended;
    }

    public ArrayList<Map<String, Object>> getSeminarDelivered() {
        return seminarDelivered;
    }

    public void setSeminarDelivered(ArrayList<Map<String, Object>> seminarDelivered) {
        this.seminarDelivered = seminarDelivered;
    }

    public String getRole() {
        return "FACULTY";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }





    public Map<Integer, Integer> getRating() {
        return rating;
    }

    public void setRating(Map<Integer, Integer> rating) {
        this.rating = rating;
    }
}
