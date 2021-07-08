package com.prova4.ua4.service;

import com.prova4.ua4.model.Store;
import com.prova4.ua4.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    StoreRepository storeRepository;

    public Store cadastra (Store store){
        System.out.println("save sussesfully");
        return storeRepository.save(store);
    }

    public Store save(Store store) {
        return store;
    }
}
