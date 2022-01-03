package Controladores; 
  
import Modelos.Consultas.ConsultarDocumentosParaEnvios;
import Modelos.Proveedor;
import Modelos.Usuario;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlDB_Usuario {
    private Connection conexion=null;
    private  ControlDB_DB control=null;  

    public ControlDB_Usuario() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos(); 
    }
    public int registrarUsuario(Usuario u) throws FileNotFoundException{
        Connection conexion= control.ConectarBaseDatos();
        int result=0;
        try{  
            PreparedStatement r= conexion.prepareStatement("INSERT INTO `radicado_facturas_vg`.`usuario` (`id_usuario`, `nombre_usuario`, `apellido_usuario`, `mail_usuario`, `id_estadoUsuario`,`permisoRadicar_usuario`)"
                + " VALUES ('"+u.getId_usuario()+"', '"+u.getNombre_usuario()+"', '"+u.getApellido_usuario()+"', '"+u.getMail_usuario()+"', '"+u.getId_estadoUsuario()+"','"+u.getPermisoRadicar_usuario()+"');" );
                     
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
    
    public Usuario validarUsuario(String IdUsuario){
        control.ConectarBaseDatos();
        Statement statement = null;
        Usuario user = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `radicado_facturas_vg`.`usuario` WHERE id_usuario='"+IdUsuario+"' AND id_estadoUsuario=1 AND permisoRadicar_usuario=1");
            while(resultSet.next()){          
                user = new Usuario();
                user.setId_usuario(resultSet.getString(1));
                user.setNombre_usuario(resultSet.getString(2));
                user.setApellido_usuario((resultSet.getString(3)));
                user.setMail_usuario(resultSet.getString(4));
                user.setId_estadoUsuario(Integer.parseInt(resultSet.getString(5)));
                user.setPermisoRadicar_usuario(Integer.parseInt(resultSet.getString(6)));
            }
            return user;
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al consultar Usuario");
            sqlException.printStackTrace();
        } 
       control.cerrarConexionBaseDatos();
       return user;
    }
    
    public ArrayList<Usuario> buscarUsuario(String valorConsulta) throws SQLException{
        ArrayList<Usuario> listadoUsuario = new ArrayList();
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
            if(valorConsulta.equals("")){
                resultSet= statement.executeQuery("SELECT * FROM `radicado_facturas_vg`.usuario LIMIT 500;");
            }else{
                resultSet = statement.executeQuery("SELECT * FROM `radicado_facturas_vg`.usuario WHERE (id_usuario LIKE '%"+valorConsulta+"%' OR nombre_usuario LIKE '%"+valorConsulta+"%' OR apellido_usuario LIKE '%"+valorConsulta+"%' OR mail_usuario LIKE '%"+valorConsulta+"%') LIMIT 500;");      
            }
            while(resultSet.next()){ 
                Usuario usuario = new Usuario(); 
                usuario.setId_usuario(resultSet.getString(1));
                usuario.setNombre_usuario(resultSet.getString(2));
                usuario.setApellido_usuario(resultSet.getString(3));
                usuario.setMail_usuario(resultSet.getString(4));
                usuario.setId_estadoUsuario(Integer.parseInt(resultSet.getString(5)));         
                usuario.setPermisoRadicar_usuario(Integer.parseInt(resultSet.getString(6)));         
                listadoUsuario.add(usuario);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar Usuarios");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoUsuario;
    } 
    public ArrayList<Usuario> buscarUsuarioRadicar(String valorConsulta) throws SQLException{
        ArrayList<Usuario> listadoUsuario = new ArrayList();
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
            if(valorConsulta.equals("")){
                resultSet= statement.executeQuery("SELECT * FROM `radicado_facturas_vg`.usuario WHERE id_estadoUsuario= 1 LIMIT 500;");
                //resultSet= statement.executeQuery("SELECT * FROM `radicado_facturas_vg`.usuario  LIMIT 500;");
            }else{
                resultSet = statement.executeQuery("SELECT * FROM `radicado_facturas_vg`.usuario WHERE id_estadoUsuario=1 AND (id_usuario LIKE '%"+valorConsulta+"%' OR nombre_usuario LIKE '%"+valorConsulta+"%' OR apellido_usuario LIKE '%"+valorConsulta+"%' OR mail_usuario LIKE '%"+valorConsulta+"%') LIMIT 500;");      
                //resultSet = statement.executeQuery("SELECT * FROM `radicado_facturas_vg`.usuario WHERE (id_usuario LIKE '%"+valorConsulta+"%' OR nombre_usuario LIKE '%"+valorConsulta+"%' OR apellido_usuario LIKE '%"+valorConsulta+"%' OR mail_usuario LIKE '%"+valorConsulta+"%') LIMIT 500;");      
            
            }
            while(resultSet.next()){ 
                Usuario usuario = new Usuario(); 
                usuario.setId_usuario(resultSet.getString(1));
                usuario.setNombre_usuario(resultSet.getString(2));
                usuario.setApellido_usuario(resultSet.getString(3));
                usuario.setMail_usuario(resultSet.getString(4));
                usuario.setId_estadoUsuario(Integer.parseInt(resultSet.getString(5)));         
                usuario.setPermisoRadicar_usuario(Integer.parseInt(resultSet.getString(6)));         
                listadoUsuario.add(usuario);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar Usuarios");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoUsuario;
    } 
    public Usuario consultarUsuarioID(Usuario u) throws SQLException{
        control.ConectarBaseDatos();
        Statement statement = null;
        Usuario usu=null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `radicado_facturas_vg`.usuario WHERE id_usuario='"+ u.getId_usuario()+"';");  
            while(resultSet.next()){  
                usu = new Usuario();   
                usu.setId_usuario(resultSet.getString(1));
                usu.setNombre_usuario(resultSet.getString(2));
                usu.setApellido_usuario(resultSet.getString(3));
                usu.setMail_usuario(resultSet.getString(4));
                usu.setId_estadoUsuario(Integer.parseInt(resultSet.getString(5)));      
                usu.setPermisoRadicar_usuario(Integer.parseInt(resultSet.getString(6)));      
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return usu;
    } 
    public int actualizarUsuario( Usuario u) throws FileNotFoundException{
        control.ConectarBaseDatos();
        int result=0;
        try{
            PreparedStatement r= conexion.prepareStatement("UPDATE `radicado_facturas_vg`.`usuario` SET `nombre_usuario` = '"+u.getNombre_usuario()+"', `apellido_usuario` = '"+u.getApellido_usuario()+"'," +
                                                            "`mail_usuario` = '"+u.getMail_usuario()+"', `id_estadoUsuario`='"+u.getId_estadoUsuario()+"', `permisoRadicar_usuario`='"+u.getPermisoRadicar_usuario()+"' WHERE `usuario`.`id_usuario` = '"+u.getId_usuario()+"';");
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
     public String convertidorEstadoID_x_Nombre(int id){
        if(id == 0){
            return "Inactivo";
        }else{
            return "Activo";
        }
    }
}
