
package Modelos.Consultas;
   
public class ConsultarDocumentosPendientesRecibir {
     private String id_historicoDocumento;
     private String id_documento;
     private String fechaRegistro_historicoDocumento;
     private String numFactura_documento;
     private String nit_proveedor;
     private String dig_proveedor;
     private String nombre_proveedor;
     private String nombre_empresa;
     private String usuarioRegistro_historicoDocumento;
     private String usuarioDestino_historicoDocumento;
     private String estadoConfirmacion;

    public ConsultarDocumentosPendientesRecibir() {
    }

    public ConsultarDocumentosPendientesRecibir(String id_historicoDocumento, String id_documento, String fechaRegistro_historicoDocumento, String numFactura_documento, String nit_proveedor, String dig_proveedor, String nombre_proveedor, String nombre_empresa, String usuarioRegistro_historicoDocumento, String usuarioDestino_historicoDocumento, String estadoConfirmacion) {
        this.id_historicoDocumento = id_historicoDocumento;
        this.id_documento = id_documento;
        this.fechaRegistro_historicoDocumento = fechaRegistro_historicoDocumento;
        this.numFactura_documento = numFactura_documento;
        this.nit_proveedor = nit_proveedor;
        this.dig_proveedor = dig_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.nombre_empresa = nombre_empresa;
        this.usuarioRegistro_historicoDocumento = usuarioRegistro_historicoDocumento;
        this.usuarioDestino_historicoDocumento = usuarioDestino_historicoDocumento;
        this.estadoConfirmacion = estadoConfirmacion;
    }

    public String getId_historicoDocumento() {
        return id_historicoDocumento;
    }

    public void setId_historicoDocumento(String id_historicoDocumento) {
        this.id_historicoDocumento = id_historicoDocumento;
    }

    public String getId_documento() {
        return id_documento;
    }

    public void setId_documento(String id_documento) {
        this.id_documento = id_documento;
    }

    public String getFechaRegistro_historicoDocumento() {
        return fechaRegistro_historicoDocumento;
    }

    public void setFechaRegistro_historicoDocumento(String fechaRegistro_historicoDocumento) {
        this.fechaRegistro_historicoDocumento = fechaRegistro_historicoDocumento;
    }

    public String getNumFactura_documento() {
        return numFactura_documento;
    }

    public void setNumFactura_documento(String numFactura_documento) {
        this.numFactura_documento = numFactura_documento;
    }

    public String getNit_proveedor() {
        return nit_proveedor;
    }

    public void setNit_proveedor(String nit_proveedor) {
        this.nit_proveedor = nit_proveedor;
    }

    public String getDig_proveedor() {
        return dig_proveedor;
    }

    public void setDig_proveedor(String dig_proveedor) {
        this.dig_proveedor = dig_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getUsuarioRegistro_historicoDocumento() {
        return usuarioRegistro_historicoDocumento;
    }

    public void setUsuarioRegistro_historicoDocumento(String usuarioRegistro_historicoDocumento) {
        this.usuarioRegistro_historicoDocumento = usuarioRegistro_historicoDocumento;
    }

    public String getUsuarioDestino_historicoDocumento() {
        return usuarioDestino_historicoDocumento;
    }

    public void setUsuarioDestino_historicoDocumento(String usuarioDestino_historicoDocumento) {
        this.usuarioDestino_historicoDocumento = usuarioDestino_historicoDocumento;
    }

    public String getEstadoConfirmacion() {
        return estadoConfirmacion;
    }

    public void setEstadoConfirmacion(String estadoConfirmacion) {
        this.estadoConfirmacion = estadoConfirmacion;
    }

    
}
