package cuentas_bancarias;

public class Banco {

    private  Integer contadorDeNumeroDeCuenta;
    private java.util.HashMap<String, Cuenta> cuentas;
    java.util.ArrayList<MovimientoEnCuentas> movimientos;

    private java.util.HashMap<String, Cliente> clientes;
    //TODO -pendiente- ¿como relacionar clientes y cuentas?

    public Banco() {
        contadorDeNumeroDeCuenta = 0;
        cuentas = new java.util.HashMap<>();
        movimientos = new java.util.ArrayList<>();
        clientes = new java.util.HashMap<>();
    }

    public Cuenta crearUnaNuevaCuenta() {
        Cuenta unaCuenta = new Cuenta();
        contadorDeNumeroDeCuenta = contadorDeNumeroDeCuenta + 1;
        unaCuenta.setNumeroDeCuenta("C" + String.format("%08d", contadorDeNumeroDeCuenta));
        cuentas.put(unaCuenta.getNumeroDeCuenta(), unaCuenta);
        return unaCuenta;
    }

    public Cuenta getCuenta(String numeroDeCuentaABuscar)
    {
        return cuentas.get(numeroDeCuentaABuscar);
    }

    public Double getSaldoDeLaCuenta(String numeroDeCuenta)
    {
        return getCuenta(numeroDeCuenta).getSaldoActual();
    }

    public void ingresarDinero(String numeroDeCuenta, Double cantidad, String explicacion) throws IllegalArgumentException
    {
        getCuenta(numeroDeCuenta).ingresarDinero(cantidad, explicacion);
        movimientos.add(new MovimientoEnCuentas(MovimientoEnCuentas.TIPO_DE_MOVIMIENTO.Ingreso, 
                                                explicacion, cantidad, getSaldoDeLaCuenta(numeroDeCuenta)));
    }

    public void sacarDinero(String numeroDeCuenta, Double cantidad, String explicacion) throws IllegalArgumentException
    {
        getCuenta(numeroDeCuenta).sacarDinero(cantidad, explicacion);
        movimientos.add(new MovimientoEnCuentas(MovimientoEnCuentas.TIPO_DE_MOVIMIENTO.Reintegro, 
                                                explicacion, cantidad, getSaldoDeLaCuenta(numeroDeCuenta)));
    }
    
    public void transferirDinero(String numeroDeCuentaOrigen, String numeroDeCuentaDestino, Double cantidad, String explicacion) throws IllegalArgumentException
    {
        getCuenta(numeroDeCuentaOrigen).sacarDinero(cantidad, explicacion);
        movimientos.add(new MovimientoEnCuentas(MovimientoEnCuentas.TIPO_DE_MOVIMIENTO.EnviarTransferencia,
                                                numeroDeCuentaDestino,
                                                cantidad, getSaldoDeLaCuenta(numeroDeCuentaOrigen), explicacion));
        getCuenta(numeroDeCuentaDestino).ingresarDinero(cantidad, explicacion);
        movimientos.add(new MovimientoEnCuentas(MovimientoEnCuentas.TIPO_DE_MOVIMIENTO.RecibirTransferencia, 
                                                numeroDeCuentaOrigen, 
                                                cantidad, getSaldoDeLaCuenta(numeroDeCuentaDestino), explicacion));
    }

    public MovimientoEnCuentas getUltimoMovimiento() {
        return movimientos.get(movimientos.size() - 1);
    }

    public void darDeAltaUnNuevoCliente(Cliente clienteNuevo)
    {
        if(!clientes.containsKey(clienteNuevo.getDNI())) {
            clientes.put(clienteNuevo.getDNI(), clienteNuevo);
        }
    }

    public Cliente getCliente(String DNIDelClienteABuscar)
    {
        return clientes.get(DNIDelClienteABuscar);
    }

 
}
