package com.example.Products.Controller;

import com.example.Products.Model.ProductJSON;
import com.example.Products.Model.ProductRequest;
import com.example.Products.Repository.ProductRepository;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsAPI {

    @PostMapping(value = "/store-products")
    public JSONObject storeProducts(@RequestBody ProductRequest productRequest) {
        JSONObject result = new JSONObject();
        List<ProductJSON> products = productRequest.getProducts();

        if (products == null || products.isEmpty()) {
            String errorMessage = "Invalid JSON input. Products array is empty.";
            result.put("error", errorMessage);
            return result;
        }

        assert products != null;
        for (ProductJSON product : products) {
            String name = product.getName();
            String price = product.getPrice();
            boolean availability = product.isAvailability();

            if (name == null || price == null) {
                String errorMessage = "Invalid product in the array.";
                result.put("error", errorMessage);
                return result;
            }

            // Process the product or insert into the database
            ProductRepository.insertProducts(name, price, availability);
            System.out.println(name + " | " + price + " | " + availability);
        }

        result.put("message", "Success.");

        return result;
    }

    @GetMapping(value = "/list-products")
    public JSONObject listProducts() {
        JSONObject result = ProductRepository.getProducts();
        return result;
    }

}
