package ra.ss2.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.ss2.model.entity.Product;
import ra.ss2.model.repository.ProductRepository;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Boolean create(Product product) {
        return productRepository.create(product);
    }

    @Override
    public Integer find(Integer productID) {
        return null;
    }

    @Override
    public Boolean update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public Boolean delete(Integer productID) {
        return productRepository.delete(productID);
    }
}
