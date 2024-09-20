package com.example.SIH1613.Service;


import com.example.SIH1613.Model.AttendenceModel;
import com.example.SIH1613.Model.EvalutationModel;

import com.example.SIH1613.Model.LecturesModel;
import com.example.SIH1613.Repository.EvaluationRepo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EvaluationService {

    @Autowired
    private EvaluationRepo evaluationRepo;



    public ResponseEntity<Object> saveEvaluation(EvalutationModel evalutationModel){

      return  ResponseEntity.status(200).body(evaluationRepo.save(evalutationModel));

    }
    public  ResponseEntity<Object> addLecture(LecturesModel lecturesModel, String username){
        Optional<EvalutationModel> evalutationModel=evaluationRepo.findByUsername(username);
        if(evalutationModel!=null){
            lecturesModel.setTargetAchieved((lecturesModel.getPeriodsEngaged()/ lecturesModel.getPeriodsAllotted())*100);
           EvalutationModel evalutationModel1=evalutationModel.get();
           evalutationModel1.getLecture().add(lecturesModel);
           return ResponseEntity.ok().body(evaluationRepo.save(evalutationModel1));
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    public  ResponseEntity<Object> addAttendence(AttendenceModel attendenceModel, String username){
     Optional<EvalutationModel> evalutationModel=evaluationRepo.findByUsername(username);
     if(evalutationModel!=null){
         EvalutationModel evalutationModel1=evalutationModel.get();
         evalutationModel1.getAttendence().add(attendenceModel);
         return ResponseEntity.ok().body(evaluationRepo.save(evalutationModel1));
     }
     else{
         return ResponseEntity.notFound().build();
     }


    }





}
