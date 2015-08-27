package gnf.gido.interfaces.batch.runners;

import gnf.ada.batch.exec.Runner;

import org.apache.log4j.Logger;

/**
 * The Class RunGreenBookJob (COBR-B-010).
 */
public final class RunLoadSupplyDebtJob {
	private static final Logger LOGGER = Logger.getLogger(RunLoadSupplyDebtJob.class);

	// Prevent instantiation
	private RunLoadSupplyDebtJob() {
	}

	/**
	 * Este Metodo hace una llamada al Runner de la jar de ADA pasandole el nombre del Job a lanzar y sus parametros.
	 * 
	 * @param args the arguments
	 */
	public static void main(final String[] args) {

		LOGGER.info("Lanzando GreenBook Batch");

//		final String codCountry = "codCountry=01";
//		final String executionDate = "executionDate=2014/03/24";

		System.setProperty("batch.context.rule", "classpath*:/gnf/gido/contexts/LoadSupplyDebtLoad-batchContext.xml");
		System.setProperty("batch.job.rule", "classpath*:/gnf/gido/jobs/loadSupplyDebt-batch.xml.xml");

		final String[] vals = { "loadSupplyDebtJob", "-next", "executiontype=simple"};

		Runner.main(vals);

	}
}