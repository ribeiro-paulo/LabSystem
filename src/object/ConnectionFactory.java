package object;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
   
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(Util.url, Util.user, Util.password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
