package com.example.SIH1613.Repository;

import com.example.SIH1613.Model.studentModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface studentRepo extends MongoRepository<studentModel, ObjectId> {

    Optional<studentModel> findByUsername(String username);
}
