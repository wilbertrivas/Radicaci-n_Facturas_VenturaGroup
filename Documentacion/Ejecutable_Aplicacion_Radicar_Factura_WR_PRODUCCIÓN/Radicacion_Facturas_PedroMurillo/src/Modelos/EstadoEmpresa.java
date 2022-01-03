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
public class EstadoEmpresa {
    private int id_estadoEmpresa;
    private String descripcion_estadoEmpresa;

    public EstadoEmpresa() {
    }

    public EstadoEmpresa(int id_estadoEmpresa, String descripcion_estadoEmpresa) {
        this.id_estadoEmpresa = id_estadoEmpresa;
        this.descripcion_estadoEmpresa = descripcion_estadoEmpresa;
    }

    public int getId_estadoEmpresa() {
        return id_estadoEmpresa;
    }

    public void setId_estadoEmpresa(int id_estadoEmpresa) {
        this.id_estadoEmpresa = id_estadoEmpresa;
    }

    public String getDescripcion_estadoEmpresa() {
        return descripcion_estadoEmpresa;
    }

    public void setDescripcion_estadoEmpresa(String descripcion_estadoEmpresa) {
        this.descripcion_estadoEmpresa = descripcion_estadoEmpresa;
    }
    
    
}
