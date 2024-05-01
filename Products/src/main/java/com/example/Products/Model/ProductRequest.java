package com.example.Products.Model;

import java.util.List;

public class ProductRequest {
    private List<ProductJSON> products;

    public void ProductsRequest() {
    }

    public List<ProductJSON> getProducts() {
        return products;
    }

    public void setProducts(List<ProductJSON> products) {
        this.products = products;
    }
}
