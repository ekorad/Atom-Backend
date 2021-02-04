package com.atom.application.mappers;

import com.atom.application.dtos.ProductDTO;
import com.atom.application.models.Product;


public class ProductMapper implements EntityDTOMapper<Product, ProductDTO>{

    @Override
    public ProductDTO mapToDto(Product entity) {
        ProductDTO dto = new ProductDTO();
       dto.setProductName(entity.getProductName());
       dto.setDescription(entity.getDescription());
       dto.setImage(entity.getImage());
       dto.setPrice(entity.gePrice());
        return dto;
    }

    @Override
    public Product mapToEntity(ProductDTO dto) {
        Product entity = new Product();
        entity.setProductName(dto.getProductName());
        entity.setDescription(dto.getDescription());
        entity.setImage(dto.getImage());
        entity.setPrice(dto.gePrice());
        return entity;
    }

  

    
}
