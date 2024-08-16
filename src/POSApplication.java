import Service.ProductService;

import java.sql.SQLException;

public class POSApplication {
    public static void main(String[] args) {
        try{
            ProductService productService = new ProductService();
            productService.addProduct(1,"Laptop",999.99,10);
            System.out.println("Product Added Successfully!");


        }catch(SQLException e){
            e.printStackTrace();
        }


    }
}