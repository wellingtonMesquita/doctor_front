package com.dev.doctor.service;

import com.dev.doctor.model.Exam;
import com.dev.doctor.model.OrderOfService;
import com.dev.doctor.repository.ExamRepository;
import com.dev.doctor.repository.OrderOfServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class OrderOfServiceService {
    @Autowired
    private OrderOfServiceRepository orderOfServiceRepository;

    @Autowired
    private ExamRepository examRepository;


    public Page<OrderOfService> findAll(Pageable pageRequest) {
        return this.orderOfServiceRepository.findAll(pageRequest);
    }

    public OrderOfService save(OrderOfService orderOfService) {
        long price = 0;
        Set<Exam> set  =  orderOfService.getExam();
        orderOfService.setExam(null);
        OrderOfService orderOfService1 = this.orderOfServiceRepository.save(orderOfService);
        for (Exam aux : set) {
            aux.setOrderOfService(orderOfService1);
            price+=aux.getPrice();
        }
        orderOfService.setPrice(price);
        this.orderOfServiceRepository.save(orderOfService1);
        this.examRepository.saveAll(set);

        return orderOfService1;
    }


}