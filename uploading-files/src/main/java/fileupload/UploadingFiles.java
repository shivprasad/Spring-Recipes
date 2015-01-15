package fileupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by shiv on 01/01/15.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class UploadingFiles {
    public static void main(String[] args) {
        SpringApplication.run(UploadingFiles.class,args);
    }
}
