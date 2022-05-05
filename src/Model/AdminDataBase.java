
package Model;

import Services.ConnectionToDataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminDataBase {
   
    ConnectionToDataBase connectionToDataBase = ConnectionToDataBase.getInstance();
    
    private Connection connection = connectionToDataBase.getConnection();
    
    public ArrayList<String> selectAllOfficer()
    {
        ArrayList<String> requestedData = new ArrayList<String>();
        try {
            String query = "SELECT dataofofficer.O_SSN, dataofofficer.Name, area.Location FROM area INNER JOIN dataofofficer ON area.SSN_Officer = dataofofficer.O_SSN;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                String data = String.valueOf(resultSet.getInt("O_SSN"))+ " ";
                data += resultSet.getString("Name") + " ";
                data += resultSet.getString("Location");
                requestedData.add(data);
                data = "";
            }
            return requestedData;
        } catch (Exception e) {
            return null;
        }
    }
    
    public void insertDataOfOfficers(int O_SSN, String name, String area)
    {
        try{
            String queryOfficer = "INSERT INTO `dataofofficer` VALUES ("+O_SSN+", '"+name+"', 123478852)";
            String queryArea = "INSERT INTO area VALUES ("+O_SSN+", '"+area+"')";
            Statement statement = connection.createStatement();
            statement.executeUpdate(queryOfficer);
            statement.executeUpdate(queryArea);
        }
        catch(Exception e)
        {
        }
    }
    public void UpdateDataOfOfficer(int O_SSN, String name, String area)
    {
        try{
            String queryOfficer = "UPDATE dataofofficer SET Name='"+name+"',AD_SSN=1234556789 WHERE O_SSN ="+O_SSN;
            String queryArea = "UPDATE area SET Location='"+area+"' WHERE SSN_Officer = "+O_SSN ;
            Statement statement = connection.createStatement();
            statement.executeUpdate(queryOfficer);
            statement.executeUpdate(queryArea);
        }
        catch(Exception e){
        }
    }
    
    public void DeleteRecord(int O_SSN)
    {
        try{
            String queryOfficer = "DELETE FROM `dataofofficer` WHERE O_SSN = " + O_SSN;
            String queryArea = "DELETE FROM area WHERE SSN_Officer = "+O_SSN;
            Statement statement = connection.createStatement();
            statement.executeUpdate(queryOfficer);
            statement.executeUpdate(queryArea);
        }
        catch(Exception e){
        }
    }
    
}
