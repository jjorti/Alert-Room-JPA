package co.jjortiz.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
		List<Novedad> listaNovedades = new ArrayList<Novedad>();
		String jpql = "SELECT n.fechaHora FROM Novedad n WHERE n.fechaHora  BETWEEN  :fechaInicio AND :fechaFinal ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("fechaInicio","2020-11-09");
		query.setParameter("fechaFinal","2020-11-12");
		listaNovedades = query.getResultList();
	return listaNovedades;
	}

}
