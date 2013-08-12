package py.gov.setics.registro.view;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;

import py.gov.setics.registro.business.PermisoBC;
import py.gov.setics.registro.domain.Permiso;

@ViewController
@NextView("./permiso_edit.jsf")
@PreviousView("./permiso_list.jsf")
public class PermisoListMB extends AbstractListPageBean<Permiso, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private PermisoBC permisoBC;
	
	@Override
	protected List<Permiso> handleResultList() {
		return this.permisoBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				permisoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}