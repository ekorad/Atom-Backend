package com.atom.application.dtos;

public class DTOComm {
    
        private Long id;
        private String productsIds;
        private String userId;
		private String code;
        private String address;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}

		public String getProductsIds() {
			return productsIds;
		}
		public void setProductsIds(String productsIds) {
			this.productsIds = productsIds;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}


        
}
