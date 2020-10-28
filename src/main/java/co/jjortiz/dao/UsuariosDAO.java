package co.jjortiz.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.jjortiz.aplicacion.JPAUtil;
import co.jjortiz.entidades.Usuario;

public class UsuariosDAO implements Serializable{

	private static final long serialVersionUID = 1L;


	EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();

	/**
	 * Metodo para consultar si un usuario se encuentra en la base de datos
	 * @param id
	 * @param contrasena
	 * @return Usuario si existe , null si no existe
	 */
	public Usuario consultarLoginUsuario(String id, String contrasena) {
		
		Usuario miUsuario=entityManager.find(Usuario.class, id);
		
		if (miUsuario!=null) {
			System.out.println("se encontro el usuario");
			System.out.println(miUsuario.getNombres());
			return miUsuario;
		}else {
			System.out.println("no se encuentra el usuario");
			return null;
		}
	}
	

	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
	}
	
	

}
