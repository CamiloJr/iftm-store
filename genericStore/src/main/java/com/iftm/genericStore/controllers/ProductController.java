package com.iftm.genericStore.controllers;

import com.iftm.genericStore.entities.Product;
import com.iftm.genericStore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable String id) {
        return productService.findById(id);
    }

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        productService.deleteById(id);
    }

    @DeleteMapping
    public void delete(@RequestBody Product product) {
        productService.delete(product);
    }
}
