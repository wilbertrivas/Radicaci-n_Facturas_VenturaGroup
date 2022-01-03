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
public class Sede {
    private int id_sede;
    private String nombre_sede;
    private int estadoSede;

    public Sede() {
    }

    public Sede(int id_sede, String nombre_sede, int estadoSede) {
        this.id_sede = id_sede;
        this.nombre_sede = nombre_sede;
        this.estadoSede = estadoSede;
    }

    public int getId_sede() {
        return id_sede;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }

    public String getNombre_sede() {
        return nombre_sede;
    }

    public void setNombre_sede(String nombre_sede) {
        this.nombre_sede = nombre_sede;
    }

    public int getEstadoSede() {
        return estadoSede;
    }

    public void setEstadoSede(int estadoSede) {
        this.estadoSede = estadoSede;
    }
    
    
}
