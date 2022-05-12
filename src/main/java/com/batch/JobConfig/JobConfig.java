package com.batch.JobConfig;

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

import com.batch.JobListener.JobListener;
import com.batch.StepListener.StepListener;
import com.batch.processor.BatchProcessor;
import com.batch.reader.BatchReader;
import com.batch.writer.BatchWriter;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
public class JobConfig {
	
	@Autowired
	StepListener stepListener ;
	
    @Autowired
    JobListener jobListener  ;
    
	@Autowired
	JobBuilderFactory jobBuilderFactory ;
	
	@Autowired
	StepBuilderFactory stepBuilderFactory ;
	
	@Autowired
	BatchProcessor batchProcessor ;
	
	@Autowired
	BatchReader batchReader ;
	
	@Autowired
	BatchWriter batchWriter ;
	
	
	@Bean
	public Job Job1() {
		
		return jobBuilderFactory.get("Job Test 1 ")
				.start(FirstStep())
				.next(ChunkStep())
				.incrementer(new RunIdIncrementer())
				.listener(jobListener)
				.build() ;
		
		
	}


	private Step ChunkStep() {
		
		return stepBuilderFactory.get("Chunk Step")
				.<Integer,Long>chunk(3)
				.reader(batchReader)
				.processor(batchProcessor)
				.writer(batchWriter)
				.listener(stepListener)
				.build() ;
				
		
		
	}
	
	
	private Step FirstStep() {
		// TODO Auto-generated method stub
		return stepBuilderFactory.get("This is step 1")
				.tasklet(Task())
				.listener(stepListener)
				.build() ;
		
		
	}


	private Tasklet Task() {
		
		return new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				// TODO Auto-generated method stub
				
				log.info("This is new Tasklet") ;
			
				log.info(contribution.getExitStatus());
				return RepeatStatus.FINISHED ;
			}
		};
		// TODO Auto-generated method stub
//		return null;
	}
	
	
	

}
