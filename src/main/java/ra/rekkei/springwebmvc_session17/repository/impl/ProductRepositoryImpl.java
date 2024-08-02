package ra.rekkei.springwebmvc_session17.repository.impl;

import ra.rekkei.springwebmvc_session17.db.DBUtility;
import ra.rekkei.springwebmvc_session17.model.entity.Product;
import ra.rekkei.springwebmvc_session17.repository.ProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();

        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;

        con = DBUtility.getConnection();
        try {
            pstmt = con.prepareStatement("select * from products");
            rs = pstmt.executeQuery();
            while(rs.next()){
                Product p = new Product();
                p.setProId(rs.getInt("product_id"));
                p.setProName(rs.getString("product_name"));
                p.setProducer(rs.getString("producer"));
                p.setYearMaking(rs.getInt("year_making"));
                p.setExpireDate(rs.getDate("expire_date"));
                p.setPrice(rs.getDouble("price"));
                p.setUnitPrice(rs.getString("unit_price"));
                p.setColor(rs.getString("color"));
                p.setImageName(rs.getString("imageName"));
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
    public Product findById(Integer proId) {
        Product p = null;

        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;

        con = DBUtility.getConnection();
        try {
            pstmt = con.prepareStatement("select * from products where product_id=?");
            pstmt.setInt(1,proId);
            rs = pstmt.executeQuery();
            if(rs.next()){
                p = new Product();
                p.setProId(rs.getInt("product_id"));
                p.setProName(rs.getString("product_name"));
                p.setProducer(rs.getString("producer"));
                p.setYearMaking(rs.getInt("year_making"));
                p.setExpireDate(rs.getDate("expire_date"));
                p.setPrice(rs.getDouble("price"));
                p.setUnitPrice(rs.getString("unit_price"));
                p.setColor(rs.getString("color"));
                p.setImageName(rs.getString("imageName"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtility.closeConnection(con);
        }

        return p;
    }

    @Override
    public boolean save(Product product) {
        boolean bl = false;

        Connection con;
        PreparedStatement pstmt;

        con = DBUtility.getConnection();
        try {
            pstmt = con.prepareStatement("insert into products(product_name,producer,year_making,expire_date,price,unit_price,color,imageName) values (?,?,?,?,?,?,?,?)");
            pstmt.setString(1, product.getProName());
            pstmt.setString(2, product.getProducer());
            pstmt.setInt(3, product.getYearMaking());
            pstmt.setDate(4, new Date(product.getExpireDate().getTime()));
            pstmt.setDouble(5, product.getPrice());
            pstmt.setString(6, product.getUnitPrice());
            pstmt.setString(7, product.getColor());
            pstmt.setString(8, product.getImageName());
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
    public boolean update(Product product) {
        boolean bl = false;

        Connection con;
        PreparedStatement pstmt;

        con = DBUtility.getConnection();
        try {
            pstmt = con.prepareStatement("update products set product_name=?,producer=?,year_making=?,expire_date=?,price=?,unit_price=?,color=?,imageName=? where product_id=?");
            pstmt.setString(1, product.getProName());
            pstmt.setString(2, product.getProducer());
            pstmt.setInt(3, product.getYearMaking());
            pstmt.setDate(4, new Date(product.getExpireDate().getTime()));
            pstmt.setDouble(5, product.getPrice());
            pstmt.setString(6, product.getUnitPrice());
            pstmt.setString(7, product.getColor());
            pstmt.setString(8, product.getImageName());
            pstmt.setInt(9, product.getProId());
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
    public boolean delete(Integer proId) {
        boolean bl = false;

        Connection con;
        PreparedStatement pstmt;

        con = DBUtility.getConnection();
        try {
            pstmt = con.prepareStatement("delete from where product_id=?");
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

    @Override
    public List<Product> findByName(String proName) {
        List<Product> list = new ArrayList<>();

        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;

        con = DBUtility.getConnection();
        try {
            if(proName==null || !proName.isEmpty()){
                proName = "%";
            }else{
                proName = "%"+proName+"%";
            }
            pstmt = con.prepareStatement("select * from products where product_name like ?");
            pstmt.setString(1, proName);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Product p = new Product();
                p.setProId(rs.getInt("product_id"));
                p.setProName(rs.getString("product_name"));
                p.setProducer(rs.getString("producer"));
                p.setYearMaking(rs.getInt("year_making"));
                p.setExpireDate(rs.getDate("expire_date"));
                p.setPrice(rs.getDouble("price"));
                p.setUnitPrice(rs.getString("unit_price"));
                p.setColor(rs.getString("color"));
                p.setImageName(rs.getString("imageName"));
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
    public Product getLastProductJustInserted() {
        Product p = null;

        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;

        con = DBUtility.getConnection();
        try {
            pstmt = con.prepareStatement("select * from products order by product_id desc limit 1");
            rs = pstmt.executeQuery();
            if(rs.next()){
                p = new Product();
                p.setProId(rs.getInt("product_id"));
                p.setProName(rs.getString("product_name"));
                p.setProducer(rs.getString("producer"));
                p.setYearMaking(rs.getInt("year_making"));
                p.setExpireDate(rs.getDate("expire_date"));
                p.setPrice(rs.getDouble("price"));
                p.setUnitPrice(rs.getString("unit_price"));
                p.setColor(rs.getString("color"));
                p.setImageName(rs.getString("imageName"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtility.closeConnection(con);
        }

        return p;
    }
}
