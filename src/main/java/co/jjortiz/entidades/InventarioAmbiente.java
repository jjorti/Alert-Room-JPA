package co.jjortiz.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class for the environment inventory table
 * @author JUAN ORTIZ
 *
 */
@Entity
@Table(name = "ambiente_inventario")
public class InventarioAmbiente {

	//TODO : La entidad no tiene una llave primaria lo que genera errores para JPA
	// modificar la base de datos o buscar otra alternativa, se coloca @id para que no
	// aparezca el error 
	@Id   
	@Column(name = "idambiente", length = 10 ,nullable = false)
	private String idAmbiente;
	
	@Column( name = "idarticulo", nullable = false)
	private Integer idArticulo;
	
	@Column( name = "cantidad" , nullable = false)
	private Integer cantidad;
	
	/**
	 * Constructor empty 
	 */
	public InventarioAmbiente () {
		
	}

	/**
	 * Class constructor using fields
	 * 
	 * @param idAmbiente
	 * @param idArticulo
	 * @param cantidad
	 */
	public InventarioAmbiente(String idAmbiente, Integer idArticulo, Integer cantidad) {
		super();
		this.idAmbiente = idAmbiente;
		this.idArticulo = idArticulo;
		this.cantidad = cantidad;
	}

	public String getIdAmbiente() {
		return idAmbiente;
	}

	public void setIdAmbiente(String idAmbiente) {
		this.idAmbiente = idAmbiente;
	}

	public Integer getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(Integer idArticulo) {
		this.idArticulo = idArticulo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
	
	
	
}
