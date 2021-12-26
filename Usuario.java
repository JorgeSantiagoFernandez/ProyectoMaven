package com.ecodeup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")

public class Usuario implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUser;
	@Column
	private String user;
	@Column
	private String password;
	@Column
	private int rol;
	
	public Usuario() {
	}
	
	public Usuario(String user, String password) {
		this.user = user;
		this.password = password;
	}
	
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
	@Override
	public String toString() {
		return "Login [idUser=" + idUser + ", user=" + user + ", password=" + password + ", rol=" + rol + "]";
	}
}
