package com.dev.doctor.controller;



import com.dev.doctor.service.PatientService;
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
public class PatientController {
    @Autowired
    private PatientService patientService;

    @CrossOrigin
    @GetMapping("/patients")
    public ResponseEntity<Object> getPatients(){
        if(patientService.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patientService.findAll());}


}

