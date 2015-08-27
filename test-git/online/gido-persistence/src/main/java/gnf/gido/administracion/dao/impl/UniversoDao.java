package gnf.gido.administracion.dao.impl;

import gnf.gido.administracion.dao.interfaces.UniversoDaoI;
import gnf.gido.administracion.entities.Universo;
import gnf.ada.core.persistence.CommonDaoImplementation; 


//<#macro GenPersistence_importsDao>
//</#macro>

public class UniversoDao extends CommonDaoImplementation<Universo> implements UniversoDaoI {

	/**
	* Método que devuelve el tipo de la entidad.
	*
	* @return Tipo de la entidad. 
	**/
	public Class<Universo> getClase(){
		return Universo.class;
	}
	
	//<#macro GenPersistence_methodsDao>
//	</#macro>
}
