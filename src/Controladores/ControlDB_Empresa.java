package Controladores;
     
import Modelos.Empresa;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlDB_Empresa {
    private Connection conexion=null;
    private ControlDB_DB control=null;    
    
    public ControlDB_Empresa() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();       
    }
    public int registrarProveedores(Empresa emp, boolean esPersonaNatural) throws FileNotFoundException, SQLException{ //esPersonaNatural = true entonces no se registra digito de verificacion  
        Connection conexion= control.ConectarBaseDatos();
        int result=0;
         try{
            PreparedStatement r= conexion.prepareStatement("INSERT INTO `radicado_facturas_vg`.`empresa` (`nit_empresa`, `dig_empresa`, `nombre_empresa`, `correo_empresa`, `telefono_empresa`, `id_estadoEmpresa`) VALUES ('"+emp.getNit_empresa()+"', '"+emp.getDig_empresa()+"', '"+emp.getNombre_empresa()+"',"
                                                     + " '"+emp.getCorreo_empresa()+"', '"+emp.getTelefono_empresa()+"', '"+emp.getId_estadoEmpresa()+"');");
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
    public ArrayList<Empresa> buscarEmpresa(String valorConsulta) throws SQLException{
        ArrayList<Empresa> listadoEmpresa = new ArrayList();
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
            if(valorConsulta.equals("")){
                resultSet= statement.executeQuery("SELECT * FROM `radicado_facturas_vg`.`empresa`;");
            }else{
                resultSet = statement.executeQuery("SELECT * FROM `radicado_facturas_vg`.empresa WHERE (nit_empresa like '%"+valorConsulta+"%' or nombre_empresa like '%"+valorConsulta+"%');");      
            }
            while(resultSet.next()){ 
                Empresa emp = new Empresa(); 
                emp.setNit_empresa(resultSet.getString(1));
                emp.setDig_empresa(resultSet.getString(2));
                emp.setNombre_empresa(resultSet.getString(3));
                emp.setCorreo_empresa(resultSet.getString(4));
                emp.setTelefono_empresa(resultSet.getString(5));
                emp.setId_estadoEmpresa(Integer.parseInt(resultSet.getString(6)));
                listadoEmpresa.add(emp);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoEmpresa;
    } 
    public Empresa consultarEmpresaID(Empresa emp) throws SQLException{
        control.ConectarBaseDatos();
        Statement statement = null;
        Empresa empre = null;   
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = null;
            resultSet = statement.executeQuery("SELECT * FROM `radicado_facturas_vg`.empresa WHERE nit_empresa='"+emp.getNit_empresa()+"';");  
            while(resultSet.next()){  
                empre= new Empresa();
                empre.setNit_empresa(resultSet.getString(1));
                empre.setDig_empresa(resultSet.getString(2));
                empre.setNombre_empresa(resultSet.getString(3));
                empre.setCorreo_empresa(resultSet.getString(4));
                empre.setTelefono_empresa(resultSet.getString(5));
                empre.setId_estadoEmpresa(Integer.parseInt(resultSet.getString(6)));                  
            }  
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return empre;
    } 
    public String convertidorEstadoID_x_Nombre(int id){
        if(id == 0){
            return "Inactivo";
        }else{
            return "Activo";
        }
    } 
    public int actualizarEmpresa( Empresa c) throws FileNotFoundException{
        control.ConectarBaseDatos();
        int result=0;
        try{
            PreparedStatement r= conexion.prepareStatement("UPDATE `radicado_facturas_vg`.`empresa` SET `nombre_empresa` = '"+c.getNombre_empresa()+"', `correo_empresa` = '"+c.getCorreo_empresa()+"'," +
                                                            "`telefono_empresa` = '"+c.getTelefono_empresa()+"', `id_estadoEmpresa`='"+c.getId_estadoEmpresa()+"' WHERE `empresa`.`nit_empresa` = '"+c.getNit_empresa()+"';");
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
  
}
