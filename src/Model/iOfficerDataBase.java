
package Model;

public interface iOfficerDataBase extends iDatabase{
    
    public void acceptUser(int id);
    public void rejectUsers(int id);
    public void delete(int id);
            
}
