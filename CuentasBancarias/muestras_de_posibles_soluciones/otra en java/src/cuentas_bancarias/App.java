package cuentas_bancarias;

import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
	
        java.util.Scanner lectorDeTeclado = new java.util.Scanner(System.in);
        while(true)
        {
            System.out.println("¿Que desea hacer?");
            System.out.println("-0- Terminar y salir.");
            System.out.println("-1- METER dinero en una cuenta.");
            System.out.println("-2- SACAR dinero de una cuenta.");
            System.out.println("-3- TRANSFERIR dinero de una cuenta a otra.");
            System.out.println("-4- Mostar datos de un CLIENTE.");
            System.out.println("-5- Mostar datos y detalle de movimientos de una CUENTA.");
            System.out.println("-6- Listar todos los clientes.");
            System.out.println("-7- Listar todas las cuentas.");
            System.out.println("-8- Listar todos los movimientos en el banco.");
            Integer accion = lectorDeTeclado.nextInt();
            
            Banco elBanco = new Banco();
            HashMap<String, Cliente> algunosClientes = FactoriaDeDatosParaPruebas.getAlgunosClientesParaPruebas();
            FactoriaDeDatosParaPruebas.crearCuentasDePruebaEnUnBanco(elBanco, algunosClientes);    

            switch(accion)
            {
            case 0:
                lectorDeTeclado.close();
                System.exit(0);
                break;
            case 1:
                String numeroDeCuenta = lectorDeTeclado.nextLine();
                Cuenta cuenta = elBanco.getCuenta(numeroDeCuenta);
                if (cuenta != null) {

                } else {
                        System.out.println("No encuentro ninguna cuenta con número " + numeroDeCuenta);
                }
                    break;
            case 2:
                    break;
            case 3:
                    break;
            case 4:
                    break;
            case 5:
                    break;
            case 6:
                    break;
            case 7:
                    break;
            case 8:
                    break;
            }
        }

    }

}
