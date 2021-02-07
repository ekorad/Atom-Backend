package com.atom.application.services;

import java.util.List;


import com.atom.application.models.Order;
import com.atom.application.repos.OrderRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;
    
    
    public List<Order> getAllOrders() {
        return repo.findAll();
    }

    public Order addNewOrder(Order newOrder) {
        return repo.save(newOrder);
    }
}
