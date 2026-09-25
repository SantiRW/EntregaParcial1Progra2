package universidaddelquindio.example.parcial1progra2.Model;

public class ServicioMatricula {
    private int cantidad;
    private double valorAplicado;
    private ServicioAdicional servicioAdicional;

    public ServicioMatricula(int cantidad, double valorAplicado, ServicioAdicional servicioAdicional) {
        this.cantidad = cantidad;
        this.valorAplicado = valorAplicado;
        this.servicioAdicional = servicioAdicional;
    }

    public double calcularSubtotal(){
        double subtotal = 0;


        return subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorAplicado() {
        return valorAplicado;
    }

    public void setValorAplicado(double valorAplicado) {
        this.valorAplicado = valorAplicado;
    }

    public ServicioAdicional getServicioAdicional() {
        return servicioAdicional;
    }

    public void setServicioAdicional(ServicioAdicional servicioAdicional) {
        this.servicioAdicional = servicioAdicional;
    }
}
