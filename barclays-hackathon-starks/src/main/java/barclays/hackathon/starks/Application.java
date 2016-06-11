package barclays.hackathon.starks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
//
//    @Bean
//    public CommandLineRunner demo(final IndividualRepository repository) {
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... strings) throws Exception {
//
//                repository.save(new Individual("Jack", "Bauer", null, null, null, null, null));
//
//                // fetch all customers
//                log.info("Customers found with findAll():");
//                log.info("-------------------------------");
//                for (Individual customer : repository.findAll()) {
//                }
//                log.info("");
//
//                // fetch an individual customer by ID
//                Individual customer = repository.findOne(1L);
//                log.info("Customer found with findOne(1L):");
//                log.info("--------------------------------");
//                log.info(customer.toString());
//                log.info("");
//
//                // fetch customers by last name
//                log.info("Customer found with findByLastName('Bauer'):");
//                log.info("--------------------------------------------");
//                log.info(repository.findByEmail("Bauer").toString());
//                log.info("");
//            }
//        };
//
//    }
}
