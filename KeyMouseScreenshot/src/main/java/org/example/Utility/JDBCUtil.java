package org.example.Utility;

import com.mysql.cj.protocol.a.authentication.MysqlNativePasswordPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtil {
    private String URL;
    private String user;
    private String password;
    Connection connection;

    public JDBCUtil(String URL, String user, String password) {
        this.URL = URL;
        this.user = user;
        this.password = password;
        this.connection = null;
    }

    public Connection getConnection() {
        //get the connection
        try {
            connection = DriverManager.getConnection(URL, user, password);
        } catch (SQLException ex) {
            System.out.println("Error getting connection: " + ex.getMessage());
            System.exit(-1);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            System.exit(-1);
        }
        return connection;
    }
}


