
package Services;

import java.sql.*;

public class ConnectionToDataBase {
    private static ConnectionToDataBase instance = new ConnectionToDataBase();
    private final ConnectionUsage connectionUsage = new ConnectionUsage();
    
    
    public static ConnectionToDataBase getInstance() {
        if (instance == null) {
            instance = new ConnectionToDataBase();
        }
        return instance;
    }

    private ConnectionToDataBase() {
        if (connectionUsage.getConnection()== null) {
            connectionUsage.setConnection();
        }
    }

    public Connection getConnection()
    {
        return connectionUsage.getConnection();
    }
    
}
