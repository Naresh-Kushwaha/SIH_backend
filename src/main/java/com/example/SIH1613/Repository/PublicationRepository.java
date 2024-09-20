package com.example.SIH1613.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.SIH1613.Model.PublicationModel;

public interface PublicationRepository extends MongoRepository <PublicationModel, String> {
    
}
