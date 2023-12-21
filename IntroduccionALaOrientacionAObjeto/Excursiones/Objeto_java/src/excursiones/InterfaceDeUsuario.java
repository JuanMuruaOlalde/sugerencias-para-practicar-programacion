package excursiones;

import java.util.ArrayList;
import java.util.Scanner;

public class InterfaceDeUsuario {

    private GestorDeExcursiones excursiones;

    public InterfaceDeUsuario(GestorDeExcursiones unGestorDeExcursiones) { 
        excursiones = unGestorDeExcursiones;
    }


    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
    
        do {
            System.out.println();
            System.out.println("Bienvenido al gestor de excursiones");
            System.out.println("0 - salir");
            System.out.println("1 - crear una nueva persona");
            System.out.println("2 - listar todas las personas");
            System.out.println("3 - crear una nueva excursion");
            System.out.println("4 - listar todas las excursiones");
            System.out.println("5 - mostrar detalles de una excursion");
            System.out.println("6 - apuntar una persona a una excursion");
            System.out.println("7 - desapuntar una persona de una excursion");
            System.out.print("Introduce una opcion: ");
    
            opcion = scanner.nextInt();
    
            switch (opcion) {
                case 1:
                    System.out.print("Introduce el DNI de la persona: ");
                    String dni = scanner.next();
                    System.out.print("Introduce su nombre: ");
                    String nombrePersona = scanner.next();
                    System.out.print("Introduce sus apellidos: ");
                    String apellidos = scanner.next();
                    System.out.print("Introduce un email de contacto: ");
                    String email = scanner.next();
                    System.out.print("Introduce un telefono de contacto: ");
                    String telefono = scanner.next();
                    Persona nuevaPersona = new Persona(dni, nombrePersona, apellidos, email, telefono);
                    excursiones.añadirPersona(nuevaPersona);
                    System.out.println("Persona creada con exito.");
                    break;
                case 2:
                    ArrayList<Persona> todasLasPersonas = excursiones.getTodasLasPersonas();
                    for (Persona persona : todasLasPersonas) {
                        System.out.println(persona.getDni_cedula_pasaporte_o_similar() + " - " + persona.getNombre() + " " + persona.getApellidos());
                    }
                    break;
                //TODO Implement other cases
                default:
                    if (opcion !=0) System.out.println("Opcion desconocida");
            }
        } while (opcion != 0);
    
        scanner.close();
    }

}
