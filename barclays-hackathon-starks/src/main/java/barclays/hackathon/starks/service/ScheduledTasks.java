package barclays.hackathon.starks.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Ashish Sanodia on 12-Jun-16.
 */
@Component
public class ScheduledTasks {

    private static Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);

    @Scheduled(cron = "*/10 * * * * *")
    public void sendMailForBirthdayEvent() {
        LOG.info("sending mail to user who have birthday.");
    }
}
