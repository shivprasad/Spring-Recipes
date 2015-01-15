package neo4j;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.impl.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.core.GraphDatabase;

import java.io.File;
import java.io.IOException;

/**
 * Created by shiv on 04/01/15.
 */
@Configuration
@EnableAutoConfiguration
@EnableNeo4jRepositories(basePackages = "neo4j")
public class AccessingDataNeo4j extends Neo4jConfiguration implements CommandLineRunner {

    public AccessingDataNeo4j() {
        setBasePackage("neo4j");
    }

    @Autowired
    PersonRepository personRepository;

    @Autowired
    GraphDatabase graphDatabase;

    @Bean
    GraphDatabaseService graphDatabaseService(){
        return new GraphDatabaseFactory().newEmbeddedDatabase("accessingdataneo4j.db");
    }

    public static void main(String[] args) throws IOException {
        FileUtils.deleteRecursively(new File("accessingdataneo4j.db"));

        SpringApplication.run(AccessingDataNeo4j.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Person shiv = new Person("shiv");
        Person anu = new Person("Anu");
        Person tanu = new Person("Tanu");

        System.out.println("Before linking up with Neo4j...");
        for (Person person : new Person[]{shiv, anu, tanu}) {
            System.out.println(person);
        }

        Transaction tx = graphDatabase.beginTx();

        try {
            personRepository.save(shiv);
            personRepository.save(anu);
            personRepository.save(tanu);

            shiv = personRepository.findByName(shiv.name);
            shiv.worksWith(anu);
            shiv.worksWith(tanu);
            personRepository.save(shiv);


            anu = personRepository.findByName(anu.name);
            anu.worksWith(tanu);
            personRepository.save(anu);

            System.out.println("Lookup each person by name...");
            for (String name: new String[]{shiv.name, anu.name, tanu.name}) {
                System.out.println(personRepository.findByName(name));
            }

            System.out.println("Looking up who works with Shiv...");
            for (Person person : personRepository.findByTeammatesName(shiv.name)) {
                System.out.println(person.name + " works with Shiv.");
            }

            tx.success();
        }finally {
            tx.close();
        }


    }
}
