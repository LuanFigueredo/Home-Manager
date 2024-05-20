package home.manager.api.repository;

import home.manager.api.model.item.patrimonio.entity.Patrimonio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatrimonioRepository extends JpaRepository<Patrimonio, Long> {
}
