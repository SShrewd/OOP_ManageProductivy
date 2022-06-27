package dao;

import model.MusicProduct;
import model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements IMapper<Product>{
    @Override
    public Product mapping(ResultSet resultSet) throws SQLException {
        Product movieProduct = new Product();
        movieProduct.setId(resultSet.getString("id"));
        movieProduct.setName(resultSet.getString("name"));

        movieProduct.setAmount(resultSet.getInt("amount"));

        movieProduct.setOutPrice(resultSet.getDouble("outPrice"));

        movieProduct.setInPrice(resultSet.getDouble("inPrice"));
        return movieProduct;
    }
}
