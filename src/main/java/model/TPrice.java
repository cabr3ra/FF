package model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;


/**
 * The persistent class for the TPrice database table.
 * 
 */
@Entity
@NamedQuery(name="TPrice.findAll", query="SELECT tp FROM TPrice tp")
public class TPrice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_price")
	private int idPrice;

	private BigDecimal price;

	//bi-directional many-to-one association to TFruit
	@ManyToOne
	@JoinColumn(name="id_fruit_p")
	private TFruit tfruit;

	//bi-directional many-to-one association to TFruitShop
	@ManyToOne
	@JoinColumn(name="id_fruit_shop_p")
	private TFruitShop tfruitShop;

	public TPrice() {
	}

	public int getIdPrice() {
		return this.idPrice;
	}

	public void setIdPrice(int idPrice) {
		this.idPrice = idPrice;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public TFruit getTfruit() {
		return this.tfruit;
	}

	public void setTfruit(TFruit tfruit) {
		this.tfruit = tfruit;
	}

	public TFruitShop getTfruitShop() {
		return this.tfruitShop;
	}

	public void setTfruitShop(TFruitShop tfruitShop) {
		this.tfruitShop = tfruitShop;
	}

}