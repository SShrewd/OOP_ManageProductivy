package dao;

import model.MovieProduct;
import model.MusicProduct;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MusicMapper implements IMapper<MusicProduct>{
    @Override
    public MusicProduct mapping(ResultSet resultSet) throws SQLException {
        MusicProduct movieProduct = new MusicProduct();
        movieProduct.setId(resultSet.getString("id"));
        movieProduct.setName(resultSet.getString("name"));

        movieProduct.setAmount(resultSet.getInt("amount"));

        movieProduct.setOutPrice(resultSet.getDouble("outPrice"));

        movieProduct.setInPrice(resultSet.getDouble("inPrice"));
        return movieProduct;
    }
}
