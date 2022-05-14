
package Model;

public interface iUserDataBase extends iDatabase{
    
     public String searchByID(int Id);
     public int returnTheChickState(int id);
}
