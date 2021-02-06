package com.atom.application.dtos;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProductDTO {
    
    private Long id;
    @NotBlank(message = "Product name is mandatory ")
    @Size(min = 2, max = 30, message = "Product name must contain between 2 and 30 valid characters")
    private String productName;
    @NotBlank(message = "Description is mandatory and cannot contain only whitespace")
    @Size(min = 2, max = 90, message = "Description must contain between 2 and 30 valid characters")
    private String description;
    @NotBlank(message = "Price is mandatory and cannot contain only whitespace")
    private int oldPrice;
    @NotBlank(message = "Price is mandatory and cannot contain only whitespace")
    private int newPrice;
    @NotBlank(message = "Image is mandatory")
    private byte[] image;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
    
    public int getOldPrice() {
        return oldPrice;
    }
    public void setOldPrice(int oldPrice) {
        this.oldPrice = oldPrice;
    }
    public int getNewPrice() {
        return newPrice;
    }
    public void setNewPrice(int newPrice) {
        this.newPrice = newPrice;
    }
}
