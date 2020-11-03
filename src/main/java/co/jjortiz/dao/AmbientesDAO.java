package co.jjortiz.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.jjortiz.aplicacion.JPAUtil;
import co.jjortiz.entidades.Ambiente;

public class AmbientesDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public String crearAmbiente(Ambiente ambiente) {
		String res = "";
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(ambiente);
			entityManager.getTransaction().commit();
			
			res = "ok";
		} catch (Exception e) {
			res = "error";
		}
		
		return res;
	}
	


	public List<Ambiente> obtenerListaAmbientes() {
		List<Ambiente> listaAmbientes = new ArrayList<Ambiente>();
		Query query=entityManager.createQuery("SELECT a FROM Ambiente a");
		listaAmbientes = query.getResultList();
		return listaAmbientes;
	}
	
	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
	}

}
