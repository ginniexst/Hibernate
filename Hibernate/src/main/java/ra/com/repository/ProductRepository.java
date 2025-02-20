package ra.com.repository;

import ra.com.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(int productId);
    boolean save(Product product);
    boolean update(Product product);
    boolean delete(int productId);
}
