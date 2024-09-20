package com.example.SIH1613.Repository;

import com.example.SIH1613.Model.EvalutationModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EvaluationRepo extends MongoRepository<EvalutationModel, String> {
    Optional<EvalutationModel> findByUsername(String username);
}
