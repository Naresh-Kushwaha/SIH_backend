package com.example.SIH1613.Service;


import com.example.SIH1613.Model.facultyModel;
import com.example.SIH1613.Model.paperModel;
import com.example.SIH1613.Model.studentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.SIH1613.Repository.facultyRepo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class facultyService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
   private facultyRepo facultyRepo;
    public facultyModel createFaculty(facultyModel faculty){
        faculty.setPassword(passwordEncoder.encode(faculty.getPassword()));
        return facultyRepo.save(faculty);
    }
    public List<facultyModel> getAllFaculty(){
        return facultyRepo.findAll();
    }
    public ResponseEntity<Object> updateFaculty(String facultyId, facultyModel faculty){
        Optional<facultyModel> existingfaculty=facultyRepo.findByUsername(facultyId);
        if(existingfaculty.isPresent()){
            facultyModel existingFaculty=existingfaculty.get();
            existingFaculty.setPassword(passwordEncoder.encode(faculty.getPassword()));
            existingFaculty.setExperience(faculty.getExperience());
            return ResponseEntity.status(200).body(facultyRepo.save(existingFaculty));
        }
        else{
            return ResponseEntity.status(404).body("User not found");
        }

    }
    public void setSeminarAttended(Map<String, Object> seminar, String facultyId){
      facultyModel faculty= facultyRepo.findByUsername(facultyId).get();
        ArrayList<Map<String,Object>>seminarData=faculty.getSeminarAttended();
        seminarData.add(seminar);
        faculty.setSeminarAttended(seminarData);
        facultyRepo.save(faculty);

    }
    public void setSeminarDelivered(Map<String,Object>seminar,String facultyId){
        facultyModel faculty= facultyRepo.findByUsername(facultyId).get();
        ArrayList<Map<String,Object>>seminarData=faculty.getSeminarDelivered();
        seminarData.add(seminar);
        faculty.setSeminarDelivered(seminarData);
        facultyRepo.save(faculty);

    }
    public void setPaper(MultipartFile paper, String id) throws IOException {

           facultyModel faculty=facultyRepo.findByUsername(id)
                   .orElseThrow(()->new UsernameNotFoundException("Faculty not found"+id));
           faculty.setPapers(paper);
           facultyRepo.save(faculty);

    }
    public ResponseEntity<List<paperModel>> downloadPaper(String id) {
        Optional<facultyModel> faculty=facultyRepo.findByUsername(id);


        if (faculty.isPresent()) {
            facultyModel existingFaculty=faculty.get();

            return ResponseEntity.ok().body( existingFaculty.getPapers());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    public void setProject(MultipartFile project, String id) throws IOException {

        facultyModel faculty=facultyRepo.findByUsername(id)
                .orElseThrow(()->new UsernameNotFoundException("Faculty not found"+id));
        faculty.setProject(project);
        facultyRepo.save(faculty);

    }
    public ResponseEntity<List<paperModel>> downloadProject(String id) {
        Optional<facultyModel> faculty=facultyRepo.findByUsername(id);


        if (faculty.isPresent()) {
            facultyModel existingFaculty=faculty.get();

            return ResponseEntity.ok().body( existingFaculty.getProject());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public void setRating(int rating,String facultyId){
       facultyModel facultyModel= facultyRepo.findByUsername(facultyId).get();
        Integer ratingValue=facultyModel.getRating().get(rating);
        if(ratingValue!=null){
            facultyModel.getRating().put(rating,ratingValue+1);

        }else{
            facultyModel.getRating().put(rating,1);
        }

       facultyRepo.save(facultyModel);


    }
    public ResponseEntity<Object> login(facultyModel faculty) {
        Optional<facultyModel> studentD=facultyRepo.findByUsername(faculty.getUsername());
        if (studentD.isPresent()){

            facultyModel foundStudent=studentD.get();
            if (passwordEncoder.matches(faculty.getPassword(),foundStudent.getPassword())){
                return  ResponseEntity.status(200).body("found");

            }else{
                return ResponseEntity.status(401).body("password incorrect");
            }
        }
        return  ResponseEntity.status(404).body("not found");

    }
}


