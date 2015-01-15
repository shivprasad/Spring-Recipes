package restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by shiv on 06/12/14.
 */
@ComponentScan
@EnableAutoConfiguration
public class RestService {

    public static void main(String[] args) {
        SpringApplication.run(RestService.class, args);
    }

}
