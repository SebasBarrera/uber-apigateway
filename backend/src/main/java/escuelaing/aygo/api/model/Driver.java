package escuelaing.aygo.api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Representa un conductor (Driver) en la aplicación de ride-sharing.
 * Contiene la información del conductor, como nombre y estado.
 */
@Entity
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

    /**
     * Constructor sin argumentos.
     */
    public Driver() {
    }

    /**
     * Constructor con todos los argumentos.
     *
     * @param id     Identificador del conductor.
     * @param name   Nombre del conductor.
     * @param status Estado del conductor.
     */
    public Driver(Long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
