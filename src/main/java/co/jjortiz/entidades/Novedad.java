package co.jjortiz.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase para la tabla novedades
 * @author JUAN ORTIZ
 *
 */
@Entity
@Table(name = "novedades")
public class Novedad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idnovedad")
	private Integer idNovedad;
	
	@Column(name = "idambiente",nullable = false, columnDefinition="CHAR(11)" )
	private String idAmbiente;
	
	@Column(name = "idusuarioI", nullable = false, columnDefinition="CHAR(11)" )
	private String idUsuarioInstructor;
	
	//TODO Preguntar por tipo de dato que almacene hora y fecha 
    @Column(name = "fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    
	@Column(name = "idusuarioG", nullable = false, columnDefinition="CHAR(11)" )
	private String idUsuarioGuarda;
    
    @Column(name ="observaciones", nullable = false , length = 255)
    private String observaciones;

	/**
	 * Class constructor empty
	 */
	public Novedad() {
		
	}
	
    /**
     * Class constructor using fields
     * @param idNovedad
     * @param idAmbiente
     * @param idUsuarioInstructor
     * @param fechaHora
     * @param idUsuarioGuarda
     * @param observaciones
     */
    public Novedad(Integer idNovedad, String idAmbiente, String idUsuarioInstructor, Date fechaHora,
			String idUsuarioGuarda, String observaciones) {
		super();
		this.idNovedad = idNovedad;
		this.idAmbiente = idAmbiente;
		this.idUsuarioInstructor = idUsuarioInstructor;
		this.fechaHora = fechaHora;
		this.idUsuarioGuarda = idUsuarioGuarda;
		this.observaciones = observaciones;
	}

	public Integer getIdNovedad() {
		return idNovedad;
	}

	public void setIdNovedad(Integer idNovedad) {
		this.idNovedad = idNovedad;
	}

	public String getIdAmbiente() {
		return idAmbiente;
	}

	public void setIdAmbiente(String idAmbiente) {
		this.idAmbiente = idAmbiente;
	}

	public String getIdUsuarioInstructor() {
		return idUsuarioInstructor;
	}

	public void setIdUsuarioInstructor(String idUsuarioInstructor) {
		this.idUsuarioInstructor = idUsuarioInstructor;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getIdUsuarioGuarda() {
		return idUsuarioGuarda;
	}

	public void setIdUsuarioGuarda(String idUsuarioGuarda) {
		this.idUsuarioGuarda = idUsuarioGuarda;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
