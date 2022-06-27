package dao;

import model.MovieProduct;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper implements IMapper<MovieProduct>{
    @Override
    public MovieProduct mapping(ResultSet resultSet) throws SQLException {
        MovieProduct movieProduct = new MovieProduct();
        movieProduct.setId(resultSet.getString("id"));
        movieProduct.setName(resultSet.getString("name"));

        movieProduct.setAmount(resultSet.getInt("amount"));

        movieProduct.setOutPrice(resultSet.getDouble("outPrice"));

        movieProduct.setInPrice(resultSet.getDouble("inPrice"));
        return movieProduct;
    }
}
