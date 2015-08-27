/**
 * Copyright 2011 GNF
 * @author ivmedina
 * 
 */
package gnf.gido.common.batch.log.convert.job;

import gnf.gido.common.batch.log.data.job.JobConvertDataInterface;

import org.springframework.batch.core.JobExecution;

/**
 * The Interface JobConvertInterface.
 */
public interface JobConvertInterface {

	static final class JobConvertStrings {

		/**
		 * Constructor para evitar instancia de la clase statica
		 */
		private JobConvertStrings() {
		}

		static final String JOB_NAME = "Job name";

		static final String JOB_MODULE = "Job module";

		static final String JOB_CODE = "Job code";

		static final String JOB_DESCRIPTION = "Job description";

		static final String JOB_PARAMETERS = "Job parameter: ";

		static final String START_TIME = "Start time";

		static final String CREATE_TIME = "Create time";

		static final String END_TIME = "End time";

		static final String TOTAL_TIME = "Total time";

		static final String EXIT_STATUS = "Exit status";

		static final String RETURN_CODE = "Return code";

		static final String LOG_JOB_ERROR = "ERROR: ";

		static final String ESTADISTICAS_PROCESO = "Estadisticas del proceso: ";

		static final String REGISTROS_LEIDOS = "Registros leidos: ";

		static final String REGISTROS_RECHAZADOS = "Registros rechazados: ";

		static final String REGISTROS_PROCESADOS = "Registros procesados: ";

		static final String ESTADISTICAS = "Estadisticas";
	}

	/**
	 * Convert.
	 * 
	 * @param jobExecution the job execution
	 * @return the job convert data interface
	 */
	public JobConvertDataInterface convert(final JobExecution jobExecution);
}
