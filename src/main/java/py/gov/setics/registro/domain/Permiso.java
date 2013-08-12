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
 * The persistent class for the permiso database table.
 * 
 */
@Entity
@Table(schema = "seguridad")
public class Permiso extends BaseEntity<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1213085665264494689L;

	@Id
	@SequenceGenerator(name = "PERMISO_PERMISOID_GENERATOR", sequenceName = "SEGURIDAD.PERMISO_PERMISO_ID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERMISO_PERMISOID_GENERATOR")
	@Column(name = "permiso_id")
	private Long permisoId;

	private String nombre;

	// bi-directional many-to-one association to RolPermiso
	@OneToMany(mappedBy = "permiso")
	private Set<RolPermiso> rolPermisos;

	public Permiso() {
	}

	public Long getPermisoId() {
		return this.permisoId;
	}

	public void setPermisoId(Long permisoId) {
		this.permisoId = permisoId;
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

	@Override
	public Long getId() {
		return getPermisoId();
	}

}