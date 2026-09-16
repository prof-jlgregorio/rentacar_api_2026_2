package br.com.jlgregorio.rentacar.repository;

import br.com.jlgregorio.rentacar.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {

}
