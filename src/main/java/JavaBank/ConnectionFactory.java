package JavaBank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private final String URL = "jdbc:mysql://localhost:3306/javabank";
    private final String USER = "suporte";
    private final String PASSWORD = "Mau0521@";
    private final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    private Connection criarConexão() throws ClassNotFoundException {
        Connection connection = null;
        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return connection;
    }

    public Connection getConnection(){
        try {
            return criarConexão();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
