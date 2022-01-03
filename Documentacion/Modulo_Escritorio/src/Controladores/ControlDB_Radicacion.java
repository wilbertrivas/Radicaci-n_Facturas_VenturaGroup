
package Controladores;
     
import Modelos.Consultas.ConsultaGeneralInforme;
import Modelos.Consultas.ImprimirRadicacion;
import Modelos.Documento;
import Modelos.Sede;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlDB_Radicacion {
    
    private Connection conexion=null;
    private  ControlDB_DB control=null;   
    int consecutivoRadicado=0;
    
    public ControlDB_Radicacion() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();       
    }   
    public int retornarElMaximoDocumento(){
         Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(id_documento) FROM radicado_facturas_vg.documento;");
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
    public int registrarRadicacion(Documento documento, String usuarioDestino) throws FileNotFoundException, SQLException{
       Connection conexion= control.ConectarBaseDatos();
       int result=0;
        try{
            
            try{
                if(documento.getId_documento()==3000){
                   PreparedStatement scriptInsertDocumento= conexion.prepareStatement("INSERT INTO `radicado_facturas_vg`.`documento` "+
                        "(`id_documento`, `numFactura_documento`,"+
                        " `nit_proveedor`, `observacion_documento`, `id_estadoDocumento`, `id_usuario`, `nit_empresa`, `id_sede`) "+
                        " VALUES (3000, '"+documento.getNumFactura_documento()+"', '"+documento.getNit_proveedor()+"', "+
                        "'"+documento.getObservacion_documento()+"', '"+documento.getId_estadoDocumento()+"', '"+documento.getId_usuario()+"',"+
                        " '"+documento.getNit_empresa()+"', '"+documento.getId_sede()+"');");       
                    scriptInsertDocumento.execute();
                    result=1;  
                }else{
                    PreparedStatement scriptInsertDocumento= conexion.prepareStatement("INSERT INTO `radicado_facturas_vg`.`documento` "+
                            "(`id_documento`, `numFactura_documento`,"+
                            " `nit_proveedor`, `observacion_documento`, `id_estadoDocumento`, `id_usuario`, `nit_empresa`, `id_sede`) "+
                            " VALUES (NULL, '"+documento.getNumFactura_documento()+"', '"+documento.getNit_proveedor()+"', "+
                            "'"+documento.getObservacion_documento()+"', '"+documento.getId_estadoDocumento()+"', '"+documento.getId_usuario()+"',"+
                            " '"+documento.getNit_empresa()+"', '"+documento.getId_sede()+"');");       
                    scriptInsertDocumento.execute();
                    result=1;
                }
            }catch(Exception e){
                result=0;
            }
            if(result == 1){
                PreparedStatement scriptInsertHistoricoDocumento= conexion.prepareStatement("INSERT INTO `radicado_facturas_vg`.`historicoDocumento` "
                            + "(`id_historicoDocumento`, `id_documento`, `usuarioRegistro_historicoDocumento`, "
                            + "`usuarioDestino_historicoDocumento`, `observacion_historicoDocumento`, `fechaRegistro_historicoDocumento`, "
                            + "`id_estadoHistorico`,`id_confirmacionRecibido`) VALUES (NULL, (SELECT MAX(id_documento) FROM `radicado_facturas_vg`.documento), '"+documento.getId_usuario()+"',"
                            + " '"+usuarioDestino+"', '"+documento.getObservacion_documento()+"', (select now()), '1','2');");       
                scriptInsertHistoricoDocumento.execute();
                result=1;
            }
        }catch(SQLException e){
            
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error Al Radicar");
         }
        return result;
    }
    public int validarSede(String nombreSede){
        control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `radicado_facturas_vg`.`sede`;");
            while(resultSet.next()){ 
                if(nombreSede.equals(resultSet.getString(2))){
                    retorno =Integer.parseInt(resultSet.getString(1));
                }
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return retorno;
    }
    public ArrayList<Sede> cargarSede(){
        ArrayList<Sede> listadoSede = new ArrayList();
        conexion=control.ConectarBaseDatos();
        Connection conexion= control.ConectarBaseDatos();
        try{
            Statement statement = conexion.createStatement();
            ResultSet resultSet;
            resultSet= statement.executeQuery("SELECT * FROM `radicado_facturas_vg`.`sede` WHERE `id_estadoSede`=1;");
            while(resultSet.next()){ 
                Sede sede = new Sede();
                sede.setId_sede(resultSet.getInt(1));
                sede.setNombre_sede(resultSet.getString(2));
                sede.setEstadoSede(resultSet.getInt(3));
                listadoSede.add(sede);
            }
        }
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar la sede");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoSede;
   }          
    public ImprimirRadicacion buscarRadicacionParaImpresion(String idDocumento) throws SQLException{
        ImprimirRadicacion imprimirRadicacion = new ImprimirRadicacion();
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
                
            resultSet = statement.executeQuery("SELECT "+
                                                "s.nombre_sede, "+
                                                "u.nombre_usuario, "+
                                                "u.apellido_usuario, "+
                                                "h.id_documento, "+
                                                "h.fechaRegistro_historicoDocumento, "+
                                                "usuarioDestino.nombre_usuario, "+
                                                "usuarioDestino.apellido_usuario "+
                                                "FROM `radicado_facturas_vg`.documento d "+
                                                "	INNER JOIN `radicado_facturas_vg`.historicoDocumento h  ON h.id_documento = d.id_documento "+
                                                "	INNER JOIN `radicado_facturas_vg`.usuario u  ON u.id_usuario = d.id_usuario "+
                                                "	INNER JOIN `radicado_facturas_vg`.usuario usuarioDestino  ON usuarioDestino.id_usuario = h.usuarioDestino_historicoDocumento "+
                                                "	INNER JOIN `radicado_facturas_vg`.sede s  ON s.id_sede = d.id_sede "+
                                                "WHERE d.id_documento='"+idDocumento+"' AND h.id_estadoHistorico='1';");      
            while(resultSet.next()){ 
                imprimirRadicacion.setSede(resultSet.getString(1));
                imprimirRadicacion.setUsuarioRadicacion(resultSet.getString(2)+" "+resultSet.getString(3));
                imprimirRadicacion.setNumeroRadicacion(resultSet.getString(4));
                imprimirRadicacion.setFecha(resultSet.getString(5));
                imprimirRadicacion.setUsuarioDestino(resultSet.getString(6)+" "+resultSet.getString(7));
               
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar Radicacion");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return imprimirRadicacion;
    } 
    public ArrayList<ConsultaGeneralInforme>  consultarRadicacion(String valor) throws SQLException{
        
        ArrayList<ConsultaGeneralInforme> listadoConsultaGeneralInforme=new ArrayList();
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
                
            resultSet = statement.executeQuery("SELECT "+ 
                                    "d.id_documento AS documento_id_documento,"+ 
                                    "d.numFactura_documento AS documento_numFactura_documento,"+ 
                                    "d.nit_proveedor AS documento_nit_proveedor,"+ 
                                    "d.observacion_documento AS documento_observacion_documento,"+ 
                                    "d.id_estadoDocumento AS documento_id_estadoDocumento,"+ 
                                    "d.id_usuario AS documento_id_usuario,"+ 
                                    "d.nit_empresa AS documento_nit_empresa,"+ 
                                    "d.id_sede AS documento_id_sede,"+ 

                                    "ed.id_estadoDocumento AS estadodocumento_id_estadoDocumento,"+ 
                                    "ed.descripcion_estadoDocumento AS estadodocumento_descripcion_estadoDocumento,"+ 

                                    "p.nit_proveedor AS proveedor_nit_proveedor,"+ 
                                    "p.dig_proveedor AS proveedor_dig_proveedor,"+ 
                                    "p.nombre_proveedor AS proveedor_nombre_proveedor,"+ 
                                    "p.correo_proveedor AS proveedor_correo_proveedor,"+ 
                                    "p.telefono_proveedor AS proveedor_telefono_proveedor,"+ 
                                    "p.id_estadoProveedor AS proveedor_id_estadoProveedor,"+ 

                                    "ep.id_estadoProveedor AS estadoProveedor_id_estadoProveedor,"+ 
                                    "ep.descripcion_estadoProveedor AS estadoProveedor_descripcion_estadoProveedor,"+ 

                                    "e.nit_empresa AS empresa_nit_empresa,"+ 
                                    "e.dig_empresa AS empresa_dig_empresa,"+ 
                                    "e.nombre_empresa AS empresa_nombre_empresa,"+ 
                                    "e.correo_empresa AS empresa_correo_empresa,"+ 
                                    "e.telefono_empresa AS empresa_telefono_empresa,"+ 
                                    "e.id_estadoEmpresa AS empresa_id_estadoEmpresa,"+ 

                                    "ee.id_estadoEmpresa AS estadoempresa_id_estadoEmpresa,"+ 
                                    "ee.descripcion_estadoEmpresa AS estadoempresa_descripcion_estadoEmpresa,"+ 

                                    "h.id_historicoDocumento AS historicodocumento_id_historicoDocumento,"+ 
                                    "h.id_documento AS historicodocumento_id_documento,"+ 
                                    "h.usuarioRegistro_historicoDocumento AS historicodocumento_usuarioRegistro_historicoDocumento,"+ 
                                    "h.usuarioDestino_historicoDocumento AS historicodocumento_usuarioDestino_historicoDocumento,"+ 
                                    "h.observacion_historicoDocumento AS historicodocumento_observacion_historicoDocumento,"+ 
                                    "h.fechaRegistro_historicoDocumento AS historicodocumento_fechaRegistro_historicoDocumento,"+ 
                                    "h.id_estadoHistorico AS historicodocumento_id_estadoHistorico,"+ 
                                    "h.id_confirmacionRecibido AS historicodocumento_id_confirmacionRecibido,"+ 

                                    "eh.id_estadoHistorico AS estadohistorico_id_estadoHistorico,"+ 
                                    "eh.descripcion_estadoHistorico AS estadohistorico_descripcion_estadoHistorico,"+ 

                                    "c.id_confirmacionRecibido AS confirmacionrecibido_id_confirmacionRecibido,"+ 
                                    "c.descripcion_confirmacionRecibido AS confirmacionrecibido_descripcion_confirmacionRecibido,"+ 

                                    "s.id_sede AS sede_id_sede,"+ 
                                    "s.nombre_sede AS sede_nombre_sede,"+ 
                                    "s.id_estadoSede AS sede_id_estadoSede,"+ 

                                    "es.id_estadoSede AS estadosede_id_estadoSede,"+ 
                                    "es.descripcion_estadoSede AS estadosede_descripcion_estadoSede,"+ 

                                    "u.id_usuario AS usuario_id_usuario,"+ 
                                    "u.nombre_usuario AS usuario_nombre_usuario,"+ 
                                    "u.apellido_usuario AS usuario_apellido_usuario,"+ 
                                    "u.mail_usuario AS usuario_mail_usuario,"+ 
                                    "u.id_estadoUsuario AS usuario_id_estadoUsuario "+ 

                                    " FROM `radicado_facturas_vg`.documento d "+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoDocumento ed  ON ed.id_estadoDocumento = d.id_estadoDocumento"+ 
                                            " INNER JOIN `radicado_facturas_vg`.proveedor p  ON p.nit_proveedor = d.nit_proveedor"+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoProveedor ep  ON ep.id_estadoProveedor = p.id_estadoProveedor"+ 
                                            " INNER JOIN `radicado_facturas_vg`.empresa e  ON e.nit_empresa = d.nit_empresa"+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoEmpresa ee  ON ee.id_estadoEmpresa = e.id_estadoEmpresa"+ 
                                            " INNER JOIN `radicado_facturas_vg`.historicoDocumento h  ON h.id_documento = d.id_documento"+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoHistorico eh  ON eh.id_estadoHistorico = h.id_estadoHistorico"+ 
                                            " INNER JOIN `radicado_facturas_vg`.confirmacionRecibido c  ON c.id_confirmacionRecibido = h.id_confirmacionRecibido"+ 
                                            " INNER JOIN `radicado_facturas_vg`.sede s  ON s.id_sede = d.id_sede"+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoSede es  ON es.id_estadoSede = s.id_estadoSede"+ 
                                            " INNER JOIN `radicado_facturas_vg`.usuario u  ON u.id_usuario = d.id_usuario WHERE eh.id_estadoHistorico=1 AND +"
                                            + " (d.id_documento like '%"+valor+"%' OR d.numFactura_documento like '%"+valor+"%' OR d.nit_proveedor like '%"+valor+"%'"
                                                    + " OR d.nit_empresa like '%"+valor+"%' OR p.nombre_proveedor like '%"+valor+"%' OR e.nombre_empresa like '%"+valor+"%' "
                                                            + " OR h.id_historicoDocumento like '%"+valor+"%');");      
            while(resultSet.next()){ 
                ConsultaGeneralInforme consultaGeneralInforme = new ConsultaGeneralInforme();
                consultaGeneralInforme.setDocumento_id_documento(resultSet.getString(1));
                consultaGeneralInforme.setDocumento_numFactura_documento(resultSet.getString(2));
                consultaGeneralInforme.setDocumento_nit_proveedor(resultSet.getString(3));
                consultaGeneralInforme.setDocumento_observacion_documento(resultSet.getString(4));
                consultaGeneralInforme.setDocumento_id_estadoDocumento(resultSet.getString(5));
                consultaGeneralInforme.setDocumento_id_usuario(resultSet.getString(6));
                consultaGeneralInforme.setDocumento_nit_empresa(resultSet.getString(7));
                consultaGeneralInforme.setDocumento_id_sede(resultSet.getString(8));
                consultaGeneralInforme.setEstadodocumento_id_estadoDocumento(resultSet.getString(9));
                consultaGeneralInforme.setEstadodocumento_descripcion_estadoDocumento(resultSet.getString(10));
                consultaGeneralInforme.setProveedor_nit_proveedor(resultSet.getString(11));
                consultaGeneralInforme.setProveedor_dig_proveedor(resultSet.getString(12));
                consultaGeneralInforme.setProveedor_nombre_proveedor(resultSet.getString(13));
                consultaGeneralInforme.setProveedor_correo_proveedor(resultSet.getString(14));
                consultaGeneralInforme.setProveedor_telefono_proveedor(resultSet.getString(15));
                consultaGeneralInforme.setProveedor_id_estadoProveedor(resultSet.getString(16));
                consultaGeneralInforme.setEstadoProveedor_id_estadoProveedor(resultSet.getString(17));
                consultaGeneralInforme.setEstadoProveedor_descripcion_estadoProveedor(resultSet.getString(18));
                consultaGeneralInforme.setEmpresa_nit_empresa(resultSet.getString(19));
                consultaGeneralInforme.setEmpresa_dig_empresa(resultSet.getString(20));
                consultaGeneralInforme.setEmpresa_nombre_empresa(resultSet.getString(21));
                consultaGeneralInforme.setEmpresa_correo_empresa(resultSet.getString(22));
                consultaGeneralInforme.setEmpresa_telefono_empresa(resultSet.getString(23));
                consultaGeneralInforme.setEmpresa_id_estadoEmpresa(resultSet.getString(24));
                consultaGeneralInforme.setEstadoempresa_id_estadoEmpresa(resultSet.getString(25));
                consultaGeneralInforme.setEstadoempresa_descripcion_estadoEmpresa(resultSet.getString(26));
                consultaGeneralInforme.setHistoricodocumento_id_historicoDocumento(resultSet.getString(27));
                consultaGeneralInforme.setHistoricodocumento_id_documento(resultSet.getString(28));
                consultaGeneralInforme.setHistoricodocumento_usuarioRegistro_historicoDocumento(resultSet.getString(29));
                consultaGeneralInforme.setHistoricodocumento_usuarioDestino_historicoDocumento(resultSet.getString(30));
                consultaGeneralInforme.setHistoricodocumento_observacion_historicoDocumento(resultSet.getString(31));
                consultaGeneralInforme.setHistoricodocumento_fechaRegistro_historicoDocumento(resultSet.getString(32));
                consultaGeneralInforme.setHistoricodocumento_id_estadoHistorico(resultSet.getString(33));
                consultaGeneralInforme.setHistoricodocumento_id_confirmacionRecibido(resultSet.getString(34));
                consultaGeneralInforme.setEstadohistorico_id_estadoHistorico(resultSet.getString(35));
                consultaGeneralInforme.setEstadohistorico_descripcion_estadoHistorico(resultSet.getString(36));
                consultaGeneralInforme.setConfirmacionrecibido_id_confirmacionRecibido(resultSet.getString(37));
                consultaGeneralInforme.setConfirmacionrecibido_descripcion_confirmacionRecibido(resultSet.getString(38));
                consultaGeneralInforme.setSede_id_sede(resultSet.getString(39));
                consultaGeneralInforme.setSede_nombre_sede(resultSet.getString(40));
                consultaGeneralInforme.setSede_id_estadoSede(resultSet.getString(41));
                consultaGeneralInforme.setEstadosede_id_estadoSede(resultSet.getString(42));
                consultaGeneralInforme.setEstadosede_descripcion_estadoSede(resultSet.getString(43));
                consultaGeneralInforme.setUsuario_id_usuario(resultSet.getString(44));
                consultaGeneralInforme.setUsuario_nombre_usuario(resultSet.getString(45));
                consultaGeneralInforme.setUsuario_apellido_usuario(resultSet.getString(46));
                consultaGeneralInforme.setUsuario_mail_usuario(resultSet.getString(47));
                consultaGeneralInforme.setUsuario_id_estadoUsuario(resultSet.getString(48));
               listadoConsultaGeneralInforme.add(consultaGeneralInforme);
               
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar Radicacion");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoConsultaGeneralInforme;
    } 
    public int AnularRadicacion(String IdDocumento, String observacion) throws FileNotFoundException{
        control.ConectarBaseDatos();
        int result=0;
        try{ 
            PreparedStatement r= conexion.prepareStatement("UPDATE `radicado_facturas_vg`.`documento` SET `id_estadoDocumento` = '2', `fechaAnulacion_documento` = (select now())," +
                                                            "`observacionAnulacion_documento` = '"+observacion+"' WHERE `documento`.`id_documento` = '"+IdDocumento+"';");
            r.execute();
            result=1; 
        }
        catch (SQLException sqlException ){   
            result=0;
            JOptionPane.showMessageDialog(null, "ERROR al querer insertar los datos.");
            sqlException.printStackTrace();
        }  
        control.cerrarConexionBaseDatos();
        return result;
    }    
    
    //Metodos Publicos Generación de Informe en el sistema
    public ArrayList<ConsultaGeneralInforme>  Informe_General(String valor) throws SQLException{//Recibe un parametro y realiza una consulta en General       
        ArrayList<ConsultaGeneralInforme> listadoConsultaGeneralInforme=new ArrayList();
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
                
            resultSet = statement.executeQuery("SELECT "+ 
                                    "d.id_documento AS documento_id_documento,"+ 
                                    "d.numFactura_documento AS documento_numFactura_documento,"+ 
                                    "d.nit_proveedor AS documento_nit_proveedor,"+ 
                                    "d.observacion_documento AS documento_observacion_documento,"+ 
                                    "d.id_estadoDocumento AS documento_id_estadoDocumento,"+ 
                                    "d.id_usuario AS documento_id_usuario,"+ 
                                    "d.nit_empresa AS documento_nit_empresa,"+ 
                                    "d.id_sede AS documento_id_sede,"+ 
                                    "d.fechaAnulacion_documento AS documento_fechaAnulacion_documento,"+ 
                                    "d.observacionAnulacion_documento AS documento_observacionAnulacion_documento,"+ 

                                    "ed.id_estadoDocumento AS estadodocumento_id_estadoDocumento,"+ 
                                    "ed.descripcion_estadoDocumento AS estadodocumento_descripcion_estadoDocumento,"+ 

                                    "p.nit_proveedor AS proveedor_nit_proveedor,"+ 
                                    "p.dig_proveedor AS proveedor_dig_proveedor,"+ 
                                    "p.nombre_proveedor AS proveedor_nombre_proveedor,"+ 
                                    "p.correo_proveedor AS proveedor_correo_proveedor,"+ 
                                    "p.telefono_proveedor AS proveedor_telefono_proveedor,"+ 
                                    "p.id_estadoProveedor AS proveedor_id_estadoProveedor,"+ 

                                    "ep.id_estadoProveedor AS estadoProveedor_id_estadoProveedor,"+ 
                                    "ep.descripcion_estadoProveedor AS estadoProveedor_descripcion_estadoProveedor,"+ 

                                    "e.nit_empresa AS empresa_nit_empresa,"+ 
                                    "e.dig_empresa AS empresa_dig_empresa,"+ 
                                    "e.nombre_empresa AS empresa_nombre_empresa,"+ 
                                    "e.correo_empresa AS empresa_correo_empresa,"+ 
                                    "e.telefono_empresa AS empresa_telefono_empresa,"+ 
                                    "e.id_estadoEmpresa AS empresa_id_estadoEmpresa,"+ 

                                    "ee.id_estadoEmpresa AS estadoempresa_id_estadoEmpresa,"+ 
                                    "ee.descripcion_estadoEmpresa AS estadoempresa_descripcion_estadoEmpresa,"+ 

                                    "h.id_historicoDocumento AS historicodocumento_id_historicoDocumento,"+ 
                                    "h.id_documento AS historicodocumento_id_documento,"+ 
                                    "h.usuarioRegistro_historicoDocumento AS historicodocumento_usuarioRegistro_historicoDocumento,"+ 
                                    "h.usuarioDestino_historicoDocumento AS historicodocumento_usuarioDestino_historicoDocumento,"+ 
                                    "h.observacion_historicoDocumento AS historicodocumento_observacion_historicoDocumento,"+ 
                                    "h.fechaRegistro_historicoDocumento AS historicodocumento_fechaRegistro_historicoDocumento,"+ 
                                    "h.id_estadoHistorico AS historicodocumento_id_estadoHistorico,"+ 
                                    "h.id_confirmacionRecibido AS historicodocumento_id_confirmacionRecibido,"+ 

                                    "eh.id_estadoHistorico AS estadohistorico_id_estadoHistorico,"+ 
                                    "eh.descripcion_estadoHistorico AS estadohistorico_descripcion_estadoHistorico,"+ 

                                    "c.id_confirmacionRecibido AS confirmacionrecibido_id_confirmacionRecibido,"+ 
                                    "c.descripcion_confirmacionRecibido AS confirmacionrecibido_descripcion_confirmacionRecibido,"+ 

                                    "s.id_sede AS sede_id_sede,"+ 
                                    "s.nombre_sede AS sede_nombre_sede,"+ 
                                    "s.id_estadoSede AS sede_id_estadoSede,"+ 

                                    "es.id_estadoSede AS estadosede_id_estadoSede,"+ 
                                    "es.descripcion_estadoSede AS estadosede_descripcion_estadoSede,"+ 

                                    "u.id_usuario AS usuario_id_usuario,"+ 
                                    "u.nombre_usuario AS usuario_nombre_usuario,"+ 
                                    "u.apellido_usuario AS usuario_apellido_usuario,"+ 
                                    "u.mail_usuario AS usuario_mail_usuario,"+ 
                                    "u.id_estadoUsuario AS usuario_id_estadoUsuario "+ 

                                    " FROM `radicado_facturas_vg`.documento d "+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoDocumento ed  ON ed.id_estadoDocumento = d.id_estadoDocumento"+ 
                                            " INNER JOIN `radicado_facturas_vg`.proveedor p  ON p.nit_proveedor = d.nit_proveedor"+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoProveedor ep  ON ep.id_estadoProveedor = p.id_estadoProveedor"+ 
                                            " INNER JOIN `radicado_facturas_vg`.empresa e  ON e.nit_empresa = d.nit_empresa"+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoEmpresa ee  ON ee.id_estadoEmpresa = e.id_estadoEmpresa"+ 
                                            " INNER JOIN `radicado_facturas_vg`.historicoDocumento h  ON h.id_documento = d.id_documento"+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoHistorico eh  ON eh.id_estadoHistorico = h.id_estadoHistorico"+ 
                                            " INNER JOIN `radicado_facturas_vg`.confirmacionRecibido c  ON c.id_confirmacionRecibido = h.id_confirmacionRecibido"+ 
                                            " INNER JOIN `radicado_facturas_vg`.sede s  ON s.id_sede = d.id_sede"+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoSede es  ON es.id_estadoSede = s.id_estadoSede"+ 
                                            " INNER JOIN `radicado_facturas_vg`.usuario u  ON u.id_usuario = d.id_usuario WHERE +"
                                            + " (d.id_documento like '%"+valor+"%' OR d.numFactura_documento like '%"+valor+"%' OR d.nit_proveedor like '%"+valor+"%'"
                                                    + " OR d.nit_empresa like '%"+valor+"%' OR p.nombre_proveedor like '%"+valor+"%' OR e.nombre_empresa like '%"+valor+"%' "
                                                            + " OR h.id_historicoDocumento like '%"+valor+"%') ORDER BY h.id_historicoDocumento ASC;");      
            while(resultSet.next()){ 
                ConsultaGeneralInforme consultaGeneralInforme = new ConsultaGeneralInforme();
                consultaGeneralInforme.setDocumento_id_documento(resultSet.getString(1));
                consultaGeneralInforme.setDocumento_numFactura_documento(resultSet.getString(2));
                consultaGeneralInforme.setDocumento_nit_proveedor(resultSet.getString(3));
                consultaGeneralInforme.setDocumento_observacion_documento(resultSet.getString(4));
                consultaGeneralInforme.setDocumento_id_estadoDocumento(resultSet.getString(5));
                consultaGeneralInforme.setDocumento_id_usuario(resultSet.getString(6));
                consultaGeneralInforme.setDocumento_nit_empresa(resultSet.getString(7));
                consultaGeneralInforme.setDocumento_id_sede(resultSet.getString(8));
                consultaGeneralInforme.setDocumento_fechaAnulacion_documento(resultSet.getString(9));
                consultaGeneralInforme.setDocumento_observacionAnulacion_documento(resultSet.getString(10));
                consultaGeneralInforme.setEstadodocumento_id_estadoDocumento(resultSet.getString(11));
                consultaGeneralInforme.setEstadodocumento_descripcion_estadoDocumento(resultSet.getString(12));
                consultaGeneralInforme.setProveedor_nit_proveedor(resultSet.getString(13));
                consultaGeneralInforme.setProveedor_dig_proveedor(resultSet.getString(14));
                consultaGeneralInforme.setProveedor_nombre_proveedor(resultSet.getString(15));
                consultaGeneralInforme.setProveedor_correo_proveedor(resultSet.getString(16));
                consultaGeneralInforme.setProveedor_telefono_proveedor(resultSet.getString(17));
                consultaGeneralInforme.setProveedor_id_estadoProveedor(resultSet.getString(18));
                consultaGeneralInforme.setEstadoProveedor_id_estadoProveedor(resultSet.getString(19));
                consultaGeneralInforme.setEstadoProveedor_descripcion_estadoProveedor(resultSet.getString(20));
                consultaGeneralInforme.setEmpresa_nit_empresa(resultSet.getString(21));
                consultaGeneralInforme.setEmpresa_dig_empresa(resultSet.getString(22));
                consultaGeneralInforme.setEmpresa_nombre_empresa(resultSet.getString(23));
                consultaGeneralInforme.setEmpresa_correo_empresa(resultSet.getString(24));
                consultaGeneralInforme.setEmpresa_telefono_empresa(resultSet.getString(25));
                consultaGeneralInforme.setEmpresa_id_estadoEmpresa(resultSet.getString(26));
                consultaGeneralInforme.setEstadoempresa_id_estadoEmpresa(resultSet.getString(27));
                consultaGeneralInforme.setEstadoempresa_descripcion_estadoEmpresa(resultSet.getString(28));
                consultaGeneralInforme.setHistoricodocumento_id_historicoDocumento(resultSet.getString(29));
                consultaGeneralInforme.setHistoricodocumento_id_documento(resultSet.getString(30));
                consultaGeneralInforme.setHistoricodocumento_usuarioRegistro_historicoDocumento(resultSet.getString(31));
                consultaGeneralInforme.setHistoricodocumento_usuarioDestino_historicoDocumento(resultSet.getString(32));
                consultaGeneralInforme.setHistoricodocumento_observacion_historicoDocumento(resultSet.getString(33));
                consultaGeneralInforme.setHistoricodocumento_fechaRegistro_historicoDocumento(resultSet.getString(34));
                consultaGeneralInforme.setHistoricodocumento_id_estadoHistorico(resultSet.getString(35));
                consultaGeneralInforme.setHistoricodocumento_id_confirmacionRecibido(resultSet.getString(36));
                consultaGeneralInforme.setEstadohistorico_id_estadoHistorico(resultSet.getString(37));
                consultaGeneralInforme.setEstadohistorico_descripcion_estadoHistorico(resultSet.getString(38));
                consultaGeneralInforme.setConfirmacionrecibido_id_confirmacionRecibido(resultSet.getString(39));
                consultaGeneralInforme.setConfirmacionrecibido_descripcion_confirmacionRecibido(resultSet.getString(40));
                consultaGeneralInforme.setSede_id_sede(resultSet.getString(41));
                consultaGeneralInforme.setSede_nombre_sede(resultSet.getString(42));
                consultaGeneralInforme.setSede_id_estadoSede(resultSet.getString(43));
                consultaGeneralInforme.setEstadosede_id_estadoSede(resultSet.getString(44));
                consultaGeneralInforme.setEstadosede_descripcion_estadoSede(resultSet.getString(45));
                consultaGeneralInforme.setUsuario_id_usuario(resultSet.getString(46));
                consultaGeneralInforme.setUsuario_nombre_usuario(resultSet.getString(47));
                consultaGeneralInforme.setUsuario_apellido_usuario(resultSet.getString(48));
                consultaGeneralInforme.setUsuario_mail_usuario(resultSet.getString(49));
                consultaGeneralInforme.setUsuario_id_estadoUsuario(resultSet.getString(50));
               listadoConsultaGeneralInforme.add(consultaGeneralInforme);    
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar Radicacion");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoConsultaGeneralInforme;
    } 
    public ArrayList<ConsultaGeneralInforme>  Informe_FechaRegistro(String fecha_ini, String fecha_fin) throws SQLException{//Recibe un parametro y realiza una consulta en General       
        ArrayList<ConsultaGeneralInforme> listadoConsultaGeneralInforme=new ArrayList();
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
                
            resultSet = statement.executeQuery("SELECT "+ 
                                    "d.id_documento AS documento_id_documento,"+ 
                                    "d.numFactura_documento AS documento_numFactura_documento,"+ 
                                    "d.nit_proveedor AS documento_nit_proveedor,"+ 
                                    "d.observacion_documento AS documento_observacion_documento,"+ 
                                    "d.id_estadoDocumento AS documento_id_estadoDocumento,"+ 
                                    "d.id_usuario AS documento_id_usuario,"+ 
                                    "d.nit_empresa AS documento_nit_empresa,"+ 
                                    "d.id_sede AS documento_id_sede,"+ 
                                    "d.fechaAnulacion_documento AS documento_fechaAnulacion_documento,"+ 
                                    "d.observacionAnulacion_documento AS documento_observacionAnulacion_documento,"+ 

                                    "ed.id_estadoDocumento AS estadodocumento_id_estadoDocumento,"+ 
                                    "ed.descripcion_estadoDocumento AS estadodocumento_descripcion_estadoDocumento,"+ 

                                    "p.nit_proveedor AS proveedor_nit_proveedor,"+ 
                                    "p.dig_proveedor AS proveedor_dig_proveedor,"+ 
                                    "p.nombre_proveedor AS proveedor_nombre_proveedor,"+ 
                                    "p.correo_proveedor AS proveedor_correo_proveedor,"+ 
                                    "p.telefono_proveedor AS proveedor_telefono_proveedor,"+ 
                                    "p.id_estadoProveedor AS proveedor_id_estadoProveedor,"+ 

                                    "ep.id_estadoProveedor AS estadoProveedor_id_estadoProveedor,"+ 
                                    "ep.descripcion_estadoProveedor AS estadoProveedor_descripcion_estadoProveedor,"+ 

                                    "e.nit_empresa AS empresa_nit_empresa,"+ 
                                    "e.dig_empresa AS empresa_dig_empresa,"+ 
                                    "e.nombre_empresa AS empresa_nombre_empresa,"+ 
                                    "e.correo_empresa AS empresa_correo_empresa,"+ 
                                    "e.telefono_empresa AS empresa_telefono_empresa,"+ 
                                    "e.id_estadoEmpresa AS empresa_id_estadoEmpresa,"+ 

                                    "ee.id_estadoEmpresa AS estadoempresa_id_estadoEmpresa,"+ 
                                    "ee.descripcion_estadoEmpresa AS estadoempresa_descripcion_estadoEmpresa,"+ 

                                    "h.id_historicoDocumento AS historicodocumento_id_historicoDocumento,"+ 
                                    "h.id_documento AS historicodocumento_id_documento,"+ 
                                    "h.usuarioRegistro_historicoDocumento AS historicodocumento_usuarioRegistro_historicoDocumento,"+ 
                                    "h.usuarioDestino_historicoDocumento AS historicodocumento_usuarioDestino_historicoDocumento,"+ 
                                    "h.observacion_historicoDocumento AS historicodocumento_observacion_historicoDocumento,"+ 
                                    "h.fechaRegistro_historicoDocumento AS historicodocumento_fechaRegistro_historicoDocumento,"+ 
                                    "h.id_estadoHistorico AS historicodocumento_id_estadoHistorico,"+ 
                                    "h.id_confirmacionRecibido AS historicodocumento_id_confirmacionRecibido,"+ 

                                    "eh.id_estadoHistorico AS estadohistorico_id_estadoHistorico,"+ 
                                    "eh.descripcion_estadoHistorico AS estadohistorico_descripcion_estadoHistorico,"+ 

                                    "c.id_confirmacionRecibido AS confirmacionrecibido_id_confirmacionRecibido,"+ 
                                    "c.descripcion_confirmacionRecibido AS confirmacionrecibido_descripcion_confirmacionRecibido,"+ 

                                    "s.id_sede AS sede_id_sede,"+ 
                                    "s.nombre_sede AS sede_nombre_sede,"+ 
                                    "s.id_estadoSede AS sede_id_estadoSede,"+ 

                                    "es.id_estadoSede AS estadosede_id_estadoSede,"+ 
                                    "es.descripcion_estadoSede AS estadosede_descripcion_estadoSede,"+ 

                                    "u.id_usuario AS usuario_id_usuario,"+ 
                                    "u.nombre_usuario AS usuario_nombre_usuario,"+ 
                                    "u.apellido_usuario AS usuario_apellido_usuario,"+ 
                                    "u.mail_usuario AS usuario_mail_usuario,"+ 
                                    "u.id_estadoUsuario AS usuario_id_estadoUsuario "+ 

                                    " FROM `radicado_facturas_vg`.documento d "+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoDocumento ed  ON ed.id_estadoDocumento = d.id_estadoDocumento"+ 
                                            " INNER JOIN `radicado_facturas_vg`.proveedor p  ON p.nit_proveedor = d.nit_proveedor"+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoProveedor ep  ON ep.id_estadoProveedor = p.id_estadoProveedor"+ 
                                            " INNER JOIN `radicado_facturas_vg`.empresa e  ON e.nit_empresa = d.nit_empresa"+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoEmpresa ee  ON ee.id_estadoEmpresa = e.id_estadoEmpresa"+ 
                                            " INNER JOIN `radicado_facturas_vg`.historicoDocumento h  ON h.id_documento = d.id_documento"+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoHistorico eh  ON eh.id_estadoHistorico = h.id_estadoHistorico"+ 
                                            " INNER JOIN `radicado_facturas_vg`.confirmacionRecibido c  ON c.id_confirmacionRecibido = h.id_confirmacionRecibido"+ 
                                            " INNER JOIN `radicado_facturas_vg`.sede s  ON s.id_sede = d.id_sede"+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoSede es  ON es.id_estadoSede = s.id_estadoSede"+ 
                                            " INNER JOIN `radicado_facturas_vg`.usuario u  ON u.id_usuario = d.id_usuario WHERE h.fechaRegistro_historicoDocumento BETWEEN '"+fecha_ini+"' AND '"+fecha_fin+"' "
                                            + " ORDER BY h.id_historicoDocumento ASC;");      
            while(resultSet.next()){ 
                ConsultaGeneralInforme consultaGeneralInforme = new ConsultaGeneralInforme();
                consultaGeneralInforme.setDocumento_id_documento(resultSet.getString(1));
                consultaGeneralInforme.setDocumento_numFactura_documento(resultSet.getString(2));
                consultaGeneralInforme.setDocumento_nit_proveedor(resultSet.getString(3));
                consultaGeneralInforme.setDocumento_observacion_documento(resultSet.getString(4));
                consultaGeneralInforme.setDocumento_id_estadoDocumento(resultSet.getString(5));
                consultaGeneralInforme.setDocumento_id_usuario(resultSet.getString(6));
                consultaGeneralInforme.setDocumento_nit_empresa(resultSet.getString(7));
                consultaGeneralInforme.setDocumento_id_sede(resultSet.getString(8));
                consultaGeneralInforme.setDocumento_fechaAnulacion_documento(resultSet.getString(9));
                consultaGeneralInforme.setDocumento_observacionAnulacion_documento(resultSet.getString(10));
                consultaGeneralInforme.setEstadodocumento_id_estadoDocumento(resultSet.getString(11));
                consultaGeneralInforme.setEstadodocumento_descripcion_estadoDocumento(resultSet.getString(12));
                consultaGeneralInforme.setProveedor_nit_proveedor(resultSet.getString(13));
                consultaGeneralInforme.setProveedor_dig_proveedor(resultSet.getString(14));
                consultaGeneralInforme.setProveedor_nombre_proveedor(resultSet.getString(15));
                consultaGeneralInforme.setProveedor_correo_proveedor(resultSet.getString(16));
                consultaGeneralInforme.setProveedor_telefono_proveedor(resultSet.getString(17));
                consultaGeneralInforme.setProveedor_id_estadoProveedor(resultSet.getString(18));
                consultaGeneralInforme.setEstadoProveedor_id_estadoProveedor(resultSet.getString(19));
                consultaGeneralInforme.setEstadoProveedor_descripcion_estadoProveedor(resultSet.getString(20));
                consultaGeneralInforme.setEmpresa_nit_empresa(resultSet.getString(21));
                consultaGeneralInforme.setEmpresa_dig_empresa(resultSet.getString(22));
                consultaGeneralInforme.setEmpresa_nombre_empresa(resultSet.getString(23));
                consultaGeneralInforme.setEmpresa_correo_empresa(resultSet.getString(24));
                consultaGeneralInforme.setEmpresa_telefono_empresa(resultSet.getString(25));
                consultaGeneralInforme.setEmpresa_id_estadoEmpresa(resultSet.getString(26));
                consultaGeneralInforme.setEstadoempresa_id_estadoEmpresa(resultSet.getString(27));
                consultaGeneralInforme.setEstadoempresa_descripcion_estadoEmpresa(resultSet.getString(28));
                consultaGeneralInforme.setHistoricodocumento_id_historicoDocumento(resultSet.getString(29));
                consultaGeneralInforme.setHistoricodocumento_id_documento(resultSet.getString(30));
                consultaGeneralInforme.setHistoricodocumento_usuarioRegistro_historicoDocumento(resultSet.getString(31));
                consultaGeneralInforme.setHistoricodocumento_usuarioDestino_historicoDocumento(resultSet.getString(32));
                consultaGeneralInforme.setHistoricodocumento_observacion_historicoDocumento(resultSet.getString(33));
                consultaGeneralInforme.setHistoricodocumento_fechaRegistro_historicoDocumento(resultSet.getString(34));
                consultaGeneralInforme.setHistoricodocumento_id_estadoHistorico(resultSet.getString(35));
                consultaGeneralInforme.setHistoricodocumento_id_confirmacionRecibido(resultSet.getString(36));
                consultaGeneralInforme.setEstadohistorico_id_estadoHistorico(resultSet.getString(37));
                consultaGeneralInforme.setEstadohistorico_descripcion_estadoHistorico(resultSet.getString(38));
                consultaGeneralInforme.setConfirmacionrecibido_id_confirmacionRecibido(resultSet.getString(39));
                consultaGeneralInforme.setConfirmacionrecibido_descripcion_confirmacionRecibido(resultSet.getString(40));
                consultaGeneralInforme.setSede_id_sede(resultSet.getString(41));
                consultaGeneralInforme.setSede_nombre_sede(resultSet.getString(42));
                consultaGeneralInforme.setSede_id_estadoSede(resultSet.getString(43));
                consultaGeneralInforme.setEstadosede_id_estadoSede(resultSet.getString(44));
                consultaGeneralInforme.setEstadosede_descripcion_estadoSede(resultSet.getString(45));
                consultaGeneralInforme.setUsuario_id_usuario(resultSet.getString(46));
                consultaGeneralInforme.setUsuario_nombre_usuario(resultSet.getString(47));
                consultaGeneralInforme.setUsuario_apellido_usuario(resultSet.getString(48));
                consultaGeneralInforme.setUsuario_mail_usuario(resultSet.getString(49));
                consultaGeneralInforme.setUsuario_id_estadoUsuario(resultSet.getString(50));
               listadoConsultaGeneralInforme.add(consultaGeneralInforme);    
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar Radicacion");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoConsultaGeneralInforme;
    } 
    public ArrayList<ConsultaGeneralInforme>  Informe_Empresa(String nitEmpresa) throws SQLException{//Recibe un parametro y realiza una consulta en General       
        ArrayList<ConsultaGeneralInforme> listadoConsultaGeneralInforme=new ArrayList();
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
                
            resultSet = statement.executeQuery("SELECT "+ 
                                    "d.id_documento AS documento_id_documento,"+ 
                                    "d.numFactura_documento AS documento_numFactura_documento,"+ 
                                    "d.nit_proveedor AS documento_nit_proveedor,"+ 
                                    "d.observacion_documento AS documento_observacion_documento,"+ 
                                    "d.id_estadoDocumento AS documento_id_estadoDocumento,"+ 
                                    "d.id_usuario AS documento_id_usuario,"+ 
                                    "d.nit_empresa AS documento_nit_empresa,"+ 
                                    "d.id_sede AS documento_id_sede,"+ 
                                    "d.fechaAnulacion_documento AS documento_fechaAnulacion_documento,"+ 
                                    "d.observacionAnulacion_documento AS documento_observacionAnulacion_documento,"+ 

                                    "ed.id_estadoDocumento AS estadodocumento_id_estadoDocumento,"+ 
                                    "ed.descripcion_estadoDocumento AS estadodocumento_descripcion_estadoDocumento,"+ 

                                    "p.nit_proveedor AS proveedor_nit_proveedor,"+ 
                                    "p.dig_proveedor AS proveedor_dig_proveedor,"+ 
                                    "p.nombre_proveedor AS proveedor_nombre_proveedor,"+ 
                                    "p.correo_proveedor AS proveedor_correo_proveedor,"+ 
                                    "p.telefono_proveedor AS proveedor_telefono_proveedor,"+ 
                                    "p.id_estadoProveedor AS proveedor_id_estadoProveedor,"+ 

                                    "ep.id_estadoProveedor AS estadoProveedor_id_estadoProveedor,"+ 
                                    "ep.descripcion_estadoProveedor AS estadoProveedor_descripcion_estadoProveedor,"+ 

                                    "e.nit_empresa AS empresa_nit_empresa,"+ 
                                    "e.dig_empresa AS empresa_dig_empresa,"+ 
                                    "e.nombre_empresa AS empresa_nombre_empresa,"+ 
                                    "e.correo_empresa AS empresa_correo_empresa,"+ 
                                    "e.telefono_empresa AS empresa_telefono_empresa,"+ 
                                    "e.id_estadoEmpresa AS empresa_id_estadoEmpresa,"+ 

                                    "ee.id_estadoEmpresa AS estadoempresa_id_estadoEmpresa,"+ 
                                    "ee.descripcion_estadoEmpresa AS estadoempresa_descripcion_estadoEmpresa,"+ 

                                    "h.id_historicoDocumento AS historicodocumento_id_historicoDocumento,"+ 
                                    "h.id_documento AS historicodocumento_id_documento,"+ 
                                    "h.usuarioRegistro_historicoDocumento AS historicodocumento_usuarioRegistro_historicoDocumento,"+ 
                                    "h.usuarioDestino_historicoDocumento AS historicodocumento_usuarioDestino_historicoDocumento,"+ 
                                    "h.observacion_historicoDocumento AS historicodocumento_observacion_historicoDocumento,"+ 
                                    "h.fechaRegistro_historicoDocumento AS historicodocumento_fechaRegistro_historicoDocumento,"+ 
                                    "h.id_estadoHistorico AS historicodocumento_id_estadoHistorico,"+ 
                                    "h.id_confirmacionRecibido AS historicodocumento_id_confirmacionRecibido,"+ 

                                    "eh.id_estadoHistorico AS estadohistorico_id_estadoHistorico,"+ 
                                    "eh.descripcion_estadoHistorico AS estadohistorico_descripcion_estadoHistorico,"+ 

                                    "c.id_confirmacionRecibido AS confirmacionrecibido_id_confirmacionRecibido,"+ 
                                    "c.descripcion_confirmacionRecibido AS confirmacionrecibido_descripcion_confirmacionRecibido,"+ 

                                    "s.id_sede AS sede_id_sede,"+ 
                                    "s.nombre_sede AS sede_nombre_sede,"+ 
                                    "s.id_estadoSede AS sede_id_estadoSede,"+ 

                                    "es.id_estadoSede AS estadosede_id_estadoSede,"+ 
                                    "es.descripcion_estadoSede AS estadosede_descripcion_estadoSede,"+ 

                                    "u.id_usuario AS usuario_id_usuario,"+ 
                                    "u.nombre_usuario AS usuario_nombre_usuario,"+ 
                                    "u.apellido_usuario AS usuario_apellido_usuario,"+ 
                                    "u.mail_usuario AS usuario_mail_usuario,"+ 
                                    "u.id_estadoUsuario AS usuario_id_estadoUsuario "+ 

                                    " FROM `radicado_facturas_vg`.documento d "+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoDocumento ed  ON ed.id_estadoDocumento = d.id_estadoDocumento"+ 
                                            " INNER JOIN `radicado_facturas_vg`.proveedor p  ON p.nit_proveedor = d.nit_proveedor"+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoProveedor ep  ON ep.id_estadoProveedor = p.id_estadoProveedor"+ 
                                            " INNER JOIN `radicado_facturas_vg`.empresa e  ON e.nit_empresa = d.nit_empresa"+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoEmpresa ee  ON ee.id_estadoEmpresa = e.id_estadoEmpresa"+ 
                                            " INNER JOIN `radicado_facturas_vg`.historicoDocumento h  ON h.id_documento = d.id_documento"+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoHistorico eh  ON eh.id_estadoHistorico = h.id_estadoHistorico"+ 
                                            " INNER JOIN `radicado_facturas_vg`.confirmacionRecibido c  ON c.id_confirmacionRecibido = h.id_confirmacionRecibido"+ 
                                            " INNER JOIN `radicado_facturas_vg`.sede s  ON s.id_sede = d.id_sede"+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoSede es  ON es.id_estadoSede = s.id_estadoSede"+ 
                                            " INNER JOIN `radicado_facturas_vg`.usuario u  ON u.id_usuario = d.id_usuario WHERE d.nit_empresa ='"+nitEmpresa+"' ORDER BY h.id_historicoDocumento ASC;");      
            while(resultSet.next()){ 
                ConsultaGeneralInforme consultaGeneralInforme = new ConsultaGeneralInforme();
                consultaGeneralInforme.setDocumento_id_documento(resultSet.getString(1));
                consultaGeneralInforme.setDocumento_numFactura_documento(resultSet.getString(2));
                consultaGeneralInforme.setDocumento_nit_proveedor(resultSet.getString(3));
                consultaGeneralInforme.setDocumento_observacion_documento(resultSet.getString(4));
                consultaGeneralInforme.setDocumento_id_estadoDocumento(resultSet.getString(5));
                consultaGeneralInforme.setDocumento_id_usuario(resultSet.getString(6));
                consultaGeneralInforme.setDocumento_nit_empresa(resultSet.getString(7));
                consultaGeneralInforme.setDocumento_id_sede(resultSet.getString(8));
                consultaGeneralInforme.setDocumento_fechaAnulacion_documento(resultSet.getString(9));
                consultaGeneralInforme.setDocumento_observacionAnulacion_documento(resultSet.getString(10));
                consultaGeneralInforme.setEstadodocumento_id_estadoDocumento(resultSet.getString(11));
                consultaGeneralInforme.setEstadodocumento_descripcion_estadoDocumento(resultSet.getString(12));
                consultaGeneralInforme.setProveedor_nit_proveedor(resultSet.getString(13));
                consultaGeneralInforme.setProveedor_dig_proveedor(resultSet.getString(14));
                consultaGeneralInforme.setProveedor_nombre_proveedor(resultSet.getString(15));
                consultaGeneralInforme.setProveedor_correo_proveedor(resultSet.getString(16));
                consultaGeneralInforme.setProveedor_telefono_proveedor(resultSet.getString(17));
                consultaGeneralInforme.setProveedor_id_estadoProveedor(resultSet.getString(18));
                consultaGeneralInforme.setEstadoProveedor_id_estadoProveedor(resultSet.getString(19));
                consultaGeneralInforme.setEstadoProveedor_descripcion_estadoProveedor(resultSet.getString(20));
                consultaGeneralInforme.setEmpresa_nit_empresa(resultSet.getString(21));
                consultaGeneralInforme.setEmpresa_dig_empresa(resultSet.getString(22));
                consultaGeneralInforme.setEmpresa_nombre_empresa(resultSet.getString(23));
                consultaGeneralInforme.setEmpresa_correo_empresa(resultSet.getString(24));
                consultaGeneralInforme.setEmpresa_telefono_empresa(resultSet.getString(25));
                consultaGeneralInforme.setEmpresa_id_estadoEmpresa(resultSet.getString(26));
                consultaGeneralInforme.setEstadoempresa_id_estadoEmpresa(resultSet.getString(27));
                consultaGeneralInforme.setEstadoempresa_descripcion_estadoEmpresa(resultSet.getString(28));
                consultaGeneralInforme.setHistoricodocumento_id_historicoDocumento(resultSet.getString(29));
                consultaGeneralInforme.setHistoricodocumento_id_documento(resultSet.getString(30));
                consultaGeneralInforme.setHistoricodocumento_usuarioRegistro_historicoDocumento(resultSet.getString(31));
                consultaGeneralInforme.setHistoricodocumento_usuarioDestino_historicoDocumento(resultSet.getString(32));
                consultaGeneralInforme.setHistoricodocumento_observacion_historicoDocumento(resultSet.getString(33));
                consultaGeneralInforme.setHistoricodocumento_fechaRegistro_historicoDocumento(resultSet.getString(34));
                consultaGeneralInforme.setHistoricodocumento_id_estadoHistorico(resultSet.getString(35));
                consultaGeneralInforme.setHistoricodocumento_id_confirmacionRecibido(resultSet.getString(36));
                consultaGeneralInforme.setEstadohistorico_id_estadoHistorico(resultSet.getString(37));
                consultaGeneralInforme.setEstadohistorico_descripcion_estadoHistorico(resultSet.getString(38));
                consultaGeneralInforme.setConfirmacionrecibido_id_confirmacionRecibido(resultSet.getString(39));
                consultaGeneralInforme.setConfirmacionrecibido_descripcion_confirmacionRecibido(resultSet.getString(40));
                consultaGeneralInforme.setSede_id_sede(resultSet.getString(41));
                consultaGeneralInforme.setSede_nombre_sede(resultSet.getString(42));
                consultaGeneralInforme.setSede_id_estadoSede(resultSet.getString(43));
                consultaGeneralInforme.setEstadosede_id_estadoSede(resultSet.getString(44));
                consultaGeneralInforme.setEstadosede_descripcion_estadoSede(resultSet.getString(45));
                consultaGeneralInforme.setUsuario_id_usuario(resultSet.getString(46));
                consultaGeneralInforme.setUsuario_nombre_usuario(resultSet.getString(47));
                consultaGeneralInforme.setUsuario_apellido_usuario(resultSet.getString(48));
                consultaGeneralInforme.setUsuario_mail_usuario(resultSet.getString(49));
                consultaGeneralInforme.setUsuario_id_estadoUsuario(resultSet.getString(50));
               listadoConsultaGeneralInforme.add(consultaGeneralInforme);    
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar Radicacion");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoConsultaGeneralInforme;
    } 	
    public ArrayList<ConsultaGeneralInforme>  Informe_Proveedor(String nitProveedor) throws SQLException{//Recibe un parametro y realiza una consulta en General       
        ArrayList<ConsultaGeneralInforme> listadoConsultaGeneralInforme=new ArrayList();
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
                
            resultSet = statement.executeQuery("SELECT "+ 
                                    "d.id_documento AS documento_id_documento,"+ 
                                    "d.numFactura_documento AS documento_numFactura_documento,"+ 
                                    "d.nit_proveedor AS documento_nit_proveedor,"+ 
                                    "d.observacion_documento AS documento_observacion_documento,"+ 
                                    "d.id_estadoDocumento AS documento_id_estadoDocumento,"+ 
                                    "d.id_usuario AS documento_id_usuario,"+ 
                                    "d.nit_empresa AS documento_nit_empresa,"+ 
                                    "d.id_sede AS documento_id_sede,"+ 
                                    "d.fechaAnulacion_documento AS documento_fechaAnulacion_documento,"+ 
                                    "d.observacionAnulacion_documento AS documento_observacionAnulacion_documento,"+ 

                                    "ed.id_estadoDocumento AS estadodocumento_id_estadoDocumento,"+ 
                                    "ed.descripcion_estadoDocumento AS estadodocumento_descripcion_estadoDocumento,"+ 

                                    "p.nit_proveedor AS proveedor_nit_proveedor,"+ 
                                    "p.dig_proveedor AS proveedor_dig_proveedor,"+ 
                                    "p.nombre_proveedor AS proveedor_nombre_proveedor,"+ 
                                    "p.correo_proveedor AS proveedor_correo_proveedor,"+ 
                                    "p.telefono_proveedor AS proveedor_telefono_proveedor,"+ 
                                    "p.id_estadoProveedor AS proveedor_id_estadoProveedor,"+ 

                                    "ep.id_estadoProveedor AS estadoProveedor_id_estadoProveedor,"+ 
                                    "ep.descripcion_estadoProveedor AS estadoProveedor_descripcion_estadoProveedor,"+ 

                                    "e.nit_empresa AS empresa_nit_empresa,"+ 
                                    "e.dig_empresa AS empresa_dig_empresa,"+ 
                                    "e.nombre_empresa AS empresa_nombre_empresa,"+ 
                                    "e.correo_empresa AS empresa_correo_empresa,"+ 
                                    "e.telefono_empresa AS empresa_telefono_empresa,"+ 
                                    "e.id_estadoEmpresa AS empresa_id_estadoEmpresa,"+ 

                                    "ee.id_estadoEmpresa AS estadoempresa_id_estadoEmpresa,"+ 
                                    "ee.descripcion_estadoEmpresa AS estadoempresa_descripcion_estadoEmpresa,"+ 

                                    "h.id_historicoDocumento AS historicodocumento_id_historicoDocumento,"+ 
                                    "h.id_documento AS historicodocumento_id_documento,"+ 
                                    "h.usuarioRegistro_historicoDocumento AS historicodocumento_usuarioRegistro_historicoDocumento,"+ 
                                    "h.usuarioDestino_historicoDocumento AS historicodocumento_usuarioDestino_historicoDocumento,"+ 
                                    "h.observacion_historicoDocumento AS historicodocumento_observacion_historicoDocumento,"+ 
                                    "h.fechaRegistro_historicoDocumento AS historicodocumento_fechaRegistro_historicoDocumento,"+ 
                                    "h.id_estadoHistorico AS historicodocumento_id_estadoHistorico,"+ 
                                    "h.id_confirmacionRecibido AS historicodocumento_id_confirmacionRecibido,"+ 

                                    "eh.id_estadoHistorico AS estadohistorico_id_estadoHistorico,"+ 
                                    "eh.descripcion_estadoHistorico AS estadohistorico_descripcion_estadoHistorico,"+ 

                                    "c.id_confirmacionRecibido AS confirmacionrecibido_id_confirmacionRecibido,"+ 
                                    "c.descripcion_confirmacionRecibido AS confirmacionrecibido_descripcion_confirmacionRecibido,"+ 

                                    "s.id_sede AS sede_id_sede,"+ 
                                    "s.nombre_sede AS sede_nombre_sede,"+ 
                                    "s.id_estadoSede AS sede_id_estadoSede,"+ 

                                    "es.id_estadoSede AS estadosede_id_estadoSede,"+ 
                                    "es.descripcion_estadoSede AS estadosede_descripcion_estadoSede,"+ 

                                    "u.id_usuario AS usuario_id_usuario,"+ 
                                    "u.nombre_usuario AS usuario_nombre_usuario,"+ 
                                    "u.apellido_usuario AS usuario_apellido_usuario,"+ 
                                    "u.mail_usuario AS usuario_mail_usuario,"+ 
                                    "u.id_estadoUsuario AS usuario_id_estadoUsuario "+ 

                                    " FROM `radicado_facturas_vg`.documento d "+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoDocumento ed  ON ed.id_estadoDocumento = d.id_estadoDocumento"+ 
                                            " INNER JOIN `radicado_facturas_vg`.proveedor p  ON p.nit_proveedor = d.nit_proveedor"+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoProveedor ep  ON ep.id_estadoProveedor = p.id_estadoProveedor"+ 
                                            " INNER JOIN `radicado_facturas_vg`.empresa e  ON e.nit_empresa = d.nit_empresa"+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoEmpresa ee  ON ee.id_estadoEmpresa = e.id_estadoEmpresa"+ 
                                            " INNER JOIN `radicado_facturas_vg`.historicoDocumento h  ON h.id_documento = d.id_documento"+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoHistorico eh  ON eh.id_estadoHistorico = h.id_estadoHistorico"+ 
                                            " INNER JOIN `radicado_facturas_vg`.confirmacionRecibido c  ON c.id_confirmacionRecibido = h.id_confirmacionRecibido"+ 
                                            " INNER JOIN `radicado_facturas_vg`.sede s  ON s.id_sede = d.id_sede"+ 
                                            " INNER JOIN `radicado_facturas_vg`.estadoSede es  ON es.id_estadoSede = s.id_estadoSede"+ 
                                            " INNER JOIN `radicado_facturas_vg`.usuario u  ON u.id_usuario = d.id_usuario WHERE d.nit_proveedor ='"+nitProveedor+"' ORDER BY h.id_historicoDocumento ASC;");      
            while(resultSet.next()){ 
                ConsultaGeneralInforme consultaGeneralInforme = new ConsultaGeneralInforme();
                consultaGeneralInforme.setDocumento_id_documento(resultSet.getString(1));
                consultaGeneralInforme.setDocumento_numFactura_documento(resultSet.getString(2));
                consultaGeneralInforme.setDocumento_nit_proveedor(resultSet.getString(3));
                consultaGeneralInforme.setDocumento_observacion_documento(resultSet.getString(4));
                consultaGeneralInforme.setDocumento_id_estadoDocumento(resultSet.getString(5));
                consultaGeneralInforme.setDocumento_id_usuario(resultSet.getString(6));
                consultaGeneralInforme.setDocumento_nit_empresa(resultSet.getString(7));
                consultaGeneralInforme.setDocumento_id_sede(resultSet.getString(8));
                consultaGeneralInforme.setDocumento_fechaAnulacion_documento(resultSet.getString(9));
                consultaGeneralInforme.setDocumento_observacionAnulacion_documento(resultSet.getString(10));
                consultaGeneralInforme.setEstadodocumento_id_estadoDocumento(resultSet.getString(11));
                consultaGeneralInforme.setEstadodocumento_descripcion_estadoDocumento(resultSet.getString(12));
                consultaGeneralInforme.setProveedor_nit_proveedor(resultSet.getString(13));
                consultaGeneralInforme.setProveedor_dig_proveedor(resultSet.getString(14));
                consultaGeneralInforme.setProveedor_nombre_proveedor(resultSet.getString(15));
                consultaGeneralInforme.setProveedor_correo_proveedor(resultSet.getString(16));
                consultaGeneralInforme.setProveedor_telefono_proveedor(resultSet.getString(17));
                consultaGeneralInforme.setProveedor_id_estadoProveedor(resultSet.getString(18));
                consultaGeneralInforme.setEstadoProveedor_id_estadoProveedor(resultSet.getString(19));
                consultaGeneralInforme.setEstadoProveedor_descripcion_estadoProveedor(resultSet.getString(20));
                consultaGeneralInforme.setEmpresa_nit_empresa(resultSet.getString(21));
                consultaGeneralInforme.setEmpresa_dig_empresa(resultSet.getString(22));
                consultaGeneralInforme.setEmpresa_nombre_empresa(resultSet.getString(23));
                consultaGeneralInforme.setEmpresa_correo_empresa(resultSet.getString(24));
                consultaGeneralInforme.setEmpresa_telefono_empresa(resultSet.getString(25));
                consultaGeneralInforme.setEmpresa_id_estadoEmpresa(resultSet.getString(26));
                consultaGeneralInforme.setEstadoempresa_id_estadoEmpresa(resultSet.getString(27));
                consultaGeneralInforme.setEstadoempresa_descripcion_estadoEmpresa(resultSet.getString(28));
                consultaGeneralInforme.setHistoricodocumento_id_historicoDocumento(resultSet.getString(29));
                consultaGeneralInforme.setHistoricodocumento_id_documento(resultSet.getString(30));
                consultaGeneralInforme.setHistoricodocumento_usuarioRegistro_historicoDocumento(resultSet.getString(31));
                consultaGeneralInforme.setHistoricodocumento_usuarioDestino_historicoDocumento(resultSet.getString(32));
                consultaGeneralInforme.setHistoricodocumento_observacion_historicoDocumento(resultSet.getString(33));
                consultaGeneralInforme.setHistoricodocumento_fechaRegistro_historicoDocumento(resultSet.getString(34));
                consultaGeneralInforme.setHistoricodocumento_id_estadoHistorico(resultSet.getString(35));
                consultaGeneralInforme.setHistoricodocumento_id_confirmacionRecibido(resultSet.getString(36));
                consultaGeneralInforme.setEstadohistorico_id_estadoHistorico(resultSet.getString(37));
                consultaGeneralInforme.setEstadohistorico_descripcion_estadoHistorico(resultSet.getString(38));
                consultaGeneralInforme.setConfirmacionrecibido_id_confirmacionRecibido(resultSet.getString(39));
                consultaGeneralInforme.setConfirmacionrecibido_descripcion_confirmacionRecibido(resultSet.getString(40));
                consultaGeneralInforme.setSede_id_sede(resultSet.getString(41));
                consultaGeneralInforme.setSede_nombre_sede(resultSet.getString(42));
                consultaGeneralInforme.setSede_id_estadoSede(resultSet.getString(43));
                consultaGeneralInforme.setEstadosede_id_estadoSede(resultSet.getString(44));
                consultaGeneralInforme.setEstadosede_descripcion_estadoSede(resultSet.getString(45));
                consultaGeneralInforme.setUsuario_id_usuario(resultSet.getString(46));
                consultaGeneralInforme.setUsuario_nombre_usuario(resultSet.getString(47));
                consultaGeneralInforme.setUsuario_apellido_usuario(resultSet.getString(48));
                consultaGeneralInforme.setUsuario_mail_usuario(resultSet.getString(49));
                consultaGeneralInforme.setUsuario_id_estadoUsuario(resultSet.getString(50));
               listadoConsultaGeneralInforme.add(consultaGeneralInforme);    
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar Radicacion");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoConsultaGeneralInforme;
    } 	
}
