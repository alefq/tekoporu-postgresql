package py.gov.setics.registro.business;

import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import py.gov.setics.registro.domain.Rol;
import py.gov.setics.registro.persistence.RolDAO;

@BusinessController
public class RolBC extends DelegateCrud<Rol, Long, RolDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
