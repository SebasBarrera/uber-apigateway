/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuelaing.aygo.api.repository;

import escuelaing.aygo.api.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para gestionar las operaciones CRUD de la entidad Driver.
 * Extiende JpaRepository, proporcionando métodos listos para ser utilizados.
 */
public interface DriverRepository extends JpaRepository<Driver, Long> {
    // No se necesita implementar nada, ya que JpaRepository proporciona todos los métodos básicos de CRUD.
}
