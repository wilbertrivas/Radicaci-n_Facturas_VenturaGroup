package Controladores;
  
import Modelos.Proveedor;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlDB_Proveedor {
    private Connection conexion=null;
    private ControlDB_DB control=null;    
    
    public ControlDB_Proveedor() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();       
    }
    public int registrarProveedores(Proveedor p, boolean esPersonaNatural) throws FileNotFoundException, SQLException{ //esPersonaNatural = true entonces no se registra digito de verificacion
        
        Connection conexion= control.ConectarBaseDatos();
        int result=0;
         try{
            if(esPersonaNatural){
                PreparedStatement r= conexion.prepareStatement("INSERT INTO `radicado_facturas_vg`.`proveedor` (`nit_proveedor`, `dig_proveedor`, `nombre_proveedor`, `correo_proveedor`, `telefono_proveedor`, `id_estadoProveedor`) VALUES ('"+p.getNit_proveedor()+"', NULL, '"+p.getNombre_proveedor()+"',"
                                                         + " '"+p.getCorreo_proveedor()+"', '"+p.getTelefono_proveedor()+"', '"+p.getId_estadoProveedor()+"');");
                r.execute();
                result=1;  
            }else{//No es persona Natural
                PreparedStatement r= conexion.prepareStatement("INSERT INTO `radicado_facturas_vg`.`proveedor` (`nit_proveedor`, `dig_proveedor`, `nombre_proveedor`, `correo_proveedor`, `telefono_proveedor`, `id_estadoProveedor`) VALUES ('"+p.getNit_proveedor()+"', '"+p.getDig_proveedor()+"', '"+p.getNombre_proveedor()+"',"
                                                         + " '"+p.getCorreo_proveedor()+"', '"+p.getTelefono_proveedor()+"', '"+p.getId_estadoProveedor()+"');");
                r.execute();
                result=1; 
            }
        }
        catch (SQLException sqlException ){   
            result=0;
            JOptionPane.showMessageDialog(null, "ERROR al querer insertar los datos.");
            sqlException.printStackTrace();
        }  
        control.cerrarConexionBaseDatos();
        return result;
    }   
    public ArrayList<Proveedor> buscarProveedor(String valorConsulta) throws SQLException{
        ArrayList<Proveedor> listadoProveedor = new ArrayList();
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
            if(valorConsulta.equals("")){
                resultSet= statement.executeQuery("SELECT * FROM `radicado_facturas_vg`.`proveedor`;");
            }else{
                resultSet = statement.executeQuery("SELECT * FROM `radicado_facturas_vg`.proveedor WHERE (nit_proveedor like '%"+valorConsulta+"%' or nombre_proveedor like '%"+valorConsulta+"%');");      
            }
            while(resultSet.next()){ 
                Proveedor prov = new Proveedor(); 
                prov.setNit_proveedor(resultSet.getString(1));
                prov.setDig_proveedor(resultSet.getString(2));
                prov.setNombre_proveedor(resultSet.getString(3));
                prov.setCorreo_proveedor(resultSet.getString(4));
                prov.setTelefono_proveedor(resultSet.getString(5));
                prov.setId_estadoProveedor(Integer.parseInt(resultSet.getString(6)));
                listadoProveedor.add(prov);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoProveedor;
    } 
    public Proveedor consultarProvedorID(Proveedor p) throws SQLException{
        control.ConectarBaseDatos();
        Statement statement = null;
        Proveedor prov=null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `radicado_facturas_vg`.proveedor WHERE nit_proveedor='"+p.getNit_proveedor()+"';");  
            while(resultSet.next()){  
                prov = new Proveedor();   
                prov.setNit_proveedor(resultSet.getString(1));
                prov.setDig_proveedor(resultSet.getString(2));
                prov.setNombre_proveedor(resultSet.getString(3));
                prov.setCorreo_proveedor(resultSet.getString(4));
                prov.setTelefono_proveedor(resultSet.getString(5));
                prov.setId_estadoProveedor(Integer.parseInt(resultSet.getString(6)));      
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return prov;
    } 
    public String convertidorEstadoID_x_Nombre(int id){
        if(id == 0){
            return "Inactivo";
        }else{
            return "Activo";
        }
    } 
    public int actualizarProveedor( Proveedor c) throws FileNotFoundException{
        control.ConectarBaseDatos();
        int result=0;
        try{
            PreparedStatement r= conexion.prepareStatement("UPDATE `radicado_facturas_vg`.`proveedor` SET `nombre_proveedor` = '"+c.getNombre_proveedor()+"', `correo_proveedor` = '"+c.getCorreo_proveedor()+"'," +
                                                            "`telefono_proveedor` = '"+c.getTelefono_proveedor()+"', `id_estadoProveedor`='"+c.getId_estadoProveedor()+"' WHERE `proveedor`.`nit_proveedor` = '"+c.getNit_proveedor()+"';");
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
