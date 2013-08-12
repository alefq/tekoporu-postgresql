package py.gov.setics.registro.persistence;

import org.ticpy.tekoporu.stereotype.PersistenceController;
import org.ticpy.tekoporu.template.JPACrud;

import py.gov.setics.registro.domain.Rol;

@PersistenceController
public class RolDAO extends JPACrud<Rol, Long> {

	private static final long serialVersionUID = 1L;
	

}
