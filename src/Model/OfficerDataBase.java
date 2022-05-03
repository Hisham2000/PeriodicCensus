
package Model;

import Services.ConnectionToDataBase;
import java.sql.*;
import java.util.ArrayList;
public class OfficerDataBase {
    
    ConnectionToDataBase connectionToDataBase = ConnectionToDataBase.getInstance();
    
    private Connection connection = connectionToDataBase.getConnection();
    
    public Boolean checkUsers(String userName, int password) {
        boolean checkUser;
        try {
            String query = "SELECT O_SSN  ,Name FROM dataofofficer WHERE O_SSN = " + password + " AND Name = '" + userName + "'";
            Statement statement = connection.createStatement();
            ResultSet reulsSet = statement.executeQuery(query);
            checkUser = reulsSet.next();
        } catch (Exception e) {
            checkUser = false;
        }
        return checkUser;
    }
    
    public ArrayList<String> returnAllRequests()
    {
        ArrayList<String> requestedData = new ArrayList<String>();
        try {
            String query = "SELECT * FROM `dataofuser` WHERE CheckState = 0;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                String data = String.valueOf(resultSet.getInt("U_SSN"))+ " ";
                data += resultSet.getString("Name") + " ";
                data += resultSet.getInt("Age")+ " ";
                data += resultSet.getString("MaritalStatus")+ " ";
                data += resultSet.getString("Address")+ " ";
                data += resultSet.getInt("MobileNum")+ " ";
                data += resultSet.getString("Sex")+ " ";
                requestedData.add(data);
                data = "";
            }
            return requestedData;
        } catch (Exception e) {
            return null;
        }
    }
    
    public void acceptUser(int id)
    {
        try {
            String query = "UPDATE dataofuser SET CheckState = 1 WHERE U_SSN = " + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
        }
    }
    
    public void rejectUsers(int id)
    {
        try {
            String query = "UPDATE dataofuser SET CheckState = 2 WHERE U_SSN = " + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
        }
    }
    
}
