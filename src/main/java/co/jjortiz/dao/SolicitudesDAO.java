package co.jjortiz.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.jjortiz.aplicacion.JPAUtil;
import co.jjortiz.entidades.Ambiente;
import co.jjortiz.entidades.Solicitud;

public class SolicitudesDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;


	EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
	}

	public String solicitudLlaves(Solicitud solicitud) {
		String res = "";
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(solicitud);
			entityManager.getTransaction().commit();
			res = "ok";
		} catch (Exception e) {
			res = "error";
		}
		return res;
	}

	public List<Solicitud> obtenerListaSolicitud() {
		List<Solicitud>  listaSolicitudes =  new ArrayList<Solicitud>();
		Query query= entityManager.createQuery("SELECT s FROM  Solicitud s");
		listaSolicitudes = query.getResultList();
		return listaSolicitudes;
	}

	public List<Solicitud> obtenerSolicitudesAmbiente(String idAmbiente) {
		System.out.println(idAmbiente);
		List<Solicitud>  listaSolicitudes =  new ArrayList<Solicitud>();
		Query query = entityManager.createQuery("SELECT  s FROM  Solicitud s WHERE s.idAmbiente.id = :idAmbiente");
		query.setParameter("idAmbiente", idAmbiente);
		listaSolicitudes = query.getResultList();
		return listaSolicitudes;
	}

}
