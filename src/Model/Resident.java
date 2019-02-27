package Model;

import java.time.LocalDate;
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
@Table(name="resident")
public class Resident {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="resisdentId")
	private int id;
	@Column(name="residentName")
	private String name;
	@Column(name="dateOfBirth")
	private LocalDate dob;
	
	/**
	 * 
	 */
	public Resident() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param name
	 * @param dob
	 */
	public Resident(String name, LocalDate dob) {
		super();
		this.name = name;
		this.dob = dob;
	}
	/**
	 * @param id
	 * @param name
	 * @param dob
	 */
	public Resident(int id, String name, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the dob
	 */
	public LocalDate getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
}
