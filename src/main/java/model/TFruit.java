package model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;


/**
 * The persistent class for the TFruit database table.
 * 
 */
@Entity
@NamedQuery(name="TFruit.findAll", query="SELECT tf FROM TFruit tf")
public class TFruit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_fruit")
	private int idFruit;

	@Column(name="image_fruit")
	private String imageFruit;

	@Column(name="name_fruit")
	private String nameFruit;

	public TFruit() {
	}

	public int getIdFruit() {
		return this.idFruit;
	}

	public void setIdFruit(int idFruit) {
		this.idFruit = idFruit;
	}

	public String getImageFruit() {
		return this.imageFruit;
	}

	public void setImageFruit(String imageFruit) {
		this.imageFruit = imageFruit;
	}

	public String getNameFruit() {
		return this.nameFruit;
	}

	public void setNameFruit(String nameFruit) {
		this.nameFruit = nameFruit;
	}

}