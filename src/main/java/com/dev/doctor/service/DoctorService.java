package com.dev.doctor.service;


import com.dev.doctor.model.Doctor;

import com.dev.doctor.repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class DoctorService  {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> findAll() {
        return this.doctorRepository.findAll();
    }
}

