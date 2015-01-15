package restservice;

/**
 * Created by shiv on 06/12/14.
 *
 */
public class Greeting {

    private Integer id;
    private String content;


    public Greeting(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
