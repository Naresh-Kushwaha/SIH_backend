package com.example.SIH1613.Controller;


import com.example.SIH1613.Model.adminModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;
import com.example.SIH1613.Service.adminService;

@RestController
@RequestMapping("/api/admin")
@EnableMethodSecurity

public class adminController {
    @Autowired
    private adminService adminService;

    @PostMapping("/create")
    public ResponseEntity<Object> setAdmin(@RequestBody adminModel admin){
       return ResponseEntity.status(200).body(adminService.setAdmin(admin));

    }
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody adminModel admin){
        return adminService.login(admin);

    }
    @GetMapping("/get/{id}")
    @PreAuthorize("#id==authentication.principal.username")
    public ResponseEntity<Object> getAdmin(@PathVariable("id") String id){
        return ResponseEntity.status(200).body(adminService.getAdmin(id));

    }

}
