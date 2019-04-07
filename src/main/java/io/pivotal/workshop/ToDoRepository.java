package io.pivotal.workshop;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = {"*"})
public interface ToDoRepository extends CrudRepository<ToDo,String>{
    public Iterable<ToDo> findByCompleted(@Param("c") Boolean completable);
}