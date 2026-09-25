package universidaddelquindio.example.parcial1progra2.Model;

public class ExportadorExcel implements ExportadorComprobante{
    @Override
    public void exportar(ComprobantePago comprobante) {
        System.out.println("Exportando Excel");
    }
}
