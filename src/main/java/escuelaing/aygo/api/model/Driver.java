package escuelaing.aygo.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa un conductor en la aplicación de ride-sharing.
 * Contiene la información del conductor, como nombre y estado.
 * Usa Lombok para simplificar la generación de código repetitivo.
 */
@Entity
@Data // Genera automáticamente getters, setters, toString, equals y hashCode.
@NoArgsConstructor // Genera un constructor sin argumentos.
@AllArgsConstructor // Genera un constructor con todos los argumentos.
public class Driver {

    /**
     * Identificador único del conductor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del conductor.
     */
    private String name;

    /**
     * Estado del conductor (por ejemplo, "available", "busy").
     */
    private String status;
}