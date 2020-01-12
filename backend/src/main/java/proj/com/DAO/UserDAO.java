package proj.com.DAO;

import java.util.List;

import proj.com.Model.Userdetail;

public interface UserDAO 
{
   public boolean addUser(Userdetail user);
   public boolean updateUser(Userdetail user);
   public boolean deleteUser(Userdetail user);
   public List<Userdetail> listUsers();
   public Userdetail getUser(int userid);
}
