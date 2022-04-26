
package Services;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class UsingForJFrame {
    
    public static void closeThGUI(JFrame jFrame)
    {
        jFrame.dispose();
    }
    
    public static String getDataFromGUI(JTextField jTextField)
    {
        return jTextField.getText();
    }
    
    public static int getIntFromGUI(JTextField jTextField)
    {
        return Integer.parseInt(getDataFromGUI(jTextField));
    }
    
     public static void convertFromGUIToGUI(JFrame Source, JFrame Distination)
    {
        Distination.setVisible(true);
        Distination.setLocationRelativeTo(null);
    }
}
