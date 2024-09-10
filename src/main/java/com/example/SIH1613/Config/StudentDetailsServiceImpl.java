package com.example.SIH1613.Config;

import com.example.SIH1613.Model.studentModel;
import com.example.SIH1613.Repository.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private studentRepo  adminRepo;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<studentModel> student=adminRepo.findByUsername(id);
        if(student.isPresent()){
            var studentObj=student.get();
            return User.builder()
                    .username((studentObj.getUsername()))
                    .password(studentObj.getPassword())
                    .roles(studentObj.getRole())
                    .build();
        }else{
            throw new UsernameNotFoundException(id);
        }
    }
}
