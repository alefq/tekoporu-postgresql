package py.gov.setics.registro.view;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;

import py.gov.setics.registro.business.RolBC;
import py.gov.setics.registro.domain.Rol;

@ViewController
@NextView("./rol_edit.jsf")
@PreviousView("./rol_list.jsf")
public class RolListMB extends AbstractListPageBean<Rol, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private RolBC rolBC;
	
	@Override
	protected List<Rol> handleResultList() {
		return this.rolBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				rolBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}