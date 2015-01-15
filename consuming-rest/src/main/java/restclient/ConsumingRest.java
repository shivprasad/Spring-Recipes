package restclient;

import org.springframework.web.client.RestTemplate;

/**
 * Created by shiv on 14/12/14.
 */
public class ConsumingRest {

    public static void main(String[] args) {
        RestTemplate template = new RestTemplate();

        Page page = template.getForObject("http://graph.facebook.com/pivotalsoftware",Page.class);

        System.out.println("Name " + page.getName());
        System.out.println("About " + page.getAbout());
        System.out.println("Phone " + page.getPhone());
        System.out.println("Website " + page.getWebsite());

    }

}