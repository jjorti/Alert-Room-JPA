package co.jjortiz.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import co.jjortiz.aplicacion.JPAUtil;
import co.jjortiz.entidades.Ambiente;
import co.jjortiz.entidades.Articulo;
import co.jjortiz.entidades.InventarioAmbiente;
import co.jjortiz.vo.InformacionInventario;

public class InventarioAmbienteDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();
	

	public String registrarIventarioAmbiente(String idAmbiente, List<InformacionInventario> listaArticulos) {
		String res = "";
		Articulo miArticulo = null;
		InventarioAmbiente miInventarioAmbiente = null;
		if (listaArticulos.size()>0) {
			System.out.println("existe la lista");
			for (InformacionInventario informacionInventario : listaArticulos) {
				System.out.println("voyu a  recorrer la lista");
				miInventarioAmbiente = new InventarioAmbiente();
				Ambiente miAmbiente = new Ambiente();
				miAmbiente.setId(idAmbiente);
				miInventarioAmbiente.setIdAmbiente(miAmbiente);
				System.out.println("cree el ambiente y lo añadi");
				miArticulo = new Articulo();
				miArticulo.setNombre(informacionInventario.getNombre());
				System.out.println("cree el articulo y lo añadi");
				miInventarioAmbiente.setIdArticulo(miArticulo);
				miInventarioAmbiente.setCantidad(informacionInventario.getCantidad());
				System.out.println("Añadi toda la informacion y voy a persistir");
				
				try {
					entityManager.getTransaction().begin();
					entityManager.persist(miInventarioAmbiente);
					entityManager.getTransaction().commit();
					System.out.println("Añadio sin problemas");
					res = "ok";
				} catch (Exception e) {
					res = "error";
					return res;
				}
			}
		}else {
			res = "error";
			return  res;
		}
		return res;
	}
	
	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
	}
}
