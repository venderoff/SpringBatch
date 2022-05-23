package com.usman.JobConfig;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
public class JobConf {
	
	
	@Autowired
	StepBuilderFactory stepBuilderFactory ;
	
	@Autowired
	JobBuilderFactory jobBuilderFactory ;
	
	
	@Bean
	public Job Job1() {
		
		return jobBuilderFactory.get("This is basic First Job") 
				.start(FirstStep())
				.incrementer(new RunIdIncrementer())
				.build() ;
				
				
	
		
	}
	
	private Step FirstStep() {
		return stepBuilderFactory.get("This is first Step")
		.tasklet(FTask())
		.build() ;
		
		
		
	}
	
	private Tasklet FTask() {
		
		return new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				// TODO Auto-generated method stub
				
				log.info("Tasklet has been executed") ;
			return 	RepeatStatus.FINISHED;
			}
		};
	}
	

}
