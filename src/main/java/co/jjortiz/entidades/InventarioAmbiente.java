package co.jjortiz.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idambiente_inventario")
	private Integer idambienteinventario;

	@ManyToOne
	@JoinColumn(name = "idambiente", referencedColumnName = "idambiente", foreignKey = @ForeignKey(name ="Fk_inventarioambiente_ambiente"))
	private Ambiente idAmbienteInventario;
	
	@ManyToOne
	@JoinColumn(name = "idarticulo", referencedColumnName = "idarticulo", foreignKey = @ForeignKey(name ="Fk_inventarioambiente_articulo"))
	private Articulo idArticulo;
	
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
	public InventarioAmbiente(Integer idambienteinventario, Ambiente idAmbiente, Articulo idArticulo, Integer cantidad) {
		super();
		this.idambienteinventario = idambienteinventario;
		this.idAmbienteInventario = idAmbiente;
		this.idArticulo = idArticulo;
		this.cantidad = cantidad;
	}

	public Ambiente getIdAmbiente() {
		return idAmbienteInventario;
	}

	public void setIdAmbiente(Ambiente idAmbiente) {
		this.idAmbienteInventario = idAmbiente;
	}

	public Articulo getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(Articulo idArticulo) {
		this.idArticulo = idArticulo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getIdambienteinventario() {
		return idambienteinventario;
	}

	public void setIdambienteinventario(Integer idambienteinventario) {
		this.idambienteinventario = idambienteinventario;
	}
}
