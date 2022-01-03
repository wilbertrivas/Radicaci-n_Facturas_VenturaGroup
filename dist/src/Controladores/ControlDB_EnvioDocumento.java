
package Controladores;
    
import Modelos.Consultas.ConsultarDocumentosParaEnvios;
import Modelos.HistoricoDocumento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControlDB_EnvioDocumento {  
    private Connection conexion=null;
    private  ControlDB_DB control=null;   
    int consecutivoRadicado=0;
    
    public ControlDB_EnvioDocumento() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();       
    }   
    public int retornarElMaximoHistoricoDocumento(){
         Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(id_historicoDocumento) FROM `radicado_facturas_vg`.historicoDocumento;");
            while(resultSet.next()){ 
                if(resultSet.getString(1) != null){
                    retorno =Integer.parseInt(resultSet.getString(1));
                }
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
            System.exit(1);
        }
        control.cerrarConexionBaseDatos();
        return retorno;
    }
    public ArrayList<ConsultarDocumentosParaEnvios> buscarDocumento(String valorConsulta) throws SQLException{
        ArrayList<ConsultarDocumentosParaEnvios> listadoDocumentos = new ArrayList();
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
            if(valorConsulta.equals("")){
                resultSet= statement.executeQuery("SELECT d.id_documento, d.numFactura_documento, d.nit_proveedor, p.nombre_proveedor, d.id_usuario,d.nit_empresa,"
                        + " e.nombre_empresa,s.nombre_sede FROM `radicado_facturas_vg`.documento d"
                        + " INNER JOIN `radicado_facturas_vg`.proveedor p ON p.nit_proveedor=d.nit_proveedor"
                        + " INNER JOIN `radicado_facturas_vg`.empresa e	ON e.nit_empresa=d.nit_empresa"
                        + " INNER JOIN `radicado_facturas_vg`.usuario u	ON u.id_usuario = d.id_usuario"
                        + " INNER JOIN `radicado_facturas_vg`.sede s ON s.id_sede = d.id_sede WHERE d.id_estadoDocumento='1' OR d.id_estadoDocumento='0' LIMIT 500;");
            }else{
                resultSet = statement.executeQuery("SELECT d.id_documento, d.numFactura_documento, d.nit_proveedor, p.nombre_proveedor, d.id_usuario,d.nit_empresa, " +
                            "e.nombre_empresa,s.nombre_sede FROM `radicado_facturas_vg`.documento d " +
                            "INNER JOIN `radicado_facturas_vg`.proveedor p ON p.nit_proveedor=d.nit_proveedor " +
                            "INNER JOIN `radicado_facturas_vg`.empresa e	ON e.nit_empresa=d.nit_empresa " +
                            "INNER JOIN `radicado_facturas_vg`.usuario u	ON u.id_usuario = d.id_usuario " +
                            "INNER JOIN `radicado_facturas_vg`.sede s ON s.id_sede = d.id_sede" +
                            "		WHERE (d.id_estadoDocumento='1' OR d.id_estadoDocumento='0') AND (d.id_documento LIKE '%"+valorConsulta+"%' OR d.numFactura_documento LIKE '%"+valorConsulta+"%' OR p.nombre_proveedor LIKE '%"+valorConsulta+"%') " +
                            "LIMIT 500;");      
            }
            while(resultSet.next()){ 
                ConsultarDocumentosParaEnvios consult = new ConsultarDocumentosParaEnvios(); 
                consult.setId(resultSet.getString(1));
                consult.setNumFactura(resultSet.getString(2));
                consult.setNitProveedor(resultSet.getString(3));
                consult.setNombreProveedor(resultSet.getString(4));
                consult.setUsuario(resultSet.getString(5));
                consult.setNitEmpresa(resultSet.getString(6));
                consult.setNombreEmpresa(resultSet.getString(7));
                consult.setSede(resultSet.getString(8));     
                listadoDocumentos.add(consult);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar Documentos");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoDocumentos;
    } 
    public ArrayList<ConsultarDocumentosParaEnvios> buscarDocumentoActivosPorUsuario(String valorConsulta, String idUsuario) throws SQLException{
        ArrayList<ConsultarDocumentosParaEnvios> listadoDocumentos = new ArrayList();
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
            if(valorConsulta.equals("")){
                resultSet= statement.executeQuery("SELECT d.id_documento, d.numFactura_documento, d.nit_proveedor, p.nombre_proveedor, d.id_usuario,d.nit_empresa,"
                        + " e.nombre_empresa,s.nombre_sede FROM `radicado_facturas_vg`.documento d"
                        + " INNER JOIN `radicado_facturas_vg`.proveedor p ON p.nit_proveedor=d.nit_proveedor"
                        + " INNER JOIN `radicado_facturas_vg`.empresa e	ON e.nit_empresa=d.nit_empresa"
                        + " INNER JOIN `radicado_facturas_vg`.usuario u	ON u.id_usuario = d.id_usuario"
                        + " INNER JOIN `radicado_facturas_vg`.sede s ON s.id_sede = d.id_sede WHERE (d.id_estadoDocumento='1' OR d.id_estadoDocumento='0') AND d.id_usuario='"+idUsuario+"' LIMIT 500;");
            }else{
                resultSet = statement.executeQuery("SELECT d.id_documento, d.numFactura_documento, d.nit_proveedor, p.nombre_proveedor, d.id_usuario,d.nit_empresa, " +
                            "e.nombre_empresa,s.nombre_sede FROM `radicado_facturas_vg`.documento d " +
                            "INNER JOIN `radicado_facturas_vg`.proveedor p ON p.nit_proveedor=d.nit_proveedor " +
                            "INNER JOIN `radicado_facturas_vg`.empresa e	ON e.nit_empresa=d.nit_empresa " +
                            "INNER JOIN `radicado_facturas_vg`.usuario u	ON u.id_usuario = d.id_usuario " +
                            "INNER JOIN `radicado_facturas_vg`.sede s ON s.id_sede = d.id_sede " +
                            "		WHERE (d.id_estadoDocumento='1' OR d.id_estadoDocumento='0') AND d.id_usuario='"+idUsuario+"' AND (d.id_documento LIKE '%"+valorConsulta+"%' OR d.numFactura_documento LIKE '%"+valorConsulta+"%' OR p.nombre_proveedor LIKE '%"+valorConsulta+"%') " +
                            "LIMIT 500;");      
            }
            while(resultSet.next()){ 
                ConsultarDocumentosParaEnvios consult = new ConsultarDocumentosParaEnvios(); 
                consult.setId(resultSet.getString(1));
                consult.setNumFactura(resultSet.getString(2));
                consult.setNitProveedor(resultSet.getString(3));
                consult.setNombreProveedor(resultSet.getString(4));
                consult.setUsuario(resultSet.getString(5));
                consult.setNitEmpresa(resultSet.getString(6));
                consult.setNombreEmpresa(resultSet.getString(7));
                consult.setSede(resultSet.getString(8));     
                listadoDocumentos.add(consult);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar Documentos");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoDocumentos;
    }    
    public int registrarEnvioDocumento(HistoricoDocumento historico) {
        int result=0;
        try {
            Connection conexion= control.ConectarBaseDatos();
            
            
            PreparedStatement scriptInsertHistoricoDocumento= conexion.prepareStatement("INSERT INTO `radicado_facturas_vg`.`historicoDocumento`"
                    + "(`id_historicoDocumento`, `id_documento`, `usuarioRegistro_historicoDocumento`, "
                    + "`usuarioDestino_historicoDocumento`, `observacion_historicoDocumento`, `fechaRegistro_historicoDocumento`, "
                    + "`id_estadoHistorico`,`id_confirmacionRecibido`) VALUES (NULL, '"+historico.getId_documento()+"', '"+historico.getUsuarioRegistro_historicoDocumento()+"',"
                            + "'"+historico.getUsuarioDestino_historicoDocumento()+"','"+historico.getObservacion_historicoDocumento()+"', (select now()), '"+historico.getId_historicoDocumento()+"','"+historico.getId_confirmacionRecibido()+"');");       
            scriptInsertHistoricoDocumento.execute();
            result=1;   
            if(result==1){
                Statement statement = statement = conexion.createStatement();
                    ResultSet resultSet= statement.executeQuery("SELECT id_estadoDocumento FROM radicado_facturas_vg.documento WHERE id_documento= '"+historico.getId_documento()+"';");
                    
                    while(resultSet.next()){ 
                        try{
                            int Doc_id_estadoDocumento =Integer.parseInt(resultSet.getString(1));
                            if(Doc_id_estadoDocumento != 2){
                                PreparedStatement scriptActivarDocumento= conexion.prepareStatement("UPDATE `radicado_facturas_vg`.`documento` SET `id_estadoDocumento` = '1' WHERE `documento`.`id_documento` = '"+historico.getId_documento()+"';");
                                scriptActivarDocumento.execute();
                            }
                        }catch(Exception e){
                        }   
                    }    
            }
            
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(ControlDB_EnvioDocumento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
