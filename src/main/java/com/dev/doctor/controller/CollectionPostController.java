package com.dev.doctor.controller;


import com.dev.doctor.service.CollectionPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Validated
public class CollectionPostController {
    @Autowired
    private CollectionPostService collectionPostService;

    @CrossOrigin
    @GetMapping("/collection-posts")
    public ResponseEntity<Object> getCollectionPosts(){
        if(collectionPostService.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(collectionPostService.findAll());}



}
