
package Modelos;
  

public class Usuario {  
    private String id_usuario;
    private String nombre_usuario;
    private String apellido_usuario;
    private String mail_usuario;
    private int id_estadoUsuario;
    private int permisoRadicar_usuario;

    public Usuario() {
    }

    public Usuario(String id_usuario, String nombre_usuario, String apellido_usuario, String mail_usuario, int id_estadoUsuario, int permisoRadicar_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.mail_usuario = mail_usuario;
        this.id_estadoUsuario = id_estadoUsuario;
        this.permisoRadicar_usuario = permisoRadicar_usuario;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getMail_usuario() {
        return mail_usuario;
    }

    public void setMail_usuario(String mail_usuario) {
        this.mail_usuario = mail_usuario;
    }

    public int getId_estadoUsuario() {
        return id_estadoUsuario;
    }

    public void setId_estadoUsuario(int id_estadoUsuario) {
        this.id_estadoUsuario = id_estadoUsuario;
    }

    public int getPermisoRadicar_usuario() {
        return permisoRadicar_usuario;
    }

    public void setPermisoRadicar_usuario(int permisoRadicar_usuario) {
        this.permisoRadicar_usuario = permisoRadicar_usuario;
    }

   
}
