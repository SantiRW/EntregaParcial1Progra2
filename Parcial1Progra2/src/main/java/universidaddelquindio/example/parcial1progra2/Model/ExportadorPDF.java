package universidaddelquindio.example.parcial1progra2.Model;

public class ExportadorPDF implements ExportadorComprobante {

    @Override
    public void exportar(ComprobantePago comprobante) {
        System.out.println("Exportando PDF");
    }
}