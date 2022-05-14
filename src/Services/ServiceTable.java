
package Services;

import java.util.ArrayList;
import javax.swing.JTable;

public interface ServiceTable {
    
    public void setDataFromDataBase(JTable jTable);
    public int returnSelectionColumn(JTable jTable);
    public void removeCurrentRow(JTable jTable);
    public void setDataInTables(JTable jTable, ArrayList<String>data);
}
