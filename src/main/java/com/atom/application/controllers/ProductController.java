package com.atom.application.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.atom.application.models.Product;
import com.atom.application.services.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    // do not verify it s admin, because only there will be this function
    @PostMapping("/add")
    public void addNewProduct(@Valid @RequestBody Product newWebProduct) {
        service.addNewProduct(newWebProduct);
    }

    @GetMapping(path = "/product", params = { "id" })
    public Optional<Product> getProductById(@Valid @RequestParam Long id) {
       return  service.getProductById(id);
    }

    @GetMapping(path = "/produse", params = { "IdsAtOnce" })
    public List<Optional<Product>> getProductByIds(@Valid @RequestParam String IdsAtOnce) {
        List<String> ids = Arrays.asList(IdsAtOnce.split(","));
        
        return service.getProductsById(ids);

    }

    @PutMapping(path = "/update", params = { "productName" })
    public void updateExistingProd(
            @RequestParam @NotBlank(message = "product is mandatory and cannot contain only whitespace") @Size(min = 1, max = 30, message = "product must contain between 5 and 30 valid characters") String productName,
            @Valid @RequestBody Product editedProduct) {
        service.updateProduct(productName, editedProduct);
    }

    @DeleteMapping(path = "/delete", params = { "IdsAtOnce" })
    public void deleteProductByIds(@Valid @RequestParam String IdsAtOnce) {
        List<String> ids = Arrays.asList(IdsAtOnce.split(","));
        
         service.deleteProducts(ids);

    }

}
