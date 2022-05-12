
package Controller;

import Model.OfficerDataBase;
import java.util.ArrayList;

public class OfficerController {
    OfficerDataBase officerDataBase = new OfficerDataBase();
    
    public boolean chickUserNameAndPassword(String name , int password)
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
    
    public void deleteOfficerRecord(int O_SSN)
    {
        officerDataBase.delete(O_SSN);
    }
    
    public void updateOfficers(ArrayList<String> data)
    {
        officerDataBase.update(data);
    }
    
    public void insertOfficerData(ArrayList<String> data)
    {
        officerDataBase.insert(data);
    }
    
    public ArrayList<String> retunAllOfficers( )
    {
        return officerDataBase.select();
    }
}
