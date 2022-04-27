
package Services;

import javax.swing.JTextField;

public class UsingForTextFields {
    
    public static boolean chickEmpty(JTextField jTextField)
    {
        if(jTextField.getText().isEmpty()) return false;
        else return true;
    }
    
    public static boolean chickInteger(JTextField jTextField)
    {
        String data = jTextField.getText();
        try{
            int number=Integer.parseInt(data);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }
    
    public static void clearText(JTextField jTextField)
    {
        jTextField.setText("");
    }
    
    public static void askForRequest(JTextField textField)
    {
        textField.requestFocus();
    }
    
    public static void setDataInFields(JTextField jTextField, String data) {
        jTextField.setText(data);
    }
}
