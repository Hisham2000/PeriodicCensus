
package Controller;

import Model.UserDataBase;
import java.util.ArrayList;

public class UserController {
    
    UserDataBase userDataBase = new UserDataBase();
    
    public boolean chickUserNameAndPassword(String name , int password)
    {
        if(userDataBase.chick(password, name)) return true;
        else return false;
    }
    
    public  String searchByIDForUser(int ID)
    {
           String data = userDataBase.searchByID(ID);
           return data;
    }
    
    public boolean updateRecords(ArrayList<String> data)
    {
        return userDataBase.update(data);
    }
    
    public int chickState(int id)
    {
        return userDataBase.returnTheChickState(id);
    }
    public boolean  insertData(ArrayList<String> data)
    {
        return userDataBase.insert(data);
    }
    
    public ArrayList<String> returnAllRequsets()
    {
        return userDataBase.select();
    }
}