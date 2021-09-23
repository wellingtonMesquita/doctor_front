package com.dev.doctor.repository;


import com.dev.doctor.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {



}