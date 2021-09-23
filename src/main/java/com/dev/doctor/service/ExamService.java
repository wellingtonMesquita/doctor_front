package com.dev.doctor.service;
import com.dev.doctor.model.Address;
import com.dev.doctor.model.Exam;
import com.dev.doctor.repository.CollectionPostRepository;
import com.dev.doctor.repository.ExamRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;
@Component
public class ExamService  {
    @Autowired
    private ExamRepository examRepository;
    public List<Exam> findAll() {
        return this.examRepository.findAll();
    }
}
