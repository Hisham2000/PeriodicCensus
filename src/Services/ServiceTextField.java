
package Services;

import javax.swing.JTextField;

public interface ServiceTextField {
    public boolean chickEmpty(JTextField jTextField);
    public boolean chickInteger(JTextField jTextField);
    public void clearText(JTextField jTextField);
    public void askForRequest(JTextField textField);
    public void setDataInFields(JTextField jTextField, String data);
}
