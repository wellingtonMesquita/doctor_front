package com.dev.doctor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class OrderOfService implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long price;

    private Date data;

    @OneToOne()
    private Patient patient;

    private String covenant;

    @OneToOne()
    private CollectionPost collectionPost;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Exam> exam;

    @OneToOne()
    private Doctor doctor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getCovenant() {
        return covenant;
    }

    public void setCovenant(String covenant) {
        this.covenant = covenant;
    }

    public CollectionPost getCollectionPost() {
        return collectionPost;
    }

    public void setCollectionPost(CollectionPost collectionPost) {
        this.collectionPost = collectionPost;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Long getPrice() {
        return price;
    }

    public Set<Exam> getExam() {
        return exam;
    }

    public void setExam(Set<Exam> exam) {
        this.exam = exam;
    }

    public void setPrice(Long price) {
        this.price = price;
    }


}

