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
public class EstadoHistorico {
    private int id_estadoHistorico;
    private String descripcion_estadoHistorico;

    public EstadoHistorico() {
    }

    public EstadoHistorico(int id_estadoHistorico, String descripcion_estadoHistorico) {
        this.id_estadoHistorico = id_estadoHistorico;
        this.descripcion_estadoHistorico = descripcion_estadoHistorico;
    }

    public int getId_estadoHistorico() {
        return id_estadoHistorico;
    }

    public void setId_estadoHistorico(int id_estadoHistorico) {
        this.id_estadoHistorico = id_estadoHistorico;
    }

    public String getDescripcion_estadoHistorico() {
        return descripcion_estadoHistorico;
    }

    public void setDescripcion_estadoHistorico(String descripcion_estadoHistorico) {
        this.descripcion_estadoHistorico = descripcion_estadoHistorico;
    }
    
    
}
