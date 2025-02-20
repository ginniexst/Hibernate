package ra.com.repository.imp;

import org.springframework.stereotype.Repository;
import ra.com.model.Categories;
import ra.com.repository.CategoriesRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CategoriesRepositoryImp implements CategoriesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Categories> findAll() {
        return entityManager.createQuery("from Categories", Categories.class).getResultList();
    }

    @Override
    public Categories findById(int catalogId) {
        return entityManager.createQuery("from Categories c where c.catalogId = :id", Categories.class)
                .setParameter("id", catalogId).getSingleResult();
    }

    // Khi thêm, sửa, xoá, có thể gây ra lỗi nên cần quản lý transaction
    // --> có lỗi thì rollback, thành công thì commit
    @Override
    @Transactional
    public boolean save(Categories catalog) {
        try {
            entityManager.persist(catalog);
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(Categories catalog) {
        try {
            entityManager.merge(catalog);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int catalogId) {
        try {
            Categories catalog = findById(catalogId);
            entityManager.remove(catalog);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
