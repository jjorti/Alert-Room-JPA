package co.jjortiz.dao;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import co.jjortiz.aplicacion.JPAUtil;
import co.jjortiz.entidades.Novedad;

public class NovedadesDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
	}

	public List<Novedad> listarNovedades(Date fechaHora) {
		Calendar inicio = Calendar.getInstance();
		inicio.set(fechaHora.getYear()+1900, fechaHora.getMonth()+1, fechaHora.getDate(),0,0,0);
		List<Novedad> listaNovedades = new ArrayList<Novedad>();
		String jpql = "SELECT n.fechaHora FROM Novedad n WHERE n.fechaHora = :fechaInicio";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("fechaInicio", new java.sql.Date(inicio.getTime().getTime()), TemporalType.DATE);

		listaNovedades = query.getResultList();
	return listaNovedades;
	}

}
