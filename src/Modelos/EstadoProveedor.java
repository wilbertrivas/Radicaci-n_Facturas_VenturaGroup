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
public class EstadoProveedor {
    private int id_estadoProveedor;
    private String descripcion_estadoProveedor;

    public EstadoProveedor() {
    }

    public EstadoProveedor(int id_estadoProveedor, String descripcion_estadoProveedor) {
        this.id_estadoProveedor = id_estadoProveedor;
        this.descripcion_estadoProveedor = descripcion_estadoProveedor;
    }

    public int getId_estadoProveedor() {
        return id_estadoProveedor;
    }

    public void setId_estadoProveedor(int id_estadoProveedor) {
        this.id_estadoProveedor = id_estadoProveedor;
    }

    public String getDescripcion_estadoProveedor() {
        return descripcion_estadoProveedor;
    }

    public void setDescripcion_estadoProveedor(String descripcion_estadoProveedor) {
        this.descripcion_estadoProveedor = descripcion_estadoProveedor;
    }
    
    
}
