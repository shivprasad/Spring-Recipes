package scheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * Created by shiv on 11/12/14.
 */
@EnableAutoConfiguration
public class SchedulingTasks {

    public static void main(String[] args) {
        SpringApplication.run(new Object[]{SchedulingTasks.class,ScheduledTask.class},args);
    }
}
