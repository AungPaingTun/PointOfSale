package DAO;

import DB.DatabaseConnection;
import DB.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {


    private Connection conn;

    public ProductDAO() throws SQLException {
        conn = DatabaseConnection.getConnection();
    }


    public void addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO Products (product_id,product_name,price,stock) VALUES (?,?,?,?)";

        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,product.getProductId());
            pstmt.setString(2,product.getProductName());
            pstmt.setDouble(3,product.getPrice());
            pstmt.setInt(4,product.getStock());
            pstmt.executeUpdate();
        }
    }

    public Product getProduct(int productId) throws SQLException {
        String sql = "SELECT * FROM Products WHERE product_id=?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,productId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return new Product(rs.getInt("product_id"), rs.getString("product_name"),
                        rs.getDouble("price"), rs.getInt("stock"));
            }
        }

        return null;
    }

    public List<Product> getAllProduct() throws SQLException {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM Products";
        try(Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                productList.add(new Product(
                        rs.getInt("product_id"), rs.getString("product_name"),
                        rs.getDouble("price"), rs.getInt("stock")));
            }
        }
        return productList;
    }


    public void updateProduct(Product product) throws SQLException {
        String sql = "UPDATE Products SET product_name = ?, price = ?, stock = ? WHERE product_id = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,product.getProductName());
            pstmt.setDouble(2,product.getPrice());
            pstmt.setInt(3,product.getStock());
            pstmt.setInt(4,product.getProductId());
            pstmt.executeUpdate();

        }
    }

    public void deleteProduct(int productId) throws SQLException {
        String sql = "DELETE FROM Products WHERE product_id = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,productId);
            pstmt.executeUpdate();
        }
    }

}
