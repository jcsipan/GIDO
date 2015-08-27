package gnf.gido.interfaces.batch.steps.mapper;

import gnf.ada.core.exceptions.ServiceException;
import gnf.gido.interfaces.batch.beans.ResultGidoLoadSupplyDebReader;

import org.apache.log4j.Logger;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * The Class GccbGreenBookMapper.
 */
public class GidoLoadSupplyDebMapper implements FieldSetMapper<ResultGidoLoadSupplyDebReader> {

	private static final Logger LOGGER = Logger.getLogger(GidoLoadSupplyDebMapper.class);

	/** {@inheritDoc}
	 * @see org.springframework.batch.item.file.mapping.FieldSetMapper#mapFieldSet(org.springframework.batch.item.file.transform.FieldSet)
	 */
	@Override
	public synchronized ResultGidoLoadSupplyDebReader mapFieldSet(final FieldSet fieldSet) throws BindException {
		final ResultGidoLoadSupplyDebReader loadSupplyDebtDto = new ResultGidoLoadSupplyDebReader();

		try {
			int i = 0;
			loadSupplyDebtDto.setCodEnti(fieldSet.readString(i++));
			loadSupplyDebtDto.setCodOfi(fieldSet.readString(i++));
			i++;
			loadSupplyDebtDto.setDenoEnti(fieldSet.readString(i++));
			loadSupplyDebtDto.setDenoOfi(fieldSet.readString(i++));
			loadSupplyDebtDto.setDomiOfi(fieldSet.readString(i++));
			loadSupplyDebtDto.setCodPostal(fieldSet.readString(i++));
			loadSupplyDebtDto.setDenoPlaza(fieldSet.readString(i++));
			i = i + 14;
			loadSupplyDebtDto.setCodComuni(fieldSet.readLong(i++));
			loadSupplyDebtDto.setDenoProv(fieldSet.readString(i++));
			loadSupplyDebtDto.setBic(fieldSet.readString(i++));
		}
		catch (final ServiceException e) {
			LOGGER.error("Error:" + e.getMessage());
		}

		return loadSupplyDebtDto;
	}

}
