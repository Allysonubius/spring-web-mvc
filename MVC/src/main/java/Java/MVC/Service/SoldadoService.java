package Java.MVC.Service;

import Java.MVC.Dto.Soldado;
import org.springframework.stereotype.Service;

@Service
public class SoldadoService {

    public Soldado buscarSoladdo(String cpf){
        Soldado soldado = new Soldado();
        soldado.setCpf (cpf);
        soldado.setNome ("Allyson");
        soldado.setRaça ("Skyrin");
        soldado.setArma ("Snipper ");
        return soldado;
    }

    public void criarSoldado(Soldado soldado){

    }
}
