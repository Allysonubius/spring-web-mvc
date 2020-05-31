package SpringWebMVC.Intermediario.Controller;

import SpringWebMVC.Intermediario.Controller.Request.SoldadoEditRequest;
import SpringWebMVC.Intermediario.DTO.Soldado;
import SpringWebMVC.Intermediario.Services.SoldadoService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soldado")
public class SoldadoController {

    private SoldadoService soldadoService;

    public  SoldadoController(SoldadoService soldadoService){
        this.soldadoService = soldadoService;
    }

    @GetMapping("/(cpf)")
    public ResponseEntity<Soldado> buscarSoldado(@PathVariable() String cpf){
        Soldado soldado = soldadoService.buscarSoldado(cpf);
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
            soldadoService.alterarSoldado(cpf,soldadoEditRequest);
        return ResponseEntity.ok().build ();
    }
    @DeleteMapping
    public ResponseEntity deletSoldado(@PathVariable String cpf){
        soldadoService.deletarSoldado(cpf);
        return ResponseEntity.ok().build ();
    }
    @GetMapping
    public ResponseEntity<List<Soldado>>buscarSoldado(){
        List<Soldado> soldados = soldadoService.ListarSoldado ();
        return ResponseEntity.status(HttpStatus.OK).body(soldados);
    }
}