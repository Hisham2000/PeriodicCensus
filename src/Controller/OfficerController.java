
package Controller;

import Model.OfficerDataBase;
import java.util.ArrayList;

public class OfficerController implements Employee{
    OfficerDataBase officerDataBase = new OfficerDataBase();
    
    @Override
    public boolean chick(String name , int password)
    {
        return officerDataBase.chick(password, name);
    }
    
    public void acceptUsers(int id)
    {
        officerDataBase.acceptUser(id); 
    }
    
    public void rejectUsers(int id)
    {
        officerDataBase.rejectUsers(id);
    }
    
    public void delete(int O_SSN)
    {
        officerDataBase.delete(O_SSN);
    }
    
    public void update(ArrayList<String> data)
    {
        officerDataBase.update(data);
    }
    
    
    public void insert(ArrayList<String> data)
    {
        officerDataBase.insert(data);
    }
    
    @Override
    public ArrayList<String> select( )
    {
        return officerDataBase.select();
    }
}
