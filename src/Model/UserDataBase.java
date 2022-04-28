package Model;

import java.sql.*;
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
            String query = "SELECT U_SSN  ,Name FROM dataofuser WHERE U_SSN = " + password + " AND Name = '" + userName + "'";
            Statement statement = connection.createStatement();
            ResultSet reulsSet = statement.executeQuery(query);
            checkUser = reulsSet.next();
        } catch (Exception e) {
            checkUser = false;
        }
        return checkUser;
    }

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
                System.out.println(myOwnD);
            }
        } catch (Exception e) {
            return myOwnD;
        }
        return myOwnD;
    }

    public boolean update(int id, String name, String martialState, String adress, int mobNum, String sex, int age) {
        int recordUpdates = 0;
        try {
            String query = "UPDATE dataofuser SET Name = '" + name + "', AGE = " + age + ", MaritalStatus = '" + martialState
                    + "', Address = '" + adress + "', MobileNum = " + mobNum + ", Sex = '" + sex + "' WHERE U_SSN = " + id;
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

    public int returnTheChickState(int id) {
        int chickState = -1;
        try {
            String query = "SELECT CheckState FROM dataofuser WHERE U_SSN = " + id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                chickState = resultSet.getInt("CheckState");
                System.out.println(chickState);
            }
            return chickState;
        } catch (Exception e) {
            return chickState;
        }
    }
    
    public boolean insertData(int id ,String name, int age, String martialStatus, String adress, int mobileNO,String sex)
    {
        int numberOfChangingQuery=0;
        try {
            String query = "INSERT INTO dataofuser VALUES ("+id+", '"+name+"', "+age+", '"+martialStatus+"', '"+adress+"', "+mobileNO+", '"+sex+"', 0, 456781)";
            System.out.println("After Insert statement");
            Statement statement = connection.createStatement();
            numberOfChangingQuery = statement.executeUpdate(query);
            System.out.println(numberOfChangingQuery);
            if(numberOfChangingQuery !=0) return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

}
