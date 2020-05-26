package com.DIO.SpringWebMVC.Rest;

import com.DIO.SpringWebMVC.JediNotFoundException.JediNotFoundException;
import com.DIO.SpringWebMVC.Repository.JediRepository;
import com.DIO.SpringWebMVC.model.Jedi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JediResource {

    @Autowired
    private JediRepository repository;

    @GetMapping("/api/jedi")
    public List<Jedi> getAllJedi(){
        return repository.findAll();
    }

    @GetMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> getJedi(@PathVariable("id")Long id){
        final Optional<Jedi> jedi = Optional.ofNullable (repository.findById (id));
            if(jedi.isPresent ()){
                return ResponseEntity.ok(jedi.get());
            }else{
                return ResponseEntity.notFound ().build ();
            }
    }
    /*@PostMapping("/api/jedi")
    public Jedi createJedi(){
        return repository.save(jedi);
    }

     */
}
