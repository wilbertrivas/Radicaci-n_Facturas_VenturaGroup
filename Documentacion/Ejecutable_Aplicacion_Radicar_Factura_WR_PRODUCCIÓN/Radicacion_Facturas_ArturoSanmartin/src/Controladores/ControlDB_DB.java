package Controladores; 
    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControlDB_DB {
    private Connection conexion=null;
    private String login="";
    private String pass="";
    private String ruta="";
    
    public ControlDB_DB(){
       this.login="root";
       this.pass="opp!2015";
       //this.ruta="jdbc:mysql://localhost/radicado_facturas";
       this.ruta="jdbc:mysql://172.30.200.80/radicado_facturas_vg";
    }
    public Connection ConectarBaseDatos(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion=DriverManager.getConnection(ruta,login,pass);
            if(conexion!=null) {
               return conexion;     
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se encuetra la Clase para conectar con SQLSERVER");
        }
        catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,  "Error al querer conectar con SQLSERVER");
        }
        finally{
            return conexion;
        }
    }
    public void cerrarConexionBaseDatos(){
        try{
            conexion.close();
        }
        catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cerrar la Conexion a la Base de Datos");
        }
    }
}
