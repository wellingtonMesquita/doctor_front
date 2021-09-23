package com.dev.doctor.repository;


import com.dev.doctor.model.Exam;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {



}