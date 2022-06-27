package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ServiceDAO<T> implements IServiceDAO<T>{


    private static ConnectionDB connector;

    static {
        connector = new ConnectionDB();
    }


    @Override
    public List<T> query(String sql, IMapper<T> mapper, Object... member) {
        List<T> result = new ArrayList<>();
        Connection connection = connector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            mapping(preparedStatement, member);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                result.add(mapper.mapping(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    protected boolean modify(String sql, Object... member){
        Connection connection = connector.getConnection();
        boolean isSuccess = false;
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = connection.prepareStatement(sql);
            mapping(preparedStatement, member);
            preparedStatement.execute();
            isSuccess = true;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isSuccess;
    }

    @Override
    public boolean insert(String sql, Object... member) {
        return modify(sql, member);
    }

    @Override
    public boolean update(String sql, Object... member) {
        return modify(sql, member);
    }

    @Override
    public boolean delete(String sql, Object... member) {
        return modify(sql, member);
    }

    public void mapping(PreparedStatement preparedStatement, Object... member) throws SQLException {
        for(int i=0; i<member.length; i++){
            int index = i + 1;
            Object object = member[i];
            if(object == null){
                preparedStatement.setObject(index, null);
            }else if(object instanceof Integer){
                preparedStatement.setInt(index, (int) object);
            } else if(object instanceof String){
                preparedStatement.setString(index, (String) object);
            } else if(object instanceof Date){
                preparedStatement.setTimestamp(index, new Timestamp(((Date) object).getTime()));
            } else if(object instanceof Long){
                preparedStatement.setLong(index, (long) object);
            } else if(object instanceof Boolean){
                preparedStatement.setInt(index, ((boolean)object? 1 : 0) );
            } else{
                preparedStatement.setString(index, object.toString());
            }
        }
    }

}