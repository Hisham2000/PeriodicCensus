
package Controller;

import View.LogIn;
import View.OfficerLogIn;
import Model.OfficerDataBase;

public class MainController {
    
    public static void main(String[] args) {
//        LogIn logIn = new LogIn();
//        logIn.setVisible(true);
//        logIn.setLocationRelativeTo(null);

        OfficerLogIn officerLogIn = new OfficerLogIn();
        officerLogIn.setVisible(true);
        officerLogIn.setLocationRelativeTo(null);

    }
    
}
