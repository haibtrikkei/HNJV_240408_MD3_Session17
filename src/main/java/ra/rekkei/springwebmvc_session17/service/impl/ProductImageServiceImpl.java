package ra.rekkei.springwebmvc_session17.service.impl;

import ra.rekkei.springwebmvc_session17.model.entity.ProductImage;
import ra.rekkei.springwebmvc_session17.repository.impl.ProductImageRepositoryImpl;
import ra.rekkei.springwebmvc_session17.service.ProductImageService;

import java.util.List;

public class ProductImageServiceImpl implements ProductImageService {
    @Override
    public List<ProductImage> findAll() {
        return new ProductImageRepositoryImpl().findAll();
    }

    @Override
    public boolean save(ProductImage productImage) {
        return new ProductImageRepositoryImpl().save(productImage);
    }

    @Override
    public boolean update(ProductImage productImage) {
        return new ProductImageRepositoryImpl().update(productImage);
    }

    @Override
    public boolean delete(Integer imageId) {
        return new ProductImageRepositoryImpl().delete(imageId);
    }

    @Override
    public boolean deleteByProId(Integer proId) {
        return new ProductImageRepositoryImpl().deleteByProId(proId);
    }
}
