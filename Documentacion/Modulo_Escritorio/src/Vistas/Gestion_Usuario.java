
package Vistas;
 
import Controladores.ControlDB_Proveedor;
import Controladores.ControlDB_Usuario;
import Modelos.AutenticacionDominio;
import Modelos.Proveedor;
import Modelos.Usuario;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Gestion_Usuario extends javax.swing.JPanel {
    ControlDB_Usuario controlDB_Usuario = new ControlDB_Usuario();
    DefaultTableModel modelo;
    String datos; 
    String [] titulo= {"ID","NOMBRE", "APELLIDO","CORREO","ESTADO","PERMISO RADICAR"};
    String [] registro;
    public Gestion_Usuario() {
        initComponents();
        try {
            tabla("");
        } catch (SQLException ex) {
            Logger.getLogger(Gestion_Proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Seleccionar = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        jLabel20 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        RegistrarUsuario = new javax.swing.JButton();
        Id = new javax.swing.JTextField();
        correo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        apellidos = new javax.swing.JTextField();
        estado = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        mensaje = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        RegistrarUsuario1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        valorBusqueda = new javax.swing.JTextField();
        limpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        permisoRadicar = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        Editar.setText("Actualizar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        Seleccionar.add(Editar);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Id Usuario:");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 80, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Apellidos:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 80, 30));

        RegistrarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        RegistrarUsuario.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        RegistrarUsuario.setText("REGISTRAR");
        RegistrarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RegistrarUsuarioMouseExited(evt);
            }
        });
        RegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarUsuarioActionPerformed(evt);
            }
        });
        add(RegistrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 130, 30));

        Id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IdMouseClicked(evt);
            }
        });
        add(Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 280, 30));

        correo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                correoMouseClicked(evt);
            }
        });
        add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 280, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Nombres:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 70, 30));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Correo:");
        add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 70, 30));

        nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nombreMouseClicked(evt);
            }
        });
        add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 280, 30));

        apellidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                apellidosMouseClicked(evt);
            }
        });
        add(apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 70, 320, 30));

        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 280, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Permiso Radicar:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 110, 110, 30));

        mensaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mensaje.setForeground(new java.awt.Color(255, 0, 51));
        add(mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 1050, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("GESTIÓN USUARIO");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 440, 50));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1220, 10));

        RegistrarUsuario1.setBackground(new java.awt.Color(255, 255, 255));
        RegistrarUsuario1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        RegistrarUsuario1.setText("NUEVO");
        RegistrarUsuario1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RegistrarUsuario1MouseExited(evt);
            }
        });
        RegistrarUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarUsuario1ActionPerformed(evt);
            }
        });
        add(RegistrarUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 130, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("BUSQUEDA POR CODIGO O NOMBRE:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 240, 30));

        valorBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                valorBusquedaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                valorBusquedaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                valorBusquedaKeyTyped(evt);
            }
        });
        add(valorBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 250, 30));

        limpiar.setBackground(new java.awt.Color(255, 255, 255));
        limpiar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiar.setForeground(new java.awt.Color(102, 102, 102));
        limpiar.setText("LIMPIAR");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 140, 30));

        Table1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        Table1.setBackground(new java.awt.Color(153, 204, 255));
        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Table1.setComponentPopupMenu(Seleccionar);
        Table1.setFocusable(false);
        Table1.setGridColor(new java.awt.Color(0, 204, 204));
        Table1.setSelectionBackground(new java.awt.Color(255, 102, 102));
        Table1.getTableHeader().setReorderingAllowed(false);
        Table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Table1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(Table1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 1250, 480));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 1220, 20));

        permisoRadicar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        add(permisoRadicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 110, 310, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Estado:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 70, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarUsuarioMouseExited
        mensaje.setText("");
    }//GEN-LAST:event_RegistrarUsuarioMouseExited

    private void RegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarUsuarioActionPerformed
        if(Id.getText().equals("")){
            mensaje.setText("Error!!.. El ID de usuario no puede estar vacio");
        }else{
            if(nombre.getText().equals("")){
                mensaje.setText("Error!!.. El nombre no puede estar vacio");
            }
            else{
                if(nombre.getText().equals("")){
                    mensaje.setText("Error!!.. El nombre no puede estar vacio");
                }else{
                    if(apellidos.getText().equals("")){
                        mensaje.setText("Error!!.. Los apellidos no puede estar vacio");
                    }else{
                        if(correo.getText().equals("")){
                            mensaje.setText("Error!!.. El correo no puede estar vacio");
                        }
                        else{
                            try {
                                Usuario u = new Usuario();                                 
                                u.setId_usuario(Id.getText());
                                u.setNombre_usuario(nombre.getText());
                                u.setApellido_usuario(apellidos.getText());
                                u.setMail_usuario(correo.getText());
                                u.setId_estadoUsuario(convertidorValorEstado(estado.getSelectedIndex()));
                                u.setPermisoRadicar_usuario(permisoRadicar.getSelectedIndex());
                                Usuario usuario= controlDB_Usuario.consultarUsuarioID(u);
                                if(usuario == null){
                                    int result=0;
                                    result=controlDB_Usuario.registrarUsuario(u);
                                    if(result==1){
                                        JOptionPane.showMessageDialog(null, "Registro de Usuario Exitoso");             
                                        Id.setText("");
                                        nombre.setText("");
                                        apellidos.setText("");
                                        correo.setText("");
                                        estado.setSelectedIndex(0);
                                        permisoRadicar.setSelectedIndex(0);
                                        mensaje.setText("");
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Error Al Registrar el Usuario");
                                    }
                                }else{
                                    int validadorConfirmacion = JOptionPane.showConfirmDialog(null, "El Usuario con ese ID ya existe, desea actualizar los datos?");
                                    if(validadorConfirmacion==0){
                                        int result=0;
                                        result=controlDB_Usuario.actualizarUsuario(u);
                                        if(result==1){
                                                JOptionPane.showMessageDialog(null, "Actualización Exitosa");
                                                Id.setText("");
                                                Id.setEnabled(true);
                                                nombre.setText("");
                                                apellidos.setText("");
                                                correo.setText("");           
                                                estado.setSelectedIndex(0);
                                                permisoRadicar.setSelectedIndex(0);
                                                mensaje.setText("");
                                                tabla("");
                                           }else{
                                               JOptionPane.showMessageDialog(null, "Error al querer actualizar los datos", "Error al actualizar", JOptionPane.INFORMATION_MESSAGE);
                                           }
                                    }
                                }
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Gestion_Usuario.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (SQLException ex) {
                                Logger.getLogger(Gestion_Usuario.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            }    
        }
    }//GEN-LAST:event_RegistrarUsuarioActionPerformed

    private void IdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IdMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_IdMouseClicked

    private void correoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_correoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_correoMouseClicked

    private void nombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreMouseClicked

    private void apellidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apellidosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidosMouseClicked

    private void RegistrarUsuario1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarUsuario1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistrarUsuario1MouseExited

    private void RegistrarUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarUsuario1ActionPerformed
        Id.setText("");
        Id.setEnabled(true);
        nombre.setText("");
        apellidos.setText("");
        correo.setText("");
        estado.setSelectedIndex(0);
        permisoRadicar.setSelectedIndex(0);
    }//GEN-LAST:event_RegistrarUsuario1ActionPerformed

    private void valorBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorBusquedaKeyPressed
        
    }//GEN-LAST:event_valorBusquedaKeyPressed

    private void valorBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorBusquedaKeyTyped
        
    }//GEN-LAST:event_valorBusquedaKeyTyped

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        valorBusqueda.setText("");
         //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)Table1.getModel();
        int CantEliminar= Table1.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
            md.removeRow(i);
        }
    }//GEN-LAST:event_limpiarActionPerformed

    private void Table1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Table1KeyPressed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        int fila1;
        String buscar="";
        try{
            fila1=Table1.getSelectedRow();
            if(fila1==-1){
                JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
            }
            else{
                modelo=(DefaultTableModel)Table1.getModel();
                String idUsu=(String)modelo.getValueAt(fila1, 0);
                Usuario u = new Usuario();
                u.setId_usuario(idUsu);
               
                consultarParaActualizar(u);
                Id.setEnabled(false);
                nombre.setEnabled(true);
                apellidos.setEnabled(true);
                correo.setEnabled(true);;
                estado.setEnabled(true);
                permisoRadicar.setEnabled(true);
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_EditarActionPerformed

    private void valorBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorBusquedaKeyReleased
        try {
            //Eliminamos la Busqueda Actual#######################################################
            DefaultTableModel md =(DefaultTableModel)Table1.getModel();
            int CantEliminar= Table1.getRowCount() -1;
            for(int i =CantEliminar; i>=0; i--){
                md.removeRow(i);
            }
            String valor=valorBusqueda.getText();
            tabla(valor);
        } catch (SQLException ex) {
            Logger.getLogger(Gestion_Proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_valorBusquedaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JTextField Id;
    private javax.swing.JButton RegistrarUsuario;
    private javax.swing.JButton RegistrarUsuario1;
    private javax.swing.JPopupMenu Seleccionar;
    private javax.swing.JTable Table1;
    private javax.swing.JTextField apellidos;
    private javax.swing.JTextField correo;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton limpiar;
    private javax.swing.JLabel mensaje;
    private javax.swing.JTextField nombre;
    private javax.swing.JComboBox<String> permisoRadicar;
    private javax.swing.JTextField valorBusqueda;
    // End of variables declaration//GEN-END:variables
     public void tabla(String valorConsulta) throws SQLException{
        registro = new String[6]; 
        modelo = new DefaultTableModel(null, titulo);

        ArrayList<Usuario> listadoUsuario=controlDB_Usuario.buscarUsuario(valorConsulta);
        for(int i =0; i< listadoUsuario.size(); i++){
            registro[0]=""+listadoUsuario.get(i).getId_usuario();
            registro[1]=""+listadoUsuario.get(i).getNombre_usuario();
            registro[2]=""+listadoUsuario.get(i).getApellido_usuario();
            registro[3]=""+listadoUsuario.get(i).getMail_usuario();
            registro[4]=""+convertidorEstadoID_x_Nombre(listadoUsuario.get(i).getId_estadoUsuario());
            registro[5]=""+convertirPermisoRadicar(listadoUsuario.get(i).getPermisoRadicar_usuario());
            modelo.addRow(registro);
            Table1.setModel(modelo);
        }
    }
    
    public void consultarParaActualizar (Usuario usu) throws SQLException{
        ControlDB_Proveedor c = new ControlDB_Proveedor();
        Usuario usuario=controlDB_Usuario.consultarUsuarioID(usu);
        try{     
            Id.setText(""+usuario.getId_usuario());
            nombre.setText(""+usuario.getNombre_usuario());
            apellidos.setText(""+usuario.getApellido_usuario());
            correo.setText(""+usuario.getMail_usuario());
            if(usuario.getId_estadoUsuario()==0){
                estado.setSelectedIndex(1);//INACTIVO
            }else{
                estado.setSelectedIndex(0);//ACTIVO
            }
            permisoRadicar.setSelectedIndex(usuario.getPermisoRadicar_usuario());
           // estado_proveedor.setSelectedItem(convertidorEstadoID_x_Nombre(proveedor.getId_estadoProveedor()));
        }catch(Exception e){
            
        }
    }
    
    public int convertidorValorEstado(int estado) {
        if (estado == 0) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public String convertirPermisoRadicar(int id) {
        if (id == 0) {
            return "NO";
        } else {
            return "SI";
        }
    }        
    public String convertidorEstadoID_x_Nombre(int id) {
        if (id == 0) {
            return "Inactivo";
        } else {
            return "Activo";
        }
    }
}
