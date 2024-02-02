package day26.pubs;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity (name = "day26.pubs.Publisher")
@Table (name = "publishers")
public class Publisher {
	@Id 
	@Column (name = "pub_id")
	private Integer pubId;
	
	@Column (name = "pub_name")
	private String pubname;
	
	@Column (name = "city")
	private String city;
	
	@Column (name = "state")
	private String state;
	
	@Column (name = "country")
	private String country;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "publisher")
	private List<Title> titlesList = new ArrayList<Title>();

	public List<Title> getTitlesList() {
		return titlesList;
	}

	public void setTitlesList(List<Title> titlesList) {
		this.titlesList = titlesList;
	}

	public void setPubId(Integer pubId) {
		this.pubId = pubId;
	}

	public Integer getPubId() {
		return pubId;
	}

	public void setPubId(int pubId) {
		this.pubId = pubId;
	}

	public String getPubName() {
		return pubname;
	}

	public void setPubName(String pubname) {
		this.pubname = pubname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Publisher [pubId=" + pubId + ", pubName=" + this.pubname + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", titlesList=" + titlesList + "]";
	}
}