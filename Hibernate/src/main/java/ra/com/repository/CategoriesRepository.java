package ra.com.repository;

import ra.com.model.Categories;

import java.util.List;

public interface CategoriesRepository {
    List<Categories> findAll();
    Categories findById(int catalogId);
    boolean save(Categories catalog);
    boolean update(Categories catalog);
    boolean delete(int catalogId);
}
