package model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;


/**
 * The persistent class for the TUser database table.
 * 
 */
@Entity
@NamedQuery(name="TUser.findAll", query="SELECT tu FROM TUser tu")
public class TUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_user")
	private Integer idUser;

	@Column(name="admin_user")
	private byte adminUser;

	@Column(name="baja_user")
	private byte bajaUser;

	@Column(name="email_user")
	private String emailUser;

	@Column(name="name_user")
	private String nameUser;

	@Column(name="password_user")
	private String passwordUser;

	@Column(name="surname_user")
	private String surnameUser;

	@Column(name="username_user")
	private String usernameUser;

	public TUser() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public byte getAdminUser() {
		return this.adminUser;
	}

	public void setAdminUser(byte adminUser) {
		this.adminUser = adminUser;
	}

	public byte getBajaUser() {
		return this.bajaUser;
	}

	public void setBajaUser(byte bajaUser) {
		this.bajaUser = bajaUser;
	}

	public String getEmailUser() {
		return this.emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getNameUser() {
		return this.nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getPasswordUser() {
		return this.passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public String getSurnameUser() {
		return this.surnameUser;
	}

	public void setSurnameUser(String surnameUser) {
		this.surnameUser = surnameUser;
	}

	public String getUsernameUser() {
		return this.usernameUser;
	}

	public void setUsernameUser(String usernameUser) {
		this.usernameUser = usernameUser;
	}

}