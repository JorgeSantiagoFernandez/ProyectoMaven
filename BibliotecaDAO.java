package com.ecodeup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ecodeup.model.Biblioteca;
import com.ecodeup.model.Login;
import com.ecodeup.model.JPAUtil;

public class BibliotecaDAO {
	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void guardar(Biblioteca biblioteca) {
		entity.getTransaction().begin();
		entity.persist(biblioteca);
		entity.getTransaction().commit();
	}
	
	public void editar(Biblioteca biblioteca) {
		entity.getTransaction().begin();
		entity.merge(biblioteca);
		entity.getTransaction().commit();	
	}
	
	public void borrar(Long id) {
		Biblioteca b = new Biblioteca();
		b = entity.find(Biblioteca.class, id);
		entity.getTransaction().begin();
		entity.remove(b);
		entity.getTransaction().commit();
	}
	
	public Biblioteca buscar(Long id) {
		Biblioteca b = new Biblioteca();
		b = entity.find(Biblioteca.class, id);
		return b;
	}
	
	public List<Biblioteca> obtenerBiblioteca(){
		List<Biblioteca> listaBiblioteca = new ArrayList<>();
		Query q = entity.createQuery("SELECT b FROM Biblioteca b");
		listaBiblioteca = q.getResultList();
		return listaBiblioteca;
	}


}
