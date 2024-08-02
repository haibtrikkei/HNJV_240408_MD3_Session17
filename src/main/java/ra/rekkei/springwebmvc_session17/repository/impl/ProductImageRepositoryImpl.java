package ra.rekkei.springwebmvc_session17.repository.impl;

import ra.rekkei.springwebmvc_session17.db.DBUtility;
import ra.rekkei.springwebmvc_session17.model.entity.Product;
import ra.rekkei.springwebmvc_session17.model.entity.ProductImage;
import ra.rekkei.springwebmvc_session17.repository.ProductImageRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductImageRepositoryImpl implements ProductImageRepository {
    @Override
    public List<ProductImage> findAll() {
        List<ProductImage> list = new ArrayList<>();

        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;

        con = DBUtility.getConnection();
        try {
            pstmt = con.prepareStatement("select * from product_image");
            rs = pstmt.executeQuery();
            while(rs.next()){
                ProductImage p = new ProductImage();
                p.setImageId(rs.getInt("image_id"));
                p.setProId(rs.getInt("product_id"));
                p.setImageName(rs.getString("image_name"));
                list.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtility.closeConnection(con);
        }
        return list;
    }

    @Override
    public boolean save(ProductImage productImage) {
        boolean bl = false;

        Connection con;
        PreparedStatement pstmt;

        con = DBUtility.getConnection();
        try {
            pstmt = con.prepareStatement("insert into product_image(product_id,image_name) values (?,?)");
            pstmt.setInt(1, productImage.getProId());
            pstmt.setString(2, productImage.getImageName());
            int i = pstmt.executeUpdate();
            if(i>0)
                bl = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtility.closeConnection(con);
        }

        return bl;
    }

    @Override
    public boolean update(ProductImage productImage) {
        boolean bl = false;

        Connection con;
        PreparedStatement pstmt;

        con = DBUtility.getConnection();
        try {
            pstmt = con.prepareStatement("update product_image set product_id=?,image_name=? where image_id=?");
            pstmt.setInt(1, productImage.getProId());
            pstmt.setString(2, productImage.getImageName());
            pstmt.setInt(3, productImage.getImageId());
            int i = pstmt.executeUpdate();
            if(i>0)
                bl = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtility.closeConnection(con);
        }

        return bl;
    }

    @Override
    public boolean delete(Integer imageId) {
        boolean bl = false;

        Connection con;
        PreparedStatement pstmt;

        con = DBUtility.getConnection();
        try {
            pstmt = con.prepareStatement("delete from product_image where image_id=?");
            pstmt.setInt(1, imageId);
            int i = pstmt.executeUpdate();
            if(i>0)
                bl = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtility.closeConnection(con);
        }

        return bl;
    }

    @Override
    public boolean deleteByProId(Integer proId) {
        boolean bl = false;

        Connection con;
        PreparedStatement pstmt;

        con = DBUtility.getConnection();
        try {
            pstmt = con.prepareStatement("delete from product_image where product_id=?");
            pstmt.setInt(1, proId);
            int i = pstmt.executeUpdate();
            if(i>0)
                bl = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtility.closeConnection(con);
        }

        return bl;
    }
}
