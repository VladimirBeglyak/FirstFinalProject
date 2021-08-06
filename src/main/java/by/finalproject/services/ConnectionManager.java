package by.finalproject.services;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    public static Connection newConnection() throws ClassNotFoundException, SQLException {

        Properties properties = new Properties();

        try (InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("db.properties")) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String password=properties.getProperty("db.password");
        String driver = properties.getProperty("db.driver");

        Class.forName(driver);

        return DriverManager.getConnection(url,user,password);
    }
}
