package escuelaing.aygo.api.repository;

import escuelaing.aygo.api.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para gestionar las operaciones CRUD de la entidad Ride.
 * Extiende JpaRepository, proporcionando métodos listos para ser utilizados.
 */
public interface RideRepository extends JpaRepository<Ride, Long> {
   
}
