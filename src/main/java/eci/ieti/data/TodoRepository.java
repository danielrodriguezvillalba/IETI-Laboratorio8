package eci.ieti.data;

import eci.ieti.data.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;


public interface TodoRepository extends MongoRepository<Todo, String> {


    Page<Todo> findByResponsible(String email, Pageable pageable);

    List<Todo> findByDescription(String regex);

    List<Todo> findByResponsibleAndPriorityGreaterThan(int priority, String responsable);


}