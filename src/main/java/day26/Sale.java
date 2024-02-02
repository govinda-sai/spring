package day26;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table (name = "sales")
@Entity (name = "day26.Sale")
public class Sale {
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "invno")
	private int id;
	
	@Column (name = "prodid")
	private int prodid;
	
	@Column (name = "transdate")
	private LocalDate transdate;
	
	@Column (name = "qty")
	private int qty;
	
	@Column (name = "amount")
	private double amount;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn (name = "prodid", insertable = false, updatable = false)
	private Product product;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	public LocalDate getTransdate() {
		return transdate;
	}
	public void setTransdate(LocalDate transdate) {
		this.transdate = transdate;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		System.out.println("toString()");
		return String.format("%-10d %-10d %-30s %-10d %-8.2f\n", 
				this.id, this.prodid, this.transdate, this.qty, this.amount);
	}
}