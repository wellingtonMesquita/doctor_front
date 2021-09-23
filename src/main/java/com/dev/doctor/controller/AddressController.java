package com.dev.doctor.controller;


import com.dev.doctor.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@Validated
public class AddressController {

    @Autowired
    private AddressService addressService;

    @CrossOrigin
    @GetMapping("/address")
    public ResponseEntity<Object> getAdresses(){
        if(addressService.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
    }
        return ResponseEntity.ok(addressService.findAll());}


}
