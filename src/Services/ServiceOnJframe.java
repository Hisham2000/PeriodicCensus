
package Services;

import javax.swing.JFrame;
import javax.swing.JTextField;

public interface ServiceOnJframe {
    
    public void closeThGUI(JFrame jFrame);
    public String getDataFromGUI(JTextField jTextField);
    public int getIntFromGUI(JTextField jTextField);
    public void convertFromGUIToGUI(JFrame Source, JFrame Distination);
}
