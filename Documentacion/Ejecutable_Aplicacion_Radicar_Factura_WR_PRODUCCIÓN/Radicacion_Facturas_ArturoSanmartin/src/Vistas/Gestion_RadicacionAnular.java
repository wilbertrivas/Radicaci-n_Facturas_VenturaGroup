package Vistas;
    
import Controladores.ControlDB_EnvioDocumento;
import Controladores.ControlDB_Radicacion;
import Controladores.ControlDB_Usuario;
import Controladores.EnviarConGmail;
import Controladores.TextPrompt;
import Modelos.Consultas.ConsultarDocumentosParaEnvios;
import Modelos.HistoricoDocumento;
import Modelos.Usuario;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Gestion_RadicacionAnular extends javax.swing.JPanel {
    Usuario user;
    
    public Gestion_RadicacionAnular(Usuario u) {
        initComponents();
        user=u;
        VentanaInternaBuscarDocumento.show(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SeleccionarDocumento = new javax.swing.JPopupMenu();
        Seleccionar = new javax.swing.JMenuItem();
        VentanaInternaBuscarDocumento = new javax.swing.JInternalFrame();
        buscarDocumento = new javax.swing.JTextField();
        ventanaInterna_Nombre = new javax.swing.JLabel();
        limpiarDocumento = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListadoBusquedaDocumento = new javax.swing.JTable();
        cancelarDocumento = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        documentoId = new javax.swing.JLabel();
        documentoNumFactura = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        documentoNitProveedor = new javax.swing.JLabel();
        documentoNombreProveedor = new javax.swing.JLabel();
        mensaje = new javax.swing.JLabel();
        Registrar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        observacion = new javax.swing.JTextArea();
        Registrar2 = new javax.swing.JButton();

        Seleccionar.setText("Seleccionar");
        Seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarActionPerformed(evt);
            }
        });
        SeleccionarDocumento.add(Seleccionar);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        VentanaInternaBuscarDocumento.setBackground(new java.awt.Color(255, 255, 255));
        VentanaInternaBuscarDocumento.setTitle("Titulo");
        VentanaInternaBuscarDocumento.setVisible(true);
        VentanaInternaBuscarDocumento.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscarDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarDocumentoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarDocumentoKeyReleased(evt);
            }
        });
        VentanaInternaBuscarDocumento.getContentPane().add(buscarDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 250, 25));

        ventanaInterna_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ventanaInterna_Nombre.setForeground(new java.awt.Color(102, 102, 102));
        ventanaInterna_Nombre.setText("BUSCAR DOCUMENTO");
        VentanaInternaBuscarDocumento.getContentPane().add(ventanaInterna_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, 210, 20));

        limpiarDocumento.setBackground(new java.awt.Color(255, 255, 255));
        limpiarDocumento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiarDocumento.setText("LIMPIAR");
        limpiarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarDocumentoActionPerformed(evt);
            }
        });
        VentanaInternaBuscarDocumento.getContentPane().add(limpiarDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 150, 30));

        ListadoBusquedaDocumento = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        ListadoBusquedaDocumento.setBackground(new java.awt.Color(153, 204, 255));
        ListadoBusquedaDocumento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        ListadoBusquedaDocumento.setComponentPopupMenu(SeleccionarDocumento);
        ListadoBusquedaDocumento.setFocusable(false);
        ListadoBusquedaDocumento.setGridColor(new java.awt.Color(0, 204, 204));
        ListadoBusquedaDocumento.setSelectionBackground(new java.awt.Color(255, 102, 102));
        ListadoBusquedaDocumento.getTableHeader().setReorderingAllowed(false);
        ListadoBusquedaDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ListadoBusquedaDocumentoKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(ListadoBusquedaDocumento);

        VentanaInternaBuscarDocumento.getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1260, 550));

        cancelarDocumento.setBackground(new java.awt.Color(255, 255, 255));
        cancelarDocumento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelarDocumento.setText("CANCELAR");
        cancelarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarDocumentoActionPerformed(evt);
            }
        });
        VentanaInternaBuscarDocumento.getContentPane().add(cancelarDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 150, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Img/Fondo.png"))); // NOI18N
        VentanaInternaBuscarDocumento.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 640));

        add(VentanaInternaBuscarDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 1300, 670));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("ID:");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 30, 25));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("NOMBRE PROVEEDOR:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, -1, 25));

        documentoId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        documentoId.setForeground(new java.awt.Color(102, 102, 102));
        add(documentoId, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 570, 25));

        documentoNumFactura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        documentoNumFactura.setForeground(new java.awt.Color(102, 102, 102));
        add(documentoNumFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 570, 25));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1020, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("ANULACIÓN DE DOCUMENTOS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 520, 40));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("No. FACTURA:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, 25));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("NIT PROVEEDOR:");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, 25));

        documentoNitProveedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        documentoNitProveedor.setForeground(new java.awt.Color(102, 102, 102));
        add(documentoNitProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 570, 25));

        documentoNombreProveedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        documentoNombreProveedor.setForeground(new java.awt.Color(102, 102, 102));
        add(documentoNombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 680, 25));

        mensaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mensaje.setForeground(new java.awt.Color(255, 0, 0));
        add(mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 740, 30));

        Registrar.setBackground(new java.awt.Color(255, 255, 255));
        Registrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Registrar.setForeground(new java.awt.Color(102, 102, 102));
        Registrar.setText("ANULAR");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });
        add(Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 130, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("MOTIVO DE ANULACIÓN:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 170, 30));

        observacion.setColumns(20);
        observacion.setRows(5);
        observacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                observacionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(observacion);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 580, 80));

        Registrar2.setBackground(new java.awt.Color(255, 255, 255));
        Registrar2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Registrar2.setForeground(new java.awt.Color(102, 102, 102));
        Registrar2.setText("CARGAR DOCUMENTO");
        Registrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registrar2ActionPerformed(evt);
            }
        });
        add(Registrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 180, 25));
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        if(documentoId.getText().equals("")){
           mensaje.setText("Debe cargar un documento Para Anularlo");
        }else{
            if(observacion.getText().equals("")){
                mensaje.setText("Debe Indicar el motivo de la Anulación.");
            }else{
                String idDocumentoD=documentoId.getText();
                String observacionD="Usuario: "+user.getId_usuario()+" Motivo: "+observacion.getText();

                ControlDB_Radicacion controlDB_Radicacion = new ControlDB_Radicacion();
                int validarAnulacion=0;
                try {
                    validarAnulacion = controlDB_Radicacion.AnularRadicacion(idDocumentoD, observacionD);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Gestion_RadicacionAnular.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(validarAnulacion==1){
                    JOptionPane.showMessageDialog(null, "ANULACION EXITOSA"); 
                    //Hacemos limpieza de datos en la interfaz.
                    documentoId.setText("");   
                    documentoNumFactura.setText("");
                    documentoNitProveedor.setText("");
                    documentoNombreProveedor.setText("");
                    observacion.setText("");                        
                }else{
                    JOptionPane.showMessageDialog(null, "Error al Anular Verifique datos");
                }
            }
        }
    }//GEN-LAST:event_RegistrarActionPerformed

    private void buscarDocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarDocumentoKeyPressed
      
    }//GEN-LAST:event_buscarDocumentoKeyPressed

    private void limpiarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarDocumentoActionPerformed
        buscarDocumento.setText("");
    }//GEN-LAST:event_limpiarDocumentoActionPerformed

    private void ListadoBusquedaDocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ListadoBusquedaDocumentoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListadoBusquedaDocumentoKeyPressed

    private void cancelarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarDocumentoActionPerformed
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)ListadoBusquedaDocumento.getModel();
        int CantEliminar= ListadoBusquedaDocumento.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
            md.removeRow(i);
        }
        buscarDocumento.setText("");
        VentanaInternaBuscarDocumento.show(false);
    }//GEN-LAST:event_cancelarDocumentoActionPerformed

    private void SeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarActionPerformed
        // TODO lo del clik derechoo
        DefaultTableModel modelo;
            int fila1;
            try{
                fila1=ListadoBusquedaDocumento.getSelectedRow();
                if(fila1==-1){
                    JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
                }
                else{
                    try{
                        modelo=(DefaultTableModel)ListadoBusquedaDocumento.getModel();
                        documentoId.setText((String)modelo.getValueAt(fila1, 0));
                        documentoNumFactura.setText((String)modelo.getValueAt(fila1, 1));
                        documentoNitProveedor.setText((String)modelo.getValueAt(fila1, 2));
                        documentoNombreProveedor.setText((String)modelo.getValueAt(fila1, 3));
                      
                        //Eliminamos la Busqueda Actual#######################################################
                        DefaultTableModel md =(DefaultTableModel)ListadoBusquedaDocumento.getModel();
                        int CantEliminar= ListadoBusquedaDocumento.getRowCount() -1;
                        for(int i =CantEliminar; i>=0; i--){
                            md.removeRow(i);
                        }
                        //######################################################################################
                        VentanaInternaBuscarDocumento.show(false);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "No se pudo cargar el Documento");
                    }
                }
            }catch(Exception e){
            }
        
    }//GEN-LAST:event_SeleccionarActionPerformed

    private void Registrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registrar2ActionPerformed
        VentanaInternaBuscarDocumento.show(true);
        TextPrompt placeholder = new TextPrompt("Buscar por Id, NumFactura, NombreProveedor:", buscarDocumento);       
        buscarDocumento.setText("");
        
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)ListadoBusquedaDocumento.getModel();
        int CantEliminar= ListadoBusquedaDocumento.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
           md.removeRow(i);
        }
        DefaultTableModel modelo;
        String [] titulo= {"ID","No FACTURA", "NIT_PROVEEDOR","NOMBRE_PROVEEDOR","USUARIO","NIT_EMPRESA","NOMBRE_EMPRESA","SEDE"};
        String [] registro = new String[8]; 
        modelo = new DefaultTableModel(null, titulo);
        ListadoBusquedaDocumento.setModel(modelo);
         try {
            BuscarEnVentanaInternaDocumentos("");
        } catch (SQLException ex) {
            Logger.getLogger(Gestion_RadicacionAnular.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_Registrar2ActionPerformed

    private void buscarDocumentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarDocumentoKeyReleased
         //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)ListadoBusquedaDocumento.getModel();
        int CantEliminar= ListadoBusquedaDocumento.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
           md.removeRow(i);
        }
        try {
            BuscarEnVentanaInternaDocumentos(buscarDocumento.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Gestion_RadicacionAnular.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarDocumentoKeyReleased

    private void observacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_observacionMouseClicked
        mensaje.setText("");
    }//GEN-LAST:event_observacionMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ListadoBusquedaDocumento;
    private javax.swing.JButton Registrar;
    private javax.swing.JButton Registrar2;
    private javax.swing.JMenuItem Seleccionar;
    private javax.swing.JPopupMenu SeleccionarDocumento;
    private javax.swing.JInternalFrame VentanaInternaBuscarDocumento;
    private javax.swing.JTextField buscarDocumento;
    private javax.swing.JButton cancelarDocumento;
    private javax.swing.JLabel documentoId;
    private javax.swing.JLabel documentoNitProveedor;
    private javax.swing.JLabel documentoNombreProveedor;
    private javax.swing.JLabel documentoNumFactura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton limpiarDocumento;
    private javax.swing.JLabel mensaje;
    private javax.swing.JTextArea observacion;
    private javax.swing.JLabel ventanaInterna_Nombre;
    // End of variables declaration//GEN-END:variables
    
    public void BuscarEnVentanaInternaDocumentos(String valorConsulta) throws SQLException{               
        DefaultTableModel modelo;
        String [] titulo= {"ID","No FACTURA", "NIT_PROVEEDOR","NOMBRE_PROVEEDOR","USUARIO","NIT_EMPRESA","NOMBRE_EMPRESA","SEDE"};
        String [] registro = new String[8]; 
        modelo = new DefaultTableModel(null, titulo);     
        ArrayList<ConsultarDocumentosParaEnvios> listadoDocumento=null;
        ControlDB_EnvioDocumento controlDB_Documento = new ControlDB_EnvioDocumento();
        listadoDocumento=controlDB_Documento.buscarDocumentoActivosPorUsuario(valorConsulta,user.getId_usuario());
        if(listadoDocumento !=null){
            for(int i =0; i< listadoDocumento.size(); i++){ 
                registro[0]=""+listadoDocumento.get(i).getId();
                registro[1]=""+listadoDocumento.get(i).getNumFactura();
                registro[2]=""+listadoDocumento.get(i).getNitProveedor();
                registro[3]=""+listadoDocumento.get(i).getNombreProveedor();
                registro[4]=""+listadoDocumento.get(i).getUsuario();
                registro[5]=""+listadoDocumento.get(i).getNitEmpresa();
                registro[6]=""+listadoDocumento.get(i).getNombreEmpresa();
                registro[7]=""+listadoDocumento.get(i).getSede();
                modelo.addRow(registro);
                ListadoBusquedaDocumento.setModel(modelo);
            }   
        }
    }
}
