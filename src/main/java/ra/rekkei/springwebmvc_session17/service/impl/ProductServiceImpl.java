package ra.rekkei.springwebmvc_session17.service.impl;

import ra.rekkei.springwebmvc_session17.model.entity.Product;
import ra.rekkei.springwebmvc_session17.repository.impl.ProductRepositoryImpl;
import ra.rekkei.springwebmvc_session17.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> findAll() {
        return new ProductRepositoryImpl().findAll();
    }

    @Override
    public Product findById(Integer proId) {
        return new ProductRepositoryImpl().findById(proId);
    }

    @Override
    public boolean save(Product product) {
        return new ProductRepositoryImpl().save(product);
    }

    @Override
    public boolean update(Product product) {
        return new ProductRepositoryImpl().update(product);
    }

    @Override
    public boolean delete(Integer proId) {
        return new ProductRepositoryImpl().delete(proId);
    }

    @Override
    public List<Product> findByName(String proName) {
        return new ProductRepositoryImpl().findByName(proName);
    }

    @Override
    public Product getLastProductJustInserted() {
        return new ProductRepositoryImpl().getLastProductJustInserted();
    }
}
