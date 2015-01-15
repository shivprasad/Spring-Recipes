package neo4j;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shiv on 04/01/15.
 */
@NodeEntity
public class Person {

    @GraphId
    Long id;

    String name;

    @RelatedTo(direction = Direction.BOTH,type = "TEAMMATE")
    @Fetch
    Set<Person> teammates;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public void worksWith(Person person){
        if (teammates == null) {
            teammates = new HashSet<Person>();
        }
        teammates.add(person);
    }

    public String toString() {
        String results = name + "'s teammates include\n";
        if (teammates != null) {
            for (Person person : teammates) {
                results += "\t- " + person.name + "\n";
            }
        }
        return results;
    }

}
