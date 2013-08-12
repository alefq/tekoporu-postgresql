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
 * The persistent class for the rol_permiso database table.
 * 
 */
@Entity
@Table(name="rol_permiso", schema="seguridad")
public class RolPermiso  extends BaseEntity<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5425750026695963107L;

	@Id
	@SequenceGenerator(name="ROL_PERMISO_ROLPERMISOID_GENERATOR", sequenceName="SEGURIDAD.ROL_PERMISO_ROL_PERMISO_ID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROL_PERMISO_ROLPERMISOID_GENERATOR")
	@Column(name="rol_permiso_id")
	private Long rolPermisoId;

	//bi-directional many-to-one association to Permiso
    @ManyToOne
	@JoinColumn(name="permiso_id")
	private Permiso permiso;

	//bi-directional many-to-one association to Rol
    @ManyToOne
	@JoinColumn(name="rol_id")
	private Rol rol;

    public RolPermiso() {
    }

	public Long getRolPermisoId() {
		return this.rolPermisoId;
	}

	public void setRolPermisoId(Long rolPermisoId) {
		this.rolPermisoId = rolPermisoId;
	}

	public Permiso getPermiso() {
		return this.permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}
	
	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public Long getId() {
		return getRolPermisoId();
	}
}