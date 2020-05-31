package SpringWebMVC.Intermediario.Services;

import SpringWebMVC.Intermediario.Controller.Request.SoldadoEditRequest;
import SpringWebMVC.Intermediario.DTO.Soldado;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SoldadoService {

    public Soldado buscarSoldado(String cpf){
        Soldado soldado = new Soldado();
        soldado.setCpf ("");
        soldado.setNome("Allyson");
        soldado.setRaça ("Elfo");
        soldado.setArma ("Katana");
        return soldado ;
    }
    public void criarSoldado(Soldado soldado){

    }
    public void alterarSoldado (String cpf, SoldadoEditRequest soldadoEditRequest){

    }

    public void deletarSoldado(String cpf) {
    }

    public List<Soldado> ListarSoldado() {
        Soldado soldado = new Soldado();
        soldado.setCpf ("123");
        soldado.setNome("Allyson");
        soldado.setRaça ("Elfo");
        soldado.setArma ("Katana");
        Soldado soldado1 = new Soldado();
        soldado1.setCpf ("321");
        soldado1.setNome("Souza");
        soldado1.setRaça ("Anão");
        soldado1.setArma ("Machado");
        return Arrays.asList (soldado,soldado1);
    }
}
