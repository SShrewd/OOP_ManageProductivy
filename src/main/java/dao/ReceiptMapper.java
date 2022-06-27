package dao;

import model.Receipt;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiptMapper implements IMapper<Receipt>{
    @Override
    public Receipt mapping(ResultSet resultSet) throws SQLException {
        Receipt receipt = new Receipt();
        receipt.setId(resultSet.getString("id"));
        receipt.setTotal(resultSet.getLong("total"));
        return receipt;
    }
}
