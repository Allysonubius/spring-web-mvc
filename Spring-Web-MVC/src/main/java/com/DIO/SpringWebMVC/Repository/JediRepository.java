package com.DIO.SpringWebMVC.Repository;

import java.util.ArrayList;
import java.util.List;
import com.DIO.SpringWebMVC.model.Jedi;
import org.springframework.stereotype.Repository;

@Repository
public class JediRepository {
    private List<Jedi> jedi;

    public JediRepository(List<Jedi> jedi) {
        jedi = new ArrayList<> ();

        jedi.add (new Jedi ("Luke" , "Skylwalker"));
    }

    public List<Jedi> getAllJEdi() {

        return this.jedi;
    }

    /*public void add(final Jedi jedi){add:Jedi(jedi)}
        this.jedi.add(jedi);
    }
    */
    public List<Jedi> findAll() {
        return this.jedi;
    }

    public Jedi findById(Long id) {
        return this.findById (id);
    }

}