package com.example.SIH1613.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SIH1613.Model.PublicationModel;
import com.example.SIH1613.Service.GoogleService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GoogleControler{
    @Autowired
    private GoogleService googleService;


@GetMapping("/googlepublications")
     public List<PublicationModel> getPublications() throws IOException {
        return googleService.scrapeGoogleScholar();
    }
}
