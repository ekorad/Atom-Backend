package com.atom.application.services;

import java.util.List;
import java.util.Optional;

import com.atom.application.models.Product;
import com.atom.application.repos.ProductRepository;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

    @Autowired
    private ProductRepository repo;

    /**
     * Retrieves all of the existing web products.
     * 
     * @return all of the existing web products, or an empty <code>List</code> if
     *         none exist
     */
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

/**
     * Retrieves a single web user whose username matches the requested username.
     * 
     * @param requestedUsername - the username of the requested web user
     * @return the requested web user
     * @throws javax.persistence.EntityNotFoundException if no web user is found for
     *                                                   the requested username
     */
    public Product getProductByProductName(String requestedProductName) {
        Optional<Product> persistedRequestedProductOpt = repo.findByProductName(requestedProductName);
        if (!persistedRequestedProductOpt.isPresent()) {
            throw new EntityNotFoundException("No product found with product name: '" + requestedProductName + "'");
        }
        Product persistedRequestedProduct = persistedRequestedProductOpt.get();
        return persistedRequestedProduct;
    }

}
