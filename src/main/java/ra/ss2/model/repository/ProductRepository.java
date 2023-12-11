package ra.ss2.model.repository;

import ra.ss2.model.entity.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> getAll();
    public Boolean create(Product product);
    public Product find(Integer productID);
    public Boolean update(Product product);
    public Boolean delete(Integer productID);
}
