package barclays.hackathon.starks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Ashish Sanodia on 6/5/2016.
 */
@SpringBootApplication
@Configuration
@EnableWebMvc
@ComponentScan
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    //    @Bean
    public CommandLineRunner demo() {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                log.info("");
            }
        };
    }
}
