package gnf.gido.steps;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/gnf/ada/batch/testBatchContext.xml",
		"classpath*:/gnf/gido/interfaces/jobs/loadSupplyDebt-batch.xml.xml" })
public class GidoLoadSupplyDebtTaskletIT {
	 
	   @Autowired
	   private JobLauncherTestUtils jobLauncherTestUtils;

	   @Test
	   public void testJob() throws Exception {

	   //jobParameters

	           final JobParametersBuilder jobParamBuilder = new JobParametersBuilder();

	            jobParamBuilder.addString("idVariant", "100000013");

	            jobParamBuilder.addString("fechaBatch", "15/02/2012");

	   //...

	            JobParameters jobParameters = jobParamBuilder.toJobParameters();

	        JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);

	        Assert.assertEquals("COMPLETED", jobExecution.getExitStatus().getExitCode());

	   }
	
}
