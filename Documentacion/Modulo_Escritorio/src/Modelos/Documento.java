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
public class Documento {
    private int id_documento;
    private String numFactura_documento;
    private String nit_proveedor;
    private String observacion_documento;
    private int id_estadoDocumento;
    private String id_usuario;
    private String nit_empresa;
    private int id_sede;

    public Documento() {
    }

    public Documento(int id_documento, String numFactura_documento, String nit_proveedor, String observacion_documento, int id_estadoDocumento, String id_usuario, String nit_empresa, int id_sede) {
        this.id_documento = id_documento;
        this.numFactura_documento = numFactura_documento;
        this.nit_proveedor = nit_proveedor;
        this.observacion_documento = observacion_documento;
        this.id_estadoDocumento = id_estadoDocumento;
        this.id_usuario = id_usuario;
        this.nit_empresa = nit_empresa;
        this.id_sede = id_sede;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public String getNumFactura_documento() {
        return numFactura_documento;
    }

    public void setNumFactura_documento(String numFactura_documento) {
        this.numFactura_documento = numFactura_documento;
    }

    public String getNit_proveedor() {
        return nit_proveedor;
    }

    public void setNit_proveedor(String nit_proveedor) {
        this.nit_proveedor = nit_proveedor;
    }

    public String getObservacion_documento() {
        return observacion_documento;
    }

    public void setObservacion_documento(String observacion_documento) {
        this.observacion_documento = observacion_documento;
    }

    public int getId_estadoDocumento() {
        return id_estadoDocumento;
    }

    public void setId_estadoDocumento(int id_estadoDocumento) {
        this.id_estadoDocumento = id_estadoDocumento;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNit_empresa() {
        return nit_empresa;
    }

    public void setNit_empresa(String nit_empresa) {
        this.nit_empresa = nit_empresa;
    }

    public int getId_sede() {
        return id_sede;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }

    
}
