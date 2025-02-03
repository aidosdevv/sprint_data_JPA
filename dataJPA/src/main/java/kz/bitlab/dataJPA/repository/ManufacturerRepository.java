package kz.bitlab.dataJPA.repository;

import kz.bitlab.dataJPA.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
}
