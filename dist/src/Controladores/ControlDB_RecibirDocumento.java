package Controladores;
   
import Modelos.Consultas.ConsultarDocumentosParaRecibir;
import Modelos.Consultas.ConsultarDocumentosPendientesRecibir;
import Modelos.EstadoHistorico;
import Modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControlDB_RecibirDocumento {
    
    private Connection conexion=null;
    private  ControlDB_DB control=null;   
    int consecutivoRadicado=0;
    
    public ControlDB_RecibirDocumento() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();       
    }   
    public ArrayList<ConsultarDocumentosParaRecibir> buscarDocumento(String valorConsulta, Usuario u) throws SQLException{
        ArrayList<ConsultarDocumentosParaRecibir> listadoDocumentos = new ArrayList();
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
            if(valorConsulta.equals("")){
                resultSet= statement.executeQuery("SELECT "+
                                                    "h.id_historicoDocumento, "+
                                                    "h.id_documento, "+
                                                    "h.fechaRegistro_historicoDocumento, "+
                                                    "d.numFactura_documento, "+
                                                    "p.nit_proveedor, "+
                                                    "p.dig_proveedor, "+
                                                    "p.nombre_proveedor, "+
                                                    "e.nombre_empresa, "+
                                                    "h.usuarioRegistro_historicoDocumento, "+
                                                    "h.usuarioDestino_historicoDocumento "+
                                                    "FROM `radicado_facturas_vg`.documento d "+
                                                    "	INNER JOIN `radicado_facturas_vg`.historicoDocumento h  ON h.id_documento = d.id_documento "+
                                                    "	INNER JOIN `radicado_facturas_vg`.proveedor p  ON p.nit_proveedor = d.nit_proveedor "+
                                                    "	INNER JOIN `radicado_facturas_vg`.empresa e  ON e.nit_empresa = d.nit_empresa "+
                                                    "WHERE h.id_estadoHistorico = 2 AND h.usuarioDestino_historicoDocumento='"+u.getId_usuario()+"' AND h.id_confirmacionRecibido=0 "+             
                                                    "LIMIT 500;");
            }else{
                resultSet = statement.executeQuery("SELECT "+
                                                    "h.id_historicoDocumento, "+
                                                    "h.id_documento, "+
                                                    "h.fechaRegistro_historicoDocumento, "+
                                                    "d.numFactura_documento, "+
                                                    "p.nit_proveedor, "+
                                                    "p.dig_proveedor, "+
                                                    "p.nombre_proveedor, "+
                                                    "e.nombre_empresa, "+
                                                    "h.usuarioRegistro_historicoDocumento, "+
                                                    "h.usuarioDestino_historicoDocumento "+
                                                    "FROM `radicado_facturas_vg`.documento d "+
                                                    "	INNER JOIN `radicado_facturas_vg`.historicoDocumento h  ON h.id_documento = d.id_documento "+
                                                    "	INNER JOIN `radicado_facturas_vg`.proveedor p  ON p.nit_proveedor = d.nit_proveedor "+
                                                    "	INNER JOIN `radicado_facturas_vg`.empresa e  ON e.nit_empresa = d.nit_empresa "+
                                                    "WHERE h.id_estadoHistorico = 2 AND h.usuarioDestino_historicoDocumento='"+u.getId_usuario()+"' AND h.id_confirmacionRecibido=0 "+
                                                            " AND (d.id_documento LIKE '%"+valorConsulta+"%' OR d.numFactura_documento LIKE '%"+valorConsulta+"%' OR p.nombre_proveedor LIKE '%"+valorConsulta+"%') "+
                                                    "LIMIT 500;");      
            }
            while(resultSet.next()){ 
                ConsultarDocumentosParaRecibir consult = new ConsultarDocumentosParaRecibir(); 
                consult.setId_historicoDocumento(resultSet.getString(1));
                consult.setId_documento(resultSet.getString(2));
                consult.setFechaRegistro_historicoDocumento(resultSet.getString(3));
                consult.setNumFactura_documento(resultSet.getString(4));
                consult.setNit_proveedor(resultSet.getString(5));
                consult.setDig_proveedor(resultSet.getString(6));
                consult.setNombre_proveedor(resultSet.getString(7));
                consult.setNombre_empresa(resultSet.getString(8));
                consult.setUsuarioRegistro_historicoDocumento(resultSet.getString(9));     
                consult.setUsuarioDestino_historicoDocumento(resultSet.getString(10));         
                listadoDocumentos.add(consult);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar Documentos");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoDocumentos;
    } 
    
    public ArrayList<ConsultarDocumentosPendientesRecibir> buscarPendientePorConfirmar(String valorConsulta, Usuario u) throws SQLException{
        ArrayList<ConsultarDocumentosPendientesRecibir> listadoDocumentos = new ArrayList();
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
            if(valorConsulta.equals("")){
                resultSet= statement.executeQuery("SELECT "+
                                                    "h.id_historicoDocumento, "+
                                                    "h.id_documento, "+
                                                    "h.fechaRegistro_historicoDocumento, "+
                                                    "d.numFactura_documento, "+
                                                    "p.nit_proveedor, "+
                                                    "p.dig_proveedor, "+
                                                    "p.nombre_proveedor, "+
                                                    "e.nombre_empresa, "+
                                                    "h.usuarioRegistro_historicoDocumento, "+
                                                    "h.usuarioDestino_historicoDocumento,h.id_confirmacionRecibido "+
                                                    "FROM `radicado_facturas_vg`.documento d "+
                                                    "	INNER JOIN `radicado_facturas_vg`.historicoDocumento h  ON h.id_documento = d.id_documento "+
                                                    "	INNER JOIN `radicado_facturas_vg`.proveedor p  ON p.nit_proveedor = d.nit_proveedor "+
                                                    "	INNER JOIN `radicado_facturas_vg`.empresa e  ON e.nit_empresa = d.nit_empresa "+
                                                    "WHERE h.id_estadoHistorico = 2 AND h.usuarioRegistro_historicoDocumento='"+u.getId_usuario()+"'  "+             
                                                    "LIMIT 500;");
            }else{//AND h.id_confirmacionRecibido=0
                resultSet = statement.executeQuery("SELECT "+
                                                    "h.id_historicoDocumento, "+
                                                    "h.id_documento, "+
                                                    "h.fechaRegistro_historicoDocumento, "+
                                                    "d.numFactura_documento, "+
                                                    "p.nit_proveedor, "+
                                                    "p.dig_proveedor, "+
                                                    "p.nombre_proveedor, "+
                                                    "e.nombre_empresa, "+
                                                    "h.usuarioRegistro_historicoDocumento, "+
                                                    "h.usuarioDestino_historicoDocumento,h.id_confirmacionRecibido  "+
                                                    "FROM `radicado_facturas_vg`.documento d "+
                                                    "	INNER JOIN `radicado_facturas_vg`.historicoDocumento h  ON h.id_documento = d.id_documento "+
                                                    "	INNER JOIN `radicado_facturas_vg`.proveedor p  ON p.nit_proveedor = d.nit_proveedor "+
                                                    "	INNER JOIN `radicado_facturas_vg`.empresa e  ON e.nit_empresa = d.nit_empresa "+
                                                    "WHERE h.id_estadoHistorico = 2 AND h.usuarioRegistro_historicoDocumento='"+u.getId_usuario()+"'  "+
                                                            " AND (d.id_documento LIKE '%"+valorConsulta+"%' OR d.numFactura_documento LIKE '%"+valorConsulta+"%' OR p.nombre_proveedor LIKE '%"+valorConsulta+"%') "+
                                                    "LIMIT 500;");      
            }//AND h.id_confirmacionRecibido=0
            while(resultSet.next()){ 
                ConsultarDocumentosPendientesRecibir consult = new ConsultarDocumentosPendientesRecibir(); 
                consult.setId_historicoDocumento(resultSet.getString(1));
                consult.setId_documento(resultSet.getString(2));
                consult.setFechaRegistro_historicoDocumento(resultSet.getString(3));
                consult.setNumFactura_documento(resultSet.getString(4));
                consult.setNit_proveedor(resultSet.getString(5));
                consult.setDig_proveedor(resultSet.getString(6));
                consult.setNombre_proveedor(resultSet.getString(7));
                consult.setNombre_empresa(resultSet.getString(8));
                consult.setUsuarioRegistro_historicoDocumento(resultSet.getString(9));     
                consult.setUsuarioDestino_historicoDocumento(resultSet.getString(10));         
                consult.setEstadoConfirmacion(resultSet.getString(11));         
                listadoDocumentos.add(consult);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar Documentos");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoDocumentos;
    } 
    public int registrarRecibidoDeDocumento(String id_Historico, String id_Documento) {
        int result=0;
        try {
            Connection conexion= control.ConectarBaseDatos();
            PreparedStatement scriptConfirmarDocumento= conexion.prepareStatement("UPDATE `radicado_facturas_vg`.`historicoDocumento` SET `id_estadoHistorico` = '3',`id_confirmacionRecibido` = '1' ,fechaConfirmacion_historicoDocumento=(select now()) WHERE `historicoDocumento`.`id_historicoDocumento` = '"+id_Historico+"' AND `historicoDocumento`.`id_documento` = '"+id_Documento+"';");
            scriptConfirmarDocumento.execute();   
            result=1;
            if(result==1){
                    Statement statement = conexion.createStatement();
                    ResultSet resultSet;
                    resultSet= statement.executeQuery("SELECT * FROM `radicado_facturas_vg`.`historicoDocumento` WHERE `id_documento`='"+id_Documento+"' AND `id_estadoHistorico`='2';");
                    
                    int validador=0;
                    while(resultSet.next()){ 
                        validador++;
                    }
                    if(validador==0){
                        ResultSet resultSet_ValidarEstadocumento;
                        resultSet_ValidarEstadocumento= statement.executeQuery("SELECT id_estadoDocumento FROM `radicado_facturas_vg`.`documento` WHERE `id_documento`='"+id_Documento+"';");

                        int validadorEstadoDocumento=0;
                        while(resultSet_ValidarEstadocumento.next()){ 
                            validadorEstadoDocumento =Integer.parseInt(resultSet_ValidarEstadocumento.getString(1));
                        }
                        if(validadorEstadoDocumento != 2){
                            PreparedStatement scriptActivarDocumento= conexion.prepareStatement("UPDATE `radicado_facturas_vg`.`documento` SET `id_estadoDocumento` = '0' WHERE `documento`.`id_documento` = '"+id_Documento+"';");
                            scriptActivarDocumento.execute();  
                        }
                    }
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(ControlDB_RecibirDocumento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public ArrayList<EstadoHistorico> listadoEstado_HistoricoDocumento(){
        ArrayList<EstadoHistorico> listadoEstadoHistorico =new ArrayList();
        try {
            Connection conexion= control.ConectarBaseDatos();
            Statement statement = conexion.createStatement();
            ResultSet resultSet;
            resultSet= statement.executeQuery("SELECT * FROM `radicado_facturas_vg`.`estadoHistorico`;");
            while(resultSet.next()){ 
                EstadoHistorico e = new EstadoHistorico();
                e.setDescripcion_estadoHistorico(resultSet.getString(2));
                listadoEstadoHistorico.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlDB_RecibirDocumento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listadoEstadoHistorico;
    }
}
