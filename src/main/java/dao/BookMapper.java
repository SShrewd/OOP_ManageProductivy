package dao;

import model.BookProduct;
import model.MusicProduct;

import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements IMapper<BookProduct>{
    @Override
    public BookProduct mapping(ResultSet resultSet) throws SQLException {
        BookProduct movieProduct = new BookProduct();
        movieProduct.setId(resultSet.getString("id"));
        movieProduct.setName(resultSet.getString("name"));

        movieProduct.setAmount(resultSet.getInt("amount"));

        movieProduct.setOutPrice(resultSet.getDouble("outPrice"));

        movieProduct.setInPrice(resultSet.getDouble("inPrice"));
        return movieProduct;
    }
}
