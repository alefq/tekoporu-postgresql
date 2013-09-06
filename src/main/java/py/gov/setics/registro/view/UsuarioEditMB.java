package py.gov.setics.registro.view;

import java.sql.BatchUpdateException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.exception.ExceptionHandler;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;

import py.gov.setics.registro.business.UsuarioBC;
import py.gov.setics.registro.domain.Usuario;

@ViewController
@PreviousView("./usuario_list.jsf")
public class UsuarioEditMB extends AbstractEditPageBean<Usuario, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private Logger logger;

	@Inject
	private UsuarioBC usuarioBC;

	@Override
	@Transactional
	public String delete() {
		this.usuarioBC.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		this.usuarioBC.insert(getBean());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {

		this.usuarioBC.update(getBean());
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {
		Usuario usuario = this.usuarioBC.load(getId());
		usuario.setContrasenha(null);
		setBean(usuario);
	}

	@Transactional
	public String insertWithError()
	{
		usuarioBC.insertWithError(getBean());
		return getPreviousView();
	}
	
	@ExceptionHandler
	public void tratarHibernatePostgreSQL(RollbackException e) {
		PersistenceException persistenceException = (PersistenceException) e
				.getCause();
		/*
		 * Desde aquí ya no es estándar JEE6, estas son clases específicas de
		 * Hibernate y PostgreSQL dependiendo del proveedor JPA y del motor que
		 * se utilice esto habrá que adaptar
		 */
		ConstraintViolationException constraintViolationException = (ConstraintViolationException) persistenceException
				.getCause();
		BatchUpdateException batchUpdateException = (BatchUpdateException) constraintViolationException
				.getCause();
		Exception psqlException = batchUpdateException.getNextException();
		String msg = psqlException.getLocalizedMessage();
		logger.error("Error al realizar el update: " + msg);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
	}
}