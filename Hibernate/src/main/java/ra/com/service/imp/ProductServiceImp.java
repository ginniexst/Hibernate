package ra.com.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.com.model.Product;
import ra.com.repository.ProductRepository;
import ra.com.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int productId) {
        return productRepository.findById(productId);
    }

    @Override
    public boolean save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public boolean delete(int productId) {
        return productRepository.delete(productId);
    }
}
