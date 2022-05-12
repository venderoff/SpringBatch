package com.batch.processor;

import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class BatchProcessor implements ItemProcessor<Integer,Long>{

	@Override
	public Long process(Integer item) throws Exception {
		// TODO Auto-generated method stub
		
		log.info("This is processor" );
		
	//	return item.longValue() ;
		
		return item.longValue() ;
	}

	

}
