package ra.ss2.model.service;

import ra.ss2.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Boolean saveOrUpdate(Category category);
    void  delete (Integer id);
    Category findById(Integer id);
}
