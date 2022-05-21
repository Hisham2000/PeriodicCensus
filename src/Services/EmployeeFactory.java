package Services;

import Controller.Employee;
import Controller.OfficerController;
import Controller.UserController;

public class EmployeeFactory {
    
    public static Employee getEmployee(String type)
    {
        if (type == null)   return null;
        else if (type.equalsIgnoreCase("Officer")) return new OfficerController();
        else if (type.equalsIgnoreCase("User"))return new UserController();
        return null;
    }
}
