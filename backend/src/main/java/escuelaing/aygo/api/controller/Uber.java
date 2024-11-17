package escuelaing.aygo.api.controller;

import escuelaing.aygo.api.model.Driver;
import escuelaing.aygo.api.model.Ride;
import escuelaing.aygo.api.repository.DriverRepository;
import escuelaing.aygo.api.repository.RideRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar los endpoints relacionados con viajes (rides) y conductores (drivers).
 * Permite a los usuarios crear, actualizar y recuperar información de conductores y viajes.
 */
@RestController
@RequestMapping("/api") // Todas las rutas comenzarán con /api
public class Uber {

    private final RideRepository rideRepository;
    private final DriverRepository driverRepository;

    /**
     * Constructor que inyecta las dependencias necesarias para gestionar las entidades Ride y Driver.
     *
     * @param rideRepository Repositorio para gestionar viajes.
     * @param driverRepository Repositorio para gestionar conductores.
     */
    public Uber(RideRepository rideRepository, DriverRepository driverRepository) {
        this.rideRepository = rideRepository;
        this.driverRepository = driverRepository;
    }

    // Endpoints para Ride

    /**
     * Recupera todos los viajes disponibles.
     *
     * @return Lista de todos los viajes.
     */
    @GetMapping("/rides")
    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    /**
     * Crea un nuevo viaje.
     *
     * @param ride Objeto Ride que contiene la información del nuevo viaje.
     * @return El viaje recién creado.
     */
    @PostMapping("/rides")
    public Ride createRide(@RequestBody Ride ride) {
        return rideRepository.save(ride);
    }

    /**
     * Actualiza la información de un viaje específico.
     *
     * @param id          Identificador del viaje que se desea actualizar.
     * @param updatedRide Objeto Ride que contiene la nueva información del viaje.
     * @return El viaje actualizado si existe, de lo contrario, una respuesta de "not found".
     */
    @PutMapping("/rides/{id}")
    public ResponseEntity<Ride> updateRide(@PathVariable Long id, @RequestBody Ride updatedRide) {
        return rideRepository.findById(id).map(ride -> {
            ride.setStatus(updatedRide.getStatus());
            return ResponseEntity.ok(rideRepository.save(ride));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Endpoints para Driver

    /**
     * Recupera todos los conductores disponibles.
     *
     * @return Lista de todos los conductores.
     */
    @GetMapping("/drivers")
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    /**
     * Crea un nuevo conductor.
     *
     * @param driver Objeto Driver que contiene la información del nuevo conductor.
     * @return El conductor recién creado.
     */
    @PostMapping("/drivers")
    public Driver createDriver(@RequestBody Driver driver) {
        return driverRepository.save(driver);
    }

    /**
     * Actualiza la información de un conductor específico.
     *
     * @param id            Identificador del conductor que se desea actualizar.
     * @param updatedDriver Objeto Driver que contiene la nueva información del conductor.
     * @return El conductor actualizado si existe, de lo contrario, una respuesta de "not found".
     */
    @PutMapping("/drivers/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Long id, @RequestBody Driver updatedDriver) {
        return driverRepository.findById(id).map(driver -> {
            driver.setStatus(updatedDriver.getStatus());
            return ResponseEntity.ok(driverRepository.save(driver));
        }).orElse(ResponseEntity.notFound().build());
    }
}