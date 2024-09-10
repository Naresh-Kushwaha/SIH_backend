package com.example.SIH1613.Config;

import com.example.SIH1613.Model.adminModel;
import com.example.SIH1613.Model.facultyModel;
import com.example.SIH1613.Model.studentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.example.SIH1613.Repository.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminDetailsServiceImpl implements UserDetailsService {
  @Autowired
  private adminRepo adminRepo;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<adminModel> admin=adminRepo.findByUsername(id);
        if(admin.isPresent()){
            var adminObj=admin.get();
            return User.builder()
                    .username((adminObj.getUsername()))
                    .password(adminObj.getPassword())
                    .roles(adminObj.getRole())
                    .build();
        }else{
            throw new UsernameNotFoundException(id);
        }
    }
}

