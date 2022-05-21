package Controller;

import Services.UsingForJFrame;
import View.StartingPoint;
import View.AdminContrllingOfficer;
import Services.ServiceOnJframe;
import Services.ServiceTextField;
import Services.UsingForTextFields;

public class MainController {

    public static void main(String[] args) {
        ServiceOnJframe serviceOnJframe = new UsingForJFrame();
        ServiceTextField serviceTextField = new UsingForTextFields();
        
        AdminContrllingOfficer adminContrllingOfficer = new AdminContrllingOfficer(serviceOnJframe,serviceTextField);
        adminContrllingOfficer.setVisible(true);
        adminContrllingOfficer.setLocationRelativeTo(null);
//        
        // Open Officer And User Parts
//        StartingPoint startingPoint = new StartingPoint(serviceOnJframe);
//        startingPoint.setVisible(true);
//        startingPoint.setLocationRelativeTo(null);
            
    }

}
