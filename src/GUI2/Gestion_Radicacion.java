package GUI2;
 
import Controladores.ControlDB_Empresa;
import Controladores.ControlDB_EnvioDocumento;
import Controladores.ControlDB_Proveedor; 
import Controladores.ControlDB_Radicacion;
import Controladores.ControlDB_Usuario;
import Controladores.EnviarConGmail;
import Controladores.ImpresionRadicado;
import Controladores.TextPrompt;
import Modelos.Consultas.ImprimirRadicacion;
import Modelos.Documento;
import Modelos.Empresa;
import Modelos.HistoricoDocumento;
import Modelos.Proveedor;
import Modelos.Sede;
import Modelos.Usuario;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Gestion_Radicacion extends javax.swing.JPanel {
    private String proveedor_nitS="";
    private String proveedor_nombreS="";
    private String proveedor_correoS="";
    
    private String empresa_nitS="";
    private String empresa_nombreS="";
    
    private String usuario_idS="";
    private String usuario_nombreS="";
    private String usuario_correoS="";
     
    String valor="";
    String accion="";
    Usuario user;

    String [] registro;
    DefaultTableModel modelo;
    int consecutivoRadicacion =18072;     
    ControlDB_Radicacion controlDB_Radicacion = new ControlDB_Radicacion();
    public Gestion_Radicacion(Usuario u) {
        initComponents();
        
        user=u;
        VentanaInterna.show(false);      
        VentanaInternaBuscarUsuario.show(false);  
        VentanaInternaRegistrar.show(false); 
        
        VentanaInternaRegistrar.getContentPane().setBackground(Color.WHITE);
        VentanaInternaBuscarUsuario.getContentPane().setBackground(Color.WHITE);
        VentanaInterna.getContentPane().setBackground(Color.WHITE);
        //#########################################################
        
        try{
            int consecutivo = controlDB_Radicacion.retornarElMaximoDocumento();
            if(consecutivo == 0){//no hay registro en la tabla documento
                numeroRadicado.setText(""+consecutivoRadicacion); //inicializamos con el valor inicial
            }else{
                consecutivoRadicacion = consecutivo;
                consecutivoRadicacion++;
                numeroRadicado.setText(""+consecutivoRadicacion);
            }
        }catch(Exception e){
            numeroRadicado.setText(""+consecutivoRadicacion);
        } 
        //Cargamos en la interfaz las Sedes
        ArrayList<Sede> listadoSede = new ArrayList();
        listadoSede=controlDB_Radicacion.cargarSede();
        for(int i=0; i< listadoSede.size(); i++){
            Sede_Listado.addItem(listadoSede.get(i).getNombre_sede());
        }
        Sede_Listado.setSelectedIndex(0); //ALMACEN OPP
        //Sede_Listado.setSelectedIndex(1); //RECEPCION COSMOS
        //Sede_Listado.setSelectedIndex(2); //ALMACEN MUELLE 13
        //Sede_Listado.setSelectedIndex(3); //RECEPCION_MUELLE_12_OPP
        //Sede_Listado.setSelectedIndex(4); //RECEPCION_BOGOTÁ
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Seleccionar = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        SeleccionarUsuario = new javax.swing.JPopupMenu();
        seleccionar = new javax.swing.JMenuItem();
        VentanaInternaRegistrar = new javax.swing.JInternalFrame();
        panel = new javax.swing.JScrollPane();
        jButton1 = new javax.swing.JButton();
        VentanaInternaBuscarUsuario = new javax.swing.JInternalFrame();
        buscarUsuario = new javax.swing.JTextField();
        ventanaInterna_Nombre1 = new javax.swing.JLabel();
        limpiarUsuarios = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        ListadoBusquedaUsuario = new javax.swing.JTable();
        cancelarUsuario = new javax.swing.JButton();
        VentanaInterna = new javax.swing.JInternalFrame();
        codigo = new javax.swing.JTextField();
        ventanaInterna_Nombre = new javax.swing.JLabel();
        limpiar1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListadoBusquedas = new javax.swing.JTable();
        cancelar1 = new javax.swing.JButton();
        numeroFactura = new javax.swing.JTextField();
        Sede_Listado = new javax.swing.JComboBox<>();
        PersonaNatural_apellidosL = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        numeroRadicado = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        proveedor_nombre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        observacion = new javax.swing.JTextArea();
        Registrar1 = new javax.swing.JButton();
        PersonaNatural_apellidosL1 = new javax.swing.JLabel();
        Registrar3 = new javax.swing.JButton();
        PersonaNatural_apellidosL2 = new javax.swing.JLabel();
        Registrar4 = new javax.swing.JButton();
        PersonaNatural_apellidosL3 = new javax.swing.JLabel();
        Registrar2 = new javax.swing.JButton();
        empresa_nombre = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        usuario_nombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mensaje = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        proveedor_nit = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        proveedor_correo = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        empresa_nit = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        usuario_correo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        Editar.setText("Seleccionar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        Seleccionar.add(Editar);

        seleccionar.setText("Seleccionar");
        seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarActionPerformed(evt);
            }
        });
        SeleccionarUsuario.add(seleccionar);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        VentanaInternaRegistrar.setVisible(false);
        VentanaInternaRegistrar.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMouseClicked(evt);
            }
        });
        VentanaInternaRegistrar.getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1260, 490));

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        VentanaInternaRegistrar.getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, 30));

        add(VentanaInternaRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1300, 630));

        VentanaInternaBuscarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        VentanaInternaBuscarUsuario.setTitle("Titulo");
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
        VentanaInternaBuscarUsuario.getContentPane().add(buscarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 250, 30));

        ventanaInterna_Nombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ventanaInterna_Nombre1.setForeground(new java.awt.Color(102, 102, 102));
        ventanaInterna_Nombre1.setText("BUSCAR USUARIOS");
        VentanaInternaBuscarUsuario.getContentPane().add(ventanaInterna_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, -1));

        limpiarUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        limpiarUsuarios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiarUsuarios.setForeground(new java.awt.Color(102, 102, 102));
        limpiarUsuarios.setText("LIMPIAR");
        limpiarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarUsuariosActionPerformed(evt);
            }
        });
        VentanaInternaBuscarUsuario.getContentPane().add(limpiarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 150, 30));

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

        VentanaInternaBuscarUsuario.getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1130, 420));

        cancelarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        cancelarUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelarUsuario.setForeground(new java.awt.Color(102, 102, 102));
        cancelarUsuario.setText("CANCELAR");
        cancelarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarUsuarioActionPerformed(evt);
            }
        });
        VentanaInternaBuscarUsuario.getContentPane().add(cancelarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 150, 30));

        add(VentanaInternaBuscarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1300, 630));

        VentanaInterna.setBackground(new java.awt.Color(255, 255, 255));
        VentanaInterna.setTitle("Titulo");
        VentanaInterna.setVisible(false);
        VentanaInterna.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigoKeyTyped(evt);
            }
        });
        VentanaInterna.getContentPane().add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 250, 30));

        ventanaInterna_Nombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ventanaInterna_Nombre.setForeground(new java.awt.Color(102, 102, 102));
        ventanaInterna_Nombre.setText("Buscar");
        VentanaInterna.getContentPane().add(ventanaInterna_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, -1));

        limpiar1.setBackground(new java.awt.Color(255, 255, 255));
        limpiar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiar1.setForeground(new java.awt.Color(102, 102, 102));
        limpiar1.setText("LIMPIAR");
        limpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar1ActionPerformed(evt);
            }
        });
        VentanaInterna.getContentPane().add(limpiar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 140, 30));

        ListadoBusquedas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        ListadoBusquedas.setBackground(new java.awt.Color(153, 204, 255));
        ListadoBusquedas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        ListadoBusquedas.setComponentPopupMenu(Seleccionar);
        ListadoBusquedas.setFocusable(false);
        ListadoBusquedas.setGridColor(new java.awt.Color(0, 204, 204));
        ListadoBusquedas.setSelectionBackground(new java.awt.Color(255, 102, 102));
        ListadoBusquedas.getTableHeader().setReorderingAllowed(false);
        ListadoBusquedas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListadoBusquedasMouseClicked(evt);
            }
        });
        ListadoBusquedas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ListadoBusquedasKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(ListadoBusquedas);

        VentanaInterna.getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1210, 480));

        cancelar1.setBackground(new java.awt.Color(255, 255, 255));
        cancelar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelar1.setForeground(new java.awt.Color(102, 102, 102));
        cancelar1.setText("CANCELAR");
        cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar1ActionPerformed(evt);
            }
        });
        VentanaInterna.getContentPane().add(cancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 160, 30));

        add(VentanaInterna, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1300, 630));

        numeroFactura.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        numeroFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                numeroFacturaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                numeroFacturaMouseEntered(evt);
            }
        });
        numeroFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroFacturaActionPerformed(evt);
            }
        });
        numeroFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                numeroFacturaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numeroFacturaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numeroFacturaKeyTyped(evt);
            }
        });
        add(numeroFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 350, 30));

        Sede_Listado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        add(Sede_Listado, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, 350, 30));

        PersonaNatural_apellidosL.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        PersonaNatural_apellidosL.setForeground(new java.awt.Color(255, 51, 102));
        PersonaNatural_apellidosL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PersonaNatural_apellidosL.setText("+");
        PersonaNatural_apellidosL.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PersonaNatural_apellidosL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PersonaNatural_apellidosLMouseClicked(evt);
            }
        });
        add(PersonaNatural_apellidosL, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 30, 40));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1020, 10));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("NÚMERO FACTURA:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 150, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Radicación No.");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("OBSERVACIÓN:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, -1, 30));

        numeroRadicado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add(numeroRadicado, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 230, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Nit Proveedor:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 130, 30));

        proveedor_nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        proveedor_nombre.setForeground(new java.awt.Color(102, 102, 102));
        add(proveedor_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 870, 30));

        observacion.setColumns(20);
        observacion.setRows(5);
        jScrollPane1.setViewportView(observacion);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, 630, -1));

        Registrar1.setBackground(new java.awt.Color(255, 255, 255));
        Registrar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Registrar1.setForeground(new java.awt.Color(102, 102, 102));
        Registrar1.setText("PROVEEDOR");
        Registrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registrar1ActionPerformed(evt);
            }
        });
        add(Registrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 150, 40));

        PersonaNatural_apellidosL1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PersonaNatural_apellidosL1.setForeground(new java.awt.Color(102, 102, 102));
        PersonaNatural_apellidosL1.setText("SEDE:");
        add(PersonaNatural_apellidosL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 140, 30));

        Registrar3.setBackground(new java.awt.Color(255, 255, 255));
        Registrar3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Registrar3.setForeground(new java.awt.Color(102, 102, 102));
        Registrar3.setText("EMPRESA");
        Registrar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registrar3ActionPerformed(evt);
            }
        });
        add(Registrar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 150, 40));

        PersonaNatural_apellidosL2.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        PersonaNatural_apellidosL2.setForeground(new java.awt.Color(255, 51, 102));
        PersonaNatural_apellidosL2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PersonaNatural_apellidosL2.setText("+");
        PersonaNatural_apellidosL2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PersonaNatural_apellidosL2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PersonaNatural_apellidosL2MouseClicked(evt);
            }
        });
        add(PersonaNatural_apellidosL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 30, 40));

        Registrar4.setBackground(new java.awt.Color(255, 255, 255));
        Registrar4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Registrar4.setForeground(new java.awt.Color(102, 102, 102));
        Registrar4.setText("USUARIO");
        Registrar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registrar4ActionPerformed(evt);
            }
        });
        add(Registrar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 150, 40));

        PersonaNatural_apellidosL3.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        PersonaNatural_apellidosL3.setForeground(new java.awt.Color(255, 51, 102));
        PersonaNatural_apellidosL3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PersonaNatural_apellidosL3.setText("+");
        PersonaNatural_apellidosL3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PersonaNatural_apellidosL3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PersonaNatural_apellidosL3MouseClicked(evt);
            }
        });
        add(PersonaNatural_apellidosL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 30, 40));

        Registrar2.setBackground(new java.awt.Color(255, 255, 255));
        Registrar2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Registrar2.setText("REGISTRAR");
        Registrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registrar2ActionPerformed(evt);
            }
        });
        add(Registrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 570, 150, 40));

        empresa_nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        empresa_nombre.setForeground(new java.awt.Color(102, 102, 102));
        add(empresa_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 870, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Correo Usuario:");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, -1, 30));

        usuario_nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usuario_nombre.setForeground(new java.awt.Color(102, 102, 102));
        add(usuario_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 870, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("RADICAR FACTURA");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 440, 50));

        mensaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mensaje.setForeground(new java.awt.Color(255, 0, 0));
        add(mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 540, 880, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Correo Proveedor:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, -1, 30));

        proveedor_nit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        proveedor_nit.setForeground(new java.awt.Color(102, 102, 102));
        add(proveedor_nit, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 870, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Nombre Proveedor:");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, 30));

        proveedor_correo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        proveedor_correo.setForeground(new java.awt.Color(102, 102, 102));
        add(proveedor_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 870, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Nombre Empresa:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 120, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Nit Empresa:");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 90, 30));

        empresa_nit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        empresa_nit.setForeground(new java.awt.Color(102, 102, 102));
        add(empresa_nit, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 870, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Nombre Usuario:");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, -1, 30));

        usuario_correo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usuario_correo.setForeground(new java.awt.Color(102, 102, 102));
        add(usuario_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 870, 30));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 620, -1));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 620, 20));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 620, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void numeroFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numeroFacturaMouseClicked

    }//GEN-LAST:event_numeroFacturaMouseClicked

    private void numeroFacturaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numeroFacturaMouseEntered

    }//GEN-LAST:event_numeroFacturaMouseEntered

    private void numeroFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroFacturaActionPerformed

    private void numeroFacturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroFacturaKeyPressed
       
    }//GEN-LAST:event_numeroFacturaKeyPressed

    private void numeroFacturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroFacturaKeyReleased
       
    }//GEN-LAST:event_numeroFacturaKeyReleased

    private void numeroFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroFacturaKeyTyped
       
    }//GEN-LAST:event_numeroFacturaKeyTyped

    private void codigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoKeyPressed
        
    }//GEN-LAST:event_codigoKeyPressed

    private void limpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar1ActionPerformed
        codigo.setText("");
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)ListadoBusquedas.getModel();
        int CantEliminar= ListadoBusquedas.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
            md.removeRow(i);
        }
    }//GEN-LAST:event_limpiar1ActionPerformed

    private void ListadoBusquedasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ListadoBusquedasKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListadoBusquedasKeyPressed

    private void cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar1ActionPerformed
        VentanaInterna.show(false);
        codigo.setText("");
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)ListadoBusquedas.getModel();
        int CantEliminar= ListadoBusquedas.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
            md.removeRow(i);
        }
    }//GEN-LAST:event_cancelar1ActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        ControlDB_Proveedor controlDB_Proveedor = new ControlDB_Proveedor();
        if(valor.equals("Proveedor")){
            int fila1;
            try{
                fila1=ListadoBusquedas.getSelectedRow();
                if(fila1==-1){
                    JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
                }
                else{
                    try{
                        modelo=(DefaultTableModel)ListadoBusquedas.getModel();
                        String nitProveedor=(String)modelo.getValueAt(fila1, 0);   
                        Proveedor prov=new Proveedor();               
                        prov.setNit_proveedor(nitProveedor);
                        Proveedor proveedor=controlDB_Proveedor.consultarProvedorID(prov);
                        if(proveedor != null){
                            try{
                                //Integer.parseInt(proveedor.getDig_proveedor());
                                proveedor_nitS =proveedor.getNit_proveedor();
                                proveedor_nit.setText(proveedor.getNit_proveedor());
                                
                                proveedor_nombreS=""+proveedor.getNombre_proveedor();
                                proveedor_nombre.setText(""+proveedor.getNombre_proveedor());
                                
                                proveedor_correoS = proveedor.getCorreo_proveedor();
                                proveedor_correo.setText(proveedor.getCorreo_proveedor());
                                
                            }catch(Exception e){
                            }  
                        }
                        //Eliminamos la Busqueda Actual#######################################################
                        DefaultTableModel md =(DefaultTableModel)ListadoBusquedas.getModel();
                        int CantEliminar= ListadoBusquedas.getRowCount() -1;
                        for(int i =CantEliminar; i>=0; i--){
                            md.removeRow(i);
                        }
                        //######################################################################################
                        VentanaInterna.show(false);
                    }catch(Exception e){
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "No se pudo cargar el Proveedor");
                    }
                }
            }catch(Exception e){
            }
        }
        if(valor.equals("Empresa")){
            int fila1;
            try{
                fila1=ListadoBusquedas.getSelectedRow();
                if(fila1==-1){
                    JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
                }
                else{
                    try{
                        accion="modificar";
                        modelo=(DefaultTableModel)ListadoBusquedas.getModel();
                        String nitEmpresa=(String)modelo.getValueAt(fila1, 0);
                        Empresa emp=new Empresa();
                        emp.setNit_empresa(nitEmpresa);
                        ControlDB_Empresa controlDB_Empresa = new ControlDB_Empresa();
                        Empresa empresa=controlDB_Empresa.consultarEmpresaID(emp);
                        if(empresa != null){
                                empresa_nitS =empresa.getNit_empresa();
                                empresa_nit.setText(""+empresa.getNit_empresa());  
                                
                                empresa_nombreS =empresa.getNombre_empresa();
                                empresa_nombre.setText(""+empresa.getNombre_empresa());    
                        }
                        //Eliminamos la Busqueda Actual#######################################################
                        DefaultTableModel md =(DefaultTableModel)ListadoBusquedas.getModel();
                        int CantEliminar= ListadoBusquedas.getRowCount() -1;
                        for(int i =CantEliminar; i>=0; i--){
                            md.removeRow(i);
                        }
                        //######################################################################################
                        VentanaInterna.show(false);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "No se pudo cargar la empresa");
                    }
                }
            }catch(Exception e){
            }
        }
    }//GEN-LAST:event_EditarActionPerformed

    private void Registrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registrar1ActionPerformed
        valor="Proveedor";
        codigo.setText("");
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)ListadoBusquedas.getModel();
        int CantEliminar= ListadoBusquedas.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
           md.removeRow(i);
        }
        DefaultTableModel modelo;
        String [] titulo= {"NIT","DIG","NOMBRE","CORREO.","TELEFONO","ESTADO"};
        String [] registro = new String[6]; 
        modelo = new DefaultTableModel(null, titulo);
        ListadoBusquedas.setModel(modelo);
        VentanaInterna.show(true);
        CargarVentanaInterna(1); 
    }//GEN-LAST:event_Registrar1ActionPerformed

    private void Registrar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registrar3ActionPerformed
        valor="Empresa";
        codigo.setText("");
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)ListadoBusquedas.getModel();
        int CantEliminar= ListadoBusquedas.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
           md.removeRow(i);
        }
        DefaultTableModel modelo;
        String [] titulo= {"NIT","DIG","NOMBRE","CORREO.","TELEFONO","ESTADO"};
        String [] registro = new String[6]; 
        modelo = new DefaultTableModel(null, titulo);
        ListadoBusquedas.setModel(modelo);
        VentanaInterna.show(true);
        CargarVentanaInterna(2); 
    }//GEN-LAST:event_Registrar3ActionPerformed

    private void Registrar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registrar4ActionPerformed
        VentanaInternaBuscarUsuario.show(true); 
        TextPrompt placeholder = new TextPrompt("Buscar por Nit o Nombre:", buscarUsuario);       
        buscarUsuario.setText("");
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)ListadoBusquedaUsuario.getModel();
        int CantEliminar= ListadoBusquedaUsuario.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
           md.removeRow(i);
        }
        DefaultTableModel modelo;
        String [] titulo= {"ID","NOMBRES", "APELLIDOS","CORREO","ESTADO"};
        String [] registro = new String[5];    
        modelo = new DefaultTableModel(null, titulo);        
        
        ListadoBusquedaUsuario.setModel(modelo);
        try {
            BuscarEnVentanaInternaUsuario("");
        } catch (SQLException ex) {
            Logger.getLogger(Envio_Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Registrar4ActionPerformed

    private void Registrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registrar2ActionPerformed
        if(numeroFactura.getText().equals("")){
            mensaje.setText("El nùmero de factura no puede estar vacio");
        }else{
            if(proveedor_nombre.getText().equals("")){
                mensaje.setText("Se debe cargar un Proveedor");
            }else{
                if(empresa_nombre.getText().equals("")){
                    mensaje.setText("Se debe cargar la empresa a la que va dirigida la factura");
                }else{
                    if(usuario_nombre.getText().equals("")){
                         mensaje.setText("Se debe cargar un Usuario a quien va dirigida la factura");
                    }else{
                        try {
                            ControlDB_Radicacion controlDB_Radicacion = new ControlDB_Radicacion();
                            Documento documento = new Documento();
                            documento.setId_documento(consecutivoRadicacion);
                            documento.setNumFactura_documento(numeroFactura.getText());
                            documento.setNit_proveedor(proveedor_nitS);
                            documento.setObservacion_documento(observacion.getText());
                            documento.setId_estadoDocumento(0);// 0=Inactivo 1=Activo 2=Cancelado
                            //documento.setId_usuario(usuario_idS);
                            documento.setId_usuario(user.getId_usuario());
                            documento.setNit_empresa(empresa_nitS);
                            documento.setId_sede(controlDB_Radicacion.validarSede(Sede_Listado.getSelectedItem().toString()));
                            System.out.println("Id documento:"+documento.getId_documento()+"\nNo. Factura:"+documento.getNumFactura_documento()+"\nNit. Proveedor: "+documento.getNit_proveedor()+"\nObservacion: "+documento.getObservacion_documento()+
                                    "\nId. Estado Documento:"+documento.getId_estadoDocumento()+"\n Id Usaurio:"+documento.getId_usuario()+"\n Id Nit emppresa:"+documento.getNit_empresa()+"\n Id Sede"+documento.getId_sede()+
                                    "");
                            int radicar = controlDB_Radicacion.registrarRadicacion(documento,usuario_idS);
                            if(radicar==1){
                                //Enviamos Mensaje a Proveedor
                                int maximo = controlDB_Radicacion.retornarElMaximoDocumento();
                                String correoEnviar=proveedor_correoS;
                                String NumfacturaEnviar=numeroFactura.getText();
                                String NitEmpresaEnviar=empresa_nitS;
                                String NombreEmpresaEnviar=empresa_nombreS;
                                EnviarConGmail c = new EnviarConGmail();
                                /*c.EnviarConGMail(correoEnviar, "Radicación de Documento No. "+NumfacturaEnviar,
                                    "Se Radicó el documento No. "+NumfacturaEnviar+"\nEnviado a la empresa "+NombreEmpresaEnviar+" con Nit: "+NitEmpresaEnviar+"\n"+
                                    + "\n\n\nIMPORTANTE:\n" +
                                    "Este correo es informativo, favor no responder a esta dirección de correo, ya\n" +
                                    "que no se encuentra habilitada para recibir mensajes.");*/
                                c.EnviarConGMail(correoEnviar, "Radicación de Documento No. "+NumfacturaEnviar,
                                    "RADICACION DE DOCUMENTO"+
                                    "\n"+
                                    "La empresa "+NombreEmpresaEnviar+" con Nit "+NitEmpresaEnviar+" informa que hemos recibido su documento No. "+NumfacturaEnviar+" para verificación con radicado No. "+maximo+"\n"+
                                    "\n"+
                                    "\n"+
                                    "IMPORTANTE:\n"+
                                    "Este correo es informativo, favor no responder a esta dirección de correo, ya que no se encuentra habilitada para recibir mensajes.\n\n");
                                
                                ImprimirRadicacion imprimirRadicacion =controlDB_Radicacion.buscarRadicacionParaImpresion(""+maximo);
                                System.err.println("Maximo Radicaicon="+maximo);
                                ImpresionRadicado imp = new ImpresionRadicado();
                                imp.imprimirRadicado(imprimirRadicacion);
                                
                                //Enviamos un Mensaje al Usuario Destino
                                HistoricoDocumento historicoDocumento = new HistoricoDocumento();
                                historicoDocumento.setId_documento(Integer.parseInt(""+controlDB_Radicacion.retornarElMaximoDocumento()));
                                historicoDocumento.setUsuarioRegistro_historicoDocumento(user.getId_usuario());
                                historicoDocumento.setUsuarioDestino_historicoDocumento(usuario_idS);
                                historicoDocumento.setObservacion_historicoDocumento(observacion.getText());
                                historicoDocumento.setId_historicoDocumento(2); //('1','RADICADO'), ('2','ENVIADO'),('3','RECIBIDO');
                                historicoDocumento.setId_confirmacionRecibido(0);  //Valor 0 porque recién se envio

                                ControlDB_EnvioDocumento controlDB_EnvioDocumento = new ControlDB_EnvioDocumento();
                                int validarEnvio=0;
                                validarEnvio = controlDB_EnvioDocumento.registrarEnvioDocumento(historicoDocumento);
                                if(validarEnvio==1){
                                    //JOptionPane.showMessageDialog(null, "Envio Exitoso");
                                    //Enviamos Mensaje al usuario destinatario que se le va a enviar un Documento
                                    String correoEnviarU=usuario_correoS;
                                    String NumfacturaEnviarU=documento.getNumFactura_documento();
                                    String NitProveedorEnviarU=documento.getNit_proveedor();
                                    String NombreProveedorEnviarU=proveedor_nombreS;
                                    String observacionEnviarU=observacion.getText();                                
                                    c.EnviarConGMail(correoEnviarU, "Envio Documento No. "+NumfacturaEnviarU, "Se ha enviado el documento No. "+NumfacturaEnviarU+" del Proveedor "+NombreProveedorEnviarU+" con Nit "+NitProveedorEnviarU+" radicado con el No. "+maximo +"\nObservación: "+observacionEnviarU
                                            + "\n\nFavor abrir el siguiente link en su navegador para confirmar recibido:\n"
                                                    + "http://172.30.200.230/Radicacion_facturas/index.php \n\n\nIMPORTANTE:\n" +
                                            "Este correo es informativo, favor no responder a esta dirección de correo, ya\n" +
                                            "que no se encuentra habilitada para recibir mensajes.");
                                }
                                JOptionPane.showMessageDialog(null, "Radicaciòn Exitosa");
                                //Cargamos Siguiente Consecutivo y hacemos limpieza de datos en la interfaz.
                                consecutivoRadicacion++;
                                numeroRadicado.setText(""+consecutivoRadicacion);
                                numeroFactura.setText("");
                                proveedor_nitS = "";
                                proveedor_nombreS = "";
                                proveedor_correoS = "";
                                proveedor_nombre.setText("");
                                
                                empresa_nitS="";
                                empresa_nombreS="";
                                empresa_nombre.setText("");
                                
                                usuario_idS="";
                                usuario_nombreS="";
                                usuario_correoS="";
                                usuario_nombre.setText("");    
                                
                                Sede_Listado.setSelectedIndex(0);
                                observacion.setText("");

                            }else{
                                JOptionPane.showMessageDialog(null, "Error al Radicar Verifique datos");
                            }
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Gestion_Radicacion.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(Gestion_Radicacion.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Gestion_Radicacion.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (PrintException ex) {
                            Logger.getLogger(Gestion_Radicacion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_Registrar2ActionPerformed

    private void buscarUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarUsuarioKeyPressed
        
    }//GEN-LAST:event_buscarUsuarioKeyPressed

    private void limpiarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarUsuariosActionPerformed
        buscarUsuario.setText("");
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)ListadoBusquedaUsuario.getModel();
        int CantEliminar= ListadoBusquedaUsuario.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
            md.removeRow(i);
        }
    }//GEN-LAST:event_limpiarUsuariosActionPerformed

    private void ListadoBusquedaUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ListadoBusquedaUsuarioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListadoBusquedaUsuarioKeyPressed

    private void cancelarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarUsuarioActionPerformed
        buscarUsuario.setText("");
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)ListadoBusquedaUsuario.getModel();
        int CantEliminar= ListadoBusquedaUsuario.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
            md.removeRow(i);
        }
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
                    usuario_idS=(String)modelo.getValueAt(fila1, 0);
                    usuario_nombreS=(String)modelo.getValueAt(fila1, 1)+" "+(String)modelo.getValueAt(fila1, 2);
                    usuario_correoS=(String)modelo.getValueAt(fila1, 3);

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

    private void PersonaNatural_apellidosL2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PersonaNatural_apellidosL2MouseClicked
        VentanaInternaRegistrar.show(true);
        panel.setViewportView(new Gestion_Proveedor());
    }//GEN-LAST:event_PersonaNatural_apellidosL2MouseClicked

    private void PersonaNatural_apellidosL3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PersonaNatural_apellidosL3MouseClicked
        VentanaInternaRegistrar.show(true);
        panel.setViewportView(new Gestion_Empresa());
    }//GEN-LAST:event_PersonaNatural_apellidosL3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentanaInternaRegistrar.show(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void PersonaNatural_apellidosLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PersonaNatural_apellidosLMouseClicked
        VentanaInternaRegistrar.show(true);
        panel.setViewportView(new Gestion_Usuario());
    }//GEN-LAST:event_PersonaNatural_apellidosLMouseClicked

    private void codigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoKeyTyped
        
    }//GEN-LAST:event_codigoKeyTyped

    private void codigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoKeyReleased
         //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)ListadoBusquedas.getModel();
        int CantEliminar= ListadoBusquedas.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
            md.removeRow(i);
        }
        try {
            BuscarEnVentanaInterna();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar");
        }
    }//GEN-LAST:event_codigoKeyReleased

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
                        usuario_idS=(String)modelo.getValueAt(fila1, 0);
                        usuario_nombreS=(String)modelo.getValueAt(fila1, 1)+" "+(String)modelo.getValueAt(fila1, 2);
                        usuario_correoS=(String)modelo.getValueAt(fila1, 3);

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

    private void ListadoBusquedasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListadoBusquedasMouseClicked
       if (evt.getClickCount() == 2) {
            ControlDB_Proveedor controlDB_Proveedor = new ControlDB_Proveedor();
            if(valor.equals("Proveedor")){
                int fila1;
                try{
                    fila1=ListadoBusquedas.getSelectedRow();
                    if(fila1==-1){
                        JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
                    }
                    else{
                        try{
                            modelo=(DefaultTableModel)ListadoBusquedas.getModel();
                            String nitProveedor=(String)modelo.getValueAt(fila1, 0);   
                            Proveedor prov=new Proveedor();               
                            prov.setNit_proveedor(nitProveedor);
                            Proveedor proveedor=controlDB_Proveedor.consultarProvedorID(prov);
                            if(proveedor != null){
                                try{
                                    //Integer.parseInt(proveedor.getDig_proveedor());
                                    proveedor_nitS =proveedor.getNit_proveedor();
                                    proveedor_nit.setText(proveedor.getNit_proveedor());

                                    proveedor_nombreS=""+proveedor.getNombre_proveedor();
                                    proveedor_nombre.setText(""+proveedor.getNombre_proveedor());

                                    proveedor_correoS = proveedor.getCorreo_proveedor();
                                    proveedor_correo.setText(proveedor.getCorreo_proveedor());    
                                }catch(Exception e){
                                }  
                            }
                            //Eliminamos la Busqueda Actual#######################################################
                            DefaultTableModel md =(DefaultTableModel)ListadoBusquedas.getModel();
                            int CantEliminar= ListadoBusquedas.getRowCount() -1;
                            for(int i =CantEliminar; i>=0; i--){
                                md.removeRow(i);
                            }
                            //######################################################################################
                            VentanaInterna.show(false);
                        }catch(Exception e){
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "No se pudo cargar el Proveedor");
                        }
                    }
                }catch(Exception e){
                }
            }
            if(valor.equals("Empresa")){
                int fila1;
                try{
                    fila1=ListadoBusquedas.getSelectedRow();
                    if(fila1==-1){
                        JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
                    }
                    else{
                        try{
                            accion="modificar";
                            modelo=(DefaultTableModel)ListadoBusquedas.getModel();
                            String nitEmpresa=(String)modelo.getValueAt(fila1, 0);
                            Empresa emp=new Empresa();
                            emp.setNit_empresa(nitEmpresa);
                            ControlDB_Empresa controlDB_Empresa = new ControlDB_Empresa();
                            Empresa empresa=controlDB_Empresa.consultarEmpresaID(emp);
                            if(empresa != null){
                                empresa_nitS =empresa.getNit_empresa();
                                empresa_nit.setText(""+empresa.getNit_empresa());  
                                
                                empresa_nombreS =empresa.getNombre_empresa();
                                empresa_nombre.setText(""+empresa.getNombre_empresa());    
                            }
                            //Eliminamos la Busqueda Actual#######################################################
                            DefaultTableModel md =(DefaultTableModel)ListadoBusquedas.getModel();
                            int CantEliminar= ListadoBusquedas.getRowCount() -1;
                            for(int i =CantEliminar; i>=0; i--){
                                md.removeRow(i);
                            }
                            //######################################################################################
                            VentanaInterna.show(false);
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null, "No se pudo cargar la empresa");
                        }
                    }
                }catch(Exception e){
                }
            }       
        } 
    }//GEN-LAST:event_ListadoBusquedasMouseClicked

    private void panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseClicked
        
    }//GEN-LAST:event_panelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JTable ListadoBusquedaUsuario;
    private javax.swing.JTable ListadoBusquedas;
    private javax.swing.JLabel PersonaNatural_apellidosL;
    private javax.swing.JLabel PersonaNatural_apellidosL1;
    private javax.swing.JLabel PersonaNatural_apellidosL2;
    private javax.swing.JLabel PersonaNatural_apellidosL3;
    private javax.swing.JButton Registrar1;
    private javax.swing.JButton Registrar2;
    private javax.swing.JButton Registrar3;
    private javax.swing.JButton Registrar4;
    private javax.swing.JComboBox<String> Sede_Listado;
    private javax.swing.JPopupMenu Seleccionar;
    private javax.swing.JPopupMenu SeleccionarUsuario;
    private javax.swing.JInternalFrame VentanaInterna;
    private javax.swing.JInternalFrame VentanaInternaBuscarUsuario;
    private javax.swing.JInternalFrame VentanaInternaRegistrar;
    private javax.swing.JTextField buscarUsuario;
    private javax.swing.JButton cancelar1;
    private javax.swing.JButton cancelarUsuario;
    private javax.swing.JTextField codigo;
    private javax.swing.JLabel empresa_nit;
    private javax.swing.JLabel empresa_nombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton limpiar1;
    private javax.swing.JButton limpiarUsuarios;
    private javax.swing.JLabel mensaje;
    private javax.swing.JTextField numeroFactura;
    private javax.swing.JLabel numeroRadicado;
    private javax.swing.JTextArea observacion;
    private javax.swing.JScrollPane panel;
    private javax.swing.JLabel proveedor_correo;
    private javax.swing.JLabel proveedor_nit;
    private javax.swing.JLabel proveedor_nombre;
    private javax.swing.JMenuItem seleccionar;
    private javax.swing.JLabel usuario_correo;
    private javax.swing.JLabel usuario_nombre;
    private javax.swing.JLabel ventanaInterna_Nombre;
    private javax.swing.JLabel ventanaInterna_Nombre1;
    // End of variables declaration//GEN-END:variables
     public void CargarVentanaInterna(int n){
        switch(n){
            case 1:{
                VentanaInterna.show(true);
                VentanaInterna.setTitle("Listado De Proveedor");
                ventanaInterna_Nombre.setText("Buscar Proveedor");
                TextPrompt placeholder = new TextPrompt("Buscar por Nit o Nombre:", codigo);
                valor="Proveedor";
                try {  
                    DefaultTableModel modelo;
                    String []titulo= {"NIT","DIG","NOMBRE","CORREO.","TELEFONO","ESTADO"};
                    String [] registro = new String[6]; 
                    modelo = new DefaultTableModel(null, titulo);
                    ControlDB_Proveedor controlDB_Proveedor = new ControlDB_Proveedor();
                    ArrayList<Proveedor> listadoProveedores=controlDB_Proveedor.buscarProveedor("");
                    for(int i =0; i< listadoProveedores.size(); i++){ 
                        registro[0]=""+listadoProveedores.get(i).getNit_proveedor();
                        registro[1]=""+listadoProveedores.get(i).getDig_proveedor();
                        registro[2]=""+listadoProveedores.get(i).getNombre_proveedor();
                        registro[3]=""+listadoProveedores.get(i).getCorreo_proveedor();
                        registro[4]=""+listadoProveedores.get(i).getTelefono_proveedor();
                        registro[5]=""+controlDB_Proveedor.convertidorEstadoID_x_Nombre(listadoProveedores.get(i).getId_estadoProveedor());
                        modelo.addRow(registro);
                        ListadoBusquedas.setModel(modelo);
                        //JOptionPane.showMessageDialog(null, "Hola si hay info"+listadoClientes.get(i).getNit()+listadoClientes.get(i).getDigitoVerificacion()+listadoClientes.get(i).getNombre());
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Gestion_Radicacion.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case 2:{
                VentanaInterna.show(true);
                VentanaInterna.setTitle("Listado De Clientes");
                ventanaInterna_Nombre.setText("Buscar Clientes");
                TextPrompt placeholder = new TextPrompt("Buscar por Nit o Nombre:", codigo);
                valor="Empresa";
                try {
                    DefaultTableModel modelo;
                    String []titulo= {"NIT","DIG","NOMBRE","CORREO.","TELEFONO","ESTADO"};
                    String [] registro = new String[6];
                    modelo = new DefaultTableModel(null, titulo);
                    ControlDB_Empresa controlDB_Empresa = new ControlDB_Empresa();
                    ArrayList<Empresa> listadoEmpresa = null;
                    listadoEmpresa = controlDB_Empresa.buscarEmpresa("");
                    for(int i =0; i< listadoEmpresa.size(); i++){
                        registro[0]=""+listadoEmpresa.get(i).getNit_empresa();
                        registro[1]=""+listadoEmpresa.get(i).getDig_empresa();
                        registro[2]=""+listadoEmpresa.get(i).getNombre_empresa();
                        registro[3]=""+listadoEmpresa.get(i).getCorreo_empresa();
                        registro[4]=""+listadoEmpresa.get(i).getTelefono_empresa();
                        registro[5]=""+controlDB_Empresa.convertidorEstadoID_x_Nombre(listadoEmpresa.get(i).getId_estadoEmpresa());
                        modelo.addRow(registro);
                        ListadoBusquedas.setModel(modelo);
                        //JOptionPane.showMessageDialog(null, "Hola si hay info"+listadoClientes.get(i).getNit()+listadoClientes.get(i).getDigitoVerificacion()+listadoClientes.get(i).getNombre());
                    }
                    break;
                } catch (SQLException ex) {
                    Logger.getLogger(Gestion_Radicacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }     
    }
    public void BuscarEnVentanaInterna() throws SQLException{
        switch(valor){
            case "Proveedor":{
                DefaultTableModel modelo;
                String []titulo= {"NIT","DIG","NOMBRE","CORREO.","TELEFONO","ESTADO"};
                String [] registro = new String[6]; 
                modelo = new DefaultTableModel(null, titulo);
                ControlDB_Proveedor controlDB_Proveedor = new ControlDB_Proveedor();
                ArrayList<Proveedor> listadoProveedores=controlDB_Proveedor.buscarProveedor(codigo.getText());
                for(int i =0; i< listadoProveedores.size(); i++){ 
                    registro[0]=""+listadoProveedores.get(i).getNit_proveedor();
                    registro[1]=""+listadoProveedores.get(i).getDig_proveedor();
                    registro[2]=""+listadoProveedores.get(i).getNombre_proveedor();
                    registro[3]=""+listadoProveedores.get(i).getCorreo_proveedor();
                    registro[4]=""+listadoProveedores.get(i).getTelefono_proveedor();
                    registro[5]=""+controlDB_Proveedor.convertidorEstadoID_x_Nombre(listadoProveedores.get(i).getId_estadoProveedor());
                    modelo.addRow(registro);
                    ListadoBusquedas.setModel(modelo);
                    //JOptionPane.showMessageDialog(null, "Hola si hay info"+listadoClientes.get(i).getNit()+listadoClientes.get(i).getDigitoVerificacion()+listadoClientes.get(i).getNombre());
                }
                break;
            }
            case "Empresa":{
                DefaultTableModel modelo;
                String []titulo= {"NIT","DIG","NOMBRE","CORREO.","TELEFONO","ESTADO"};
                String [] registro = new String[6]; 
                modelo = new DefaultTableModel(null, titulo);
                ControlDB_Empresa controlDB_Empresa = new ControlDB_Empresa();
                ArrayList<Empresa> listadoEmpresa=controlDB_Empresa.buscarEmpresa(codigo.getText());
                for(int i =0; i< listadoEmpresa.size(); i++){ 
                    registro[0]=""+listadoEmpresa.get(i).getNit_empresa();
                    registro[1]=""+listadoEmpresa.get(i).getDig_empresa();
                    registro[2]=""+listadoEmpresa.get(i).getNombre_empresa();
                    registro[3]=""+listadoEmpresa.get(i).getCorreo_empresa();
                    registro[4]=""+listadoEmpresa.get(i).getTelefono_empresa();
                    registro[5]=""+controlDB_Empresa.convertidorEstadoID_x_Nombre(listadoEmpresa.get(i).getId_estadoEmpresa());
                    modelo.addRow(registro);
                    ListadoBusquedas.setModel(modelo);
                    //JOptionPane.showMessageDialog(null, "Hola si hay info"+listadoClientes.get(i).getNit()+listadoClientes.get(i).getDigitoVerificacion()+listadoClientes.get(i).getNombre());
                }
                break;
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
        listadoUsuario=controlDB_usuario.buscarUsuarioRadicar(valorConsulta);
        if(listadoUsuario !=null){
            for(int i =0; i< listadoUsuario.size(); i++){ 
                registro[0]=""+listadoUsuario.get(i).getId_usuario();
                registro[1]=""+listadoUsuario.get(i).getNombre_usuario();
                registro[2]=""+listadoUsuario.get(i).getApellido_usuario();
                registro[3]=""+listadoUsuario.get(i).getMail_usuario();
                registro[4]=""+controlDB_usuario.convertidorEstadoID_x_Nombre(listadoUsuario.get(i).getId_estadoUsuario());
                modelo.addRow(registro);
                ListadoBusquedaUsuario.setModel(modelo);
            }   
        }
    }
}
