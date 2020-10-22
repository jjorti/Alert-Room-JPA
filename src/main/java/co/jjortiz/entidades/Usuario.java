package co.jjortiz.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * class for users table mapping
 * @author JUAN ORTIZ
 *
 */
@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@Column(name = "identificacion", length = 11,  columnDefinition="CHAR(11)")
	private String id;
	
	@Column(nullable = false , length = 50  )
	private String nombres;
	
	@Column(nullable = false , length = 50)
	private String apellidos;
	
	@Column(nullable = false , columnDefinition="CHAR(32)")
	private String contrasena;
	
	@Column(nullable = false , length = 50  )
	private String email;
	
	@Column(nullable = true , length = 25  )
	private String telefono;
	
	@Column(name="tipo_usuario" , nullable = false , columnDefinition="CHAR(1)")
	private String tipoUsuario;
	
	@Column(nullable = true , columnDefinition = "TEXT")
	private String foto;
	
	@Column(nullable = false , columnDefinition="CHAR(1)")
	private String estado;
	
	/**
	 *Constructor empty 
	 */
	public Usuario() {
		
	}

	/**
	 * Class constructor using fields
	 * 
	 * @param id
	 * @param nombres
	 * @param apellidos
	 * @param contrasena
	 * @param email
	 * @param telefono
	 * @param tipoUsuario
	 * @param foto
	 * @param estado
	 */
	public Usuario(String id, String nombres, String apellidos, String contrasena, String email, String telefono,
			String tipoUsuario, String foto, String estado) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.contrasena = contrasena;
		this.email = email;
		this.telefono = telefono;
		this.tipoUsuario = tipoUsuario;
		this.foto = foto;
		this.estado = estado;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}	
}
