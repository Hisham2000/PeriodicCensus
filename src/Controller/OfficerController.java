
package Controller;

import Model.OfficerDataBase;
import java.util.ArrayList;

public class OfficerController {
    OfficerDataBase officerDataBase = new OfficerDataBase();
    
    public boolean chickUserNameAndPassword(String name , int password)
    {
        return officerDataBase.checkUsers(name, password);
    }
    
    public ArrayList<String> returnAllRequsets()
    {
        return officerDataBase.returnAllRequests();
    }
    
    public void acceptUsers(int id)
    {
        officerDataBase.acceptUser(id); 
    }
    
    public void rejectUsers(int id)
    {
        officerDataBase.rejectUsers(id);
    }
}
