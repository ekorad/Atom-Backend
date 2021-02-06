package com.atom.application.services;

import java.util.ArrayList;
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


    public Product getProductByProductName(String requestedProductName) {
        Optional<Product> persistedRequestedProductOpt = repo.findByProductName(requestedProductName);
        if (!persistedRequestedProductOpt.isPresent()) {
            throw new EntityNotFoundException("No product found with product name: '" + requestedProductName + "'");
        }
        Product persistedRequestedProduct = persistedRequestedProductOpt.get();
        return persistedRequestedProduct;
    }

    public Product addNewProduct(Product newProduct) {
        return repo.save(newProduct);
    }

    public Optional<Product> getProductById(Long id) {
       
        Optional<Product> p = repo.findById(id);
        
        return p;
    }

    public List<Optional<Product>> getProductsById(List<String> ids) {
       
        List<Optional<Product>> products = new ArrayList<Optional<Product>>();

        List<Long> longIds = new ArrayList();

        for (String stringId : ids) {
            longIds.add(Long.valueOf(stringId));
        }

        for (Long productId : longIds) {
            Optional<Product> p = repo.findById(productId);
            products.add(p);
        }
        return products;
    }

}
