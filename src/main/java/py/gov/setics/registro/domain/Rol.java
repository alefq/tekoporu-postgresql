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

/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@Table(schema = "seguridad")
public class Rol extends BaseEntity<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ROL_ROLID_GENERATOR", sequenceName = "SEGURIDAD.ROL_ROL_ID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROL_ROLID_GENERATOR")
	@Column(name = "rol_id")
	private Long rolId;

	private String nombre;

	// bi-directional many-to-one association to RolPermiso
	@OneToMany(mappedBy = "rol")
	private Set<RolPermiso> rolPermisos;

	// bi-directional many-to-one association to UsuarioRol
	@OneToMany(mappedBy = "rol")
	private Set<UsuarioRol> usuarioRols;

	public Rol() {
	}

	public Long getRolId() {
		return this.rolId;
	}

	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<RolPermiso> getRolPermisos() {
		return this.rolPermisos;
	}

	public void setRolPermisos(Set<RolPermiso> rolPermisos) {
		this.rolPermisos = rolPermisos;
	}

	public Set<UsuarioRol> getUsuarioRols() {
		return this.usuarioRols;
	}

	public void setUsuarioRols(Set<UsuarioRol> usuarioRols) {
		this.usuarioRols = usuarioRols;
	}

	@Override
	public Long getId() {
		return getRolId();
	}
}