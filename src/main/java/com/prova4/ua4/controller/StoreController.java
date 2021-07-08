package com.prova4.ua4.controller;

import com.prova4.ua4.model.Product;
import com.prova4.ua4.model.Store;
import com.prova4.ua4.repository.StoreRepository;
import com.prova4.ua4.service.StoreService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "store")

public class StoreController {

    @Autowired
    StoreService storeService;
    @Autowired
    StoreRepository storeRepository;

    @ApiOperation("Cadastra uma empresa")
    @PostMapping
    public Store cadastra(@RequestBody Store store){
        System.out.println("Store save sussesfully");
        return storeService.save(store);
    }

    @ApiOperation("Edita nome da empresa")
    @PutMapping("store/{id}")
    public ResponseEntity edita (@PathVariable("id") long id,
                                 @RequestBody Store store){
        return storeRepository.findById(id).map(record ->{
            record.setName(store.getName());
            Store edita = storeRepository.save(record);
            return ResponseEntity.ok().body(edita);
        }).orElse(ResponseEntity.notFound().build());
    }
}
