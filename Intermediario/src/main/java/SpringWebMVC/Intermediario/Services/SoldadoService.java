package SpringWebMVC.Intermediario.Services;

import SpringWebMVC.Intermediario.Controller.Request.SoldadoEditRequest;
import SpringWebMVC.Intermediario.Controller.Response.SoldadoListResponse;
import SpringWebMVC.Intermediario.Controller.Response.SoldadoResponse;
import SpringWebMVC.Intermediario.DTO.Soldado;
import SpringWebMVC.Intermediario.Entity.SoldadoEntity;
import SpringWebMVC.Intermediario.Repository.Resource.ResourceSoldado;
import SpringWebMVC.Intermediario.Repository.SoldadoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resources;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SoldadoService {

    private  SoldadoRepository soldadoRepository;
    private  ObjectMapper objectMapper;
    private ResourceSoldado resourceSoldado;
    private Object Resource;

    public SoldadoService(SoldadoRepository soldadoRepository , ObjectMapper objectMapper , ResourceSoldado resourceSoldado) {
        this.soldadoRepository = soldadoRepository;
        this.objectMapper = objectMapper;
        this.resourceSoldado = resourceSoldado;
    }

    public SoldadoService(SoldadoRepository soldadoRepository, ObjectMapper objectMapper){
    this.soldadoRepository = soldadoRepository;
    this.objectMapper =objectMapper;
    }
    public SoldadoResponse buscarSoldado(Long id){
        SoldadoEntity soldado = soldadoRepository.findById (id).orElseThrow ();
        SoldadoResponse soldadoResponse = objectMapper.convertValue (soldado, SoldadoResponse.class);
        return soldadoResponse;
    }
    public void criarSoldado(Soldado soldado){
        SoldadoEntity soldadoEntity = objectMapper.convertValue (soldado,SoldadoEntity.class);
        soldadoRepository.save(soldadoEntity);
    }
    public void alterarSoldado(Long id, SoldadoEditRequest soldadoEditRequest){
        SoldadoEntity soldadoEntity = objectMapper.convertValue (soldadoEditRequest,SoldadoEntity.class);
        soldadoRepository.save(soldadoEntity);
    }
    public void deletarSoldado (Long id){
        SoldadoEntity soldado = soldadoRepository.findById (id).orElseThrow ();
        soldadoRepository.delete (soldado);
    }
    public Resources buscarSoldado(Object resources){
        List<SoldadoEntity> all = soldadoRepository.findAll ();
        List<SoldadoListResponse> soldadoStream = all.stream ()
                .map(it -> resourceSoldado.criarSoldado (it))
                .collect(Collectors.toList());
        final Resources resources1 = null;
        return resources1;
    }

    private class Resource<T> {
    }
}


