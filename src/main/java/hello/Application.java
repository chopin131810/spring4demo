package hello;

import java.io.File;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import hello.dao.PersonRepository;
import hello.entity.Person;

@SpringBootApplication
public class Application {

    public static String ROOT = "upload-dir";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @Order(value = 1)
    CommandLineRunner init() {
        return (String[] args) -> {
            new File(ROOT).mkdir();
        };
    }
    
    @Bean
    @Order(value = 2)
    CommandLineRunner initDatabase(PersonRepository repo) {
    	return (args) -> {
//    		repo.save(new Person(1, "person1"));
//    		repo.save(new Person(2, "person2"));
//    		repo.save(new Person(3, "person3"));
    	};
    }
}