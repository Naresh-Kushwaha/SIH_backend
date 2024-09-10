package com.example.SIH1613.Repository;

import com.example.SIH1613.Model.facultyModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface facultyRepo extends MongoRepository<facultyModel, ObjectId> {

    Optional<facultyModel>findByUsername(String username);
}
