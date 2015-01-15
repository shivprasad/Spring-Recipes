package restservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by shiv on 06/12/14.
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicInteger counter = new AtomicInteger();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }

}
