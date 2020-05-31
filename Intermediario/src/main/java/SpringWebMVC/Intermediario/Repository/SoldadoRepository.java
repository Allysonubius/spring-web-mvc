package SpringWebMVC.Intermediario.Repository;

import SpringWebMVC.Intermediario.Entity.SoldadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class SoldadoRepository implements JpaRepository<SoldadoEntity, Long> {
}
