/**
 * Copyright 2011 GNF
 * @author ivmedina
 * 
 */
package gnf.gido.common.batch.log.convert.step;

import gnf.gido.common.batch.log.data.step.StepConvertDataInterface;

import org.springframework.batch.core.StepExecution;

/**
 * The Interface StepConvertInterface.
 */
public interface StepConvertInterface {

	final static class StepConvertStrings {

		// Prevent instantation
		private StepConvertStrings() {
		}

		static final String STEP_NAME = "Step Name";

		static final String READ_COUNT = "Read count";

		static final String WRITE_COUNT = "Write count";

		static final String COMMIT_COUNT = "Commit count";

		static final String ROLLBACK_COUNT = "Rollback count";

		static final String READ_SKIP_COUNT = "Read skip count";

		static final String PROCESS_SKIP_COUNT = "Process skip count";

		static final String WRITE_SKIP_COUNT = "Write skip count";

		static final String START_TIME = "Start time";

		static final String END_TIME = "End time";

		static final String TOTAL_TIME = "Total time";

		static final String EXIT_STATUS = "Exit status";

		static final String FILTER_COUNT = "Filter count";
	}

	/**
	 * Convert.
	 * 
	 * @param stepContext the step context
	 * @return the step convert data interface
	 */
	public StepConvertDataInterface convert(final StepExecution stepContext);

}
