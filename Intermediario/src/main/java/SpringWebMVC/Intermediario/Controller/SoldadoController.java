package SpringWebMVC.Intermediario.Controller;

import SpringWebMVC.Intermediario.Controller.Request.SoldadoEditRequest;
import SpringWebMVC.Intermediario.DTO.Soldado;
import SpringWebMVC.Intermediario.Services.SoldadoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soldado")
public class SoldadoController {

    private SoldadoService soldadoService;
    private ObjectMapper objectMapper;
    private Long id;

    public  SoldadoController(SoldadoService soldadoService){
        this.soldadoService = soldadoService;
    }

    @GetMapping("/(cpf)")
    public ResponseEntity<Soldado> buscarSoldado(@PathVariable() String cpf){
        Soldado soldado = soldadoService.buscarSoldado(id);
        return  ResponseEntity.status(HttpStatus.OK).body(soldado);
    }

    @PostMapping
    public ResponseEntity criarSoldado(@RequestBody Soldado soldado){
        soldadoService.criarSoldado (soldado);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PostMapping("/(cpf)")
    public ResponseEntity editarSoldado(@PathVariable() String cpf,
                                        @RequestBody SoldadoEditRequest soldadoEditRequest){
            soldadoService.alterarSoldado(id,soldadoEditRequest);
        return ResponseEntity.ok().build ();
    }
    @DeleteMapping
    public ResponseEntity deletSoldado(@PathVariable String cpf){
        soldadoService.deletarSoldado(id);
        return ResponseEntity.ok().build ();
    }
    @GetMapping
    public <Resources> ResponseEntity<List<Soldado>> buscarSoldado(Long id , Long resources){
        List<Soldado> soldadoListResponses = soldadoService.buscarSoldado (resources);
        return ResponseEntity.status(HttpStatus.OK).body (soldadoListResponses);
    }
}
