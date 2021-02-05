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
       dto.setNewPrice(entity.getNewPrice());
       dto.setOldPrice(entity.getOldPrice());
        return dto;
    }

    @Override
    public Product mapToEntity(ProductDTO dto) {
        Product entity = new Product();
        entity.setProductName(dto.getProductName());
        entity.setDescription(dto.getDescription());
        entity.setImage(dto.getImage());
        entity.setNewPrice(dto.getNewPrice());
        entity.setOldPrice(dto.getOldPrice());
        return entity;
    }

  

    
}
