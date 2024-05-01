package com.example.Products.Repository;

import com.example.Products.Model.ProductJSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.Products.Repository.DbConstants.*;

public class ProductRepository {

    public static void insertProducts(String productName, String productPrice, Boolean productAvailability){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(RDS_URL, USERNAME, PASSWORD);

            String insertProduct = "insert into csci_5409_a2_database.products (name, price, availability) values (?, ?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(insertProduct);
            insertStmt.setString(1, productName);
            insertStmt.setString(2, productPrice);
            insertStmt.setBoolean(3, productAvailability);

            int rowsAffected = insertStmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Products Inserted: " + productName + " | " + productPrice + " | " + productAvailability);
            } else {
                System.out.println("Failed to insert product: " + productName);
            }

            insertStmt.close();
            connection.close();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static JSONObject getProducts(){
        JSONObject resultJSON = new JSONObject();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(RDS_URL, USERNAME, PASSWORD);

            String listProduct = "select * from csci_5409_a2_database.products";
            PreparedStatement selectStmt = connection.prepareStatement(listProduct);

            ResultSet productList = selectStmt.executeQuery(listProduct);


            JSONArray productsArray = new JSONArray();
            while(productList.next()){
                JSONObject productJSON = new JSONObject();
                productJSON.put("name", productList.getString("name"));
                productJSON.put("price", productList.getString("price"));
                productJSON.put("availability", productList.getBoolean("availability"));
                productsArray.add(productJSON);
                System.out.println("Getting product list:");
                System.out.println(productsArray);
            }

//            JSONObject resultJSON = new JSONObject();
            resultJSON.put("products", productsArray);

            selectStmt.close();
            connection.close();

//            // Adding random data
//            ProductJSON p1 = new ProductJSON("p1", "1", true);
//            ProductJSON p2 = new ProductJSON("p2", "12", false);
//            ProductJSON p3 = new ProductJSON("p3", "13", false);
//            ProductJSON p4 = new ProductJSON("p4", "3", true);
//            List<ProductJSON> dataList = new ArrayList<>();
//            dataList.add(p1);
//            dataList.add(p2);
//            dataList.add(p3);
//            dataList.add(p4);
            
        }
        catch (Exception e){
            System.out.println(e);
        }
        return resultJSON;
    }

}
