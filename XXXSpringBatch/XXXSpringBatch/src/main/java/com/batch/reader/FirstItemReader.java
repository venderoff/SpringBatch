package com.batch.reader;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class FirstItemReader implements ItemReader<Integer>{

     List<Integer> elist = Arrays.asList(1,2,3,4,5,6,7,8,9,10) ;
	
     int i = 0 ;
	
	@Override
	public Integer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
         Integer item = null ;
		while(i < elist.size()) {
			
			item = elist.get(i) ;
			
			log.info("Reading the list as position" + i + "    has element   " + item) ;
		i++ ;
		
		return item;
		}
		
		i = 0 ;
		return null;
	}

}
