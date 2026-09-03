package br.com.jlgregorio.rentacar.repository;

import br.com.jlgregorio.rentacar.entity.ManufacturerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<ManufacturerEntity, Long> {

}
