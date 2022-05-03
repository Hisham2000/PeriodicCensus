
package Services;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionToDataBase {
    private static ConnectionToDataBase instance = new ConnectionToDataBase();

    public static ConnectionToDataBase getInstance() {
        if (instance == null) {
            instance = new ConnectionToDataBase();
        }
        return instance;
    }

    private ConnectionToDataBase() {
        if (checkConnection() == null) {
            setConnection();
        }
    }

    private static Connection connection;

    private static String setURL() {
        String url = "jdbc:mysql://localhost:3306/PeriodicCensus"
                + "?useUnicode=true&characterEncoding=UTF-8";
        return url;
    }

    private static void setConnection() {
        try {
            connection = DriverManager.getConnection(setURL(), "root", "");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "The Connection Has been faild");
        }
    }

    private Connection checkConnection() {
        return connection;
    }
    
    public Connection getConnection()
    {
        return connection;
    }
}
