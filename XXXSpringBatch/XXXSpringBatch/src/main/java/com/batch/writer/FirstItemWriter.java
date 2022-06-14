package com.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.batch.model.StudentJDBC;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class FirstItemWriter implements ItemWriter<StudentJDBC>{@Override
	public void write(List<? extends StudentJDBC> items) throws Exception {
	
	log.info("Chunk Size set set" + 3);
	
	items.stream().forEach(System.out::println) ;
		
	}
//@Override
//	public void write(List<? extends Long> items) throws Exception {
//	
//	log.info("processing Writer") ;
//	
//	items.stream().forEach(System.out::println) ;
//	
//	System.out.println(items.listIterator()) ;
//	
//		
//	}

	
	
}
