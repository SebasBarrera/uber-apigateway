package escuelaing.aygo.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa un viaje (Ride) en la aplicación de ride-sharing.
 * Contiene la información sobre el viaje, como origen, destino y estado.
 * Usa Lombok para reducir la cantidad de código repetitivo.
 */
@Entity
@Data // Genera automáticamente getters, setters, toString, equals y hashCode.
@NoArgsConstructor // Genera un constructor sin argumentos.
@AllArgsConstructor // Genera un constructor con todos los argumentos.
public class Ride {

    /**
     * Identificador único del viaje.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Origen del viaje.
     */
    private String origin;

    /**
     * Destino del viaje.
     */
    private String destination;

    /**
     * Estado del viaje (por ejemplo, "requested", "in-progress", "completed").
     */
    private String status;
}