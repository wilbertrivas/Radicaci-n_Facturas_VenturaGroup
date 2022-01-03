package Vistas;
 
import Controladores.ControlDB_Radicacion;
import Controladores.ImpresionRadicado;
import Modelos.Consultas.ConsultaGeneralInforme;
import Modelos.Consultas.ImprimirRadicacion;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Reportes.Generar_Reportes;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Radicacion_Reimprimir extends javax.swing.JPanel {
    DefaultTableModel modelo;
    String datos;
    String [] titulo= {"idDocumento", "No. Factura","Nit_Proveedor", "Nombre_Proveedor", "IdHistorico","EstadoHistorico","Usuario_Registra","Empresa_Destino","Sede","Fecha_Registro",};
    String [] registro;   
    
    public Radicacion_Reimprimir() {
        initComponents();      
        try {          
            tabla(valorBusqueda.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Radicacion_Reimprimir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Reimprimir1 = new javax.swing.JPopupMenu();
        Reimprimir = new javax.swing.JMenuItem();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        valorBusqueda = new javax.swing.JTextField();
        listar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        limpiar = new javax.swing.JButton();
        listar1 = new javax.swing.JButton();

        Reimprimir.setText("REIMPRIMIR");
        Reimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReimprimirActionPerformed(evt);
            }
        });
        Reimprimir1.add(Reimprimir);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("CONSULTAR RADICACIÓN");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 430, 30));

        jLabel7.setFont(new java.awt.Font("Tekton Pro", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Buscar por: id_documento, numFactura_documento");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 380, 20));

        valorBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                valorBusquedaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                valorBusquedaKeyReleased(evt);
            }
        });
        add(valorBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 200, 30));

        listar.setBackground(new java.awt.Color(255, 255, 255));
        listar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        listar.setForeground(new java.awt.Color(102, 102, 102));
        listar.setText("LISTAR");
        listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarActionPerformed(evt);
            }
        });
        add(listar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 150, 30));

        tabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabla.setBackground(new java.awt.Color(153, 204, 255));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla.setComponentPopupMenu(Reimprimir1);
        tabla.setFocusable(false);
        tabla.setGridColor(new java.awt.Color(255, 255, 255));
        tabla.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1420, 510));

        limpiar.setBackground(new java.awt.Color(255, 255, 255));
        limpiar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiar.setForeground(new java.awt.Color(102, 102, 102));
        limpiar.setText("LIMPIAR");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 150, 30));

        listar1.setBackground(new java.awt.Color(255, 255, 255));
        listar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        listar1.setForeground(new java.awt.Color(102, 102, 102));
        listar1.setText("GENERAR DOCUMENTO");
        listar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listar1ActionPerformed(evt);
            }
        });
        add(listar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 190, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarActionPerformed
        try {
            tabla("");
        } catch (SQLException ex) {
            Logger.getLogger(Radicacion_Reimprimir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        valorBusqueda.setText("");
    }//GEN-LAST:event_limpiarActionPerformed

    private void valorBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorBusquedaKeyPressed
       
    }//GEN-LAST:event_valorBusquedaKeyPressed

    private void ReimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReimprimirActionPerformed
        // TODO lo del clik derechoo
        int fila1;
        String buscar="";
        try{
            fila1=tabla.getSelectedRow();
            if(fila1==-1){
                JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
            }
            else{
                modelo=(DefaultTableModel)tabla.getModel();
                String idDocumento=(String)modelo.getValueAt(fila1, 0);
                ControlDB_Radicacion controlDB_Radicacion = new ControlDB_Radicacion();
                ImprimirRadicacion imprimirRadicacion=controlDB_Radicacion.buscarRadicacionParaImpresion(idDocumento);
                ImpresionRadicado imp = new ImpresionRadicado();
                imp.imprimirRadicado(imprimirRadicacion);  
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_ReimprimirActionPerformed

    private void listar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listar1ActionPerformed
        Generar_Reportes gr = new Generar_Reportes();
        gr.generarInformeGeneral("%"+valorBusqueda.getText()+"%");
    }//GEN-LAST:event_listar1ActionPerformed

    private void valorBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorBusquedaKeyReleased
        try {
            //Eliminamos la Busqueda Actual#######################################################
            DefaultTableModel md =(DefaultTableModel)tabla.getModel();
            int CantEliminar= tabla.getRowCount() -1;
            for(int i =CantEliminar; i>=0; i--){
                md.removeRow(i);
            }
            tabla(valorBusqueda.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Radicacion_Reimprimir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_valorBusquedaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Reimprimir;
    private javax.swing.JPopupMenu Reimprimir1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar;
    private javax.swing.JButton listar;
    private javax.swing.JButton listar1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField valorBusqueda;
    // End of variables declaration//GEN-END:variables
    public void tabla(String valorConsulta) throws SQLException{
        registro = new String[10]; 
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_Radicacion c = new ControlDB_Radicacion();
        ArrayList<ConsultaGeneralInforme> listadoConsultaGeneralInforme=c.consultarRadicacion(valorConsulta);
        
        for(int i =0; i< listadoConsultaGeneralInforme.size(); i++){
            registro[0]=""+listadoConsultaGeneralInforme.get(i).getDocumento_id_documento();
            registro[1]=""+listadoConsultaGeneralInforme.get(i).getDocumento_numFactura_documento();
            registro[2]=""+listadoConsultaGeneralInforme.get(i).getDocumento_nit_proveedor();
            registro[3]=""+listadoConsultaGeneralInforme.get(i).getProveedor_nombre_proveedor();
            registro[4]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_id_historicoDocumento();
            registro[5]=""+listadoConsultaGeneralInforme.get(i).getEstadohistorico_descripcion_estadoHistorico();
            registro[6]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_usuarioRegistro_historicoDocumento();
            registro[7]=""+listadoConsultaGeneralInforme.get(i).getEmpresa_nombre_empresa();
            registro[8]=""+listadoConsultaGeneralInforme.get(i).getSede_nombre_sede();
            registro[9]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_fechaRegistro_historicoDocumento();
            modelo.addRow(registro);
            tabla.setModel(modelo);
        }
    }
   
}
