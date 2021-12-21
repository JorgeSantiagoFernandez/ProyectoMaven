package com.ecodeup.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.ecodeup.dao.BibliotecaDAO;
import com.ecodeup.model.Biblioteca;
import com.ecodeup.model.Login;

@ManagedBean (name="bibliotecaBean")
@RequestScoped
public class BibliotecaBean {

	public List<Biblioteca> obtenerBiblioteca(){		
		BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();	
		return bibliotecaDAO.obtenerBiblioteca();
	}
	
	public String nuevo() {
		Biblioteca b = new Biblioteca();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("biblioteca", b);
		return "/faces/nuevo.xhtml";
	}
	
	public String guardar(Biblioteca biblioteca) {
		BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
		bibliotecaDAO.guardar(biblioteca);
		return "/faces/index.xhtml";
	}
	
	public String editar(Long id){
		BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
		Biblioteca b = new Biblioteca();
		b = bibliotecaDAO.buscar(id);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("biblioteca", b);
		return "/faces/editar.xhtml";
	}
	public String actualizar(Biblioteca biblioteca) {
		BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
		bibliotecaDAO.editar(biblioteca);
		return "/faces/index.xhtml";
	}
	public String borrar(Long id) {
		BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
		bibliotecaDAO.borrar(id);
		System.out.println("Libro eliminado");
		return "/faces/index.xhtml";
	}
	
	public String acceder() {
		return "/faces/nuevo.xhtml";
	}
}
