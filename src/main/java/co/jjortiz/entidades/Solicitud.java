package co.jjortiz.entidades;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Class for requests table
 * @author JUAN ORTIZ
 *
 */
@Entity
@Table(name ="solicitudes")
public class Solicitud {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idsolicitud")
	private Integer idSolicitud;
	
	@ManyToOne
	@JoinColumn(name = "idambiente", referencedColumnName = "idambiente", foreignKey = @ForeignKey(name ="Fk_solicitud_ambiente"))

	private Ambiente idAmbiente;

	
	@Column(name = "idusuario", nullable = false, columnDefinition="CHAR(11)" )
	private String idUsuario;
	
	//TODO Preguntar por tipo de dato que almacene hora y fecha 
    @Column(name = "fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    
    @ManyToOne
    @JoinColumn(name = "idconcepto", referencedColumnName = "idconcepto" , foreignKey = @ForeignKey(name ="Fk_solicitud_concepto"))
    private Concepto concepto;
	
    @Column(name ="observaciones", nullable = false , length = 255)
    private String observaciones;
    
    /**
     * Class constructor empty
     */
    public Solicitud() {
    	
    }

	/**
	 * Class constructor using fields
	 * 
	 * @param idSolicitud
	 * @param idAmbiente
	 * @param idUsuario
	 * @param fechaHora
	 * @param concepto
	 * @param observaciones
	 */
	public Solicitud(Integer idSolicitud, Ambiente idAmbiente, String idUsuario, Date fechaHora, Concepto concepto,
			String observaciones) {
		super();
		this.idSolicitud = idSolicitud;
		this.idAmbiente = idAmbiente;
		this.idUsuario = idUsuario;
		this.fechaHora = fechaHora;
		this.concepto = concepto;
		this.observaciones = observaciones;
	}

	public Integer getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Ambiente getIdAmbiente() {
		return idAmbiente;
	}

	public void setIdAmbiente(Ambiente idAmbiente) {
		this.idAmbiente = idAmbiente;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Concepto getConcepto() {
		return concepto;
	}

	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
    
    
	

}
