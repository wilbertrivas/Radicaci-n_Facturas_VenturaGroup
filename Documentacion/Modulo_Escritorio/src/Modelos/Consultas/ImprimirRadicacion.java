
package Modelos.Consultas;
 
 
public class ImprimirRadicacion {
    private String sede;
    private String usuarioRadicacion;
    private String usuarioDestino;
    private String numeroRadicacion;
    private String fecha;

    public ImprimirRadicacion() {
    }

    public ImprimirRadicacion(String sede, String usuarioRadicacion, String usuarioDestino, String numeroRadicacion, String fecha) {
        this.sede = sede;
        this.usuarioRadicacion = usuarioRadicacion;
        this.usuarioDestino = usuarioDestino;
        this.numeroRadicacion = numeroRadicacion;
        this.fecha = fecha;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getUsuarioRadicacion() {
        return usuarioRadicacion;
    }

    public void setUsuarioRadicacion(String usuarioRadicacion) {
        this.usuarioRadicacion = usuarioRadicacion;
    }

    public String getUsuarioDestino() {
        return usuarioDestino;
    }

    public void setUsuarioDestino(String usuarioDestino) {
        this.usuarioDestino = usuarioDestino;
    }

    public String getNumeroRadicacion() {
        return numeroRadicacion;
    }

    public void setNumeroRadicacion(String numeroRadicacion) {
        this.numeroRadicacion = numeroRadicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

  
}
