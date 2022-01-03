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
public class Empresa {
    private String nit_empresa;
    private String dig_empresa;
    private String nombre_empresa;
    private String correo_empresa;
    private String telefono_empresa;
    private int id_estadoEmpresa;

    public Empresa() {
    }

    public Empresa(String nit_empresa, String dig_empresa, String nombre_empresa, String correo_empresa, String telefono_empresa, int id_estadoEmpresa) {
        this.nit_empresa = nit_empresa;
        this.dig_empresa = dig_empresa;
        this.nombre_empresa = nombre_empresa;
        this.correo_empresa = correo_empresa;
        this.telefono_empresa = telefono_empresa;
        this.id_estadoEmpresa = id_estadoEmpresa;
    }

    public String getNit_empresa() {
        return nit_empresa;
    }

    public void setNit_empresa(String nit_empresa) {
        this.nit_empresa = nit_empresa;
    }

    public String getDig_empresa() {
        return dig_empresa;
    }

    public void setDig_empresa(String dig_empresa) {
        this.dig_empresa = dig_empresa;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getCorreo_empresa() {
        return correo_empresa;
    }

    public void setCorreo_empresa(String correo_empresa) {
        this.correo_empresa = correo_empresa;
    }

    public String getTelefono_empresa() {
        return telefono_empresa;
    }

    public void setTelefono_empresa(String telefono_empresa) {
        this.telefono_empresa = telefono_empresa;
    }

    public int getId_estadoEmpresa() {
        return id_estadoEmpresa;
    }

    public void setId_estadoEmpresa(int id_estadoEmpresa) {
        this.id_estadoEmpresa = id_estadoEmpresa;
    }

    
}
