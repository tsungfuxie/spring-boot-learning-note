package person.tsungfuxie.springguidesschedulingtasks;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
//	@Scheduled(fixedDelay = 1000)
	public void reportCurrentTimeWithFixedDelay() {
		logger.info(">> <fixedDelay> Start");
		logger.info("	<fixedDelay> current time is {}", SIMPLE_DATE_FORMAT.format(new Date()));
		logger.info(">> <fixedDelay> End");
		int index = 0;
		while (true) {
			++index;
			if(index % 10000000 == 0) {logger.info("	index = {}", index);}
			if(index >= 90000000) {break;}
		}
	}
	
//	@Scheduled(fixedRate = 3000)
	public void reportCurrentTimeWithFixedRate() {
		logger.info(">> <fixedRate> Start");
		logger.info("	<fixedRate> current time is {}", SIMPLE_DATE_FORMAT.format(new Date()));
		logger.info(">> <fixedRate> End");
	}
	
	@Scheduled(initialDelay = 5000, fixedRate = 3000)
	public void reportCurrentTimeWithInitialDelay() throws InterruptedException {
		logger.info(">> <initialDelay> Start");
		logger.info("	<initialDelay> current time is {}", SIMPLE_DATE_FORMAT.format(new Date()));
		Thread.sleep(6000);
		logger.info(">> <initialDelay> End");
	}
	
}
