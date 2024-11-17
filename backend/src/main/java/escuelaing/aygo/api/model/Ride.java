package escuelaing.aygo.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Representa un viaje (Ride) en la aplicación de ride-sharing.
 * Contiene la información sobre el viaje, como origen, destino y estado.
 */
@Entity
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

    /**
     * Constructor sin argumentos.
     */
    public Ride() {
    }

    /**
     * Constructor con todos los argumentos.
     *
     * @param id          Identificador del viaje.
     * @param origin      Origen del viaje.
     * @param destination Destino del viaje.
     * @param status      Estado del viaje.
     */
    public Ride(Long id, String origin, String destination, String status) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.status = status;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
