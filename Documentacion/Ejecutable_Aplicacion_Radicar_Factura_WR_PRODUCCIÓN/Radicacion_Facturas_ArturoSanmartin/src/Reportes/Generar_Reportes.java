
package Reportes;
 
import Controladores.ControlDB_DB;
import java.awt.Frame;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
 

public class Generar_Reportes {
    public void generarReporteEmpresa(){
        try{
            JasperReport reporte = (JasperReport) JRLoader.loadObject("src//Reportes//Empresa//Reporte_Empresa_ListadoEmpresa.jasper");
            ControlDB_DB control = new ControlDB_DB();
            JasperPrint j = JasperFillManager.fillReport(reporte, null, control.ConectarBaseDatos());
            JasperViewer jv = new  JasperViewer(j,false);  
            jv.setTitle("Reporte Compañias");
            jv.setExtendedState(Frame.MAXIMIZED_BOTH);
            jv.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al Mostrar Reporte"+e);
        }
    }
    public void generarReporteProveedor(){
        try{
            JasperReport reporte = (JasperReport) JRLoader.loadObject("src//Reportes//Proveedor//Reporte_Proveedor_ListadoProveedor.jasper");
            ControlDB_DB control = new ControlDB_DB();
            JasperPrint j = JasperFillManager.fillReport(reporte, null, control.ConectarBaseDatos());
            JasperViewer jv = new  JasperViewer(j,false);  
            jv.setTitle("Reporte Proveedores");
            jv.setExtendedState(Frame.MAXIMIZED_BOTH);
            jv.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al Mostrar Reporte"+e);
        }
    }
    public void generarInformeGeneral(String valorD) { 
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//Informes//Informe_General.jasper";
            Map parametros = new HashMap<String, String>();
            parametros.put("valor", valorD);          
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("INFORME GENERAL");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }   
    public void generarInformeFecha(String fechaIni, String fechaFin) { 
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//Informes//Informe_FechaRegistro.jasper";
            Map parametros = new HashMap<String, String>();
            parametros.put("fechaIni", fechaIni);          
            parametros.put("fechaFin", fechaFin);          
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("INFORME GENERAL");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }   
    public void generarInformeEmpresa(String nitEmpresa) { 
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//Informes//Informe_Empresa.jasper";
            Map parametros = new HashMap<String, String>();
            parametros.put("nitEmpresa", nitEmpresa);          
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("INFORME GENERAL");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }   
     public void generarInformeProveedor(String nitProveedor) { 
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//Informes//Informe_Proveedor.jasper";
            Map parametros = new HashMap<String, String>();
            parametros.put("nitProveedor", nitProveedor);          
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("INFORME GENERAL");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }  
}
