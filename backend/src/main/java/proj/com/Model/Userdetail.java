package proj.com.Model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Userdetail 
{
	@Id
	@GeneratedValue
   int userid;
   String Username;
   String Password;
   String contact;
   String Street;
   String City;
   String Zip;
   String Email;
   String Role;
   
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUsername() {
	return Username;
}
public void setUsername(String username) {
	Username = username;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getStreet() {
	return Street;
}
public void setStreet(String street) {
	Street = street;
}
public String getCity() {
	return City;
}
public void setCity(String city) {
	City = city;
}
public String getZip() {
	return Zip;
}
public void setZip(String zip) {
	Zip = zip;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getRole() {
	return Role;
}
public void setRole(String role) {
	Role = role;
}
   
   
}
