package com.example.SIH1613.Controller;


import com.example.SIH1613.Model.AttendenceModel;
import com.example.SIH1613.Model.EvalutationModel;
import com.example.SIH1613.Model.LecturesModel;
import com.example.SIH1613.Service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evalution")
public class EvalutionController {

    @Autowired
    private  EvaluationService evaluationService;

    @PostMapping("/save")
    private ResponseEntity<Object> save(@RequestBody EvalutationModel evalutationModel){

       return   evaluationService.saveEvaluation(evalutationModel);

    }
    @PostMapping("/addLecture/{username}")
    private ResponseEntity<Object> addLecture(@RequestBody LecturesModel lecturesModel ,@PathVariable String username){

        return evaluationService.addLecture(lecturesModel,username);
    }
    @PutMapping("/addAttendance/{username}")
    private ResponseEntity<Object> addAttendance(@RequestBody AttendenceModel attendenceModel,@PathVariable String username){

        return evaluationService.addAttendence(attendenceModel,username);
    }

}
