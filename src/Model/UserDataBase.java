package Model;

import Services.ConnectionToDataBase;
import java.sql.*;
import java.util.ArrayList;

public class UserDataBase implements iUserDataBase{  
    
    ConnectionToDataBase connectionToDataBase = ConnectionToDataBase.getInstance();
    
    private Connection connection = connectionToDataBase.getConnection();
    
    @Override
    public String searchByID(int Id) {
        String myOwnD = null;
        try {
            String query = "SELECT Name , MaritalStatus , Address , MobileNum , Sex , Age FROM dataofuser WHERE U_SSN = " + Id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                myOwnD =  resultSet.getString("Name")+ " ";
                myOwnD += resultSet.getString("MaritalStatus") + " " + resultSet.getString("Address")
                        + " " + resultSet.getInt("MobileNum");
                myOwnD += " " + resultSet.getString("Sex") + " " + resultSet.getInt("Age");
            }
        } catch (Exception e) {
            return myOwnD;
        }
        return myOwnD;
    }

    @Override
    public int returnTheChickState(int id) {
        int chickState = -1;
        try {
            String query = "SELECT CheckState FROM dataofuser WHERE U_SSN = " + id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                chickState = resultSet.getInt("CheckState");
            }
            return chickState;
        } catch (Exception e) {
            return chickState;
        }
    }
    

    @Override
    public boolean chick(int id, String Name) {
        boolean checkUser;
        try {
            String query = "SELECT U_SSN  ,Name FROM dataofuser WHERE U_SSN = " + id + " AND Name = '" + Name + "'";
            Statement statement = connection.createStatement();
            ResultSet reulsSet = statement.executeQuery(query);
            checkUser = reulsSet.next();
        } catch (Exception e) {
            checkUser = false;
        }
        return checkUser;
    }

    @Override
    public ArrayList<String> select() {
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
        }    }

    @Override
    public boolean insert(ArrayList<String> data) {
        int numberOfChangingQuery=0;
        try {
            String query = "INSERT INTO dataofuser VALUES ("+Integer.parseInt(data.get(0))+", '"+data.get(1)+"', "+Integer.parseInt(data.get(2))+", '"+data.get(3)+"', '"+data.get(4)+"', "+Integer.parseInt(data.get(5))+", '"+data.get(6)+"', 0, 456781)";
            Statement statement = connection.createStatement();
            numberOfChangingQuery = statement.executeUpdate(query);
            if(numberOfChangingQuery !=0) return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public boolean update(ArrayList<String> data) {
        int recordUpdates = 0;
        try {
            String query = "UPDATE dataofuser SET Name = '" + data.get(1) + "', AGE = " + Integer.parseInt(data.get(2)) + ", MaritalStatus = '" + data.get(3)
                    + "', Address = '" + data.get(4) + "', MobileNum = " + Integer.parseInt(data.get(5)) + ", Sex = '" + data.get(6) + "' WHERE U_SSN = " + Integer.parseInt(data.get(0));
            Statement statement = connection.createStatement();
            recordUpdates = statement.executeUpdate(query);
            if (recordUpdates != 0) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    
}
