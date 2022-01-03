package Vistas;
  
import Controladores.ControlDB_Empresa;
import Controladores.ControlDB_Proveedor;
import Controladores.Funciones;
import Modelos.Proveedor;
import Reportes.Generar_Reportes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Gestion_Proveedor extends javax.swing.JPanel {
    Controladores.ControlDB_Empresa controlDB_Empresa = new ControlDB_Empresa();
    Controladores.ControlDB_Proveedor controlDB_Proveedor = new ControlDB_Proveedor();
    DefaultTableModel modelo;
    String datos; 
    String [] titulo= {"NIT","DIG_VERIFICACION", "NOMBRE","CORREO","TELEFONO","ESTADO"};
    String [] registro;
    String accion="";
    String nombreOriginal="";
    public Gestion_Proveedor(){
        initComponents();     
        try {
            tabla("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar registro de empresa");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Seleccionar = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        valorBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        limpiar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        digitoVerificacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nombreProveedor = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        estado_proveedor = new javax.swing.JComboBox<>();
        RegistrarEmpresa = new javax.swing.JButton();
        mensaje = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        reporte = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        RegistrarEmpresa1 = new javax.swing.JButton();
        personaNatural = new javax.swing.JCheckBox();

        Editar.setText("Actualizar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        Seleccionar.add(Editar);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("BUSQUEDA POR CODIGO O NOMBRE:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 240, 25));

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
        add(valorBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 250, 25));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 1250, 530));

        limpiar.setBackground(new java.awt.Color(255, 255, 255));
        limpiar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiar.setForeground(new java.awt.Color(102, 102, 102));
        limpiar.setText("LIMPIAR");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 140, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("GESTIÓN PROVEEDOR");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 440, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("NIT:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, 25));

        nit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nit.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        nit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nitMouseEntered(evt);
            }
        });
        nit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nitActionPerformed(evt);
            }
        });
        nit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nitKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nitKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nitKeyTyped(evt);
            }
        });
        add(nit, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 200, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("DIG");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, -1, 25));

        digitoVerificacion.setEditable(false);
        digitoVerificacion.setBackground(new java.awt.Color(255, 255, 255));
        digitoVerificacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        digitoVerificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        digitoVerificacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(digitoVerificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 30, 25));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("NOMBRE DEL PROVEEDOR:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 170, 25));

        nombreProveedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nombreProveedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        nombreProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nombreProveedorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nombreProveedorMouseEntered(evt);
            }
        });
        add(nombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 80, 260, 25));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("CORREO:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 60, 25));

        correo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        correo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        correo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                correoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                correoMouseEntered(evt);
            }
        });
        add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 250, 25));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("TELEFONO:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 70, 25));

        telefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        telefono.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        telefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telefonoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                telefonoMouseEntered(evt);
            }
        });
        add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 140, 25));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("ESTADO:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, -1, 25));

        estado_proveedor.setForeground(new java.awt.Color(102, 102, 102));
        estado_proveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO" }));
        estado_proveedor.setBorder(null);
        add(estado_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 110, 260, 25));

        RegistrarEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        RegistrarEmpresa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        RegistrarEmpresa.setForeground(new java.awt.Color(102, 102, 102));
        RegistrarEmpresa.setText("NUEVO");
        RegistrarEmpresa.setBorder(null);
        RegistrarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarEmpresaActionPerformed(evt);
            }
        });
        add(RegistrarEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 130, 30));

        mensaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mensaje.setForeground(new java.awt.Color(255, 0, 0));
        add(mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 1030, 25));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, 40));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1230, 10));

        reporte.setBackground(new java.awt.Color(255, 255, 255));
        reporte.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        reporte.setForeground(new java.awt.Color(102, 102, 102));
        reporte.setText("REPORTE");
        reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteActionPerformed(evt);
            }
        });
        add(reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 230, 140, 30));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 1250, 10));

        RegistrarEmpresa1.setBackground(new java.awt.Color(255, 255, 255));
        RegistrarEmpresa1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        RegistrarEmpresa1.setForeground(new java.awt.Color(102, 102, 102));
        RegistrarEmpresa1.setText("REGISTRAR");
        RegistrarEmpresa1.setBorder(null);
        RegistrarEmpresa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarEmpresa1ActionPerformed(evt);
            }
        });
        add(RegistrarEmpresa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 130, 30));

        personaNatural.setBackground(new java.awt.Color(255, 255, 255));
        personaNatural.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        personaNatural.setForeground(new java.awt.Color(102, 102, 102));
        personaNatural.setText("Persona Natural");
        personaNatural.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                personaNaturalItemStateChanged(evt);
            }
        });
        add(personaNatural, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 190, 25));
    }// </editor-fold>//GEN-END:initComponents

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
                accion="modificar";
                modelo=(DefaultTableModel)Table1.getModel();
                String nitT=(String)modelo.getValueAt(fila1, 0);
                String digiVerific=(String)modelo.getValueAt(fila1, 1);
                buscar=nitT+":"+digiVerific;
                Proveedor c = new Proveedor();
                c.setNit_proveedor(nitT);
                c.setDig_proveedor(digiVerific);
                consultarParaActualizar(c);
                nit.setEnabled(false);
                digitoVerificacion.setEnabled(true);
                nombreProveedor.setEnabled(true);              
                correo.setEnabled(true);
                telefono.setEnabled(true);
                estado_proveedor.setEnabled(true);  
           }
        }catch(Exception e){
        }
    }//GEN-LAST:event_EditarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        valorBusqueda.setText("");
         //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)Table1.getModel();
        int CantEliminar= Table1.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
            md.removeRow(i);
        }
    }//GEN-LAST:event_limpiarActionPerformed

    private void valorBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorBusquedaKeyPressed
        
    }//GEN-LAST:event_valorBusquedaKeyPressed

    private void valorBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorBusquedaKeyTyped
       
    }//GEN-LAST:event_valorBusquedaKeyTyped

    private void nitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nitMouseClicked
        mensaje.setText("");
    }//GEN-LAST:event_nitMouseClicked

    private void nitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nitMouseEntered
        mensaje.setText("");
    }//GEN-LAST:event_nitMouseEntered

    private void nitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nitActionPerformed

    private void nitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nitKeyPressed
        mensaje.setText("");
        try{
            if(nit.getText().equals("")){//El nit está vacio
            }else{
                //Procedemos a validar si es un número entero
                try{
                    new java.math.BigDecimal(nit.getText());
                    String nitS = nit.getText();
                    long nitL = Long.parseLong(nitS);
                    Funciones calcularDigitoVerificacion = new Funciones();
                    digitoVerificacion.setText(""+calcularDigitoVerificacion.generarDigitoVerificacion(nitL));
                }catch(Exception e){
                    mensaje.setText("El Nit debe ser númerico");
                }
            }
        }catch(Exception e){

        }
    }//GEN-LAST:event_nitKeyPressed

    private void nitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nitKeyReleased
        mensaje.setText("");
        try{
            if(nit.getText().equals("")){//El nit está vacio
            }else{
                //Procedemos a validar si es un número entero
                try{
                    new java.math.BigDecimal(nit.getText());
                    String nitS = nit.getText();
                    long nitL = Long.parseLong(nitS);
                    Funciones calcularDigitoVerificacion = new Funciones();
                    digitoVerificacion.setText(""+calcularDigitoVerificacion.generarDigitoVerificacion(nitL));
                }catch(Exception e){
                    mensaje.setText("El Nit debe ser númerico");
                }
            }
        }catch(Exception e){

        }
    }//GEN-LAST:event_nitKeyReleased

    private void nitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nitKeyTyped
        mensaje.setText("");
        try{
            if(nit.getText().equals("")){//El nit está vacio
            }else{
                //Procedemos a validar si es un número entero
                try{
                    new java.math.BigDecimal(nit.getText());
                    String nitS = nit.getText();
                    long nitL = Long.parseLong(nitS);
                    Funciones calcularDigitoVerificacion = new Funciones();
                    digitoVerificacion.setText(""+calcularDigitoVerificacion.generarDigitoVerificacion(nitL));
                }catch(Exception e){
                    mensaje.setText("El Nit debe ser númerico");
                }
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_nitKeyTyped

    private void nombreProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombreProveedorMouseClicked
        mensaje.setText("");
    }//GEN-LAST:event_nombreProveedorMouseClicked

    private void nombreProveedorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombreProveedorMouseEntered
        mensaje.setText("");
    }//GEN-LAST:event_nombreProveedorMouseEntered

    private void correoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_correoMouseClicked
        mensaje.setText("");
    }//GEN-LAST:event_correoMouseClicked

    private void correoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_correoMouseEntered
        mensaje.setText("");
    }//GEN-LAST:event_correoMouseEntered

    private void telefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telefonoMouseClicked
        mensaje.setText("");
    }//GEN-LAST:event_telefonoMouseClicked

    private void telefonoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telefonoMouseEntered
        mensaje.setText("");
    }//GEN-LAST:event_telefonoMouseEntered

    private void RegistrarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarEmpresaActionPerformed
        nit.setText("");
        nit.setEnabled(true);
        digitoVerificacion.setText("");
        nombreProveedor.setText("");
        correo.setText("");
        telefono.setText("");
        estado_proveedor.setSelectedIndex(0);
    }//GEN-LAST:event_RegistrarEmpresaActionPerformed

    private void reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteActionPerformed
       Generar_Reportes gr = new Generar_Reportes();
        gr.generarReporteProveedor();
    }//GEN-LAST:event_reporteActionPerformed

    private void RegistrarEmpresa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarEmpresa1ActionPerformed
        if(nit.getText().equalsIgnoreCase("")){
            mensaje.setText("!!Nit del proveedor no puede estar vacio!!");
        }else{
            if(nombreProveedor.getText().equals("")){
                mensaje.setText("!!Nombre del proveedor no puede estar vacio!!");
            }else{
                try{
                    if(!personaNatural.isSelected()){ //La Persona Natural no fue seleccionado debe validar el Nombre del Proveedor
                        Proveedor prov = new Proveedor();
                        prov.setNit_proveedor(nit.getText());
                        prov.setDig_proveedor(digitoVerificacion.getText());
                        prov.setNombre_proveedor(nombreProveedor.getText());
                        prov.setCorreo_proveedor(correo.getText());
                        prov.setTelefono_proveedor(telefono.getText());
                        prov.setId_estadoProveedor(convertidorValorEstado(estado_proveedor.getSelectedIndex()));        
                        ControlDB_Proveedor controladorProveedor  = new ControlDB_Proveedor();     
                        Proveedor proveedorValidar= controladorProveedor.consultarProvedorID(prov);
                        if(proveedorValidar == null){
                            try{
                                int result=controladorProveedor.registrarProveedores(prov, false);
                                if(result==1){
                                    JOptionPane.showMessageDialog(null, "Registro Exitoso");
                                    nit.setText("");
                                    nit.setEnabled(true);
                                    digitoVerificacion.setText("");
                                    nombreProveedor.setText("");
                                    correo.setText("");
                                    telefono.setText("");
                                    estado_proveedor.setSelectedIndex(0);
                                    tabla("");
                                    personaNatural.setSelected(false);
                                }else{
                                    JOptionPane.showMessageDialog(null, "Error al Registrar Proveedor");
                                }
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, "Error al Registrar Proveedor");
                            }       
                        }else{
                            int validadorConfirmacion = JOptionPane.showConfirmDialog(null, "El proveedor con ese Nit ya existe, desea actualizar los datos?");
                            if(validadorConfirmacion==0){
                                if(nit.getText().equals("")){
                                    mensaje.setText("!!El Nit no Puede estar vacio!!");
                                }else{
                                    if(nombreProveedor.getText().equals("")){
                                        mensaje.setText("!!El Nombre no Puede estar vacio!!");
                                    }else{
                                       try{
                                            new java.math.BigDecimal(nit.getText());
                                            Proveedor c = new Proveedor();
                                            c.setNit_proveedor(nit.getText());
                                            c.setDig_proveedor(digitoVerificacion.getText());
                                            c.setNombre_proveedor(nombreProveedor.getText());
                                            c.setCorreo_proveedor(correo.getText());
                                            c.setTelefono_proveedor(telefono.getText()); 
                                            c.setId_estadoProveedor(convertidorValorEstado(estado_proveedor.getSelectedIndex()));
                                            int result=0;
                                            result=controlDB_Proveedor.actualizarProveedor(c);
                                            if(result==1){
                                                JOptionPane.showMessageDialog(null, "Actualización Exitosa");
                                                nit.setText("");
                                                nit.setEnabled(true);
                                                digitoVerificacion.setText("");
                                                nombreProveedor.setText("");
                                                correo.setText("");
                                                telefono.setText("");              
                                                estado_proveedor.setSelectedIndex(0);
                                                mensaje.setText("");
                                                tabla("");
                                                personaNatural.setSelected(false);
                                           }else{
                                               JOptionPane.showMessageDialog(null, "Error al querer actualizar los datos", "Error al actualizar", JOptionPane.INFORMATION_MESSAGE);
                                           }
                                       }catch(Exception e){
                                           JOptionPane.showMessageDialog(null, "Error verifique Nit, debe ser Númerico");
                                       }
                                   } 
                                }
                            }
                        }
                    }else{
                        Proveedor prov = new Proveedor();
                        prov.setNit_proveedor(nit.getText());
                        prov.setDig_proveedor("NULL");
                        prov.setNombre_proveedor(nombreProveedor.getText());
                        prov.setCorreo_proveedor(correo.getText());
                        prov.setTelefono_proveedor(telefono.getText());
                        prov.setId_estadoProveedor(convertidorValorEstado(estado_proveedor.getSelectedIndex()));        
                        ControlDB_Proveedor controladorProveedor  = new ControlDB_Proveedor();     
                        Proveedor proveedorValidar= controladorProveedor.consultarProvedorID(prov);
                        if(proveedorValidar == null){
                            try{
                                int result=controladorProveedor.registrarProveedores(prov, true);
                                if(result==1){
                                    JOptionPane.showMessageDialog(null, "Registro Exitoso");
                                    nit.setText("");
                                    nit.setEnabled(true);
                                    digitoVerificacion.setText("");
                                    nombreProveedor.setText("");
                                    correo.setText("");
                                    telefono.setText("");
                                    estado_proveedor.setSelectedIndex(0);
                                    tabla("");
                                    personaNatural.setSelected(false);
                                }else{
                                    JOptionPane.showMessageDialog(null, "Error al Registrar Proveedor");
                                }
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, "Error al Registrar Proveedor");
                            }       
                        }else{
                            int validadorConfirmacion = JOptionPane.showConfirmDialog(null, "El proveedor con ese Nit ya existe, desea actualizar los datos?");
                            if(validadorConfirmacion==0){
                                if(nit.getText().equals("")){
                                    mensaje.setText("!!El Nit no Puede estar vacio!!");
                                }else{
                                    if(nombreProveedor.getText().equals("")){
                                        mensaje.setText("!!El Nombre no Puede estar vacio!!");
                                    }else{
                                       try{
                                            new java.math.BigDecimal(nit.getText());
                                            Proveedor c = new Proveedor();
                                            c.setNit_proveedor(nit.getText());
                                            c.setDig_proveedor(digitoVerificacion.getText());
                                            c.setNombre_proveedor(nombreProveedor.getText());
                                            c.setCorreo_proveedor(correo.getText());
                                            c.setTelefono_proveedor(telefono.getText()); 
                                            c.setId_estadoProveedor(convertidorValorEstado(estado_proveedor.getSelectedIndex()));
                                            int result=0;
                                            result=controlDB_Proveedor.actualizarProveedor(c);
                                            if(result==1){
                                                JOptionPane.showMessageDialog(null, "Actualización Exitosa");
                                                nit.setText("");
                                                nit.setEnabled(true);
                                                digitoVerificacion.setText("");
                                                nombreProveedor.setText("");
                                                correo.setText("");
                                                telefono.setText("");              
                                                estado_proveedor.setSelectedIndex(0);
                                                mensaje.setText("");
                                                tabla("");
                                                personaNatural.setSelected(false);
                                           }else{
                                               JOptionPane.showMessageDialog(null, "Error al querer actualizar los datos", "Error al actualizar", JOptionPane.INFORMATION_MESSAGE);
                                           }
                                       }catch(Exception e){
                                           JOptionPane.showMessageDialog(null, "Error verifique Nit, debe ser Númerico");
                                       }
                                   } 
                                }
                            }
                        }
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error al Registrar Empresa");
                }
            }
        }     
    }//GEN-LAST:event_RegistrarEmpresa1ActionPerformed

    private void personaNaturalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_personaNaturalItemStateChanged
      
    }//GEN-LAST:event_personaNaturalItemStateChanged

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
    private javax.swing.JButton RegistrarEmpresa;
    private javax.swing.JButton RegistrarEmpresa1;
    private javax.swing.JPopupMenu Seleccionar;
    private javax.swing.JTable Table1;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField digitoVerificacion;
    private javax.swing.JComboBox<String> estado_proveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton limpiar;
    private javax.swing.JLabel mensaje;
    private javax.swing.JTextField nit;
    private javax.swing.JTextField nombreProveedor;
    private javax.swing.JCheckBox personaNatural;
    private javax.swing.JButton reporte;
    private javax.swing.JTextField telefono;
    private javax.swing.JTextField valorBusqueda;
    // End of variables declaration//GEN-END:variables
    public void tabla(String valorConsulta) throws SQLException{
        registro = new String[6]; 
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_Proveedor c = new ControlDB_Proveedor();
        ArrayList<Proveedor> listadoProveedor=c.buscarProveedor(valorConsulta);
        for(int i =0; i< listadoProveedor.size(); i++){
            registro[0]=""+listadoProveedor.get(i).getNit_proveedor();
            registro[1]=""+listadoProveedor.get(i).getDig_proveedor();
            registro[2]=""+listadoProveedor.get(i).getNombre_proveedor();
            registro[3]=""+listadoProveedor.get(i).getCorreo_proveedor();
            registro[4]=""+listadoProveedor.get(i).getTelefono_proveedor();
            registro[5]=""+convertidorEstadoID_x_Nombre(listadoProveedor.get(i).getId_estadoProveedor());
            modelo.addRow(registro);
            Table1.setModel(modelo);
        }
    }
    
    public void consultarParaActualizar (Proveedor prov) throws SQLException{
        ControlDB_Proveedor c = new ControlDB_Proveedor();
        Proveedor proveedor=c.consultarProvedorID(prov);
        try{     
            nit.setText(""+proveedor.getNit_proveedor());
            digitoVerificacion.setText(""+proveedor.getDig_proveedor());
            nombreProveedor.setText(""+proveedor.getNombre_proveedor());
            correo.setText(""+proveedor.getCorreo_proveedor());
            telefono.setText(""+proveedor.getTelefono_proveedor());
            if(proveedor.getId_estadoProveedor()==0){
                estado_proveedor.setSelectedIndex(1);//INACTIVO
            }else{
                estado_proveedor.setSelectedIndex(0);//ACTIVO
            }
           // estado_proveedor.setSelectedItem(convertidorEstadoID_x_Nombre(proveedor.getId_estadoProveedor()));
        }catch(Exception e){
            
        }
    }
    public String convertidorEstadoID_x_Nombre(int id){
        if(id == 0){
            return "Inactivo";
        }else{
            return "Activo";
        }
    } 
    public int convertidorValorEstado(int estado){
        if(estado == 0){
            return 1;
        }else{
            return 0;
        }
    } 
}


