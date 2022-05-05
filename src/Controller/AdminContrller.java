
package Controller;

import java.util.ArrayList;
import Model.AdminDataBase;

public class AdminContrller {
    
    AdminDataBase adminDataBase = new AdminDataBase();
    
    public ArrayList<String> retunAllOfficers()
    {
        return adminDataBase.selectAllOfficer();
    }
    
    public void insertOfficerData(int O_SSN, String name, String area)
    {
        adminDataBase.insertDataOfOfficers(O_SSN, name, area);
    }
    
    public void updateOfficers(int O_SSN, String name, String area)
    {
        adminDataBase.UpdateDataOfOfficer(O_SSN, name, area);
    }
    
    public void deleteOfficerRecord(int O_SSN)
    {
        adminDataBase.DeleteRecord(O_SSN);
    }
}
