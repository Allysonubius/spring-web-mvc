package Java.MVC.Controller;

import Java.MVC.Dto.Soldado;
import Java.MVC.Service.SoldadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {

    private SoldadoService soldadoService;

    public SoldadoController(SoldadoService soldadoService){
        this.soldadoService = soldadoService;
    }

    @GetMapping("/(cpf)")
    public ResponseEntity<Soldado> buscarSoldado(@PathVariable ()String cpf){
        Soldado soldado = soldadoService.buscarSoladdo (cpf);
        return ResponseEntity.status (HttpStatus.OK).body(soldado);
    }

    @PostMapping
    public  ResponseEntity criarSoldado(@RequestBody Soldado soldado){
        soldadoService.criarSoldado(soldado);
        return ResponseEntity.ok().build();
    }
}
