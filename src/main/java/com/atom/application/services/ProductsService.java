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

    public Product updateProduct(long id,Product updatedroduct) {
        
        Product existingProductDb=  getProductById(id).get();

        existingProductDb.setCpu(updatedroduct.getCpu());
        existingProductDb.setDescription(updatedroduct.getDescription());
        existingProductDb.setGpu(updatedroduct.getGpu());
        existingProductDb.setMotherBoard(updatedroduct.getMotherBoard());
        existingProductDb.setProductName(updatedroduct.getProductName());
        existingProductDb.setNewPrice(updatedroduct.getNewPrice());
        existingProductDb.setOldPrice(updatedroduct.getOldPrice());
        existingProductDb.setRam(updatedroduct.getRam());
        //i do not want to update reviews
        //existingProductDb.setReviews(updatedroduct.getReviews());

        return repo.save(existingProductDb);
    }

    public void deleteProducts(List<String>  idsProductsToBeDeleted) {
        List<Product> products = new ArrayList<Product>();
        List<Long> longIds = new ArrayList();
        
        for (String stringId : idsProductsToBeDeleted) {
            longIds.add(Long.valueOf(stringId));
        }
        for (Long productId : longIds) {
            Optional<Product> p = repo.findById(productId);
            products.add(p.get());
        }
        repo.deleteInBatch(products);
    }


    public Optional <Product> getProductsByIdFroDiscount(List<String> ids) {
       

        List<Long> longIds = new ArrayList();

        for (String stringId : ids) {
            longIds.add(Long.valueOf(stringId));
        }

        
        int sumatotala=0;

        for (Long productId : longIds) {
            sumatotala+=  repo.findById(productId).get().getOldPrice();
            
        }

        int medie = sumatotala/ids.size();
        int smaller = -1;
        Long id=0l;
        List<Product> products = getAllProducts();

        for (Product product : products) {
            
            if(0< medie-product.getOldPrice() &&  medie-product.getOldPrice()< medie-smaller){
                smaller=product.getOldPrice();
                id=product.getId();
                
            }
        }

        return repo.findById(id);
    }

}
