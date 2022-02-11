package com.ecodeup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ecodeup.model.Biblioteca;
import com.ecodeup.model.Usuario;
import com.ecodeup.model.JPAUtil;

public class BibliotecaDAO {
	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
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

	public Usuario iniciarSesion(Usuario us) {
		Usuario usuario = null;
		String consulta;
		try {
			consulta= "FROM Usuario u WHERE u.user=?1 AND u.password=?2";
			Query q = entity.createQuery(consulta);
			q.setParameter(1, us.getUser());
			q.setParameter(2, us.getPassword());
			List<Usuario> lista = q.getResultList();
			if(!lista.isEmpty())
				usuario=lista.get(0);		
		}
		catch(Exception e) {
			throw e;
		}
		return usuario;
	}
	
}
