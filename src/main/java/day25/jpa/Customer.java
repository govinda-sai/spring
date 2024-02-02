package day25.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity (name = "day25.jpa.Customer")
@Table (name = "customers_spring")
public class Customer {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column (name = "cust_id")
	private Integer id;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "email")
	private String email;
	
	@Column (name = "mobile")
	private String mobile;
	
	@Column (name = "gender")
	private String gender;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", gender="
				+ gender + "]";
	}
}