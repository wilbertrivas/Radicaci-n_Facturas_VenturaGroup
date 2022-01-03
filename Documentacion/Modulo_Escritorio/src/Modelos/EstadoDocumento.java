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
public class EstadoDocumento {
    private int id_estadoDocumento;
    private String descripcion_estadoDocumento;

    public EstadoDocumento() {
    }

    public EstadoDocumento(int id_estadoDocumento, String descripcion_estadoDocumento) {
        this.id_estadoDocumento = id_estadoDocumento;
        this.descripcion_estadoDocumento = descripcion_estadoDocumento;
    }

    public int getId_estadoDocumento() {
        return id_estadoDocumento;
    }

    public void setId_estadoDocumento(int id_estadoDocumento) {
        this.id_estadoDocumento = id_estadoDocumento;
    }

    public String getDescripcion_estadoDocumento() {
        return descripcion_estadoDocumento;
    }

    public void setDescripcion_estadoDocumento(String descripcion_estadoDocumento) {
        this.descripcion_estadoDocumento = descripcion_estadoDocumento;
    }
    
}
