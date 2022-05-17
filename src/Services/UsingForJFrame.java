
package Services;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class UsingForJFrame implements ServiceOnJframe{
    
    public void closeThGUI(JFrame jFrame)
    {
        //JFrame window to be destroyed and cleaned up by the operating system
        jFrame.dispose();
    }
    
    public String getDataFromGUI(JTextField jTextField)
    {
        return jTextField.getText();
    }
    
    public int getIntFromGUI(JTextField jTextField)
    {
        return Integer.parseInt(getDataFromGUI(jTextField));
    }
    
     public void convertFromGUIToGUI(JFrame Source, JFrame Distination)
    {
        Distination.setVisible(true);
        Distination.setLocationRelativeTo(null);
    }
}
