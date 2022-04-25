
package View;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Constraints {
    
    
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
    
    public static boolean chickEmpty(JTextField jTextField)
    {
        if(jTextField.getText().isEmpty()) return false;
        else return true;
    }
    
    public static boolean chickInteger(JTextField jTextField)
    {
        String data = jTextField.getText();
        int number;
        try{
            number=Integer.parseInt(data);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }
    
    public static void clearText(JTextField jTextField)
    {
        jTextField.setText("");
    }
    
    public static void convertFromGUIToGUI(JFrame Source, JFrame Distination)
    {
        Distination.setVisible(true);
        Distination.setLocationRelativeTo(null);
    }
    
    public static void askForRequest(JTextField textField)
    {
        textField.requestFocus();
    }
    
}
