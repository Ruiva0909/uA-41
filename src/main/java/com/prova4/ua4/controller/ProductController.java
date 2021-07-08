package com.prova4.ua4.controller;


import com.prova4.ua4.model.Product;
import com.prova4.ua4.repository.ProductRepository;
import com.prova4.ua4.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "product")

public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

    @PostMapping
    public Product cadastraStore(@RequestBody Product product){
        System.out.println("");
    }

}
