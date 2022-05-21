
package Controller;

import Model.UserDataBase;
import java.util.ArrayList;

public class UserController implements Employee{
    
    UserDataBase userDataBase = new UserDataBase();
    
    @Override
    public boolean chick(String name , int password)
    {
        return userDataBase.chick(password, name);
    }
    
    public  String searchByIDForUser(int ID)
    {
           return userDataBase.searchByID(ID);
    }
    
    public boolean update(ArrayList<String> data)
    {
        return userDataBase.update(data);
    }
    
    public int chickState(int id)
    {
        return userDataBase.returnTheChickState(id);
    }
    
    public boolean insert(ArrayList<String> data)
    {
        return userDataBase.insert(data);
    }
    
    @Override
    public ArrayList<String> select()
    {
        return userDataBase.select();
    }
}