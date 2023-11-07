package es.susosise.excursiones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import es.susosise.excursiones.excursiones.ManejoDeExcursiones;
import es.susosise.excursiones.personas.ManejoDePersonas;
import es.susosise.excursiones.poblaciones.ManejoDePoblaciones;
import es.susosise.excursiones.seguridad.ManejoDeCredenciales;


@SpringBootApplication
public class App {
    public static final Logger logger = LoggerFactory.getLogger(App.class);
    
	public static void main(String[] args) {
	    logger.info("Arrancando la aplicación...");
	    SpringApplication.run(App.class, args);
	}
	
	
	@Bean
	public CommandLineRunner llenarLaBaseDeDatosConLosDatosDePrueba(
	        ManejoDeCredenciales credenciales, 
	        ManejoDePoblaciones poblaciones,
	        ManejoDePersonas personas,
	        ManejoDeExcursiones excursiones) {
	    return args -> {
	        credenciales.crearCredencialesParaPruebas();
	        poblaciones.crearPoblacionesParaPruebas();
	        personas.crearPersonaParaPruebas(poblaciones);
	        excursiones.crearExcursionParaPruebas(poblaciones);
	    };
	}

}
