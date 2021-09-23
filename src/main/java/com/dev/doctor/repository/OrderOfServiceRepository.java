package com.dev.doctor.repository;

import com.dev.doctor.model.OrderOfService;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

public interface OrderOfServiceRepository extends JpaRepository<OrderOfService, Long> {
    Page<OrderOfService> findAll(Pageable pageable);


}