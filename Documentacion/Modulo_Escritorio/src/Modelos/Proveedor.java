/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
  
/**
 * 
 *
 * @author wrivas
 */
public class Proveedor {
    private String nit_proveedor;
    private String dig_proveedor;
    private String nombre_proveedor;
    private String correo_proveedor;
    private String telefono_proveedor;
    private int id_estadoProveedor;

    public Proveedor() {
    }

    public Proveedor(String nit_proveedor, String dig_proveedor, String nombre_proveedor, String correo_proveedor, String telefono_proveedor, int id_estadoProveedor) {
        this.nit_proveedor = nit_proveedor;
        this.dig_proveedor = dig_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.correo_proveedor = correo_proveedor;
        this.telefono_proveedor = telefono_proveedor;
        this.id_estadoProveedor = id_estadoProveedor;
    }

    public String getNit_proveedor() {
        return nit_proveedor;
    }

    public void setNit_proveedor(String nit_proveedor) {
        this.nit_proveedor = nit_proveedor;
    }

    public String getDig_proveedor() {
        return dig_proveedor;
    }

    public void setDig_proveedor(String dig_proveedor) {
        this.dig_proveedor = dig_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getCorreo_proveedor() {
        return correo_proveedor;
    }

    public void setCorreo_proveedor(String correo_proveedor) {
        this.correo_proveedor = correo_proveedor;
    }

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    public int getId_estadoProveedor() {
        return id_estadoProveedor;
    }

    public void setId_estadoProveedor(int id_estadoProveedor) {
        this.id_estadoProveedor = id_estadoProveedor;
    }

   
}
