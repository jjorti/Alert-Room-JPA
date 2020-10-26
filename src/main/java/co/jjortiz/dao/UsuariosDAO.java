package co.jjortiz.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.jjortiz.aplicacion.JPAUtil;
import co.jjortiz.entidades.Usuario;

public class UsuariosDAO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	//permite crear el crud
	EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();

	public Usuario consultarLoginUsuario(String documento, String password) {
		
		Usuario miUsuario=entityManager.find(Usuario.class, documento);
		
		if (miUsuario!=null) {
			return miUsuario;
		}else {
			System.out.println("no se encuentra el usuario");
			return null;
		}
	}
	

	public String registrarUsuario(Usuario miUsuario) {
		//empezar la transaccion
		entityManager.getTransaction().begin();
		//guarda en la db, hibenate mapea los datos en la db
		entityManager.persist(miUsuario);
		//finalizar la transaccion para que se gaurde en la db
		entityManager.getTransaction().commit();
		
		String resp="Registro Exitoso";
	
		return resp;
	}
	
	

	public List<Usuario> consultarListaUsuarios() {
	
		List<Usuario> listaUsuarios=new ArrayList<Usuario>();
		Query query=entityManager.createQuery("SELECT u FROM Usuario u");
		listaUsuarios=query.getResultList();
		
		return listaUsuarios;
	}
	
	public String actualizarUsuario(Usuario miUsuario) {

		String resp="";
		try {
			entityManager.getTransaction().begin();
			//busca un registro que concuerde con los datos 
			entityManager.merge(miUsuario);
			entityManager.getTransaction().commit();
			
			resp="Persona Actualizada!";
		} catch (Exception e) {
			resp="No se puede eliminar la persona"
					+ " verifique que no tenga registros pendientes";
		}		
		return resp;
	}
	
	
	
	public Usuario consultarUsuario(String documento) {
		
		//Consulta al usuario al pasarle el documento como parametro
		Usuario miUsuario=entityManager.find(Usuario.class,documento);
		
		if (miUsuario!=null) {
			return miUsuario;
		}else {
			return null;
		}
	}
	
	
	
	public String eliminarUsuario(Usuario miUsuario) {

		String resp="";
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(miUsuario);
			entityManager.getTransaction().commit();
			
			resp="Persona Eliminada!";
		} catch (Exception e) {
			System.out.println("No se puede eliminar la persona"
					+ " verifique que no tenga registros pendientes");
		}		
		return resp;
	}

	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
	}
	
	

}
