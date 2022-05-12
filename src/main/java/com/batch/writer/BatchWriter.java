package com.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class BatchWriter implements ItemWriter<Long>{

	@Override
	public void write(List<? extends Long> items) throws Exception {
		// TODO Auto-generated method stub
		
		items.stream().forEach(System.out::println) ;
		
	}

	

}
