package com.example.SIH1613.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.SIH1613.Model.PublicationModel;
import com.example.SIH1613.Repository.PublicationRepository;
import java.util.*;
@RestController
@RequestMapping("/api/publications")
public class PublicationController {
   
    @Autowired
    private PublicationRepository publicationRepository;

    @PostMapping
    public PublicationModel createPublication(@RequestBody PublicationModel publicationModel) {
        return publicationRepository.save(publicationModel);
    } 
    @GetMapping
    public List<PublicationModel> getAllPublication(){
        return publicationRepository.findAll();

    }
}
