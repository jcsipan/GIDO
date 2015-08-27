/**
 * Copyright 2011 GNF
 * @author ivmedina
 *
 */
package gnf.gido.common.batch.log.data;

import gnf.gido.common.batch.log.data.job.JobConvertDataInterface;
import gnf.gido.common.batch.log.data.step.StepConvertDataInterface;

import java.util.Collection;

/**
 * The Class ConvertData.
 */
public final class ConvertData {

	private final JobConvertDataInterface jobData;
	
	private final Collection<StepConvertDataInterface> stepData;
	
	/**
	 * Instantiates a new convert data.
	 * 
	 * @param jobData the job data
	 * @param stepData the step data
	 */
	public ConvertData(final JobConvertDataInterface jobData, final Collection<StepConvertDataInterface> stepData) {
		super();
		this.jobData = jobData;
		this.stepData = stepData;
	}

	/**
	 * Gets the job data.
	 * 
	 * @return the job data
	 */
	public JobConvertDataInterface getJobData() {
		return jobData;
	}

	/**
	 * Gets the step data.
	 * 
	 * @return the step data
	 */
	public Collection<StepConvertDataInterface> getStepData() {
		return stepData;
	}
}
