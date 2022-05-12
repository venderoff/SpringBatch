package com.batch.JobListener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JobListener implements JobExecutionListener{

	@Override
	public void beforeJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub

		log.info("this is before job");
		
		log.info("Exceptions" + jobExecution.getAllFailureExceptions() );
		

		log.info("Exit Status" + jobExecution.getExitStatus() );
		

		log.info("Execution" + jobExecution.getStepExecutions() );
		

		log.info("Status" + jobExecution.getStatus() );
		

		log.info("Is running" + jobExecution.isRunning() );
		
		
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub


		log.info("this is after job");
		
		log.info("Exceptions" + jobExecution.getAllFailureExceptions() );
		

		log.info("Exit Status" + jobExecution.getExitStatus() );
		

		log.info("Execution" + jobExecution.getStepExecutions() );
		

		log.info("Status" + jobExecution.getStatus() );
		

		log.info("Is running" + jobExecution.isRunning() );

		
	}

}
