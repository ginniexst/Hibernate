package ra.com.repository.imp;

import org.springframework.stereotype.Repository;
import ra.com.model.Product;
import ra.com.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepositoryImp implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product findById(int productId) {
        return entityManager.createQuery("from Product p where p.productId = :id",
                Product.class).setParameter("id", productId).getSingleResult();
    }

    @Override
    @Transactional
    public boolean save(Product product) {
        boolean result = false;
        try {
            entityManager.persist(product);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(Product product) {
        try {
            entityManager.merge(product);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int productId) {
        try {
            Product product = findById(productId);
            entityManager.remove(product);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
