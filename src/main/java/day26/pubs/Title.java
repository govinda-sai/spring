package day26.pubs;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "day26.pubs.Title")
@Table(name = "titles")
public class Title {
	@Id
	@Column(name = "title_id")
	private String title_id;

	@Column(name = "title")
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "pub_id")
	private Integer pub_id;

	@Column(name = "price")
	private Double price;

	@Column(name = "ytd_sales")
	private Integer ytdSales;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pub_id", insertable = false, updatable = false)
	private Publisher publisher;

	public String getTitle_id() {
		return title_id;
	}

	public void setTitle_id(String title_id) {
		this.title_id = title_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Publisher getPublishers() {
		return publisher;
	}

	public void setPublishers(Publisher publisher) {
		this.publisher = publisher;
	}

	public int getPub_id() {
		return pub_id;
	}

	public void setPub_id(int pub_id) {
		this.pub_id = pub_id;
	}

	public Integer getYtdSales() {
		return ytdSales;
	}

	public void setYtdSales(Integer ytdSales) {
		this.ytdSales = ytdSales;
	}

	public Publisher getPublishersPubId() {
		return publisher;
	}

	public void setPublishersPubId(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return String.format("%-10s %-65s %-15s %-10d %-9.2f %-10d\n",
				this.title_id, this.name, this.type, this.pub_id,
				this.price, this.ytdSales);
	}
}