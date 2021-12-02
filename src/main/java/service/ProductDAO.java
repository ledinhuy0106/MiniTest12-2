package service;

import model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ProductDAO implements IProductDAO {

    public ProductDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo20062?useSSL=false", "root", "123456");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void add(Product product) throws SQLException {

    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

    @Override
    public void edit(int id, Product product) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Product> sortByQuantity() {
        return null;
    }

}
