package com.example.SIH1613.Service;

import com.example.SIH1613.Model.facultyModel;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.SIH1613.Model.studentModel;
import com.example.SIH1613.Repository.studentRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class studentService{
  @Autowired
   studentRepo studentRepo;
  @Autowired
  private PasswordEncoder passwordEncoder;

  public studentModel createStudent(studentModel student){
    student.setPassword(passwordEncoder.encode(student.getPassword()));
    return studentRepo.save(student);
  }
  public studentModel getStudent(String id){

    return studentRepo.findByUsername(id).get();

  }

  public ResponseEntity<Object> login(studentModel faculty) {
    Optional<studentModel> studentD=studentRepo.findByUsername(faculty.getUsername());
    if (studentD.isPresent()){

      studentModel foundStudent=studentD.get();
      if (passwordEncoder.matches(faculty.getPassword(),foundStudent.getPassword())){
        return  ResponseEntity.status(200).body("found");

      }else{
        return ResponseEntity.status(401).body("password incorrect");
      }
    }
    return  ResponseEntity.status(404).body("not found");

  }
}