package py.gov.setics.registro.persistence;

import org.ticpy.tekoporu.stereotype.PersistenceController;
import org.ticpy.tekoporu.template.JPACrud;

import py.gov.setics.registro.domain.Permiso;

@PersistenceController
public class PermisoDAO extends JPACrud<Permiso, Long> {

	private static final long serialVersionUID = 1L;
	

}
