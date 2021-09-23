package com.dev.doctor.dto;

import com.dev.doctor.model.Exam;
import com.dev.doctor.model.OrderOfService;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

public class OrderServiceExamDto {
    private Long id;
    private OrderOfService orderOfService;
    private Double price;
    private List<Exam> examlist;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderOfService getOrderOfService() {
        return orderOfService;
    }

    public void setOrderOfService(OrderOfService orderOfService) {
        this.orderOfService = orderOfService;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Exam> getExamlist() {
        return examlist;
    }

    public void setExamlist(List<Exam> examlist) {
        this.examlist = examlist;
    }
}
