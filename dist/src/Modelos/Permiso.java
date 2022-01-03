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
public class Permiso {
    private int id_permiso;
    private String descripcion_permiso;

    public Permiso() {
    }

    public Permiso(int id_permiso, String descripcion_permiso) {
        this.id_permiso = id_permiso;
        this.descripcion_permiso = descripcion_permiso;
    }

    public int getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(int id_permiso) {
        this.id_permiso = id_permiso;
    }

    public String getDescripcion_permiso() {
        return descripcion_permiso;
    }

    public void setDescripcion_permiso(String descripcion_permiso) {
        this.descripcion_permiso = descripcion_permiso;
    }
    
    
}
