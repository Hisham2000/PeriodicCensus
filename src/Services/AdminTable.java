package Services;

import java.util.ArrayList;
import Controller.OfficerController;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminTable implements ServiceTable {

    private DefaultTableModel model ;
    
    @Override
    public void setDataFromDataBase (JTable jTable) {
        ArrayList<String> data = new ArrayList<>();
        OfficerController officerController = new OfficerController();
        data = officerController.select();
        model = (DefaultTableModel) jTable.getModel();
        for (int i = 0; i < data.size(); i++) {
            Object mydata[] = data.get(i).split(" ");
            model.addRow(mydata);
        }
    }

    @Override
    public int returnSelectionColumn(JTable jTable) {
        int currentRow = jTable.getSelectedRow();
        model = (DefaultTableModel) jTable.getModel();
        int colummn = Integer.parseInt((String) model.getValueAt(currentRow, 0));
        return colummn;
    }

    @Override
    public void removeCurrentRow(JTable jTable) {
        int currentRow = jTable.getSelectedRow();
        model = (DefaultTableModel) jTable.getModel();
        model.removeRow(currentRow);
    }
 
    @Override
    public void setDataInTables(JTable jTable, ArrayList<String> data) {
        model =(DefaultTableModel)jTable.getModel();
        Object myData [] = data.toArray();
        model.addRow(myData);
    }

}
