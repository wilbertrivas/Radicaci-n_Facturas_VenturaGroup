package GUI2;
 
import Controladores.ControlDB_Empresa;
import Controladores.ControlDB_Proveedor;
import Controladores.ControlDB_Radicacion;
import Controladores.TextPrompt;
import Modelos.Consultas.ConsultaGeneralInforme;
import Modelos.Empresa;
import Modelos.Proveedor;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Reportes.Generar_Reportes;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Informe_Generar extends javax.swing.JPanel {
    DefaultTableModel modelo;
    String datos;
    String [] registro;   
    String proveedor_nitS = "";
    String proveedor_nombreS="";
    String empresa_nitS = "";
    String empresa_nombreS="";
    
    
    String valorGeneral="";
    String fechaIniB="1999-01-01";
    String fechaFinB="2050-01-01";
    
    public Informe_Generar() {
        initComponents();    
        
        VentanaInternaProveedor.show(false);
        VentanaInternaEmpresa.show(false);
        valorBusqueda_label.show(true);
        valorBusqueda.show(true);
        fecha_label1.show(false);
        fechaInicioL.show(false);
        fecha_label2.show(false);
        fechaFinL.show(false);
        empresa_label.show(false);
        empresa_nombre.show(false);
        proveedor_label.show(false);
        proveedor_nombre.show(false);
        VentanaInternaEmpresa.getContentPane().setBackground(Color.WHITE);
        VentanaInternaProveedor.getContentPane().setBackground(Color.WHITE);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Proveedor = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        Empresa = new javax.swing.JPopupMenu();
        Editar1 = new javax.swing.JMenuItem();
        VentanaInternaEmpresa = new javax.swing.JInternalFrame();
        codigoEmpresa = new javax.swing.JTextField();
        ventanaInterna_Nombre1 = new javax.swing.JLabel();
        limpiarEmpresa = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        ListadoBusquedaEmpresa = new javax.swing.JTable();
        buscarEmpresa = new javax.swing.JButton();
        cancelarEmpresa = new javax.swing.JButton();
        VentanaInternaProveedor = new javax.swing.JInternalFrame();
        codigoProveedor = new javax.swing.JTextField();
        ventanaInterna_Nombre = new javax.swing.JLabel();
        limpiarProveedor = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListadoBusquedaProveedor = new javax.swing.JTable();
        buscarProveedor = new javax.swing.JButton();
        cancelarProveedor = new javax.swing.JButton();
        valorBusqueda_label = new javax.swing.JLabel();
        valorBusqueda = new javax.swing.JTextField();
        consultar = new javax.swing.JButton();
        generarDocumento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        listar1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        fechaInicioL = new com.toedter.calendar.JDateChooser();
        fechaFinL = new com.toedter.calendar.JDateChooser();
        proveedor_nombre = new javax.swing.JLabel();
        empresa_nombre = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tipoInforme = new javax.swing.JComboBox<>();
        fecha_label2 = new javax.swing.JLabel();
        proveedor_label = new javax.swing.JLabel();
        empresa_label = new javax.swing.JLabel();
        fecha_label1 = new javax.swing.JLabel();

        Editar.setText("Seleccionar_Proveedor");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        Proveedor.add(Editar);

        Editar1.setText("Seleccionar_Empresa");
        Editar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar1ActionPerformed(evt);
            }
        });
        Empresa.add(Editar1);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        VentanaInternaEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        VentanaInternaEmpresa.setTitle("Titulo");
        VentanaInternaEmpresa.setVisible(false);
        VentanaInternaEmpresa.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        codigoEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoEmpresaKeyPressed(evt);
            }
        });
        VentanaInternaEmpresa.getContentPane().add(codigoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 250, 30));

        ventanaInterna_Nombre1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ventanaInterna_Nombre1.setForeground(new java.awt.Color(0, 153, 153));
        ventanaInterna_Nombre1.setText("EMPRESA");
        VentanaInternaEmpresa.getContentPane().add(ventanaInterna_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, -1));

        limpiarEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        limpiarEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiarEmpresa.setText("LIMPIAR");
        limpiarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarEmpresaActionPerformed(evt);
            }
        });
        VentanaInternaEmpresa.getContentPane().add(limpiarEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 140, 40));

        ListadoBusquedaEmpresa = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        ListadoBusquedaEmpresa.setBackground(new java.awt.Color(153, 204, 255));
        ListadoBusquedaEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        ListadoBusquedaEmpresa.setComponentPopupMenu(Empresa);
        ListadoBusquedaEmpresa.setFocusable(false);
        ListadoBusquedaEmpresa.setGridColor(new java.awt.Color(0, 204, 204));
        ListadoBusquedaEmpresa.setSelectionBackground(new java.awt.Color(255, 102, 102));
        ListadoBusquedaEmpresa.getTableHeader().setReorderingAllowed(false);
        ListadoBusquedaEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListadoBusquedaEmpresaMouseClicked(evt);
            }
        });
        ListadoBusquedaEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ListadoBusquedaEmpresaKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(ListadoBusquedaEmpresa);

        VentanaInternaEmpresa.getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 1190, 440));

        buscarEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        buscarEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buscarEmpresa.setText("BUSCAR");
        buscarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarEmpresaActionPerformed(evt);
            }
        });
        VentanaInternaEmpresa.getContentPane().add(buscarEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, 40));

        cancelarEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        cancelarEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelarEmpresa.setText("CANCELAR");
        cancelarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEmpresaActionPerformed(evt);
            }
        });
        VentanaInternaEmpresa.getContentPane().add(cancelarEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 160, 40));

        add(VentanaInternaEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1300, 630));

        VentanaInternaProveedor.setBackground(new java.awt.Color(255, 255, 255));
        VentanaInternaProveedor.setTitle("Titulo");
        VentanaInternaProveedor.setVisible(false);
        VentanaInternaProveedor.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        codigoProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoProveedorKeyPressed(evt);
            }
        });
        VentanaInternaProveedor.getContentPane().add(codigoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 250, 30));

        ventanaInterna_Nombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ventanaInterna_Nombre.setForeground(new java.awt.Color(0, 153, 153));
        ventanaInterna_Nombre.setText("PROVEEDOR");
        VentanaInternaProveedor.getContentPane().add(ventanaInterna_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, -1));

        limpiarProveedor.setBackground(new java.awt.Color(255, 255, 255));
        limpiarProveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiarProveedor.setText("LIMPIAR");
        limpiarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarProveedorActionPerformed(evt);
            }
        });
        VentanaInternaProveedor.getContentPane().add(limpiarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 140, 30));

        ListadoBusquedaProveedor = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        ListadoBusquedaProveedor.setBackground(new java.awt.Color(153, 204, 255));
        ListadoBusquedaProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        ListadoBusquedaProveedor.setComponentPopupMenu(Proveedor);
        ListadoBusquedaProveedor.setFocusable(false);
        ListadoBusquedaProveedor.setGridColor(new java.awt.Color(0, 204, 204));
        ListadoBusquedaProveedor.setSelectionBackground(new java.awt.Color(255, 102, 102));
        ListadoBusquedaProveedor.getTableHeader().setReorderingAllowed(false);
        ListadoBusquedaProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListadoBusquedaProveedorMouseClicked(evt);
            }
        });
        ListadoBusquedaProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ListadoBusquedaProveedorKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(ListadoBusquedaProveedor);

        VentanaInternaProveedor.getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1190, 500));

        buscarProveedor.setBackground(new java.awt.Color(255, 255, 255));
        buscarProveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buscarProveedor.setText("BUSCAR");
        buscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarProveedorActionPerformed(evt);
            }
        });
        VentanaInternaProveedor.getContentPane().add(buscarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 140, 30));

        cancelarProveedor.setBackground(new java.awt.Color(255, 255, 255));
        cancelarProveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelarProveedor.setText("CANCELAR");
        cancelarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarProveedorActionPerformed(evt);
            }
        });
        VentanaInternaProveedor.getContentPane().add(cancelarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 160, 30));

        add(VentanaInternaProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1300, 630));

        valorBusqueda_label.setFont(new java.awt.Font("Tekton Pro", 1, 12)); // NOI18N
        valorBusqueda_label.setText("BUSCAR:");
        add(valorBusqueda_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 80, 30));

        valorBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorBusquedaActionPerformed(evt);
            }
        });
        valorBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                valorBusquedaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                valorBusquedaKeyReleased(evt);
            }
        });
        add(valorBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 300, 30));

        consultar.setBackground(new java.awt.Color(255, 255, 255));
        consultar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        consultar.setText("CONSULTAR");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 130, 30));

        generarDocumento.setBackground(new java.awt.Color(255, 255, 255));
        generarDocumento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        generarDocumento.setText("GENERAR EXCEL");
        generarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarDocumentoActionPerformed(evt);
            }
        });
        add(generarDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 170, 30));

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
        tabla.setFocusable(false);
        tabla.setGridColor(new java.awt.Color(255, 255, 255));
        tabla.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 1480, 520));

        listar1.setBackground(new java.awt.Color(255, 255, 255));
        listar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        listar1.setText("LISTAR");
        listar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listar1ActionPerformed(evt);
            }
        });
        add(listar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 130, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("TIPO:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 40, 30));

        fechaInicioL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaInicioLMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fechaInicioLMouseEntered(evt);
            }
        });
        add(fechaInicioL, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 120, 30));

        fechaFinL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaFinLMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fechaFinLMouseEntered(evt);
            }
        });
        add(fechaFinL, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 110, 30));

        proveedor_nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        proveedor_nombre.setForeground(new java.awt.Color(102, 102, 102));
        proveedor_nombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        proveedor_nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proveedor_nombreMouseClicked(evt);
            }
        });
        add(proveedor_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 560, 30));

        empresa_nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        empresa_nombre.setForeground(new java.awt.Color(102, 102, 102));
        empresa_nombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        empresa_nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empresa_nombreMouseClicked(evt);
            }
        });
        add(empresa_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 560, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("INFORMES");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 160, 30));

        tipoInforme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GENERAL", "FECHA", "EMPRESA", "PROVEEDOR" }));
        tipoInforme.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoInformeItemStateChanged(evt);
            }
        });
        tipoInforme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tipoInformeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tipoInformeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tipoInformeMouseReleased(evt);
            }
        });
        tipoInforme.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tipoInformeKeyReleased(evt);
            }
        });
        add(tipoInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 210, 30));

        fecha_label2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fecha_label2.setText("FECHA FIN:");
        add(fecha_label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 100, 30));

        proveedor_label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        proveedor_label.setText("PROVEEDOR:");
        add(proveedor_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 120, 30));

        empresa_label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        empresa_label.setText("EMPRESA:");
        add(empresa_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 100, 30));

        fecha_label1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fecha_label1.setText("FECHA INICIO:");
        add(fecha_label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 100, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)tabla.getModel();
        int CantEliminar= tabla.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
            md.removeRow(i);
        }
            
        int opcion = tipoInforme.getSelectedIndex();
        switch(opcion){
            case 0:{//General
                try{
                    tabla_Informe_General(valorBusqueda.getText());
                }catch(Exception e){
                }
                break;
            }
            case 1:{//Fecha
                try{
                    String fechaInicio="";
                    String fechaFinal ="";
                    Calendar fechaI = fechaInicioL.getCalendar();
                    String anoI = ""+fechaI.get(Calendar.YEAR);
                    String mesI = "";
                    if((fechaI.get(Calendar.MONTH) +1) <=9){
                        mesI = "0"+(fechaI.get(Calendar.MONTH) + 1);
                    }else{
                        mesI = ""+(fechaI.get(Calendar.MONTH) + 1);
                    }
                    String diaI = "";
                    if(fechaI.get(Calendar.DAY_OF_MONTH) <=9){
                        diaI = "0"+fechaI.get(Calendar.DAY_OF_MONTH);
                    }else{
                        diaI = ""+fechaI.get(Calendar.DAY_OF_MONTH);
                    }
                     fechaInicio=anoI+"-"+mesI+"-"+diaI;

                    Calendar fechaF = fechaFinL.getCalendar();
                    String anoF = ""+fechaF.get(Calendar.YEAR);
                    String mesF = "";
                    if((fechaF.get(Calendar.MONTH) +1) <=9){
                        mesF = "0"+(fechaF.get(Calendar.MONTH) + 1);
                    }else{
                        mesF = ""+(fechaF.get(Calendar.MONTH) + 1);
                    }
                    String diaF = "";
                    if(fechaF.get(Calendar.DAY_OF_MONTH) <=9){
                        diaF = "0"+fechaF.get(Calendar.DAY_OF_MONTH);
                    }else{
                        diaF = ""+fechaF.get(Calendar.DAY_OF_MONTH);
                    }
                     fechaFinal=anoF+"-"+mesF+"-"+diaF;  
                     fechaIniB=fechaInicio;
                     fechaFinB=fechaFinal;
                     try{
                        tabla_Informe_FechaRegistro(fechaInicio,fechaFinal);
                    }catch(Exception e){
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Verifique formatos de fechas");
                }
                break;
            }
            case 2:{//Empresa
                try{
                    tabla_Informe_Empresa(empresa_nitS);
                }catch(Exception e){
                }
                break;
            }
            case 3:{//Proveedor
                try{
                    tabla_InformeProveedor(proveedor_nitS);
                }catch(Exception e){
                }
                break;
            }
            default:{
                break;
            }
        }    
    }//GEN-LAST:event_consultarActionPerformed

    private void generarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarDocumentoActionPerformed
       /* Generar_Reportes gr = new Generar_Reportes();
        int opcion = tipoInforme.getSelectedIndex();
        switch(opcion){
            case 0:{//General
                try{
                   gr.generarInformeGeneral("%"+valorBusqueda.getText()+"%");
                }catch(Exception e){}
                break;
            }
            case 1:{//Fecha
                 gr.generarInformeFecha(fechaIniB,fechaFinB);
                break;
            }
            case 2:{//Empresa
                gr.generarInformeEmpresa(empresa_nitS);
                break;
            }
            case 3:{//Proveedor
                gr.generarInformeProveedor(proveedor_nitS);
                break;
            }
            default:{
                break;
            }
        }   */
        JFileChooser selecArchivo= new JFileChooser();
        File archivo;
        selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)", "xls"));
        selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
        if(selecArchivo.showDialog(null, "Exportar") ==JFileChooser.APPROVE_OPTION){
            archivo=selecArchivo.getSelectedFile();
            if(archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")){
                //JOptionPane.showMessageDialog(null, Exportar(archivo));
                Workbook wb;
                String respuesta="No se realizó con exito la exportacion";
                int numFila=tabla.getRowCount(), numColumna=tabla.getColumnCount();
                if(archivo.getName().endsWith("xls")){
                    wb = new HSSFWorkbook();
                }else{
                    wb= new XSSFWorkbook();
                }
                Sheet hoja= wb.createSheet("Descargue_Carbón");
                try{
                    for(int i= -1; i < numFila; i++ ){
                        Row fila= hoja.createRow(i+1);
                        for(int j=0; j< numColumna; j++){
                            Cell celda= fila.createCell(j);
                            if(i==-1){
                                celda.setCellValue(String.valueOf(tabla.getColumnName(j)));
                            }else{
                                try{
                                    String[] valor=String.valueOf(tabla.getValueAt(i, j)).split("-");
                                    if(valor.length==3){
                                         String[] valor2=valor[2].split(":");
                                        if(valor2.length >= 3){
                                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                            Date fechaM = dateFormat.parse(String.valueOf(tabla.getValueAt(i, j)));
                                            celda.setCellValue(fechaM);
                                        }else{
                                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                            Date fechaM = dateFormat.parse(tabla.getValueAt(i, j).toString());
                                            celda.setCellValue(fechaM);
                                        }
                                    }else{
                                        try{
                                            celda.setCellValue(Integer.parseInt(tabla.getValueAt(i, j).toString()));
                                        }catch(Exception e){
                                            celda.setCellValue(String.valueOf(tabla.getValueAt(i, j)));
                                        }
                                    }   
                                }catch(Exception e){
                                    celda.setCellValue(String.valueOf(tabla.getValueAt(i, j)));
                                }
                            }
                        }
                    }
                    for(int j=0; j<=numColumna; j++){
                        hoja.autoSizeColumn(j,true);
                    }
                    wb.write(new FileOutputStream(archivo));
                    respuesta= "Exportacion exitosa";
                }catch(Exception e){
                }
                JOptionPane.showMessageDialog(null, respuesta);
            }else{
                JOptionPane.showMessageDialog(null,"Elija un formato valido");
            }
        }   
    }//GEN-LAST:event_generarDocumentoActionPerformed

    private void valorBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorBusquedaKeyPressed
         
    }//GEN-LAST:event_valorBusquedaKeyPressed

    private void listar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listar1ActionPerformed
        try {
            tabla_Informe_General("");
        } catch (SQLException ex) {
            Logger.getLogger(Informe_Generar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listar1ActionPerformed

    private void valorBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorBusquedaActionPerformed

    private void fechaInicioLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaInicioLMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaInicioLMouseClicked

    private void fechaInicioLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaInicioLMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaInicioLMouseEntered

    private void fechaFinLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaFinLMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaFinLMouseClicked

    private void fechaFinLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaFinLMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaFinLMouseEntered

    private void proveedor_nombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proveedor_nombreMouseClicked
        codigoProveedor.setText("");
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)ListadoBusquedaProveedor.getModel();
        int CantEliminar= ListadoBusquedaProveedor.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
           md.removeRow(i);
        }
        DefaultTableModel modelo;
        String [] titulo= {"NIT","DIG","NOMBRE","CORREO.","TELEFONO","ESTADO"};
        String [] registro = new String[6]; 
        modelo = new DefaultTableModel(null, titulo);
        ListadoBusquedaProveedor.setModel(modelo);
        VentanaInternaProveedor.show(true);
        VentanaInternaProveedor.setTitle("Listado De Proveedor");
        TextPrompt placeholder = new TextPrompt("Buscar por Nit o Nombre:", codigoProveedor);       
    }//GEN-LAST:event_proveedor_nombreMouseClicked

    private void codigoProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoProveedorKeyPressed
        DefaultTableModel modelo;
        String []titulo= {"NIT","DIG","NOMBRE","CORREO.","TELEFONO","ESTADO"};
        String [] registro = new String[6]; 
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_Proveedor controlDB_Proveedor = new ControlDB_Proveedor();
        ArrayList<Proveedor> listadoProveedores = null;
        try {
            listadoProveedores = controlDB_Proveedor.buscarProveedor(codigoProveedor.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Informe_Generar.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i =0; i< listadoProveedores.size(); i++){ 
            registro[0]=""+listadoProveedores.get(i).getNit_proveedor();
            registro[1]=""+listadoProveedores.get(i).getDig_proveedor();
            registro[2]=""+listadoProveedores.get(i).getNombre_proveedor();
            registro[3]=""+listadoProveedores.get(i).getCorreo_proveedor();
            registro[4]=""+listadoProveedores.get(i).getTelefono_proveedor();
            registro[5]=""+controlDB_Proveedor.convertidorEstadoID_x_Nombre(listadoProveedores.get(i).getId_estadoProveedor());
            modelo.addRow(registro);
            ListadoBusquedaProveedor.setModel(modelo);
            //JOptionPane.showMessageDialog(null, "Hola si hay info"+listadoClientes.get(i).getNit()+listadoClientes.get(i).getDigitoVerificacion()+listadoClientes.get(i).getNombre());
        }
    }//GEN-LAST:event_codigoProveedorKeyPressed

    private void limpiarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarProveedorActionPerformed
        codigoProveedor.setText("");
    }//GEN-LAST:event_limpiarProveedorActionPerformed

    private void ListadoBusquedaProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ListadoBusquedaProveedorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListadoBusquedaProveedorKeyPressed

    private void buscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarProveedorActionPerformed
        DefaultTableModel modelo;
        String []titulo= {"NIT","DIG","NOMBRE","CORREO.","TELEFONO","ESTADO"};
        String [] registro = new String[6]; 
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_Proveedor controlDB_Proveedor = new ControlDB_Proveedor();
        ArrayList<Proveedor> listadoProveedores = null;
        try {
            listadoProveedores = controlDB_Proveedor.buscarProveedor(codigoProveedor.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Informe_Generar.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i =0; i< listadoProveedores.size(); i++){ 
            registro[0]=""+listadoProveedores.get(i).getNit_proveedor();
            registro[1]=""+listadoProveedores.get(i).getDig_proveedor();
            registro[2]=""+listadoProveedores.get(i).getNombre_proveedor();
            registro[3]=""+listadoProveedores.get(i).getCorreo_proveedor();
            registro[4]=""+listadoProveedores.get(i).getTelefono_proveedor();
            registro[5]=""+controlDB_Proveedor.convertidorEstadoID_x_Nombre(listadoProveedores.get(i).getId_estadoProveedor());
            modelo.addRow(registro);
            ListadoBusquedaProveedor.setModel(modelo);
            //JOptionPane.showMessageDialog(null, "Hola si hay info"+listadoClientes.get(i).getNit()+listadoClientes.get(i).getDigitoVerificacion()+listadoClientes.get(i).getNombre());
        }
    }//GEN-LAST:event_buscarProveedorActionPerformed

    private void cancelarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarProveedorActionPerformed
        VentanaInternaProveedor.show(false);
    }//GEN-LAST:event_cancelarProveedorActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        ControlDB_Proveedor controlDB_Proveedor = new ControlDB_Proveedor();
            int fila1;
            try{
                fila1=ListadoBusquedaProveedor.getSelectedRow();
                if(fila1==-1){
                    JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
                }
                else{
                    try{
                        modelo=(DefaultTableModel)ListadoBusquedaProveedor.getModel();
                        String nitProveedor=(String)modelo.getValueAt(fila1, 0);
                        Proveedor prov=new Proveedor();
                        prov.setNit_proveedor(nitProveedor);
                        Proveedor proveedor=controlDB_Proveedor.consultarProvedorID(prov);
                        if(proveedor != null){
                            try{
                                proveedor_nitS =proveedor.getNit_proveedor();
                                proveedor_nombreS=""+proveedor.getNombre_proveedor();
                                proveedor_nombre.setText(""+proveedor.getNombre_proveedor());
                            }catch(Exception e){
                            }
                        }
                        //Eliminamos la Busqueda Actual#######################################################
                        DefaultTableModel md =(DefaultTableModel)ListadoBusquedaProveedor.getModel();
                        int CantEliminar= ListadoBusquedaProveedor.getRowCount() -1;
                        for(int i =CantEliminar; i>=0; i--){
                            md.removeRow(i);
                        }
                        //######################################################################################
                        VentanaInternaProveedor.show(false);
                    }catch(Exception e){
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "No se pudo cargar el Proveedor");
                    }
                }
            }catch(Exception e){
            }
    }//GEN-LAST:event_EditarActionPerformed

    private void codigoEmpresaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoEmpresaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoEmpresaKeyPressed

    private void limpiarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarEmpresaActionPerformed
        codigoEmpresa.setText("");
    }//GEN-LAST:event_limpiarEmpresaActionPerformed

    private void ListadoBusquedaEmpresaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ListadoBusquedaEmpresaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListadoBusquedaEmpresaKeyPressed

    private void buscarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarEmpresaActionPerformed
        DefaultTableModel modelo;
        String []titulo= {"NIT","DIG","NOMBRE","CORREO.","TELEFONO","ESTADO"};
        String [] registro = new String[6]; 
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_Empresa controlDB_Empresa = new ControlDB_Empresa();
        ArrayList<Empresa> listadoEmpresa = null;
        try {
            listadoEmpresa = controlDB_Empresa.buscarEmpresa(codigoEmpresa.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Informe_Generar.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i =0; i< listadoEmpresa.size(); i++){ 
            registro[0]=""+listadoEmpresa.get(i).getNit_empresa();
            registro[1]=""+listadoEmpresa.get(i).getDig_empresa();
            registro[2]=""+listadoEmpresa.get(i).getNombre_empresa();
            registro[3]=""+listadoEmpresa.get(i).getCorreo_empresa();
            registro[4]=""+listadoEmpresa.get(i).getTelefono_empresa();
            registro[5]=""+controlDB_Empresa.convertidorEstadoID_x_Nombre(listadoEmpresa.get(i).getId_estadoEmpresa());
            modelo.addRow(registro);
            ListadoBusquedaEmpresa.setModel(modelo);
            //JOptionPane.showMessageDialog(null, "Hola si hay info"+listadoClientes.get(i).getNit()+listadoClientes.get(i).getDigitoVerificacion()+listadoClientes.get(i).getNombre());
        }
    }//GEN-LAST:event_buscarEmpresaActionPerformed

    private void cancelarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEmpresaActionPerformed
        VentanaInternaEmpresa.show(false);
    }//GEN-LAST:event_cancelarEmpresaActionPerformed

    private void Editar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar1ActionPerformed
        int fila1;
        try{
            fila1=ListadoBusquedaEmpresa.getSelectedRow();
            if(fila1==-1){
                JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
            }
            else{
                try{
                    modelo=(DefaultTableModel)ListadoBusquedaEmpresa.getModel();
                    String nitEmpresa=(String)modelo.getValueAt(fila1, 0);
                    Empresa emp=new Empresa();
                    emp.setNit_empresa(nitEmpresa);
                    ControlDB_Empresa controlDB_Empresa = new ControlDB_Empresa();
                    Empresa empresa=controlDB_Empresa.consultarEmpresaID(emp);
                    if(empresa != null){
                            empresa_nitS =empresa.getNit_empresa();
                            empresa_nombreS =empresa.getNombre_empresa();                               
                            empresa_nombre.setText(""+empresa.getNombre_empresa());    
                    }
                    //Eliminamos la Busqueda Actual#######################################################
                    DefaultTableModel md =(DefaultTableModel)ListadoBusquedaEmpresa.getModel();
                    int CantEliminar= ListadoBusquedaEmpresa.getRowCount() -1;
                    for(int i =CantEliminar; i>=0; i--){
                        md.removeRow(i);
                    }
                    //######################################################################################
                    VentanaInternaEmpresa.show(false);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No se pudo cargar la empresa");
                }
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_Editar1ActionPerformed

    private void empresa_nombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empresa_nombreMouseClicked
        codigoEmpresa.setText("");
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)ListadoBusquedaEmpresa.getModel();
        int CantEliminar= ListadoBusquedaEmpresa.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
           md.removeRow(i);
        }
        DefaultTableModel modelo;
        String [] titulo= {"NIT","DIG","NOMBRE","CORREO","TELEFONO","ESTADO"};
        String [] registro = new String[6]; 
        modelo = new DefaultTableModel(null, titulo);
        ListadoBusquedaEmpresa.setModel(modelo);
        VentanaInternaEmpresa.show(true);
        VentanaInternaEmpresa.setTitle("Listado De Compañias");
        TextPrompt placeholder = new TextPrompt("Buscar por Nit o Nombre:", codigoProveedor);  
    }//GEN-LAST:event_empresa_nombreMouseClicked

    private void valorBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorBusquedaKeyReleased
        
    }//GEN-LAST:event_valorBusquedaKeyReleased

    private void tipoInformeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipoInformeKeyReleased
        
    }//GEN-LAST:event_tipoInformeKeyReleased

    private void tipoInformeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tipoInformeMousePressed
        
    }//GEN-LAST:event_tipoInformeMousePressed

    private void tipoInformeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tipoInformeMouseReleased
     
    }//GEN-LAST:event_tipoInformeMouseReleased

    private void tipoInformeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tipoInformeMouseClicked
         
    }//GEN-LAST:event_tipoInformeMouseClicked

    private void tipoInformeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoInformeItemStateChanged
        int opcion = tipoInforme.getSelectedIndex();
        switch(opcion){
            case 0:{//General
                valorBusqueda_label.show(true);
                valorBusqueda.show(true);
                fecha_label1.show(false);
                fechaInicioL.show(false);
                fecha_label2.show(false);
                fechaFinL.show(false);
                empresa_label.show(false);
                empresa_nombre.show(false);
                proveedor_label.show(false);
                proveedor_nombre.show(false);
                break;
            }
            case 1:{//Fecha
                valorBusqueda_label.show(false);
                valorBusqueda.show(false);
                fecha_label1.show(true);
                fechaInicioL.show(true);
                fecha_label2.show(true);
                fechaFinL.show(true);
                empresa_label.show(false);
                empresa_nombre.show(false);
                proveedor_label.show(false);
                proveedor_nombre.show(false);
                break;
            }
            case 2:{//Empresa
                valorBusqueda_label.show(false);
                valorBusqueda.show(false);
                fecha_label1.show(false);
                fechaInicioL.show(false);
                fecha_label2.show(false);
                fechaFinL.show(false);
                empresa_label.show(true);
                empresa_nombre.show(true);
                proveedor_label.show(false);
                proveedor_nombre.show(false);
                break;
            }
            case 3:{//Proveedor
                valorBusqueda_label.show(false);
                valorBusqueda.show(false);
                fecha_label1.show(false);
                fechaInicioL.show(false);
                fecha_label2.show(false);
                fechaFinL.show(false);
                empresa_label.show(false);
                empresa_nombre.show(false);
                proveedor_label.show(true);
                proveedor_nombre.show(true);
                break;
            }
            default:{
                break;
            }
        }    
    }//GEN-LAST:event_tipoInformeItemStateChanged

    private void ListadoBusquedaProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListadoBusquedaProveedorMouseClicked
        if (evt.getClickCount() == 2) {
            ControlDB_Proveedor controlDB_Proveedor = new ControlDB_Proveedor();
            int fila1;
            try{
                fila1=ListadoBusquedaProveedor.getSelectedRow();
                if(fila1==-1){
                    JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
                }
                else{
                    try{
                        modelo=(DefaultTableModel)ListadoBusquedaProveedor.getModel();
                        String nitProveedor=(String)modelo.getValueAt(fila1, 0);
                        Proveedor prov=new Proveedor();
                        prov.setNit_proveedor(nitProveedor);
                        Proveedor proveedor=controlDB_Proveedor.consultarProvedorID(prov);
                        if(proveedor != null){
                            try{
                                proveedor_nitS =proveedor.getNit_proveedor();
                                proveedor_nombreS=""+proveedor.getNombre_proveedor();
                                proveedor_nombre.setText(""+proveedor.getNombre_proveedor());
                            }catch(Exception e){
                            }
                        }
                        //Eliminamos la Busqueda Actual#######################################################
                        DefaultTableModel md =(DefaultTableModel)ListadoBusquedaProveedor.getModel();
                        int CantEliminar= ListadoBusquedaProveedor.getRowCount() -1;
                        for(int i =CantEliminar; i>=0; i--){
                            md.removeRow(i);
                        }
                        //######################################################################################
                        VentanaInternaProveedor.show(false);
                    }catch(Exception e){
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "No se pudo cargar el Proveedor");
                    }
                }
            }catch(Exception e){
            }
        }
    }//GEN-LAST:event_ListadoBusquedaProveedorMouseClicked

    private void ListadoBusquedaEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListadoBusquedaEmpresaMouseClicked
        if (evt.getClickCount() == 2) {
            int fila1;
            try{
                fila1=ListadoBusquedaEmpresa.getSelectedRow();
                if(fila1==-1){
                    JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
                }
                else{
                    try{
                        modelo=(DefaultTableModel)ListadoBusquedaEmpresa.getModel();
                        String nitEmpresa=(String)modelo.getValueAt(fila1, 0);
                        Empresa emp=new Empresa();
                        emp.setNit_empresa(nitEmpresa);
                        ControlDB_Empresa controlDB_Empresa = new ControlDB_Empresa();
                        Empresa empresa=controlDB_Empresa.consultarEmpresaID(emp);
                        if(empresa != null){
                                empresa_nitS =empresa.getNit_empresa();
                                empresa_nombreS =empresa.getNombre_empresa();                               
                                empresa_nombre.setText(""+empresa.getNombre_empresa());    
                        }
                        //Eliminamos la Busqueda Actual#######################################################
                        DefaultTableModel md =(DefaultTableModel)ListadoBusquedaEmpresa.getModel();
                        int CantEliminar= ListadoBusquedaEmpresa.getRowCount() -1;
                        for(int i =CantEliminar; i>=0; i--){
                            md.removeRow(i);
                        }
                        //######################################################################################
                        VentanaInternaEmpresa.show(false);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "No se pudo cargar la empresa");
                    }
                }
            }catch(Exception e){
            }
        }
    }//GEN-LAST:event_ListadoBusquedaEmpresaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Editar1;
    private javax.swing.JPopupMenu Empresa;
    private javax.swing.JTable ListadoBusquedaEmpresa;
    private javax.swing.JTable ListadoBusquedaProveedor;
    private javax.swing.JPopupMenu Proveedor;
    private javax.swing.JInternalFrame VentanaInternaEmpresa;
    private javax.swing.JInternalFrame VentanaInternaProveedor;
    private javax.swing.JButton buscarEmpresa;
    private javax.swing.JButton buscarProveedor;
    private javax.swing.JButton cancelarEmpresa;
    private javax.swing.JButton cancelarProveedor;
    private javax.swing.JTextField codigoEmpresa;
    private javax.swing.JTextField codigoProveedor;
    private javax.swing.JButton consultar;
    private javax.swing.JLabel empresa_label;
    private javax.swing.JLabel empresa_nombre;
    private com.toedter.calendar.JDateChooser fechaFinL;
    private com.toedter.calendar.JDateChooser fechaInicioL;
    private javax.swing.JLabel fecha_label1;
    private javax.swing.JLabel fecha_label2;
    private javax.swing.JButton generarDocumento;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton limpiarEmpresa;
    private javax.swing.JButton limpiarProveedor;
    private javax.swing.JButton listar1;
    private javax.swing.JLabel proveedor_label;
    private javax.swing.JLabel proveedor_nombre;
    private javax.swing.JTable tabla;
    private javax.swing.JComboBox<String> tipoInforme;
    private javax.swing.JTextField valorBusqueda;
    private javax.swing.JLabel valorBusqueda_label;
    private javax.swing.JLabel ventanaInterna_Nombre;
    private javax.swing.JLabel ventanaInterna_Nombre1;
    // End of variables declaration//GEN-END:variables
    public void tabla_Informe_General(String valorConsulta) throws SQLException{
        registro = new String[15]; 
        String [] titulo= {"IdHistorico","idDocumento","No. Factura",
                           "Nit_Proveedor", "Nombre_Proveedor" ,"EstadoHistorico",
                           "EstadoDocumento","Observación","Usuario_Origen","Usuario_Destino",
                           "Empresa_Destino","Sede","Fecha_Registro",
                           "Fecha_Anulacion","Observacion_Anulacion"};    
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_Radicacion c = new ControlDB_Radicacion();
        ArrayList<ConsultaGeneralInforme> listadoConsultaGeneralInforme=c.Informe_General(valorConsulta);
        for(int i =0; i< listadoConsultaGeneralInforme.size(); i++){
            registro[0]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_id_historicoDocumento();
            registro[1]=""+listadoConsultaGeneralInforme.get(i).getDocumento_id_documento();
            registro[2]=""+listadoConsultaGeneralInforme.get(i).getDocumento_numFactura_documento();
            registro[3]=""+listadoConsultaGeneralInforme.get(i).getDocumento_nit_proveedor();
            registro[4]=""+listadoConsultaGeneralInforme.get(i).getProveedor_nombre_proveedor();
            registro[5]=""+listadoConsultaGeneralInforme.get(i).getEstadohistorico_descripcion_estadoHistorico();
            registro[6]=""+listadoConsultaGeneralInforme.get(i).getEstadodocumento_descripcion_estadoDocumento();
            registro[7]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_observacion_historicoDocumento();
            registro[8]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_usuarioRegistro_historicoDocumento();
            registro[9]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_usuarioDestino_historicoDocumento();
            registro[10]=""+listadoConsultaGeneralInforme.get(i).getEmpresa_nombre_empresa();
            registro[11]=""+listadoConsultaGeneralInforme.get(i).getSede_nombre_sede();
            registro[12]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_fechaRegistro_historicoDocumento();
            registro[13]=""+listadoConsultaGeneralInforme.get(i).getDocumento_fechaAnulacion_documento();
            registro[14]=""+listadoConsultaGeneralInforme.get(i).getDocumento_observacionAnulacion_documento();
            modelo.addRow(registro);
            tabla.setModel(modelo);
        }
    }
    public void tabla_Informe_FechaRegistro(String fecha_ini, String fecha_fin) throws SQLException{
        registro = new String[15]; 
        String [] titulo= {"IdHistorico","idDocumento","No. Factura",
                           "Nit_Proveedor", "Nombre_Proveedor" ,"EstadoHistorico",
                           "EstadoDocumento","Observación","Usuario_Origen","Usuario_Destino",
                           "Empresa_Destino","Sede","Fecha_Registro",
                           "Fecha_Anulacion","Observacion_Anulacion"};       
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_Radicacion c = new ControlDB_Radicacion();
        ArrayList<ConsultaGeneralInforme> listadoConsultaGeneralInforme=c.Informe_FechaRegistro(fecha_ini,fecha_fin);
        for(int i =0; i< listadoConsultaGeneralInforme.size(); i++){
            registro[0]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_id_historicoDocumento();
            registro[1]=""+listadoConsultaGeneralInforme.get(i).getDocumento_id_documento();
            registro[2]=""+listadoConsultaGeneralInforme.get(i).getDocumento_numFactura_documento();
            registro[3]=""+listadoConsultaGeneralInforme.get(i).getDocumento_nit_proveedor();
            registro[4]=""+listadoConsultaGeneralInforme.get(i).getProveedor_nombre_proveedor();
            registro[5]=""+listadoConsultaGeneralInforme.get(i).getEstadohistorico_descripcion_estadoHistorico();
            registro[6]=""+listadoConsultaGeneralInforme.get(i).getEstadodocumento_descripcion_estadoDocumento();
            registro[7]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_observacion_historicoDocumento();
            registro[8]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_usuarioRegistro_historicoDocumento();
            registro[9]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_usuarioDestino_historicoDocumento();
            registro[10]=""+listadoConsultaGeneralInforme.get(i).getEmpresa_nombre_empresa();
            registro[11]=""+listadoConsultaGeneralInforme.get(i).getSede_nombre_sede();
            registro[12]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_fechaRegistro_historicoDocumento();
            registro[13]=""+listadoConsultaGeneralInforme.get(i).getDocumento_fechaAnulacion_documento();
            registro[14]=""+listadoConsultaGeneralInforme.get(i).getDocumento_observacionAnulacion_documento();
            modelo.addRow(registro);
            tabla.setModel(modelo);
        }
    }
    public void tabla_Informe_Empresa(String nitEmpresa) throws SQLException{
        registro = new String[15]; 
        String [] titulo= {"IdHistorico","idDocumento","No. Factura",
                           "Nit_Proveedor", "Nombre_Proveedor" ,"EstadoHistorico",
                           "EstadoDocumento","Observación","Usuario_Origen","Usuario_Destino",
                           "Empresa_Destino","Sede","Fecha_Registro",
                           "Fecha_Anulacion","Observacion_Anulacion"};     
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_Radicacion c = new ControlDB_Radicacion();
        ArrayList<ConsultaGeneralInforme> listadoConsultaGeneralInforme=c.Informe_Empresa(nitEmpresa);
        for(int i =0; i< listadoConsultaGeneralInforme.size(); i++){
            registro[0]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_id_historicoDocumento();
            registro[1]=""+listadoConsultaGeneralInforme.get(i).getDocumento_id_documento();
            registro[2]=""+listadoConsultaGeneralInforme.get(i).getDocumento_numFactura_documento();
            registro[3]=""+listadoConsultaGeneralInforme.get(i).getDocumento_nit_proveedor();
            registro[4]=""+listadoConsultaGeneralInforme.get(i).getProveedor_nombre_proveedor();
            registro[5]=""+listadoConsultaGeneralInforme.get(i).getEstadohistorico_descripcion_estadoHistorico();
            registro[6]=""+listadoConsultaGeneralInforme.get(i).getEstadodocumento_descripcion_estadoDocumento();
            registro[7]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_observacion_historicoDocumento();
            registro[8]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_usuarioRegistro_historicoDocumento();
            registro[9]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_usuarioDestino_historicoDocumento();
            registro[10]=""+listadoConsultaGeneralInforme.get(i).getEmpresa_nombre_empresa();
            registro[11]=""+listadoConsultaGeneralInforme.get(i).getSede_nombre_sede();
            registro[12]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_fechaRegistro_historicoDocumento();
            registro[13]=""+listadoConsultaGeneralInforme.get(i).getDocumento_fechaAnulacion_documento();
            registro[14]=""+listadoConsultaGeneralInforme.get(i).getDocumento_observacionAnulacion_documento();
            modelo.addRow(registro);
            tabla.setModel(modelo);
        }
    }
    public void tabla_InformeProveedor(String nitProveedor) throws SQLException{
        registro = new String[15]; 
        String [] titulo= {"IdHistorico","idDocumento","No. Factura",
                           "Nit_Proveedor", "Nombre_Proveedor" ,"EstadoHistorico",
                           "EstadoDocumento","Observación","Usuario_Origen","Usuario_Destino",
                           "Empresa_Destino","Sede","Fecha_Registro",
                           "Fecha_Anulacion","Observacion_Anulacion"};    
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_Radicacion c = new ControlDB_Radicacion();
        ArrayList<ConsultaGeneralInforme> listadoConsultaGeneralInforme=c.Informe_Proveedor(nitProveedor);   
        for(int i =0; i< listadoConsultaGeneralInforme.size(); i++){
            registro[0]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_id_historicoDocumento();
            registro[1]=""+listadoConsultaGeneralInforme.get(i).getDocumento_id_documento();
            registro[2]=""+listadoConsultaGeneralInforme.get(i).getDocumento_numFactura_documento();
            registro[3]=""+listadoConsultaGeneralInforme.get(i).getDocumento_nit_proveedor();
            registro[4]=""+listadoConsultaGeneralInforme.get(i).getProveedor_nombre_proveedor();
            registro[5]=""+listadoConsultaGeneralInforme.get(i).getEstadohistorico_descripcion_estadoHistorico();
            registro[6]=""+listadoConsultaGeneralInforme.get(i).getEstadodocumento_descripcion_estadoDocumento();
            registro[7]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_observacion_historicoDocumento();
            registro[8]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_usuarioRegistro_historicoDocumento();
            registro[9]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_usuarioDestino_historicoDocumento();
            registro[10]=""+listadoConsultaGeneralInforme.get(i).getEmpresa_nombre_empresa();
            registro[11]=""+listadoConsultaGeneralInforme.get(i).getSede_nombre_sede();
            registro[12]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_fechaRegistro_historicoDocumento();
            registro[13]=""+listadoConsultaGeneralInforme.get(i).getDocumento_fechaAnulacion_documento();
            registro[14]=""+listadoConsultaGeneralInforme.get(i).getDocumento_observacionAnulacion_documento();
            modelo.addRow(registro);
            tabla.setModel(modelo);
        }
    }
}
