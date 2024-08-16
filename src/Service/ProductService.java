package Service;

import DAO.ProductDAO;
import DB.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {

    private ProductDAO productDAO;

    public ProductService() throws SQLException {
        productDAO = new ProductDAO();
    }

    public void addProduct(int productId,String productName, double price, int stock)throws SQLException{
        Product product = new Product();
        product.setProductId(productId);
        product.setProductName(productName);
        product.setPrice(price);
        product.setStock(stock);
        productDAO.addProduct(product);
    }

    public Product getProduct(int productId)throws SQLException{
        return productDAO.getProduct(productId);
    }

    public List<Product> getAllProduct()throws SQLException{
        return productDAO.getAllProduct();
    }

    public void updateProduct(int productId,String productName, double price, int stock)throws SQLException{
        Product product = new Product();
        product.setProductId(productId);
        product.setProductName(productName);
        product.setPrice(price);
        product.setStock(stock);
        productDAO.updateProduct(product);

    }

    public void deleteProduct(int productId)throws SQLException{
        productDAO.deleteProduct(productId);
    }



}
