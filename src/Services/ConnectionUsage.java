
package Services;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionUsage {
    
    private Connection connection;
    private URL url;
    
    public void setConnection() {
        try {
            this.url = new URL();
            url.setURL();
            connection = DriverManager.getConnection(url.getURL(), "root", "");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "The Connection Has been faild");
        }
    }
    
    public Connection getConnection()
    {
        return connection;
    }
}
