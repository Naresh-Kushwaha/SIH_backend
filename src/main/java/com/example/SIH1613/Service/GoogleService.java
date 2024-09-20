package com.example.SIH1613.Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.example.SIH1613.Model.PublicationModel;

import io.jsonwebtoken.io.IOException;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoogleService {
    
  private List<PublicationModel> publicationModels = new ArrayList<>();
  String url = "https://scholar.google.com/citations?user=iR36uOoAAAAJ";

 
  // Runs every hour (3600000 milliseconds)

  @Scheduled(fixedRate = 3600000)
    public List<PublicationModel> scrapeGoogleScholar() throws java.io.IOException {
        try {
            // Connect to the Google Scholar profile page and fetch the HTML
            Document doc = Jsoup.connect(url).get();

            // Select the publication rows
            Elements publicationRows = doc.select("tr.gsc_a_tr");
            

            // Clear the previous list of publications
            publicationModels.clear();

            // Loop through each publication row and extract the details
            for (Element publication : publicationRows) {
                String title = publication.select("a.gsc_a_at").text();
                String authors = publication.select("div.gs_gray").first().text();
                String publicationInfo = publication.select("div.gs_gray").next().text();
                String citations = publication.select("a.gsc_a_ac").text();

                // Create a new publication object and add it to the list
                publicationModels.add(new PublicationModel(title, authors, publicationInfo, citations));
            }

            System.out.println("Successfully scraped Google Scholar data.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error occurred while scraping Google Scholar.");
        }
        return publicationModels;
    }

    
}
