package day27;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table (name = "products")
@Entity (name = "day27.Product")
public class Product {
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "prodid")
	private int prodid;
	
	@Column (name = "prodname") 
	private String prodname;
	
	@Column (name = "price")
	private double price; 
	
	@Column (name = "qoh")
	private int qoh; 
	
	@Column (name = "remarks")
	private String remarks;
	
	@Column (name = "catcode") 
	private String catcode;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "product") 
	List<Sale> salesList = new ArrayList<>();

	public List<Sale> getSalesList() {
		return salesList;
	}

	public void setSalesList(List<Sale> salesList) {
		this.salesList = salesList;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQoh(int qoh) {
		this.qoh = qoh;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setCatcode(String catcode) {
		this.catcode = catcode;
	}
	
	public int getProdid() {
		return prodid;
	}

	public String getProdname() {
		return prodname;
	}

	public double getPrice() {
		return price;
	}

	public int getQoh() {
		return qoh;
	}

	public String getRemarks() {
		return remarks;
	}

	public String getCatcode() {
		return catcode;
	}

	@Override 
	public String toString() {
		return String.format("%-7d %-30s %-10.2f \t %d \t %-30s %-30s", this.prodid, this.prodname, 
				this.price, this.qoh, this.remarks, this.catcode);
	}
}