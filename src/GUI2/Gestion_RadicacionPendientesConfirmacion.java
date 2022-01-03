package GUI2;
 
import Controladores.ControlDB_Radicacion;
import Controladores.ControlDB_RecibirDocumento;
import Controladores.ControlDB_Usuario;
import Modelos.Consultas.ConsultaGeneralInforme;
import Modelos.EstadoHistorico;
import Modelos.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Gestion_RadicacionPendientesConfirmacion extends javax.swing.JPanel {
    String [] registro;   
    DefaultTableModel modelo;
    public Gestion_RadicacionPendientesConfirmacion() throws SQLException {
        initComponents();
        
        //Cargamos en la interfaz los Usuarios quienes envian
        ArrayList<Usuario> listadoUsuarioQuienEnvia = new ArrayList();
        ControlDB_Usuario controlDB_Usuario = new ControlDB_Usuario();
        listadoUsuarioQuienEnvia=controlDB_Usuario.buscarUsuario("");
        for(int i=0; i< listadoUsuarioQuienEnvia.size(); i++){
            select_listadoUsuarioQuienEnvia.addItem(listadoUsuarioQuienEnvia.get(i).getId_usuario());
        }
        select_listadoUsuarioQuienEnvia.setSelectedIndex(0); 
        
        //Cargamos en la interfaz los Usuarios quienes reciben
        ArrayList<Usuario> listadoUsuarioQuienRecibe = new ArrayList();
        listadoUsuarioQuienRecibe=controlDB_Usuario.buscarUsuario("");
        for(int i=0; i< listadoUsuarioQuienRecibe.size(); i++){
            select_listadoUsuarioQuienRecibe.addItem(listadoUsuarioQuienRecibe.get(i).getId_usuario());
        }
        select_listadoUsuarioQuienRecibe.setSelectedIndex(0); 
        
        //Cargamos en la interfaz los Estados de historicos
        ArrayList<EstadoHistorico> listadoEstadoHistorico = new ArrayList();
        ControlDB_RecibirDocumento controlDB_RecibirDocumento = new ControlDB_RecibirDocumento();
        listadoEstadoHistorico=controlDB_RecibirDocumento.listadoEstado_HistoricoDocumento();
        for(int i=0; i< listadoEstadoHistorico.size(); i++){
            select_listadoEstadoHistorico.addItem(listadoEstadoHistorico.get(i).getDescripcion_estadoHistorico());   
        }
        select_listadoEstadoHistorico.setSelectedIndex(1); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        consultar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        select_listadoUsuarioQuienEnvia = new javax.swing.JComboBox<>();
        select_listadoUsuarioQuienRecibe = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        select_listadoEstadoHistorico = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        consultar.setBackground(new java.awt.Color(255, 255, 255));
        consultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        consultar.setForeground(new java.awt.Color(102, 102, 102));
        consultar.setText("CONSULTAR");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 10, 220, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("QUIEN RECIBE:");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 100, 25));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("QUIEN ENVIA:");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 25));

        select_listadoUsuarioQuienEnvia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        add(select_listadoUsuarioQuienEnvia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 220, 30));

        select_listadoUsuarioQuienRecibe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        select_listadoUsuarioQuienRecibe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));
        add(select_listadoUsuarioQuienRecibe, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 220, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("ESTADO:");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 70, 25));

        select_listadoEstadoHistorico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        add(select_listadoEstadoHistorico, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 220, 30));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1520, 610));
    }// </editor-fold>//GEN-END:initComponents

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)tabla.getModel();
        int CantEliminar= tabla.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
            md.removeRow(i);
        }
        
        if(select_listadoUsuarioQuienRecibe.getSelectedItem().toString().equals("Todos")){
            try {
                tabla_Informe_Todos(select_listadoUsuarioQuienEnvia.getSelectedItem().toString(), select_listadoEstadoHistorico.getSelectedItem().toString());
            } catch (SQLException ex) {
                Logger.getLogger(Gestion_RadicacionPendientesConfirmacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                tabla_Informe_Especifico(select_listadoUsuarioQuienEnvia.getSelectedItem().toString(),select_listadoUsuarioQuienRecibe.getSelectedItem().toString(), select_listadoEstadoHistorico.getSelectedItem().toString());
            } catch (SQLException ex) {
                Logger.getLogger(Gestion_RadicacionPendientesConfirmacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                         
    }//GEN-LAST:event_consultarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton consultar;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> select_listadoEstadoHistorico;
    private javax.swing.JComboBox<String> select_listadoUsuarioQuienEnvia;
    private javax.swing.JComboBox<String> select_listadoUsuarioQuienRecibe;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
    public void tabla_Informe_Todos(String quienEnvia, String estado) throws SQLException{
        registro = new String[15]; 
        String [] titulo= {"IdHistorico","idDocumento","No. Factura","Nit_Proveedor", "Nombre_Proveedor" ,"EstadoHistorico","EstadoDocumento","Usuario_Origen"
                ,"Usuario_Destino","Empresa_Destino","Sede","Fecha_Registro","Fecha_Confirmacion","Fecha_Anulacion","Observacion_Anulacion"};    
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_Radicacion c = new ControlDB_Radicacion();
        ArrayList<ConsultaGeneralInforme> listadoConsultaGeneralInforme=c.Informe_ConfirmacionGeneral(quienEnvia, estado);
        for(int i =0; i< listadoConsultaGeneralInforme.size(); i++){
            registro[0]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_id_historicoDocumento();
            registro[1]=""+listadoConsultaGeneralInforme.get(i).getDocumento_id_documento();
            registro[2]=""+listadoConsultaGeneralInforme.get(i).getDocumento_numFactura_documento();
            registro[3]=""+listadoConsultaGeneralInforme.get(i).getDocumento_nit_proveedor();
            registro[4]=""+listadoConsultaGeneralInforme.get(i).getProveedor_nombre_proveedor();
            registro[5]=""+listadoConsultaGeneralInforme.get(i).getEstadohistorico_descripcion_estadoHistorico();
            registro[6]=""+listadoConsultaGeneralInforme.get(i).getEstadodocumento_descripcion_estadoDocumento();
            registro[7]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_usuarioRegistro_historicoDocumento();
            registro[8]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_usuarioDestino_historicoDocumento();
            registro[9]=""+listadoConsultaGeneralInforme.get(i).getEmpresa_nombre_empresa();
            registro[10]=""+listadoConsultaGeneralInforme.get(i).getSede_nombre_sede();
            registro[11]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_fechaRegistro_historicoDocumento();
            registro[12]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_fechaConfirmacion_historicoDocumento();
            registro[13]=""+listadoConsultaGeneralInforme.get(i).getDocumento_fechaAnulacion_documento();
            registro[14]=""+listadoConsultaGeneralInforme.get(i).getDocumento_observacionAnulacion_documento();
            modelo.addRow(registro);
            tabla.setModel(modelo);
        }
    }
     public void tabla_Informe_Especifico(String quienEnvia, String quienRecibe, String estado) throws SQLException{
        registro = new String[15]; 
        String [] titulo= {"IdHistorico","idDocumento","No. Factura","Nit_Proveedor", "Nombre_Proveedor" ,"EstadoHistorico","EstadoDocumento","Usuario_Origen"
                ,"Usuario_Destino","Empresa_Destino","Sede","Fecha_Registro","Fecha_Confirmacion","Fecha_Anulacion","Observacion_Anulacion"};    
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_Radicacion c = new ControlDB_Radicacion();
        ArrayList<ConsultaGeneralInforme> listadoConsultaGeneralInforme=c.Informe_ConfirmacionEspecifico(quienEnvia,quienRecibe,estado);
        for(int i =0; i< listadoConsultaGeneralInforme.size(); i++){
            registro[0]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_id_historicoDocumento();
            registro[1]=""+listadoConsultaGeneralInforme.get(i).getDocumento_id_documento();
            registro[2]=""+listadoConsultaGeneralInforme.get(i).getDocumento_numFactura_documento();
            registro[3]=""+listadoConsultaGeneralInforme.get(i).getDocumento_nit_proveedor();
            registro[4]=""+listadoConsultaGeneralInforme.get(i).getProveedor_nombre_proveedor();
            registro[5]=""+listadoConsultaGeneralInforme.get(i).getEstadohistorico_descripcion_estadoHistorico();
            registro[6]=""+listadoConsultaGeneralInforme.get(i).getEstadodocumento_descripcion_estadoDocumento();
            registro[7]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_usuarioRegistro_historicoDocumento();
            registro[8]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_usuarioDestino_historicoDocumento();
            registro[9]=""+listadoConsultaGeneralInforme.get(i).getEmpresa_nombre_empresa();
            registro[10]=""+listadoConsultaGeneralInforme.get(i).getSede_nombre_sede();
            registro[11]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_fechaRegistro_historicoDocumento();
            registro[12]=""+listadoConsultaGeneralInforme.get(i).getHistoricodocumento_fechaConfirmacion_historicoDocumento();
            registro[13]=""+listadoConsultaGeneralInforme.get(i).getDocumento_fechaAnulacion_documento();
            registro[14]=""+listadoConsultaGeneralInforme.get(i).getDocumento_observacionAnulacion_documento();
            modelo.addRow(registro);
            tabla.setModel(modelo);
        }
    }
}
