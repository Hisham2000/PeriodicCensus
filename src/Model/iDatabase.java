
package Model;

import java.util.ArrayList;

public interface iDatabase {
    public boolean chick(int id , String Name);
    public ArrayList<String> select();
    public boolean insert(ArrayList<String> data);
    public boolean update(ArrayList<String> data);
    public void delete(int id);
    
}
