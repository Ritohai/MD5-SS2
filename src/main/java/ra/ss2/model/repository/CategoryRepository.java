package ra.ss2.model.repository;

import ra.ss2.model.entity.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();
    Boolean saveOrUpdate(Category category);
    Boolean  delete (Integer id);
    Category findById(Integer id);
}
