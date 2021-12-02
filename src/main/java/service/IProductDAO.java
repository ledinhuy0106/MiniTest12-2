package service;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    public void add(Product product)throws SQLException;

    public List<Product> findAll();

    public Product findById(int id );

    public List<Product> findByName(String name);

    public void edit(int id,Product product);

    public void delete(int id);

    public List<Product> sortByQuantity();

}
