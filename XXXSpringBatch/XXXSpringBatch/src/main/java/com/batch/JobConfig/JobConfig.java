package com.batch.JobConfig;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.batch.model.StudentJDBC;
import com.batch.processor.FirstItemProcessor;
import com.batch.reader.FirstItemReader;
import com.batch.writer.FirstItemWriter;

import lombok.extern.log4j.Log4j2;


@Log4j2
@Configuration
public class JobConfig {
	
	//Properties from Yml Datasource
//	@Autowired
//	DataSource datasource ;
	
      
	
	
	
	@Autowired
	FirstItemWriter firstItemWriter ;
	
	@Autowired
	FirstItemProcessor firstItemProcessor ;
	
	@Autowired
    FirstItemReader firstItemReader ;
	
	@Autowired
	JobBuilderFactory jobBuilderFactory ;
	
	@Autowired
	StepBuilderFactory stepBuilderFactory ;
	
	@Primary
	@Bean   
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource datasource() {
   	 
   	 return DataSourceBuilder.create().build() ;
    }
    
    
    @Bean
    @ConfigurationProperties(prefix = "spring.universitydatasource")
    public DataSource universitydatasource() {
   	 
   	 return DataSourceBuilder.create().build() ;
    }
   
	
	
	
	@Bean
	public Job FirstJob() {
		
		return jobBuilderFactory.get("Demo Job1")
				.incrementer(new RunIdIncrementer())
				.start(StepChunk())
				
				.incrementer(new RunIdIncrementer())
				.build() ;
			}
	
	
	
	
	
	public JdbcCursorItemReader<StudentJDBC> jdbcCursorItemReader() {
		
		JdbcCursorItemReader<StudentJDBC> jdbcCursorItemReader = new 
				JdbcCursorItemReader<>();
		
		/**
		 * Resource or location
		 */
		
		jdbcCursorItemReader.setDataSource(universitydatasource());
		
		/**
		 * set SQL
		 */
		jdbcCursorItemReader.setSql("select id,first_name,last_name,email from student");
		
		
		//RowMapper
		
		jdbcCursorItemReader.setRowMapper(new BeanPropertyRowMapper<StudentJDBC>() {
			
			{
				setMappedClass(StudentJDBC.class) ;
				
			}
			
			
			
		});
		
		
		
		
		
		
		
				
				return jdbcCursorItemReader ;
		
	}
	
	
	public Step StepChunk() {
		return stepBuilderFactory.get("Chunkstep1")
//			.tasklet(Task1())
		.<StudentJDBC,StudentJDBC> chunk(3)
//			.reader(firstItemReader)
				.reader(jdbcCursorItemReader())
//			.processor(firstItemProcessor)
			.writer(firstItemWriter)
				
				.build() ;
		
		
	}
	
	
	public Tasklet Task1() {
		
		return new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				
				log.info("This is Tasklet") ;
				
				return RepeatStatus.FINISHED;
			}
		};
	}

}
