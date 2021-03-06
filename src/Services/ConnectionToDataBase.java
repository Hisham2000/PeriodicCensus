
package Services;

import java.sql.*;

public class ConnectionToDataBase {
    
    //Here Singlton Design Pattern
    //Eager singlton
    private static ConnectionToDataBase instance = new ConnectionToDataBase();
    private ConnectionUsage connectionUsage = new ConnectionUsage();
    
    
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
