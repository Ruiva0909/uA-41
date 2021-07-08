package com.prova4.ua4.service;

import com.prova4.ua4.model.Product;
import com.prova4.ua4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product save (Product product){
        System.out.println("save sussesfully");
        return productRepository.save(product);
    }

    public List<Product> list(){
        return productRepository.findAll();
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
