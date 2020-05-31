package SpringWebMVC.Intermediario.Controller.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.Link;
import org.springframework.transaction.support.ResourceHolderSupport;

public class SoldadoListResponse extends ResourceHolderSupport {

    private Long id;
    private String nome;
    private String raça;

    // @JsonProperty("id")
    public Long getResourceId(){
        return id;
    }

    // @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaça() {
        return raça;
    }

    public void setRaça(String raça) {
        this.raça = raça;
    }

    public void add(Link link) {
    }
}
