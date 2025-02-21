package ra.com.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.com.model.Categories;
import ra.com.model.Product;
import ra.com.repository.CategoriesRepository;
import ra.com.repository.ProductRepository;
import ra.com.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoriesRepository categoriesRepository;

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
        Categories catalog = categoriesRepository.findById(product.getCatalog().getCatalogId());
        Product newProduct = new Product(
                product.getProductId(),
                product.getProductName(),
                product.getPrice(),
                product.isStatus(),
                catalog);
        return productRepository.save(newProduct);
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
