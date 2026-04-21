package com.product_services.controller;

import com.product_services.beans.Product;
import com.product_services.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return repo.findById(id).orElseThrow();
    }

    @PutMapping("/{id}/reduce")
    public void reduceStock(@PathVariable Long id, @RequestParam int qty){

        Product product = repo.findById(id).orElseThrow();
        if(product.getStock()<qty){
            throw new RuntimeException("Insufficient Stock");
        }
        product.setStock(product.getStock() - qty);
        repo.save(product);
    }
}
