package com.dev.doctor.controller;


import com.dev.doctor.model.Exam;
import com.dev.doctor.service.AddressService;
import com.dev.doctor.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Validated
public class ExamController {
    @Autowired
    private ExamService examService;

    @CrossOrigin
    @GetMapping("/exams")
    public ResponseEntity<Object> getExams(){
        if(examService.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(examService.findAll());}


}

