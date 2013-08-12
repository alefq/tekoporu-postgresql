package py.gov.setics.registro.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the usuario_rol database table.
 * 
 */
@Entity
@Table(name="usuario_rol", schema="seguridad")
public class UsuarioRol extends BaseEntity<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2206317868747108868L;

	@Id
	@SequenceGenerator(name="USUARIO_ROL_USUARIOROLID_GENERATOR", sequenceName="SEGURIDAD.USUARIO_ROL_USUARIO_ROL_ID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_ROL_USUARIOROLID_GENERATOR")
	@Column(name="usuario_rol_id")
	private Long usuarioRolId;

	//bi-directional many-to-one association to Rol
    @ManyToOne
	@JoinColumn(name="rol_id")
	private Rol rol;

	//bi-directional many-to-one association to Usuario
    @ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

    public UsuarioRol() {
    }

	public Long getUsuarioRolId() {
		return this.usuarioRolId;
	}

	public void setUsuarioRolId(Long usuarioRolId) {
		this.usuarioRolId = usuarioRolId;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public Long getId() {
		return getUsuarioRolId();
	}
}