package gnf.gido.interfaces.batch.steps.writers;

import gnf.gido.common.batch.log.utils.GidoLogUtils;
import gnf.gido.interfaces.batch.beans.ResultGidoLoadSupplyDebReader;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The Class GccbGreenBookWriter.
 */
public class GidoLoadSupplyDebWriter implements ItemWriter<ResultGidoLoadSupplyDebReader> {

	private static final Log LOGGER = LogFactory
			.getLog(GidoLoadSupplyDebWriter.class);

	
	@Autowired
	private transient GidoLogUtils logUtils;


	/*
	 * {@inheritDoc}
	 * 
	 * @see org.springframework.batch.item.ItemWriter#write(java.util.List)
	 */
	@Override
	public void write(final List<? extends ResultGidoLoadSupplyDebReader> items)
			throws Exception {

		LOGGER.debug("Entrando en GidoLoadSupplyDebWriter.write - Thread: "
				+ Thread.currentThread().getId());

		for (final ResultGidoLoadSupplyDebReader loadSupplyDto : items) {

			LOGGER.debug(loadSupplyDto);

			// Entidades
//			final GidoLoadSupplyDeb bank = tratamientoEntidad(loadSupplyDto);
			
		}

	}



//	private GidoLoadSupplyDeb tratamientoEntidad(ResultGidoLoadSupplyDebReader loadSupplyDto) {
//		// TODO Auto-generated method stub
//		return null;
//	}



//	private void dtoToEntity(final Bank bank, final BankDto bankDto) {
//		bank.setCodeBank(bankDto.getCodeBank());
//		bank.setDescription(bankDto.getDescription());
//		bank.setManualStartDate(bankDto.getManualStartDate());
//		bank.setAutomaticStartDate(gccbGlobalDateTimeHelper.getTimeStamp());
//		bank.setEffectiveEndDate(bankDto.getEffectiveEndDate());
//		bank.setUpdateProgram(bankDto.getUpdateProgram());
//		bank.setCodCountry(bankDto.getCodCountry());
//
//		if (CheckConditions.isNotEmpty(bankDto.getBic())) {
//			bank.setBic(bankDto.getBic());
//		}
//
//		final TypeBank typeBank = typeBankDao
//				.searchByPrimaryKey(GccbTcsTypeBankAutoEnum.ENTIDAD_BANCARIA
//						.getCode());
//		bank.setTypeBank(typeBank);
//	}
	

	/**
	 * After step.
	 * 
	 * @param stepExecution
	 *            the step execution
	 * @return the exit status
	 */
	@AfterStep
	public ExitStatus afterStep(final StepExecution stepExecution) {
		final Long idThread = Thread.currentThread().getId();

		LOGGER.debug("AfterStep  idThread: " + idThread);

		logUtils.flushLogInExecutionContext(stepExecution.getJobExecution()
				.getExecutionContext());

		return stepExecution.getExitStatus();
	}

	@BeforeStep
	public void beforeStep(final StepExecution stepExecution) {

		logUtils.addLogTitle("", "Lectura del fichero TbEnti.txt", Thread
				.currentThread().getId());
	}	

}
