package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IMapper<T> {
    public T mapping(ResultSet resultSet) throws SQLException;
}