package com.ecodeup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="biblioteca")

public class Biblioteca {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlibro;
	@Column
	private String titulo;
	@Column
	private String autor;
	@Column
	private String editorial;
	@Column
	private String genero;
	@Column
	private String tipo;
	@Column
	private String imagen;

	public Long getIdlibro() {
		return idlibro;
	}

	public void setIdlibro(Long idlibro) {
		this.idlibro = idlibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Cliente [idlibro=" + idlibro + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial
				+ ", genero=" + genero + ", tipo=" + tipo + ", imagen=" + imagen + "]";
	}

}
