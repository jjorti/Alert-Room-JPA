package co.jjortiz.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * class for ambient table mapping
 * @author JUAN ORTIZ
 *
 */
@Entity
@Table(name = "ambientes")
public class Ambiente {
	
	@Id
	@Column(name = "iambiente", columnDefinition="CHAR(11)")
	private String id;
	
	@Column(nullable = true , columnDefinition="CHAR(50)")
	private String nombre;
	
	@Column(nullable = false , columnDefinition="CHAR(4)")
	private String numero;

	@Column(nullable = false , columnDefinition="CHAR(1)")
	private String estado;

	@Column(nullable = false , columnDefinition="CHAR(1)")
	private String ocupado;

	/**
	 *Constructor empty 
	 */
	public Ambiente() {
		
	}
	
	/**
	 * Class constructor using fields
	 * 
	 * @param id
	 * @param nombre
	 * @param numero
	 * @param estado
	 * @param ocupado
	 */
	public Ambiente(String id, String nombre, String numero, String estado, String ocupado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numero = numero;
		this.estado = estado;
		this.ocupado = ocupado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getOcupado() {
		return ocupado;
	}

	public void setOcupado(String ocupado) {
		this.ocupado = ocupado;
	}
}
