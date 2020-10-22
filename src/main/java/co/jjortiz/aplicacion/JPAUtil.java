package co.jjortiz.aplicacion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final String UNIDAD_DE_PERSISTENCIA = "AlertRoom";
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		System.out.println("1");
		if (factory == null ) {
			factory= Persistence.createEntityManagerFactory(UNIDAD_DE_PERSISTENCIA);
		}
		System.out.println("2");
		return factory;
	}
	
	public static void shutdown() {
		if (factory!=null) {
			factory.close();
			
		}
	}
	
}
