package model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;


/**
 * The persistent class for the TFruitShop database table.
 * 
 */
@Entity
@NamedQuery(name="TFruitShop.findAll", query="SELECT tfs FROM TFruitShop tfs")
public class TFruitShop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_fruit_shop")
	private int idFruitShop;

	@Column(name="location_fruit_shop")
	private String locationFruitShop;

	@Column(name="name_fruit_shop")
	private String nameFruitShop;

	@Column(name="phone_fruit_shop")
	private String phoneFruitShop;
	
	@Column(name="horiz")
	private double horiz;
	
	@Column(name="vertical")
	private double vertical;

	public TFruitShop() {
	}

	public int getIdFruitShop() {
		return this.idFruitShop;
	}

	public void setIdFruitShop(int idFruitShop) {
		this.idFruitShop = idFruitShop;
	}

	public String getLocationFruitShop() {
		return this.locationFruitShop;
	}

	public void setLocationFruitShop(String locationFruitShop) {
		this.locationFruitShop = locationFruitShop;
	}

	public String getNameFruitShop() {
		return this.nameFruitShop;
	}

	public void setNameFruitShop(String nameFruitShop) {
		this.nameFruitShop = nameFruitShop;
	}

	public String getPhoneFruitShop() {
		return this.phoneFruitShop;
	}

	public void setPhoneFruitShop(String phoneFruitShop) {
		this.phoneFruitShop = phoneFruitShop;
	}

}