package com.dev.doctor.service;
import com.dev.doctor.model.Address;
import com.dev.doctor.model.CollectionPost;
import com.dev.doctor.repository.CollectionPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CollectionPostService {
    @Autowired
    private CollectionPostRepository collectionPostRepository;

    public List<CollectionPost> findAll() {
        return this.collectionPostRepository.findAll();
    }
}

