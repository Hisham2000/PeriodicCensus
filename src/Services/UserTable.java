package Services;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Controller.OfficerController;
import Controller.UserController;

public class UserTable implements ServiceTable {

    @Override
    public void setDataFromDataBase(JTable jTable) {
        ArrayList<String> data = new ArrayList<>();
        UserController userController = new UserController();
        data = userController.select();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        for (int i = 0; i < data.size(); i++) {
            Object mydata[] = data.get(i).split(" ");
            model.addRow(mydata);
        }
    }

    @Override
    public int returnSelectionColumn(JTable jTable) {
        int currentRow = jTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        int id = Integer.parseInt((String) model.getValueAt(currentRow, 0));
        return id;
    }

    @Override
    public void removeCurrentRow(JTable jTable) {
        int currentRow = jTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.removeRow(currentRow);
    }

    @Override
    public void setDataInTables(JTable jTable, ArrayList<String> data) {
        DefaultTableModel model =(DefaultTableModel)jTable.getModel();
        Object myData [] = data.toArray();
        model.addRow(myData);
    }

}
