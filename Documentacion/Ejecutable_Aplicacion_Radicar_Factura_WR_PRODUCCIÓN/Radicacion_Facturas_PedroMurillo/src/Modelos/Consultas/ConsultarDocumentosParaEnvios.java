/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Consultas;
  
/**
 *
 * @author wrivas
 */
public class ConsultarDocumentosParaEnvios {
    String id;
    String numFactura;
    String nitProveedor;
    String nombreProveedor;
    String usuario;
    String nitEmpresa;
    String nombreEmpresa;
    String sede;

    public ConsultarDocumentosParaEnvios() {
    }

    public ConsultarDocumentosParaEnvios(String id, String numFactura, String nitProveedor, String nombreProveedor, String usuario, String nitEmpresa, String nombreEmpresa, String sede) {
        this.id = id;
        this.numFactura = numFactura;
        this.nitProveedor = nitProveedor;
        this.nombreProveedor = nombreProveedor;
        this.usuario = usuario;
        this.nitEmpresa = nitEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.sede = sede;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public String getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(String nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

  
}
