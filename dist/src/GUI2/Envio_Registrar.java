package GUI2;
      
import Controladores.ControlDB_EnvioDocumento;
import Controladores.ControlDB_Radicacion;
import Controladores.ControlDB_Usuario;
import Controladores.EnviarConGmail;
import Controladores.TextPrompt;
import Modelos.Consultas.ConsultarDocumentosParaEnvios;
import Modelos.HistoricoDocumento;
import Modelos.Usuario;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Envio_Registrar extends javax.swing.JPanel {
    Usuario user;
    
    public Envio_Registrar(Usuario u) {
        initComponents();
        user=u;
        VentanaInternaBuscarDocumento.getContentPane().setBackground(Color.WHITE);
        VentanaInternaBuscarUsuario.getContentPane().setBackground(Color.WHITE);
        VentanaInternaBuscarDocumento.show(false);
        VentanaInternaBuscarUsuario.show(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SeleccionarDocumento = new javax.swing.JPopupMenu();
        Seleccionar = new javax.swing.JMenuItem();
        SeleccionarUsuario = new javax.swing.JPopupMenu();
        seleccionar = new javax.swing.JMenuItem();
        VentanaInternaBuscarUsuario = new javax.swing.JInternalFrame();
        buscarUsuario = new javax.swing.JTextField();
        ventanaInterna_Nombre1 = new javax.swing.JLabel();
        limpiarUsuarios = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        ListadoBusquedaUsuario = new javax.swing.JTable();
        cancelarUsuario = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
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
        usuario_correo = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        usuario_id = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        mensaje = new javax.swing.JLabel();
        Registrar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        observacion = new javax.swing.JTextArea();
        usuario_nombre = new javax.swing.JLabel();
        cargarUsuario = new javax.swing.JButton();
        cargarDocumento = new javax.swing.JButton();

        Seleccionar.setText("Seleccionar");
        Seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarActionPerformed(evt);
            }
        });
        SeleccionarDocumento.add(Seleccionar);

        seleccionar.setText("Seleccionar");
        seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarActionPerformed(evt);
            }
        });
        SeleccionarUsuario.add(seleccionar);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        VentanaInternaBuscarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        VentanaInternaBuscarUsuario.setTitle("LISTADO DE USUARIO");
        VentanaInternaBuscarUsuario.setVisible(false);
        VentanaInternaBuscarUsuario.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarUsuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarUsuarioKeyReleased(evt);
            }
        });
        VentanaInternaBuscarUsuario.getContentPane().add(buscarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 250, 25));

        ventanaInterna_Nombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ventanaInterna_Nombre1.setForeground(new java.awt.Color(102, 102, 102));
        ventanaInterna_Nombre1.setText("BUSCAR USUARIOS");
        VentanaInternaBuscarUsuario.getContentPane().add(ventanaInterna_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, -1));

        limpiarUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        limpiarUsuarios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiarUsuarios.setText("LIMPIAR");
        limpiarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarUsuariosActionPerformed(evt);
            }
        });
        VentanaInternaBuscarUsuario.getContentPane().add(limpiarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 150, 30));

        ListadoBusquedaUsuario = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        ListadoBusquedaUsuario.setBackground(new java.awt.Color(153, 204, 255));
        ListadoBusquedaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        ListadoBusquedaUsuario.setComponentPopupMenu(SeleccionarUsuario);
        ListadoBusquedaUsuario.setFocusable(false);
        ListadoBusquedaUsuario.setGridColor(new java.awt.Color(0, 204, 204));
        ListadoBusquedaUsuario.setSelectionBackground(new java.awt.Color(255, 102, 102));
        ListadoBusquedaUsuario.getTableHeader().setReorderingAllowed(false);
        ListadoBusquedaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListadoBusquedaUsuarioMouseClicked(evt);
            }
        });
        ListadoBusquedaUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ListadoBusquedaUsuarioKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(ListadoBusquedaUsuario);

        VentanaInternaBuscarUsuario.getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1160, 480));

        cancelarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        cancelarUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelarUsuario.setText("CANCELAR");
        cancelarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarUsuarioActionPerformed(evt);
            }
        });
        VentanaInternaBuscarUsuario.getContentPane().add(cancelarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 150, 30));
        VentanaInternaBuscarUsuario.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 560));

        add(VentanaInternaBuscarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1200, 590));

        VentanaInternaBuscarDocumento.setBackground(new java.awt.Color(255, 255, 255));
        VentanaInternaBuscarDocumento.setTitle("LISTADO DE DOCUMENTOS");
        VentanaInternaBuscarDocumento.setVisible(false);
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
        VentanaInternaBuscarDocumento.getContentPane().add(limpiarDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 150, 30));

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
        ListadoBusquedaDocumento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListadoBusquedaDocumentoMouseClicked(evt);
            }
        });
        ListadoBusquedaDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ListadoBusquedaDocumentoKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(ListadoBusquedaDocumento);

        VentanaInternaBuscarDocumento.getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1350, 470));

        cancelarDocumento.setBackground(new java.awt.Color(255, 255, 255));
        cancelarDocumento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelarDocumento.setText("CANCELAR");
        cancelarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarDocumentoActionPerformed(evt);
            }
        });
        VentanaInternaBuscarDocumento.getContentPane().add(cancelarDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 150, 30));
        VentanaInternaBuscarDocumento.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 560));

        add(VentanaInternaBuscarDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1410, 590));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("ID:");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 40, 25));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("NOMBRE PROVEEDOR:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, 25));

        documentoId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        documentoId.setForeground(new java.awt.Color(102, 102, 102));
        add(documentoId, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 410, 25));

        documentoNumFactura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        documentoNumFactura.setForeground(new java.awt.Color(102, 102, 102));
        add(documentoNumFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 390, 25));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1020, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("ENVIAR DOCUMENTO");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 330, 20));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("No. FACTURA:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, 25));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("NIT PROVEEDOR:");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, 25));

        documentoNitProveedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        documentoNitProveedor.setForeground(new java.awt.Color(102, 102, 102));
        add(documentoNitProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 360, 25));

        documentoNombreProveedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        documentoNombreProveedor.setForeground(new java.awt.Color(102, 102, 102));
        add(documentoNombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 340, 25));

        usuario_correo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usuario_correo.setForeground(new java.awt.Color(102, 102, 102));
        add(usuario_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 540, 25));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("ID:");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, 25));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("CORREO:");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, -1, 25));

        usuario_id.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usuario_id.setForeground(new java.awt.Color(102, 102, 102));
        add(usuario_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 480, 25));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("NOMBRE:");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, 25));

        mensaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mensaje.setForeground(new java.awt.Color(255, 0, 0));
        add(mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 570, 20));

        Registrar.setBackground(new java.awt.Color(255, 255, 255));
        Registrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Registrar.setForeground(new java.awt.Color(102, 102, 102));
        Registrar.setText("ENVIAR");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });
        add(Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 510, 130, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("OBSERVACIONES:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 110, 30));

        observacion.setColumns(20);
        observacion.setRows(5);
        jScrollPane1.setViewportView(observacion);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 570, 150));

        usuario_nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usuario_nombre.setForeground(new java.awt.Color(102, 102, 102));
        add(usuario_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 490, 25));

        cargarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        cargarUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cargarUsuario.setForeground(new java.awt.Color(102, 102, 102));
        cargarUsuario.setText("CARGAR USUARIO");
        cargarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarUsuarioActionPerformed(evt);
            }
        });
        add(cargarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 180, 25));

        cargarDocumento.setBackground(new java.awt.Color(255, 255, 255));
        cargarDocumento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cargarDocumento.setForeground(new java.awt.Color(102, 102, 102));
        cargarDocumento.setText("CARGAR DOCUMENTO");
        cargarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarDocumentoActionPerformed(evt);
            }
        });
        add(cargarDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 180, 25));
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        if(documentoId.getText().equals("")){
           mensaje.setText("Debe cargar un documento para enviarlo");
        }else{
            if(usuario_id.getText().equals("")){
                mensaje.setText("Debe cargar un usuario destinatario");
            }else{
                HistoricoDocumento historicoDocumento = new HistoricoDocumento();
                historicoDocumento.setId_documento(Integer.parseInt(documentoId.getText()));
                historicoDocumento.setUsuarioRegistro_historicoDocumento(user.getId_usuario());
                historicoDocumento.setUsuarioDestino_historicoDocumento(usuario_id.getText());
                historicoDocumento.setObservacion_historicoDocumento(observacion.getText());
                historicoDocumento.setId_historicoDocumento(2); //('1','RADICADO'), ('2','ENVIADO'),('3','RECIBIDO');
                historicoDocumento.setId_confirmacionRecibido(0);  //Valor 0 porque recién se envio
                
                ControlDB_EnvioDocumento controlDB_EnvioDocumento = new ControlDB_EnvioDocumento();
                int radicar=0;
                radicar = controlDB_EnvioDocumento.registrarEnvioDocumento(historicoDocumento);
                if(radicar==1){
                    JOptionPane.showMessageDialog(null, "Envio Exitoso");
                    //Enviamos Mensaje al usuario destinatario que se le va a enviar un Documento
                    ControlDB_Radicacion controlDB_Radicacion = new ControlDB_Radicacion();
                    int maximo = controlDB_Radicacion.retornarElMaximoDocumento();
                    String correoEnviar=usuario_correo.getText();
                    String NumfacturaEnviar=documentoNumFactura.getText();
                    String NitProveedorEnviar=documentoNitProveedor.getText();
                    String NombreProveedorEnviar=documentoNombreProveedor.getText();
                    String observacionEnviar=observacion.getText();
                    EnviarConGmail c = new EnviarConGmail();
                    c.EnviarConGMail(correoEnviar, "Envio Documento No. "+NumfacturaEnviar, "Se ha enviado el documento No. "+NumfacturaEnviar+" del Proveedor "+NombreProveedorEnviar+" con Nit "+NitProveedorEnviar+" radicado con el No. "+maximo +"\nObservación: "+observacionEnviar
                                            + "\n\nFavor abrir el siguiente link en su navegador para confirmar recibido:\n"
                                                    + "http://kanguro.goib.com/Radicacion_facturas/index.php \n\n\nIMPORTANTE:\n" +
                                            "Este correo es informativo, favor no responder a esta dirección de correo, ya\n" +
                                            "que no se encuentra habilitada para recibir mensajes.");
                    //Hacemos limpieza de datos en la interfaz.
                    documentoId.setText("");   
                    documentoNumFactura.setText("");
                    documentoNitProveedor.setText("");
                    documentoNombreProveedor.setText("");
                    usuario_id.setText("");
                    usuario_nombre.setText("");
                    usuario_correo.setText("");
                    observacion.setText("");                        
                }else{
                    JOptionPane.showMessageDialog(null, "Error al Enviar Verifique datos");
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

    private void buscarUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarUsuarioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarUsuarioKeyPressed

    private void limpiarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarUsuariosActionPerformed
        buscarUsuario.setText("");
    }//GEN-LAST:event_limpiarUsuariosActionPerformed

    private void ListadoBusquedaUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ListadoBusquedaUsuarioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListadoBusquedaUsuarioKeyPressed

    private void cancelarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarUsuarioActionPerformed
        VentanaInternaBuscarUsuario.show(false);
    }//GEN-LAST:event_cancelarUsuarioActionPerformed

    private void seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarActionPerformed
        // TODO lo del clik derechoo
        DefaultTableModel modelo;
        int fila1;
        try{
            fila1=ListadoBusquedaUsuario.getSelectedRow();
            if(fila1==-1){
                JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
            }
            else{
                try{
                    modelo=(DefaultTableModel)ListadoBusquedaUsuario.getModel();
                    usuario_id.setText((String)modelo.getValueAt(fila1, 0));
                    usuario_nombre.setText((String)modelo.getValueAt(fila1, 1)+" "+(String)modelo.getValueAt(fila1, 2));
                    usuario_correo.setText((String)modelo.getValueAt(fila1, 3));

                    //Eliminamos la Busqueda Actual#######################################################
                    DefaultTableModel md =(DefaultTableModel)ListadoBusquedaUsuario.getModel();
                    int CantEliminar= ListadoBusquedaUsuario.getRowCount() -1;
                    for(int i =CantEliminar; i>=0; i--){
                        md.removeRow(i);
                    }
                    //######################################################################################
                    VentanaInternaBuscarUsuario.show(false);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No se pudo cargar el Usuario");
                }
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_seleccionarActionPerformed

    private void cargarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarUsuarioActionPerformed
        VentanaInternaBuscarDocumento.show(false);
        VentanaInternaBuscarUsuario.show(true); 
        TextPrompt placeholder = new TextPrompt("Buscar por Nit o Nombre:", buscarDocumento);       
        buscarDocumento.setText("");
        
        DefaultTableModel modelo;
        String [] titulo= {"ID","No FACTURA", "NIT_PROVEEDOR","NOMBRE_PROVEEDOR","USUARIO","NIT_EMPRESA","NOMBRE_EMPRESA","SEDE"};
        String [] registro = new String[8]; 
        modelo = new DefaultTableModel(null, titulo);
        ListadoBusquedaDocumento.setModel(modelo);
        
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)ListadoBusquedaDocumento.getModel();
        int CantEliminar= ListadoBusquedaDocumento.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
           md.removeRow(i);
        }
        
        try {
            BuscarEnVentanaInternaUsuario("");
        } catch (SQLException ex) {
            Logger.getLogger(Envio_Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cargarUsuarioActionPerformed

    private void cargarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarDocumentoActionPerformed
        VentanaInternaBuscarDocumento.show(true);
        VentanaInternaBuscarUsuario.show(false); 
        TextPrompt placeholder = new TextPrompt("Buscar por Id, NumFactura, NombreProveedor:", buscarDocumento);       
        buscarDocumento.setText("");
        DefaultTableModel modelo;
        String [] titulo= {"ID","No FACTURA", "NIT_PROVEEDOR","NOMBRE_PROVEEDOR","USUARIO","NIT_EMPRESA","NOMBRE_EMPRESA","SEDE"};
        String [] registro = new String[8]; 
        modelo = new DefaultTableModel(null, titulo);
        ListadoBusquedaDocumento.setModel(modelo);
        
        try {
            BuscarEnVentanaInternaDocumentos("");
        } catch (SQLException ex) {
            Logger.getLogger(Envio_Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cargarDocumentoActionPerformed

    private void buscarUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarUsuarioKeyReleased
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)ListadoBusquedaUsuario.getModel();
        int CantEliminar= ListadoBusquedaUsuario.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
           md.removeRow(i);
        }
        try {
            BuscarEnVentanaInternaUsuario(buscarUsuario.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Envio_Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarUsuarioKeyReleased

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
            Logger.getLogger(Envio_Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarDocumentoKeyReleased

    private void ListadoBusquedaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListadoBusquedaUsuarioMouseClicked
        if (evt.getClickCount() == 2) {
            // TODO lo del clik derechoo
            DefaultTableModel modelo;
            int fila1;
            try{
                fila1=ListadoBusquedaUsuario.getSelectedRow();
                if(fila1==-1){
                    JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
                }
                else{
                    try{
                        modelo=(DefaultTableModel)ListadoBusquedaUsuario.getModel();
                        usuario_id.setText((String)modelo.getValueAt(fila1, 0));
                        usuario_nombre.setText((String)modelo.getValueAt(fila1, 1)+" "+(String)modelo.getValueAt(fila1, 2));
                        usuario_correo.setText((String)modelo.getValueAt(fila1, 3));

                        //Eliminamos la Busqueda Actual#######################################################
                        DefaultTableModel md =(DefaultTableModel)ListadoBusquedaUsuario.getModel();
                        int CantEliminar= ListadoBusquedaUsuario.getRowCount() -1;
                        for(int i =CantEliminar; i>=0; i--){
                            md.removeRow(i);
                        }
                        //######################################################################################
                        VentanaInternaBuscarUsuario.show(false);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "No se pudo cargar el Usuario");
                    }
                }
            }catch(Exception e){
            }
        }
    }//GEN-LAST:event_ListadoBusquedaUsuarioMouseClicked

    private void ListadoBusquedaDocumentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListadoBusquedaDocumentoMouseClicked
        if (evt.getClickCount() == 2) {
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
        }
    }//GEN-LAST:event_ListadoBusquedaDocumentoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ListadoBusquedaDocumento;
    private javax.swing.JTable ListadoBusquedaUsuario;
    private javax.swing.JButton Registrar;
    private javax.swing.JMenuItem Seleccionar;
    private javax.swing.JPopupMenu SeleccionarDocumento;
    private javax.swing.JPopupMenu SeleccionarUsuario;
    private javax.swing.JInternalFrame VentanaInternaBuscarDocumento;
    private javax.swing.JInternalFrame VentanaInternaBuscarUsuario;
    private javax.swing.JTextField buscarDocumento;
    private javax.swing.JTextField buscarUsuario;
    private javax.swing.JButton cancelarDocumento;
    private javax.swing.JButton cancelarUsuario;
    private javax.swing.JButton cargarDocumento;
    private javax.swing.JButton cargarUsuario;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton limpiarDocumento;
    private javax.swing.JButton limpiarUsuarios;
    private javax.swing.JLabel mensaje;
    private javax.swing.JTextArea observacion;
    private javax.swing.JMenuItem seleccionar;
    private javax.swing.JLabel usuario_correo;
    private javax.swing.JLabel usuario_id;
    private javax.swing.JLabel usuario_nombre;
    private javax.swing.JLabel ventanaInterna_Nombre;
    private javax.swing.JLabel ventanaInterna_Nombre1;
    // End of variables declaration//GEN-END:variables
    
    public void BuscarEnVentanaInternaDocumentos(String valorConsulta) throws SQLException{               
        DefaultTableModel modelo;
        String [] titulo= {"ID","No FACTURA", "NIT_PROVEEDOR","NOMBRE_PROVEEDOR","USUARIO","NIT_EMPRESA","NOMBRE_EMPRESA","SEDE"};
        String [] registro = new String[8]; 
        modelo = new DefaultTableModel(null, titulo);     
        ArrayList<ConsultarDocumentosParaEnvios> listadoDocumento=null;
        ControlDB_EnvioDocumento controlDB_Documento = new ControlDB_EnvioDocumento();
        listadoDocumento=controlDB_Documento.buscarDocumento(valorConsulta);
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
    public void BuscarEnVentanaInternaUsuario(String valorConsulta) throws SQLException{               
        DefaultTableModel modelo;
        String [] titulo= {"ID","NOMBRES", "APELLIDOS","CORREO","ESTADO"};
        String [] registro = new String[5]; 
        modelo = new DefaultTableModel(null, titulo);     
        ArrayList<Usuario> listadoUsuario=null;
        ControlDB_Usuario controlDB_usuario = new ControlDB_Usuario();
        listadoUsuario=controlDB_usuario.buscarUsuario(valorConsulta);
        if(listadoUsuario !=null){
            for(int i =0; i< listadoUsuario.size(); i++){ 
                registro[0]=""+listadoUsuario.get(i).getId_usuario();
                registro[1]=""+listadoUsuario.get(i).getNombre_usuario();
                registro[2]=""+listadoUsuario.get(i).getApellido_usuario();
                registro[3]=""+listadoUsuario.get(i).getMail_usuario();
                registro[4]=""+listadoUsuario.get(i).getId_estadoUsuario();
                modelo.addRow(registro);
                ListadoBusquedaUsuario.setModel(modelo);
            }   
        }
    }
}
