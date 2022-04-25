package Model;

//import Model.OfficerData;
import java.awt.List;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class UserDataBase {

    private static UserDataBase instance = new UserDataBase();

    public static UserDataBase getInstance() {
        if (instance == null) {
            instance = new UserDataBase();
        }
        return instance;
    }

    private UserDataBase() {
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

    public static UserDataBase createDataBase() {
        return new UserDataBase();
    }

    private static void setConnection() {
        try {
            connection = DriverManager.getConnection(setURL(), "root", "");
            System.out.println("COnnection is done ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "The Connection Has been faild");
        }
    }

    private Connection checkConnection() {
        return connection;
    }

    public Boolean checkUsers(String userName, int password) {
        boolean checkUser;
        try {
            String query = "SELECT U_SSN  ,FirstName FROM dataofuser WHERE U_SSN = " + password + " AND FirstName = '" + userName + "'";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet reulsSet = statement.executeQuery(query);
            checkUser = reulsSet.next();
        } catch (Exception e) {
            checkUser = false;
        }
        return checkUser;
    }

    public String searchByID(int Id)
    {
        String myOwnD = null;
        try {
            String query = "SELECT U_SSN , FirstName , lastName , mirtalState , Address , mobileNO , sex , AGE FROM dataofuser WHERE U_SSN = " + Id ;
            Statement statement = connection.createStatement();
            System.out.println("We are in search :) ");
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("After Statement ");
            System.out.println("Has Done ");
            while (resultSet.next()) {
            System.out.println("in while loop");
            myOwnD = resultSet.getInt("U_SSN")+ " " +resultSet.getString("FirstName")
                    + " " + resultSet.getString("lastName") + " "  ;
            myOwnD +=  resultSet.getString("mirtalState") + " "+ resultSet.getString("Address")
                    + " "+ resultSet.getInt("mobileNO"); 
            myOwnD +=  " "+resultSet.getString("sex") + " "+ resultSet.getInt("AGE");
                    System.out.println(myOwnD);
                }
        } catch (Exception e) {
            return myOwnD;
        }
        return myOwnD;
    }
    
    public boolean update(int id, String name, String martialState, String adress, int mobNum, String sex, int age)
    {
        int recordUpdates = 0;
        try {
            String query = "UPDATE dataofuser SET FirstName = ' "+name+" ', AGE = " + age+ ", mirtalState = '" + martialState
                    +"', Address = '"+adress+"', mobileNO = " + mobNum +", sex = '"+sex+"' WHERE U_SSN = "+id;
            Statement statement = connection.createStatement();
            recordUpdates = statement.executeUpdate(query);
            if(recordUpdates != 0) return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    
}
