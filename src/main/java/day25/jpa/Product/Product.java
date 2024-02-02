package day25.jpa.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity (name = "day25.jpa.Product")
@Table (name = "products")
public class Product {
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "prodid")
	Integer prodid;
	
	@Column (name = "prodname")
	String name;
	
	@Column (name = "price")
	Double price;
	
	@Column (name = "qoh")
	Integer qoh;
	
	@Column (name = "remarks")
	String remarks;
	
	@Column (name = "catcode")
	String catcode;

	public Integer getProdid() {
		return prodid;
	}

	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQoh() {
		return qoh;
	}

	public void setQoh(Integer qoh) {
		this.qoh = qoh;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCatcode() {
		return catcode;
	}

	public void setCatcode(String catcode) {
		this.catcode = catcode;
	}

	@Override
	public String toString() {
		return String.format("%-8s %-30s %-10.2f %-10s %-20s",
				this.prodid, this.name, this.price, this.qoh, this.catcode);
	}
}