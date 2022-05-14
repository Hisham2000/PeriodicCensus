package Controller;

import Services.UsingForJFrame;
import View.StartingPoint;
import View.AdminContrllingOfficer;
import Services.ServiceOnJframe;
public class MainController {

    public static void main(String[] args) {
        ServiceOnJframe serviceOnJframe = new UsingForJFrame();
        
//        AdminContrllingOfficer adminContrllingOfficer = new AdminContrllingOfficer(ijframe);
//        adminContrllingOfficer.setVisible(true);
//        adminContrllingOfficer.setLocationRelativeTo(null);

        StartingPoint startingPoint = new StartingPoint(serviceOnJframe);
        startingPoint.setVisible(true);
        startingPoint.setLocationRelativeTo(null);
            
    }

}
