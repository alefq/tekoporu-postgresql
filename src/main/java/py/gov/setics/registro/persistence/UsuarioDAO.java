package py.gov.setics.registro.persistence;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.RollbackException;

import org.slf4j.Logger;
import org.ticpy.tekoporu.exception.ExceptionHandler;
import org.ticpy.tekoporu.stereotype.PersistenceController;
import org.ticpy.tekoporu.template.JPACrud;

import py.gov.setics.registro.domain.Usuario;

@PersistenceController
public class UsuarioDAO extends JPACrud<Usuario, Long> implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 2979610779444308402L;

	@Override
	public void insert(Usuario entity) {
		super.insert(entity);
	}

	/**
	 * Este método a propósito generará un error al querer guardar una
	 * contraseña nula. Se hizo para tener un ejemplo de captura de mensajes
	 * para mostrar al usuario
	 * 
	 * @param bean
	 */
	public void insertWithError(Usuario bean) {
		bean.setContrasenha(null);
		super.insert(bean);
	}

}
