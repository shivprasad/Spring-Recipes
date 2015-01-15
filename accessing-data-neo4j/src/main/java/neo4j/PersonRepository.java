package neo4j;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by shiv on 04/01/15.
 */
public interface PersonRepository extends CrudRepository<Person,String> {

    Person findByName(String name);

    Iterable<Person> findByTeammatesName(String name);

}
