package com.dev.doctor.controller;

import com.dev.doctor.dto.OrderServiceExamDto;
import com.dev.doctor.model.Exam;
import com.dev.doctor.model.OrderOfService;
import com.dev.doctor.service.OrderOfServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
@Validated
public class OrderOfServiceController {
    @Autowired
    private OrderOfServiceService orderOfServiceService;

    @CrossOrigin
    @GetMapping("/order-services")
    Object findAll( @RequestParam(value = "pag", defaultValue = "0") int pag, @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable =  PageRequest.of((pag),size);
        return orderOfServiceService.findAll(pageable);
    }

    @CrossOrigin
    @PostMapping("/order-services")
    public OrderOfService create(@RequestBody OrderServiceExamDto orderServiceExamDto){

        return orderOfServiceService.save(this.convertDtoToModel(orderServiceExamDto));
    }


    public OrderOfService convertDtoToModel(OrderServiceExamDto orderServiceExamDto){
        OrderOfService orderOfService = new OrderOfService();
        orderOfService.setCovenant(orderServiceExamDto.getOrderOfService().getCovenant());
        orderOfService.setCollectionPost(orderServiceExamDto.getOrderOfService().getCollectionPost());
        orderOfService.setDoctor(orderServiceExamDto.getOrderOfService().getDoctor());
        orderOfService.setPatient(orderServiceExamDto.getOrderOfService().getPatient());
        Set<Exam> setExame = new HashSet<>(orderServiceExamDto.getExamlist());
        orderOfService.setExam(setExame);
        orderOfService.setData(orderServiceExamDto.getOrderOfService().getData());
        orderOfService.setPrice(orderServiceExamDto.getOrderOfService().getPrice());
        return orderOfService;
    }
}

