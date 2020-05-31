package SpringWebMVC.Intermediario.Repository.Resource;

import SpringWebMVC.Intermediario.Controller.Response.SoldadoListResponse;
import SpringWebMVC.Intermediario.Controller.SoldadoController;
import SpringWebMVC.Intermediario.Entity.SoldadoEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ResourceSoldado {
    private ObjectMapper objectMapper;
    private Long resources;

    public ResourceSoldado(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    public SoldadoListResponse criarSoldado(SoldadoEntity soldadoEntity){
        SoldadoListResponse soldadoListResponse = objectMapper.convertValue (soldadoEntity, SoldadoListResponse.class);
        Link link = linkTo (methodOn (SoldadoController.class).buscarSoldado (soldadoEntity.getId () , resources)).withSelfRel ();
        soldadoListResponse.add (link);
        return soldadoListResponse;
    }

}
