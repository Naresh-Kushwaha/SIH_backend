package com.example.SIH1613.Service;


import com.example.SIH1613.Model.adminModel;
import com.example.SIH1613.Model.studentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import  com.example.SIH1613.Repository.adminRepo;

import java.util.Optional;

@Service
public class adminService {
    @Autowired
    private adminRepo adminRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public adminModel setAdmin(adminModel admin){
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
      return   adminRepo.save(admin);
    }
    public adminModel getAdmin(String adminId){
       return adminRepo.findByUsername(adminId).get();
    }
    public ResponseEntity<Object> login(adminModel admin) {
        Optional<adminModel> studentD=adminRepo.findByUsername(admin.getUsername());
        if (studentD.isPresent()){

            adminModel foundStudent=studentD.get();
            if (passwordEncoder.matches(admin.getPassword(),foundStudent.getPassword())){
                return  ResponseEntity.status(200).body("found");

            }else{
                return ResponseEntity.status(401).body("password incorrect");
            }
        }
        return  ResponseEntity.status(404).body("not found");

    }
}
