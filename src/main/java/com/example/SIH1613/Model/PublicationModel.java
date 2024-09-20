package com.example.SIH1613.Model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PublicationModel {
      @Id
    private String id;
    private String title;
    private String authors;
    private String journal;
    private int year;
    private String volume;
    private String issue;
    private String pages;
    private String doi;
    private String publisher;
    private String publicationType;
    private String Abstract;
    private String keywords;
    private String citationCount;
    private String url;
    private boolean peerReviewStatus;
    private String awards;

    
    public PublicationModel(String title, String authors, String journal, String citationCount) {
        this.title = title;
        this.authors = authors;
        this.journal = journal;
        this.citationCount = citationCount;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthors() {
        return authors;
    }
    public void setAuthors(String authors) {
        this.authors = authors;
    }
    public String getJournal() {
        return journal;
    }
    public void setJournal(String journal) {
        this.journal = journal;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getVolume() {
        return volume;
    }
    public void setVolume(String volume) {
        this.volume = volume;
    }
    public String getIssue() {
        return issue;
    }
    public void setIssue(String issue) {
        this.issue = issue;
    }
    public String getPages() {
        return pages;
    }
    public void setPages(String pages) {
        this.pages = pages;
    }
    public String getDoi() {
        return doi;
    }
    public void setDoi(String doi) {
        this.doi = doi;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getPublicationType() {
        return publicationType;
    }
    public void setPublicationType(String publicationType) {
        this.publicationType = publicationType;
    }
    public String getAbstract() {
        return Abstract;
    }
    public void setAbstract(String abstract1) {
        Abstract = abstract1;
    }
    public String getKeywords() {
        return keywords;
    }
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    public String getCitationCount() {
        return citationCount;
    }
    public void setCitationCount(String citationCount) {
        this.citationCount = citationCount;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public boolean isPeerReviewStatus() {
        return peerReviewStatus;
    }
    public void setPeerReviewStatus(boolean peerReviewStatus) {
        this.peerReviewStatus = peerReviewStatus;
    }
    public String getAwards() {
        return awards;
    }
    public void setAwards(String awards) {
        this.awards = awards;
    }

    
}
