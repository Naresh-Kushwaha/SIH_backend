package com.example.SIH1613.Controller;


import com.example.SIH1613.Model.facultyModel;
import com.example.SIH1613.Model.paperModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;
import com.example.SIH1613.Service.facultyService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@EnableMethodSecurity
@RequestMapping("/api/faculty")
public class facultyController {
    @Autowired
    facultyService facultyService;
    @PostMapping("/create")
    public ResponseEntity<Object> createFaculty(@RequestBody facultyModel faculty){
        return  ResponseEntity.status(201).body(facultyService.createFaculty(faculty));
    }
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody facultyModel faculty){
        return facultyService.login(faculty);
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object>getAllFaculty(){
        return ResponseEntity.status(200).body(facultyService.getAllFaculty());

    }

    @PutMapping("/update/{id}")
    @PreAuthorize("#id==authentication.principal.username")
    public ResponseEntity<Object> updateFaculty(@PathVariable("id") String id,@RequestBody facultyModel facultyModel){
    return facultyService.updateFaculty(id,facultyModel);
    }
    @PutMapping("/seminar/attended/{id}")
    @PreAuthorize("#id==authentication.principal.username")
    public ResponseEntity<Object> setSeminarAttended(@RequestBody Map<String,Object>seminar,@PathVariable("id") String id){
        facultyService.setSeminarAttended(seminar,id);
        return ResponseEntity.status(200).body("Seminar added successfully");
    }
    @PutMapping("/seminar/delivered/{id}")
    @PreAuthorize("#id==authentication.principal.username or hasRole('ADMIN')")
    public ResponseEntity<Object> setSeminarDelivered(@RequestBody Map<String,Object> seminar,@PathVariable("id") String id){
        facultyService.setSeminarDelivered(seminar,id);
        return ResponseEntity.status(200).body("Seminar added successfully");
    }
    @PutMapping("/paper/add/{id}")
    @PreAuthorize("#id==authentication.principal.username or hasRole('ADMIN')")
    public ResponseEntity<Object> setPaper(@RequestParam("file") MultipartFile paper, @PathVariable("id") String id) throws IOException {
        facultyService.setPaper(paper,id);
        return ResponseEntity.status(200).body("paper added successfully");
    }

    @GetMapping("/paper/get/{id}")
    @PreAuthorize("#id==authentication.principal.username or hasRole('ADMIN')")
    public ResponseEntity<List<paperModel>> downloadPaper(@PathVariable String id) {
        return facultyService.downloadPaper(id);
    }

    @PutMapping("/project/add/{id}")
    @PreAuthorize("#id==authentication.principal.username or hasRole('ADMIN')")
    public ResponseEntity<Object> setProject(@RequestParam("file") MultipartFile paper, @PathVariable("id") String id) throws IOException {
        facultyService.setProject(paper,id);
        return ResponseEntity.status(200).body("paper added successfully");
    }

    @GetMapping("/project/get/{id}")
    @PreAuthorize("#id==authentication.principal.username or hasRole('ADMIN')")
    public ResponseEntity<List<paperModel>> downloadProject(@PathVariable String id) {
        return facultyService.downloadProject(id);
    }


    @PutMapping("/rating/{id}")
    @PreAuthorize("#id==authentication.principal.username or hasRole('student')")
    public ResponseEntity<Object> rating(@RequestBody int rating,@PathVariable("id") String id){
        facultyService.setRating(rating,id);
        return ResponseEntity.status(200).body("Rating added successfully");
    }


    }
