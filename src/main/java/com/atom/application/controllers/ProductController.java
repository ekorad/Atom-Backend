package com.atom.application.controllers;

import java.util.List;


import com.atom.application.models.Product;
import com.atom.application.services.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductsService service;

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }
}
