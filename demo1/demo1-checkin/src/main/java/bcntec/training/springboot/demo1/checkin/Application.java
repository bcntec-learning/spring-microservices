package bcntec.training.springboot.demo1.checkin;

import java.util.Date;

import bcntec.training.springboot.demo1.checkin.repository.CheckinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import bcntec.training.springboot.demo1.checkin.entity.CheckInRecord;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
    CheckinRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... strings) throws Exception {
		CheckInRecord record = new CheckInRecord("Franc", "Gean","28A",new Date(),"BF101","22-JAN-18",1);
		 
 		CheckInRecord result  = repository.save(record);
		logger.info("checked in successfully ..." + result);
		
		
		
		logger.info("Looking to load checkedIn record..."); 
	    logger.info("Result: " + repository.findById(result.getId()));
 
	    
	}
}
