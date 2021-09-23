package com.dev.doctor.service;

import com.dev.doctor.model.Address;
import com.dev.doctor.model.Patient;
import com.dev.doctor.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findAll() {
        return this.patientRepository.findAll();
    }

}

