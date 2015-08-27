package gnf.gido.administracion.dao.impl;

import gnf.gido.administracion.dao.interfaces.MorososNisDaoI;
import gnf.gido.administracion.entities.MorososNis;
import gnf.ada.core.persistence.CommonDaoImplementation; 


//<#macro GenPersistence_importsDao>
//</#macro>

public class MorososNisDao extends CommonDaoImplementation<MorososNis> implements MorososNisDaoI {

	/**
	* Método que devuelve el tipo de la entidad.
	*
	* @return Tipo de la entidad. 
	**/
	public Class<MorososNis> getClase(){
		return MorososNis.class;
	}
	
	//<#macro GenPersistence_methodsDao>
//	</#macro>
}
