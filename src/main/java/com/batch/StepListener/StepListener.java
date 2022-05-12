package com.batch.StepListener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StepListener implements StepExecutionListener{

	
	@Override
	public void beforeStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		
		log.info("This is before Step") ;
		
	log.info("Summary" + stepExecution.getSummary()) ;	
	
	log.info("Executoion Context" + stepExecution.getExecutionContext());
	
	log.info("Exceptions" + stepExecution.getFailureExceptions());
	
	log.info("Exit Status" + stepExecution.getExitStatus());
	
	log.info(stepExecution.getCommitCount());
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		
		log.info("This is After Step") ;
		
		log.info("Summary" + stepExecution.getSummary()) ;	
		
		log.info("Executoion Context" + stepExecution.getExecutionContext());
		
		log.info("Exceptions" + stepExecution.getFailureExceptions());
		
		log.info("Exit Status" + stepExecution.getExitStatus());
		
		log.info(stepExecution.getCommitCount());
		
		return null;

		

	}

}
