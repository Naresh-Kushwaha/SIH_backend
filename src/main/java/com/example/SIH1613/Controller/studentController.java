package com.example.SIH1613.Controller;
import com.example.SIH1613.Model.studentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;
import com.example.SIH1613.Service.studentService;

@RestController
@RequestMapping("/api/student")
@EnableMethodSecurity
public class studentController {
    @Autowired
    studentService studentService;


@PostMapping("/create")
    public ResponseEntity<Object> createStudent(@RequestBody studentModel student){
    return ResponseEntity.status(201).body(studentService.createStudent(student));

}
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody studentModel student){
        return studentService.login(student);

    }
    @GetMapping("/get/{id}")
    @PreAuthorize("#id==authentication.principal.username")
    public ResponseEntity<Object> getStudent(@PathVariable("id") String id){
   return ResponseEntity.status(200).body(studentService.getStudent(id));

    }



}
