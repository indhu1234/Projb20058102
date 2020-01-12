package proj.com.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
@Entity
@Table
public class Product 
{
	@Id
	@GeneratedValue
  int prodId;
  String prodname;
  String proddesc;
  
  int catid;
  int price;
  int qty;
  
  @Transient
  MultipartFile pimage;

public int getProdId() {
	return prodId;
}

public void setProdId(int prodId) {
	this.prodId = prodId;
}

public String getProdname() {
	return prodname;
}

public void setProdname(String prodname) {
	this.prodname = prodname;
}

public String getProddesc() {
	return proddesc;
}

public void setProddesc(String proddesc) {
	this.proddesc = proddesc;
}

public int getCatid() {
	return catid;
}

public void setCatid(int catid) {
	this.catid = catid;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public int getQty() {
	return qty;
}

public void setQty(int qty) {
	this.qty = qty;
}

public MultipartFile getPimage() {
	return pimage;
}

public void setPimage(MultipartFile pimage) {
	this.pimage = pimage;
}
  
  
  
}
