package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static Connection _instance;

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE_NAME = "media_one";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Shrewdtqh_24";

    public ConnectionDB(){

    }

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            _instance = DriverManager.getConnection(URL + DATABASE_NAME, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return _instance;
    }
}
