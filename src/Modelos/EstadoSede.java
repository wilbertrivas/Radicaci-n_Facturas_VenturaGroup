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
public class EstadoSede {
    
    private int id_estadoSede;
    private String descripcion_estadoSede;

    public EstadoSede() {
    }

    public EstadoSede(int id_estadoSede, String descripcion_estadoSede) {
        this.id_estadoSede = id_estadoSede;
        this.descripcion_estadoSede = descripcion_estadoSede;
    }

    public int getId_estadoSede() {
        return id_estadoSede;
    }

    public void setId_estadoSede(int id_estadoSede) {
        this.id_estadoSede = id_estadoSede;
    }

    public String getDescripcion_estadoSede() {
        return descripcion_estadoSede;
    }

    public void setDescripcion_estadoSede(String descripcion_estadoSede) {
        this.descripcion_estadoSede = descripcion_estadoSede;
    }
    
}
