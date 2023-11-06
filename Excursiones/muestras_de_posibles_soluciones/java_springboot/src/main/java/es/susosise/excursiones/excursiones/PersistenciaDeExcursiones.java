package es.susosise.excursiones.excursiones;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersistenciaDeExcursiones extends JpaRepository<Excursion, Long> {

    //nota: No es necesario proveer una implementación explícita para este interfaz
    //      porque ya lo hace Spring Boot, proporcionando una implementación por defecto basada en SimpleJpaRepository
    //      ( https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/support/SimpleJpaRepository.html )

    //Estas son funciones añadidas por nosotros, pero que Spring Boot también se encarga de implementar automáticamente.
    // (https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation)
    Optional<Excursion> findByDescripcionContaining(String descripcion);
    
}
