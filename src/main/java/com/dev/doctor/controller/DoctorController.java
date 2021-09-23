package com.dev.doctor.controller;


import com.dev.doctor.service.AddressService;
import com.dev.doctor.service.DoctorService;
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
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @CrossOrigin
    @GetMapping("/doctors")
    public ResponseEntity<Object> getDoctors(){
        if(this.doctorService.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.doctorService.findAll());}


}
