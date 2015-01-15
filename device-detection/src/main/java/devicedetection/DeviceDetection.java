package devicedetection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by shiv on 13/12/14.
 */
@EnableAutoConfiguration
@ComponentScan
public class DeviceDetection {

    public static void main(String[] args) {
        SpringApplication.run(DeviceDetection.class,args);
    }

}
