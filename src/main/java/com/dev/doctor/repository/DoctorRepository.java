package com.dev.doctor.repository;


import com.dev.doctor.model.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {



}