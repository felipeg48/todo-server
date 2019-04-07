package io.pivotal.workshop;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class ToDoConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(ToDo.class);
    }
    
    @Bean
    public ApplicationRunner init(ToDoRepository toDoRepository){
        return args -> {
            toDoRepository.save(new ToDo("Buy 1 millk galon"));
            toDoRepository.save(new ToDo("Make a dentist appointment"));
            toDoRepository.save(new ToDo("Read a Book"));
        };
    }
    
}