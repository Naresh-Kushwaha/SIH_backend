package com.example.SIH1613.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.SIH1613.Model.Publication;
import com.example.SIH1613.Repository.PublicationRepository;
import java.util.*;
@RestController
@RequestMapping("/api/publications")
public class PublicationController {
   
    @Autowired
    private PublicationRepository publicationRepository;

    @PostMapping
    public Publication createPublication(@RequestBody Publication publication) {
        return publicationRepository.save(publication);
    } 
    @GetMapping
    public List<Publication> getAllPublication(){
        return publicationRepository.findAll();

    }
}
