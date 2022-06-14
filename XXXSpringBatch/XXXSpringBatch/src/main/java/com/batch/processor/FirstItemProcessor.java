package com.batch.processor;

import javax.batch.api.chunk.ItemProcessor;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class FirstItemProcessor implements org.springframework.batch.item.ItemProcessor<Integer,Long>{

	@Override
	public Long process(Integer item) throws Exception {
		// TODO Auto-generated method stub
		
		log.info("This is inside item Processor") ;
		
		return item.longValue();
	}

}
