/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
     
/**
 *
 * @author wrivas
 */
public class HistoricoDocumento {
    private int id_historicoDocumento;
    private int id_documento;
    private String usuarioRegistro_historicoDocumento;
    private String usuarioDestino_historicoDocumento;
    private String observacion_historicoDocumento;
    private String fechaRegistro_historicoDocumento;
    private int id_estadoHistorico;
    private int id_confirmacionRecibido;

    public HistoricoDocumento() {
    }

    public HistoricoDocumento(int id_historicoDocumento, int id_documento, String usuarioRegistro_historicoDocumento, String usuarioDestino_historicoDocumento, String observacion_historicoDocumento, String fechaRegistro_historicoDocumento, int id_estadoHistorico, int id_confirmacionRecibido) {
        this.id_historicoDocumento = id_historicoDocumento;
        this.id_documento = id_documento;
        this.usuarioRegistro_historicoDocumento = usuarioRegistro_historicoDocumento;
        this.usuarioDestino_historicoDocumento = usuarioDestino_historicoDocumento;
        this.observacion_historicoDocumento = observacion_historicoDocumento;
        this.fechaRegistro_historicoDocumento = fechaRegistro_historicoDocumento;
        this.id_estadoHistorico = id_estadoHistorico;
        this.id_confirmacionRecibido = id_confirmacionRecibido;
    }

    public int getId_historicoDocumento() {
        return id_historicoDocumento;
    }

    public void setId_historicoDocumento(int id_historicoDocumento) {
        this.id_historicoDocumento = id_historicoDocumento;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
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

    public String getObservacion_historicoDocumento() {
        return observacion_historicoDocumento;
    }

    public void setObservacion_historicoDocumento(String observacion_historicoDocumento) {
        this.observacion_historicoDocumento = observacion_historicoDocumento;
    }

    public String getFechaRegistro_historicoDocumento() {
        return fechaRegistro_historicoDocumento;
    }

    public void setFechaRegistro_historicoDocumento(String fechaRegistro_historicoDocumento) {
        this.fechaRegistro_historicoDocumento = fechaRegistro_historicoDocumento;
    }

    public int getId_estadoHistorico() {
        return id_estadoHistorico;
    }

    public void setId_estadoHistorico(int id_estadoHistorico) {
        this.id_estadoHistorico = id_estadoHistorico;
    }

    public int getId_confirmacionRecibido() {
        return id_confirmacionRecibido;
    }

    public void setId_confirmacionRecibido(int id_confirmacionRecibido) {
        this.id_confirmacionRecibido = id_confirmacionRecibido;
    }

    
}
