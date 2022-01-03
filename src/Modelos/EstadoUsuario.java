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
public class EstadoUsuario {
    private int id_estadoUsuario;
    private String descripcion_estadoUsuario;

    public EstadoUsuario() {
    }

    public EstadoUsuario(int id_estadoUsuario, String descripcion_estadoUsuario) {
        this.id_estadoUsuario = id_estadoUsuario;
        this.descripcion_estadoUsuario = descripcion_estadoUsuario;
    }

    public int getId_estadoUsuario() {
        return id_estadoUsuario;
    }

    public void setId_estadoUsuario(int id_estadoUsuario) {
        this.id_estadoUsuario = id_estadoUsuario;
    }

    public String getDescripcion_estadoUsuario() {
        return descripcion_estadoUsuario;
    }

    public void setDescripcion_estadoUsuario(String descripcion_estadoUsuario) {
        this.descripcion_estadoUsuario = descripcion_estadoUsuario;
    }
    
    
}
