package com.batch.reader;


import java.util.Arrays;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class BatchReader implements ItemReader<Integer> {
	
//	Integer a[] = new Integer[1,2,3,4,5,6,7,8,9,10] ;

	List<Integer> elist = Arrays.asList(1,2,3,4,5,6,7,8,9,10) ;
	int i =0 ; 
	@Override
	public Integer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		
		Integer item = null ;
		
		while(i < elist.size()) {
			item = elist.get(i) ;
			
			
			log.info(item);
			i++ ;
			return item ;
		}
		
		return null;
	}

	
}
