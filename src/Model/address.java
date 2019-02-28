package Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="addressId")
	private int id;
	@Column(name="street")
	private String street;
	@Column(name="houseNumber")
	private int houseNumber;
	@Column(name="country")
	private String country;
	@Column(name="city")
	private String city;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable(
			name="address_resident",
			//               address_resident.AddressID                 address.addressId               
			joinColumns= {@JoinColumn(name="addressId", referencedColumnName="addressId")}
			,
			//                      address_resisdent.residentId                     resident.residentId               
			inverseJoinColumns= {@JoinColumn(name="residentId", referencedColumnName="residentId", unique=true)})
	private List<Resident> listOfResidents;
	
	
	/**
	 * @param street
	 * @param houseNumber
	 * @param country
	 * @param city
	 */
	public address(String street, int houseNumber, String country, String city) {
		super();
		this.street = street;
		this.houseNumber = houseNumber;
		this.country = country;
		this.city = city;
	}
	/**
	 * @param id
	 * @param street
	 * @param houseNumber
	 * @param country
	 * @param city
	 */
	public address(int id, String street, int houseNumber, String country, String city) {
		super();
		this.id = id;
		this.street = street;
		this.houseNumber = houseNumber;
		this.country = country;
		this.city = city;
	}
	/**
	 * 
	 */
	public address() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the houseNumber
	 */
	public int getHouseNumber() {
		return houseNumber;
	}
	/**
	 * @param houseNumber the houseNumber to set
	 */
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
}
