   
package GUI2;
   
import Modelos.Usuario;
import java.sql.SQLException; 
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUIPrincipal_Menu extends javax.swing.JFrame {
    Usuario user;
    public GUIPrincipal_Menu() {
        initComponents();
    }
     public void cargarUsuario(Usuario userT) throws ParseException{
        user = userT;  
        userOnline.setText("Usuario: "+ user.getId_usuario());
        nombreUsuarioEnLinea.setText(("Nombre: "+ user.getNombre_usuario()+" "+ user.getApellido_usuario()));              
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JScrollPane();
        entradaAlmacenNo1 = new javax.swing.JLabel();
        userOnline = new javax.swing.JLabel();
        nombreUsuarioEnLinea = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1510, 630));

        entradaAlmacenNo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        entradaAlmacenNo1.setForeground(new java.awt.Color(0, 153, 51));
        entradaAlmacenNo1.setText("Usuario Conectado: ");
        getContentPane().add(entradaAlmacenNo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 20));

        userOnline.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        userOnline.setForeground(new java.awt.Color(0, 153, 153));
        userOnline.setText("Usuario");
        getContentPane().add(userOnline, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 250, 20));

        nombreUsuarioEnLinea.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombreUsuarioEnLinea.setForeground(new java.awt.Color(0, 153, 153));
        nombreUsuarioEnLinea.setText("Nombre:");
        getContentPane().add(nombreUsuarioEnLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 560, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Fondo.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1510, 70));

        jMenu1.setText("Gestión");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sub_menu.png"))); // NOI18N
        jMenuItem1.setText("Empresa");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sub_menu.png"))); // NOI18N
        jMenuItem2.setText("Proveedor");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sub_menu.png"))); // NOI18N
        jMenuItem14.setText("Usuario");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem14);

        jMenuBar1.add(jMenu1);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sub_menu.png"))); // NOI18N
        jMenu3.setText("Radicación");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sub_menu.png"))); // NOI18N
        jMenuItem7.setText("Radicar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sub_menu.png"))); // NOI18N
        jMenuItem8.setText("Consultar");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sub_menu.png"))); // NOI18N
        jMenuItem3.setText("Anular");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sub_menu.png"))); // NOI18N
        jMenuItem4.setText("Confirmación");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sub_menu.png"))); // NOI18N
        jMenu4.setText("Enviar");

        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sub_menu.png"))); // NOI18N
        jMenuItem16.setText("Enviar Documento");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem16);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sub_menu.png"))); // NOI18N
        jMenu5.setText("Recibir");

        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sub_menu.png"))); // NOI18N
        jMenuItem19.setText("Recibir Documento");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem19);

        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sub_menu.png"))); // NOI18N
        jMenu6.setText("Reportes");

        jMenuItem23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sub_menu.png"))); // NOI18N
        jMenuItem23.setText("Generar Reporte");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem23);

        jMenuBar1.add(jMenu6);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sub_menu.png"))); // NOI18N
        jMenu8.setText("Sistema       ");

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sub_menu.png"))); // NOI18N
        jMenuItem9.setText("Salir");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem9);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        panel.setViewportView(new Gestion_Empresa());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        panel.setViewportView(new Gestion_Radicacion(user));
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        panel.setViewportView(new Envio_Registrar(user));
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
         panel.setViewportView(new Recepcion_Registrar(user));
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        panel.setViewportView(new Gestion_Proveedor());
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        GUIPrincipal_Login GUIPrincipal_Login1 = new GUIPrincipal_Login();
        GUIPrincipal_Login1.setVisible(true);
        this.removeAll();
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        panel.setViewportView(new Radicacion_Reimprimir());
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        panel.setViewportView(new Gestion_Usuario());
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        panel.setViewportView(new Informe_Generar());
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        panel.setViewportView(new Gestion_RadicacionAnular(user));
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try {
            panel.setViewportView(new Gestion_RadicacionPendientesConfirmacion());
        } catch (SQLException ex) {
            Logger.getLogger(GUIPrincipal_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIPrincipal_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel entradaAlmacenNo1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JLabel nombreUsuarioEnLinea;
    private javax.swing.JScrollPane panel;
    private javax.swing.JLabel userOnline;
    // End of variables declaration//GEN-END:variables
}
