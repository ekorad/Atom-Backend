package com.atom.application.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.atom.application.dtos.DTOComm;
import com.atom.application.models.Product;
import com.atom.application.models.WebUser;
import com.atom.application.services.CommandService;
import com.atom.application.services.ProductsService;
import com.atom.application.services.WebUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commands")
public class CommandController {

    // @Autowired
    // private CommandService commandService;
    // @Autowired
    // private WebUserService webUserService;
    @Autowired
    private ProductsService productsService;

    @PostMapping("/add")
    public void addNewProduct(@Valid @RequestBody DTOComm commandToBeAdded) {

        //WebUser user = webUserService.getUserById(Long.parseLong(commandToBeAdded.getUserId())).get();

        List<String> ids = Arrays.asList(commandToBeAdded.getProductsIds().split(","));

        List<Optional<Product>> optionalProducts = productsService.getProductsById(ids);

        List<Product> products=  null;

        for (Optional<Product> product : optionalProducts) {
            products.add(product.get());
        }

        System.out.println(products+"products");
    }
}
