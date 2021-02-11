package com.atom.application.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.atom.application.dtos.DTOComm;
import com.atom.application.models.DeliveryAddress;
import com.atom.application.models.Order;
import com.atom.application.models.Product;
import com.atom.application.models.WebUser;
import com.atom.application.services.OrderService;
import com.atom.application.services.ProductsService;
import com.atom.application.services.WebUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private WebUserService webUserService;
    @Autowired
    private ProductsService productsService;

    @PostMapping("/add")
    public void addNewProduct(@Valid @RequestBody DTOComm commandToBeAdded) {

System.out.println(commandToBeAdded.toString());
        
        List<String> ids = Arrays.asList(commandToBeAdded.getProductsIds().split(","));

        List<Optional<Product>> optionalProducts = productsService.getProductsById(ids);

        List<Product> products=   new ArrayList<Product>();

        for (Optional<Product> product : optionalProducts) {
            products.add(product.get());
        }
        //System.out.println(products.toString()+"products");

        Optional<WebUser> optionalUser = webUserService.getUserById(Long.parseLong(commandToBeAdded.getUserId()));
        //System.out.println(optionalUser.toString()+"optional user");
        WebUser user = new WebUser();
        user = optionalUser.get();
        //System.out.println(user.toString()+"optional user user");
        Order order = new Order();

        DeliveryAddress deliveryAdress = new DeliveryAddress(commandToBeAdded.getCode(), commandToBeAdded.getAddress());

        order.setAddress(deliveryAdress);
        order.setProducts(products);
        order.setUser(user);
        //System.out.println(order.toString()+ "order");
        orderService.addNewOrder(order);

    }

    @PutMapping(path = "/update", params = { "id" })
    public void updateExistingProd(
        @Valid @RequestParam Long id,
            @Valid @RequestBody Order editedOrder) {
                orderService.updateOrder(id, editedOrder);
    }

    @GetMapping(path = "/ordersByIds", params = { "IdsAtOnce" })
    public List<Order> getProductByIds(@Valid @RequestParam String IdsAtOnce) {
        List<String> ids = Arrays.asList(IdsAtOnce.split(","));
        
        return orderService.getOrdersById(ids);

    }

    @DeleteMapping(path = "/delete", params = { "IdsAtOnce" })
    public void deleteProductByIds(@Valid @RequestParam String IdsAtOnce) {
        List<String> ids = Arrays.asList(IdsAtOnce.split(","));
        
        orderService.deleteOrders(ids);

    }
}
