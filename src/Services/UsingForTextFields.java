
package Services;

import javax.swing.JTextField;

public class UsingForTextFields implements ServiceTextField{
    
    public boolean chickEmpty(JTextField jTextField)
    {
        if(jTextField.getText().isEmpty()) return false;
        else return true;
    }
    
    public boolean chickInteger(JTextField jTextField)
    {
        String data = jTextField.getText();
        try{
            int number=Integer.parseInt(data);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }
    
    public void clearText(JTextField jTextField)
    {
        jTextField.setText("");
    }
    
    public void askForRequest(JTextField textField)
    {
        textField.requestFocus();
    }
    
    public void setDataInFields(JTextField jTextField, String data) {
        jTextField.setText(data);
    }
}
