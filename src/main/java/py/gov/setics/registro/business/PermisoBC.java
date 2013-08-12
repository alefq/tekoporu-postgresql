package py.gov.setics.registro.business;

import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import py.gov.setics.registro.domain.Permiso;
import py.gov.setics.registro.persistence.PermisoDAO;

@BusinessController
public class PermisoBC extends DelegateCrud<Permiso, Long, PermisoDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
