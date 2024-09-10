package com.example.SIH1613.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.SIH1613.Model.Publication;

public interface PublicationRepository extends MongoRepository <Publication, String> {
    
}
