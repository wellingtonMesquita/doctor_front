package com.dev.doctor.service;

import com.dev.doctor.model.Address;
import com.dev.doctor.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressService  {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findAll() {
        return this.addressRepository.findAll();
    }



}

