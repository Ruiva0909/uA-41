package com.prova4.ua4.controller;


import com.prova4.ua4.model.Product;
import com.prova4.ua4.repository.ProductRepository;
import com.prova4.ua4.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "product")

public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

    @ApiOperation("Cadastra um produto")
    @PostMapping
    public Product cadastraProduct(@RequestBody Product product){
        System.out.println("Product save sussesfully");
        return productService.save(product);
    }

    @ApiOperation("Lista produtos cadastrados")
    @GetMapping
    public List <Product> buscarTodas(){
        return productService.list();
    }

    @PutMapping("product/{id}")
    public ResponseEntity edita (@PathVariable("id") long id,
                                        @RequestBody Product product){
        return productRepository.findById(id).map(record -> {
            record.setValue(product.getValue());
            Product edita = productRepository.save(record);
            return ResponseEntity.ok().body(edita);
        }).orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable(name="id") Long id){
        productService.delete(id);
    }
}
