package Vistas;
    
import Controladores.ControlDB_Usuario;
import Controladores.TextPrompt;
import Modelos.AutenticacionDominio;
import Modelos.Usuario;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUIPrincipal_Login extends javax.swing.JFrame {
    
    public GUIPrincipal_Login() {
        initComponents();
        //TextPrompt placeholderUsuario = new TextPrompt("               Usuario", usuario); 
        //TextPrompt placeholderPassword = new TextPrompt("             Contraseña", password); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        alertaUsuario = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("USUARIO:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 70, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("CONTRASEÑA:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, 30));

        alertaUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaUsuario.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(alertaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 520, 20));

        usuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 170, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("INGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 170, 30));

        password.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        password.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 170, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Img/logo_Ventura.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 360, 280));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Img/Fondo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(usuario.getText().equals("")){
            alertaUsuario.setText("Error!.. El nombre de usuario no puede estar vacio");
        }else{
            if(password.getText().equals("")){
                alertaUsuario.setText("Error!.. La contraseña no puede estar vacia");
            }else{
                ControlDB_Usuario  controlDB_Usuario = new ControlDB_Usuario();
                Usuario u = null;
                u=controlDB_Usuario.validarUsuario(usuario.getText());
                if(u != null){  
                    AutenticacionDominio autenticar = new AutenticacionDominio();
                    boolean respuestaAutenticar = autenticar.login(usuario.getText(), password.getText());
                    if(respuestaAutenticar==true){// La autenticación fue exitosa
                        GUIPrincipal_Menu guiPrincipal;
                        guiPrincipal = new GUIPrincipal_Menu();
                        try {
                            guiPrincipal.cargarUsuario(u);
                            //guiPrincipal.cargaMenu();

                        } catch (ParseException ex) {
                            Logger.getLogger(GUIPrincipal_Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        guiPrincipal.setVisible(true);
                        this.setVisible(false); 
                    }else{
                        alertaUsuario.setText("Error al autenticarse en el servidor de dominio, verifique datos");
                    }

                }else{
                    alertaUsuario.setText("El Usuario no tiene permiso para acceder a este aplicativo");
                }
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GUIPrincipal_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIPrincipal_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alertaUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
