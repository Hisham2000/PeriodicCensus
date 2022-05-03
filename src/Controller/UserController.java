
package Controller;

import Model.UserDataBase;

public class UserController {
    
    UserDataBase userDataBase = new UserDataBase();
    
    public boolean chickUserNameAndPassword(String name , int password)
    {
        if(userDataBase.checkUsers(name, password)) return true;
        else return false;
    }
    
    public  String searchByIDForUser(int ID)
    {
           String data = userDataBase.searchByID(ID);
           return data;
    }
    
    public boolean updateRecords(int id, String name, int age, String martialState, String adredd, int mobNum, String sex)
    {
        return userDataBase.update(id, name, martialState, adredd, mobNum, sex, age);
    }
    
    public int chickState(int id)
    {
        return userDataBase.returnTheChickState(id);
    }
    public boolean  insertData(int id, String name, int age, String martialStatus, String adress, int mobileNO, String sex)
    {
        return userDataBase.insertData(id, name, age, martialStatus, adress, mobileNO, sex);
    }
}