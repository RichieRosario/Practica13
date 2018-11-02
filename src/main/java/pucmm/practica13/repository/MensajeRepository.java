package pucmm.practica13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pucmm.practica13.model.Mensaje;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {


}
