package ra.ss2.model.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.ss2.model.entity.Product;

import java.util.List;
@Repository
public class ProductRepositoryImpl implements ProductRepository{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Product> getAll() {
        Session session = sessionFactory.openSession();
        try {
            List list = session.createQuery("from Product p ORDER BY p.productId DESC").list();
            return list;
        } catch (Exception e) {
            // TODO: handle exception\
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean create(Product product) {
        Session session = sessionFactory.openSession();
        try {
            session.save(product);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public Product find(Integer productID) {
        Session session = sessionFactory.openSession();
        try {
            Product product = session.get(Product.class, productID);
            return product;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Boolean update(Product product) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public Boolean delete(Integer productID) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(find(productID));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }
}
