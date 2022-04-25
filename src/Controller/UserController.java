
package Controller;

import Model.UserDataBase;
import java.util.ArrayList;

public class UserController {
    UserDataBase userDataBase = UserDataBase.getInstance();
    
    public boolean chickUserNameAndPassword(String name , int password)
    {
        if(userDataBase.checkUsers(name, password)) return true;
        else return false;
    }
    
    public String searchByIDForUser(int ID)
    {
           String data = userDataBase.searchByID(ID);
           return data;
    }
    
    public boolean updateRecords(int id, String name, int age, String martialState, String adredd, int mobNum, String sex)
    {
        return userDataBase.update(id, name, martialState, adredd, mobNum, sex, age);
    }
    
}