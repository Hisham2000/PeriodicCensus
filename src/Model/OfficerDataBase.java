package Model;

import Services.ConnectionToDataBase;
import java.sql.*;
import java.util.ArrayList;

public class OfficerDataBase implements iOfficerDataBase {

    private ConnectionToDataBase connectionToDataBase = ConnectionToDataBase.getInstance();
    private Connection connection = connectionToDataBase.getConnection();
    
    @Override
    public void acceptUser(int id) {
        try {
            String query = "UPDATE dataofuser SET CheckState = 1 WHERE U_SSN = " + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
        }
    }

    @Override
    public void rejectUsers(int id) {
        try {
            String query = "UPDATE dataofuser SET CheckState = 2 WHERE U_SSN = " + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
        }
    }

    @Override
    public boolean chick(int id, String name) {
        boolean checkUser;
        try {
            String query = "SELECT O_SSN  ,Name FROM dataofofficer WHERE O_SSN = " + id + " AND Name = '" + name + "'";
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
            String query = "SELECT dataofofficer.O_SSN, dataofofficer.Name, area.Location FROM area INNER JOIN dataofofficer ON area.SSN_Officer = dataofofficer.O_SSN;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String data = String.valueOf(resultSet.getInt("O_SSN")) + " ";
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

    @Override
    public boolean insert(ArrayList<String> data) {
        int numberOfChanginfgOfficers = 0;
        int numberOfChangeingArea = 0;
        try {
            String queryOfficer = "INSERT INTO dataofofficer VALUES (" + Integer.parseInt(data.get(0)) + ", '" + data.get(1) + "', 123456789)";
            String queryArea = "INSERT INTO area VALUES (" + Integer.parseInt(data.get(0)) + ", '" + data.get(2) + "')";
            Statement statement = connection.createStatement();
            numberOfChanginfgOfficers = statement.executeUpdate(queryOfficer);
            numberOfChangeingArea = statement.executeUpdate(queryArea);
            if (numberOfChangeingArea != 0 && numberOfChanginfgOfficers != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(ArrayList<String> data) {
        int recordUdatedOfficer = 0;
        int recordUpdatedArea = 0;
        try {
            String queryOfficer = "UPDATE dataofofficer SET Name='" + data.get(1) + "',AD_SSN=1234556789 WHERE O_SSN =" + Integer.parseInt(data.get(0));
            String queryArea = "UPDATE area SET Location='" + data.get(2) + "' WHERE SSN_Officer = " + data.get(0);
            Statement statement = connection.createStatement();
            recordUdatedOfficer = statement.executeUpdate(queryOfficer);
            recordUpdatedArea = statement.executeUpdate(queryArea);
            if (recordUdatedOfficer != 0 && recordUpdatedArea != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void delete(int id) {
        try {
            String queryOfficer = "DELETE FROM `dataofofficer` WHERE O_SSN = " + id;
            String queryArea = "DELETE FROM area WHERE SSN_Officer = " + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(queryOfficer);
            statement.executeUpdate(queryArea);
        } catch (Exception e) {
        }
    }

}
