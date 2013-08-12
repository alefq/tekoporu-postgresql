package py.gov.setics.registro.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(schema = "seguridad")
public class Usuario extends BaseEntity<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9181870912068722866L;

	public static final int TIPO_MANDUA = 1;
	public static final int TIPO_GOOGLE = 2;
	public static final int TIPO_FACEBOOK = 3;

	@Id
	@SequenceGenerator(name = "USUARIO_USUARIOID_GENERATOR", sequenceName = "SEGURIDAD.USUARIO_USUARIO_ID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_USUARIOID_GENERATOR")
	@Column(name = "usuario_id")
	private Long usuarioId;

	@Column(name = "clave_privada")
	private String clavePrivada;

	@Column(name = "clave_publica")
	private String clavePublica;

	private String contrasenha;

	@NotNull
	private String nombre;

	private String salt;

	// bi-directional many-to-one association to UsuarioRol
	@OneToMany(mappedBy = "usuario")
	private Set<UsuarioRol> usuarioRols;

	public Usuario() {
	}

	public Usuario(String contrasenha, String nombre, String salt) {
		super();
		this.contrasenha = contrasenha;
		this.nombre = nombre;
		this.salt = salt;
	}

	public Long getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getClavePrivada() {
		return this.clavePrivada;
	}

	public void setClavePrivada(String clavePrivada) {
		this.clavePrivada = clavePrivada;
	}

	public String getClavePublica() {
		return this.clavePublica;
	}

	public void setClavePublica(String clavePublica) {
		this.clavePublica = clavePublica;
	}

	public String getContrasenha() {
		return this.contrasenha;
	}

	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Set<UsuarioRol> getUsuarioRols() {
		return this.usuarioRols;
	}

	public void setUsuarioRols(Set<UsuarioRol> usuarioRols) {
		this.usuarioRols = usuarioRols;
	}

	@Override
	public Long getId() {
		return getUsuarioId();
	}

}