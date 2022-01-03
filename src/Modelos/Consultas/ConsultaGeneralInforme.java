package Modelos.Consultas;
   
public class ConsultaGeneralInforme {
    private String documento_id_documento;
    private String documento_numFactura_documento;
    private String documento_nit_proveedor;
    private String documento_observacion_documento;
    private String documento_id_estadoDocumento;
    private String documento_id_usuario;
    private String documento_nit_empresa;
    private String documento_id_sede;
    private String documento_fechaAnulacion_documento;
    private String documento_observacionAnulacion_documento;
    
    private String estadodocumento_id_estadoDocumento;
    private String estadodocumento_descripcion_estadoDocumento;
    
    private String proveedor_nit_proveedor;
    private String proveedor_dig_proveedor;
    private String proveedor_nombre_proveedor;
    private String proveedor_correo_proveedor;
    private String proveedor_telefono_proveedor;
    private String proveedor_id_estadoProveedor;
    
    private String estadoProveedor_id_estadoProveedor;
    private String estadoProveedor_descripcion_estadoProveedor;
    
    private String empresa_nit_empresa;
    private String empresa_dig_empresa;
    private String empresa_nombre_empresa;
    private String empresa_correo_empresa;
    private String empresa_telefono_empresa;
    private String empresa_id_estadoEmpresa;
    
    private String estadoempresa_id_estadoEmpresa;
    private String estadoempresa_descripcion_estadoEmpresa;
    
    private String historicodocumento_id_historicoDocumento;
    private String historicodocumento_id_documento;
    private String historicodocumento_usuarioRegistro_historicoDocumento;
    private String historicodocumento_usuarioDestino_historicoDocumento;
    private String historicodocumento_observacion_historicoDocumento;
    private String historicodocumento_fechaRegistro_historicoDocumento;
    private String historicodocumento_id_estadoHistorico;
    private String historicodocumento_id_confirmacionRecibido;
    private String historicodocumento_fechaConfirmacion_historicoDocumento;
      
    private String estadohistorico_id_estadoHistorico;
    private String estadohistorico_descripcion_estadoHistorico;
    
    private String confirmacionrecibido_id_confirmacionRecibido;
    private String confirmacionrecibido_descripcion_confirmacionRecibido;
    
    private String sede_id_sede;
    private String sede_nombre_sede;
    private String sede_id_estadoSede;

    private String estadosede_id_estadoSede;
    private String estadosede_descripcion_estadoSede;
    
    private String usuario_id_usuario;
    private String usuario_nombre_usuario;
    private String usuario_apellido_usuario;
    private String usuario_mail_usuario;
    private String usuario_id_estadoUsuario;
   public ConsultaGeneralInforme() {
    }

    public ConsultaGeneralInforme(String documento_id_documento, String documento_numFactura_documento, String documento_nit_proveedor, String documento_observacion_documento, String documento_id_estadoDocumento, String documento_id_usuario, String documento_nit_empresa, String documento_id_sede, String documento_fechaAnulacion_documento, String documento_observacionAnulacion_documento, String estadodocumento_id_estadoDocumento, String estadodocumento_descripcion_estadoDocumento, String proveedor_nit_proveedor, String proveedor_dig_proveedor, String proveedor_nombre_proveedor, String proveedor_correo_proveedor, String proveedor_telefono_proveedor, String proveedor_id_estadoProveedor, String estadoProveedor_id_estadoProveedor, String estadoProveedor_descripcion_estadoProveedor, String empresa_nit_empresa, String empresa_dig_empresa, String empresa_nombre_empresa, String empresa_correo_empresa, String empresa_telefono_empresa, String empresa_id_estadoEmpresa, String estadoempresa_id_estadoEmpresa, String estadoempresa_descripcion_estadoEmpresa, String historicodocumento_id_historicoDocumento, String historicodocumento_id_documento, String historicodocumento_usuarioRegistro_historicoDocumento, String historicodocumento_usuarioDestino_historicoDocumento, String historicodocumento_observacion_historicoDocumento, String historicodocumento_fechaRegistro_historicoDocumento, String historicodocumento_id_estadoHistorico, String historicodocumento_id_confirmacionRecibido, String historicodocumento_fechaConfirmacion_historicoDocumento, String estadohistorico_id_estadoHistorico, String estadohistorico_descripcion_estadoHistorico, String confirmacionrecibido_id_confirmacionRecibido, String confirmacionrecibido_descripcion_confirmacionRecibido, String sede_id_sede, String sede_nombre_sede, String sede_id_estadoSede, String estadosede_id_estadoSede, String estadosede_descripcion_estadoSede, String usuario_id_usuario, String usuario_nombre_usuario, String usuario_apellido_usuario, String usuario_mail_usuario, String usuario_id_estadoUsuario) {
        this.documento_id_documento = documento_id_documento;
        this.documento_numFactura_documento = documento_numFactura_documento;
        this.documento_nit_proveedor = documento_nit_proveedor;
        this.documento_observacion_documento = documento_observacion_documento;
        this.documento_id_estadoDocumento = documento_id_estadoDocumento;
        this.documento_id_usuario = documento_id_usuario;
        this.documento_nit_empresa = documento_nit_empresa;
        this.documento_id_sede = documento_id_sede;
        this.documento_fechaAnulacion_documento = documento_fechaAnulacion_documento;
        this.documento_observacionAnulacion_documento = documento_observacionAnulacion_documento;
        this.estadodocumento_id_estadoDocumento = estadodocumento_id_estadoDocumento;
        this.estadodocumento_descripcion_estadoDocumento = estadodocumento_descripcion_estadoDocumento;
        this.proveedor_nit_proveedor = proveedor_nit_proveedor;
        this.proveedor_dig_proveedor = proveedor_dig_proveedor;
        this.proveedor_nombre_proveedor = proveedor_nombre_proveedor;
        this.proveedor_correo_proveedor = proveedor_correo_proveedor;
        this.proveedor_telefono_proveedor = proveedor_telefono_proveedor;
        this.proveedor_id_estadoProveedor = proveedor_id_estadoProveedor;
        this.estadoProveedor_id_estadoProveedor = estadoProveedor_id_estadoProveedor;
        this.estadoProveedor_descripcion_estadoProveedor = estadoProveedor_descripcion_estadoProveedor;
        this.empresa_nit_empresa = empresa_nit_empresa;
        this.empresa_dig_empresa = empresa_dig_empresa;
        this.empresa_nombre_empresa = empresa_nombre_empresa;
        this.empresa_correo_empresa = empresa_correo_empresa;
        this.empresa_telefono_empresa = empresa_telefono_empresa;
        this.empresa_id_estadoEmpresa = empresa_id_estadoEmpresa;
        this.estadoempresa_id_estadoEmpresa = estadoempresa_id_estadoEmpresa;
        this.estadoempresa_descripcion_estadoEmpresa = estadoempresa_descripcion_estadoEmpresa;
        this.historicodocumento_id_historicoDocumento = historicodocumento_id_historicoDocumento;
        this.historicodocumento_id_documento = historicodocumento_id_documento;
        this.historicodocumento_usuarioRegistro_historicoDocumento = historicodocumento_usuarioRegistro_historicoDocumento;
        this.historicodocumento_usuarioDestino_historicoDocumento = historicodocumento_usuarioDestino_historicoDocumento;
        this.historicodocumento_observacion_historicoDocumento = historicodocumento_observacion_historicoDocumento;
        this.historicodocumento_fechaRegistro_historicoDocumento = historicodocumento_fechaRegistro_historicoDocumento;
        this.historicodocumento_id_estadoHistorico = historicodocumento_id_estadoHistorico;
        this.historicodocumento_id_confirmacionRecibido = historicodocumento_id_confirmacionRecibido;
        this.historicodocumento_fechaConfirmacion_historicoDocumento = historicodocumento_fechaConfirmacion_historicoDocumento;
        this.estadohistorico_id_estadoHistorico = estadohistorico_id_estadoHistorico;
        this.estadohistorico_descripcion_estadoHistorico = estadohistorico_descripcion_estadoHistorico;
        this.confirmacionrecibido_id_confirmacionRecibido = confirmacionrecibido_id_confirmacionRecibido;
        this.confirmacionrecibido_descripcion_confirmacionRecibido = confirmacionrecibido_descripcion_confirmacionRecibido;
        this.sede_id_sede = sede_id_sede;
        this.sede_nombre_sede = sede_nombre_sede;
        this.sede_id_estadoSede = sede_id_estadoSede;
        this.estadosede_id_estadoSede = estadosede_id_estadoSede;
        this.estadosede_descripcion_estadoSede = estadosede_descripcion_estadoSede;
        this.usuario_id_usuario = usuario_id_usuario;
        this.usuario_nombre_usuario = usuario_nombre_usuario;
        this.usuario_apellido_usuario = usuario_apellido_usuario;
        this.usuario_mail_usuario = usuario_mail_usuario;
        this.usuario_id_estadoUsuario = usuario_id_estadoUsuario;
    }

    public String getDocumento_id_documento() {
        return documento_id_documento;
    }

    public void setDocumento_id_documento(String documento_id_documento) {
        this.documento_id_documento = documento_id_documento;
    }

    public String getDocumento_numFactura_documento() {
        return documento_numFactura_documento;
    }

    public void setDocumento_numFactura_documento(String documento_numFactura_documento) {
        this.documento_numFactura_documento = documento_numFactura_documento;
    }

    public String getDocumento_nit_proveedor() {
        return documento_nit_proveedor;
    }

    public void setDocumento_nit_proveedor(String documento_nit_proveedor) {
        this.documento_nit_proveedor = documento_nit_proveedor;
    }

    public String getDocumento_observacion_documento() {
        return documento_observacion_documento;
    }

    public void setDocumento_observacion_documento(String documento_observacion_documento) {
        this.documento_observacion_documento = documento_observacion_documento;
    }

    public String getDocumento_id_estadoDocumento() {
        return documento_id_estadoDocumento;
    }

    public void setDocumento_id_estadoDocumento(String documento_id_estadoDocumento) {
        this.documento_id_estadoDocumento = documento_id_estadoDocumento;
    }

    public String getDocumento_id_usuario() {
        return documento_id_usuario;
    }

    public void setDocumento_id_usuario(String documento_id_usuario) {
        this.documento_id_usuario = documento_id_usuario;
    }

    public String getDocumento_nit_empresa() {
        return documento_nit_empresa;
    }

    public void setDocumento_nit_empresa(String documento_nit_empresa) {
        this.documento_nit_empresa = documento_nit_empresa;
    }

    public String getDocumento_id_sede() {
        return documento_id_sede;
    }

    public void setDocumento_id_sede(String documento_id_sede) {
        this.documento_id_sede = documento_id_sede;
    }

    public String getDocumento_fechaAnulacion_documento() {
        return documento_fechaAnulacion_documento;
    }

    public void setDocumento_fechaAnulacion_documento(String documento_fechaAnulacion_documento) {
        this.documento_fechaAnulacion_documento = documento_fechaAnulacion_documento;
    }

    public String getDocumento_observacionAnulacion_documento() {
        return documento_observacionAnulacion_documento;
    }

    public void setDocumento_observacionAnulacion_documento(String documento_observacionAnulacion_documento) {
        this.documento_observacionAnulacion_documento = documento_observacionAnulacion_documento;
    }

    public String getEstadodocumento_id_estadoDocumento() {
        return estadodocumento_id_estadoDocumento;
    }

    public void setEstadodocumento_id_estadoDocumento(String estadodocumento_id_estadoDocumento) {
        this.estadodocumento_id_estadoDocumento = estadodocumento_id_estadoDocumento;
    }

    public String getEstadodocumento_descripcion_estadoDocumento() {
        return estadodocumento_descripcion_estadoDocumento;
    }

    public void setEstadodocumento_descripcion_estadoDocumento(String estadodocumento_descripcion_estadoDocumento) {
        this.estadodocumento_descripcion_estadoDocumento = estadodocumento_descripcion_estadoDocumento;
    }

    public String getProveedor_nit_proveedor() {
        return proveedor_nit_proveedor;
    }

    public void setProveedor_nit_proveedor(String proveedor_nit_proveedor) {
        this.proveedor_nit_proveedor = proveedor_nit_proveedor;
    }

    public String getProveedor_dig_proveedor() {
        return proveedor_dig_proveedor;
    }

    public void setProveedor_dig_proveedor(String proveedor_dig_proveedor) {
        this.proveedor_dig_proveedor = proveedor_dig_proveedor;
    }

    public String getProveedor_nombre_proveedor() {
        return proveedor_nombre_proveedor;
    }

    public void setProveedor_nombre_proveedor(String proveedor_nombre_proveedor) {
        this.proveedor_nombre_proveedor = proveedor_nombre_proveedor;
    }

    public String getProveedor_correo_proveedor() {
        return proveedor_correo_proveedor;
    }

    public void setProveedor_correo_proveedor(String proveedor_correo_proveedor) {
        this.proveedor_correo_proveedor = proveedor_correo_proveedor;
    }

    public String getProveedor_telefono_proveedor() {
        return proveedor_telefono_proveedor;
    }

    public void setProveedor_telefono_proveedor(String proveedor_telefono_proveedor) {
        this.proveedor_telefono_proveedor = proveedor_telefono_proveedor;
    }

    public String getProveedor_id_estadoProveedor() {
        return proveedor_id_estadoProveedor;
    }

    public void setProveedor_id_estadoProveedor(String proveedor_id_estadoProveedor) {
        this.proveedor_id_estadoProveedor = proveedor_id_estadoProveedor;
    }

    public String getEstadoProveedor_id_estadoProveedor() {
        return estadoProveedor_id_estadoProveedor;
    }

    public void setEstadoProveedor_id_estadoProveedor(String estadoProveedor_id_estadoProveedor) {
        this.estadoProveedor_id_estadoProveedor = estadoProveedor_id_estadoProveedor;
    }

    public String getEstadoProveedor_descripcion_estadoProveedor() {
        return estadoProveedor_descripcion_estadoProveedor;
    }

    public void setEstadoProveedor_descripcion_estadoProveedor(String estadoProveedor_descripcion_estadoProveedor) {
        this.estadoProveedor_descripcion_estadoProveedor = estadoProveedor_descripcion_estadoProveedor;
    }

    public String getEmpresa_nit_empresa() {
        return empresa_nit_empresa;
    }

    public void setEmpresa_nit_empresa(String empresa_nit_empresa) {
        this.empresa_nit_empresa = empresa_nit_empresa;
    }

    public String getEmpresa_dig_empresa() {
        return empresa_dig_empresa;
    }

    public void setEmpresa_dig_empresa(String empresa_dig_empresa) {
        this.empresa_dig_empresa = empresa_dig_empresa;
    }

    public String getEmpresa_nombre_empresa() {
        return empresa_nombre_empresa;
    }

    public void setEmpresa_nombre_empresa(String empresa_nombre_empresa) {
        this.empresa_nombre_empresa = empresa_nombre_empresa;
    }

    public String getEmpresa_correo_empresa() {
        return empresa_correo_empresa;
    }

    public void setEmpresa_correo_empresa(String empresa_correo_empresa) {
        this.empresa_correo_empresa = empresa_correo_empresa;
    }

    public String getEmpresa_telefono_empresa() {
        return empresa_telefono_empresa;
    }

    public void setEmpresa_telefono_empresa(String empresa_telefono_empresa) {
        this.empresa_telefono_empresa = empresa_telefono_empresa;
    }

    public String getEmpresa_id_estadoEmpresa() {
        return empresa_id_estadoEmpresa;
    }

    public void setEmpresa_id_estadoEmpresa(String empresa_id_estadoEmpresa) {
        this.empresa_id_estadoEmpresa = empresa_id_estadoEmpresa;
    }

    public String getEstadoempresa_id_estadoEmpresa() {
        return estadoempresa_id_estadoEmpresa;
    }

    public void setEstadoempresa_id_estadoEmpresa(String estadoempresa_id_estadoEmpresa) {
        this.estadoempresa_id_estadoEmpresa = estadoempresa_id_estadoEmpresa;
    }

    public String getEstadoempresa_descripcion_estadoEmpresa() {
        return estadoempresa_descripcion_estadoEmpresa;
    }

    public void setEstadoempresa_descripcion_estadoEmpresa(String estadoempresa_descripcion_estadoEmpresa) {
        this.estadoempresa_descripcion_estadoEmpresa = estadoempresa_descripcion_estadoEmpresa;
    }

    public String getHistoricodocumento_id_historicoDocumento() {
        return historicodocumento_id_historicoDocumento;
    }

    public void setHistoricodocumento_id_historicoDocumento(String historicodocumento_id_historicoDocumento) {
        this.historicodocumento_id_historicoDocumento = historicodocumento_id_historicoDocumento;
    }

    public String getHistoricodocumento_id_documento() {
        return historicodocumento_id_documento;
    }

    public void setHistoricodocumento_id_documento(String historicodocumento_id_documento) {
        this.historicodocumento_id_documento = historicodocumento_id_documento;
    }

    public String getHistoricodocumento_usuarioRegistro_historicoDocumento() {
        return historicodocumento_usuarioRegistro_historicoDocumento;
    }

    public void setHistoricodocumento_usuarioRegistro_historicoDocumento(String historicodocumento_usuarioRegistro_historicoDocumento) {
        this.historicodocumento_usuarioRegistro_historicoDocumento = historicodocumento_usuarioRegistro_historicoDocumento;
    }

    public String getHistoricodocumento_usuarioDestino_historicoDocumento() {
        return historicodocumento_usuarioDestino_historicoDocumento;
    }

    public void setHistoricodocumento_usuarioDestino_historicoDocumento(String historicodocumento_usuarioDestino_historicoDocumento) {
        this.historicodocumento_usuarioDestino_historicoDocumento = historicodocumento_usuarioDestino_historicoDocumento;
    }

    public String getHistoricodocumento_observacion_historicoDocumento() {
        return historicodocumento_observacion_historicoDocumento;
    }

    public void setHistoricodocumento_observacion_historicoDocumento(String historicodocumento_observacion_historicoDocumento) {
        this.historicodocumento_observacion_historicoDocumento = historicodocumento_observacion_historicoDocumento;
    }

    public String getHistoricodocumento_fechaRegistro_historicoDocumento() {
        return historicodocumento_fechaRegistro_historicoDocumento;
    }

    public void setHistoricodocumento_fechaRegistro_historicoDocumento(String historicodocumento_fechaRegistro_historicoDocumento) {
        this.historicodocumento_fechaRegistro_historicoDocumento = historicodocumento_fechaRegistro_historicoDocumento;
    }

    public String getHistoricodocumento_id_estadoHistorico() {
        return historicodocumento_id_estadoHistorico;
    }

    public void setHistoricodocumento_id_estadoHistorico(String historicodocumento_id_estadoHistorico) {
        this.historicodocumento_id_estadoHistorico = historicodocumento_id_estadoHistorico;
    }

    public String getHistoricodocumento_id_confirmacionRecibido() {
        return historicodocumento_id_confirmacionRecibido;
    }

    public void setHistoricodocumento_id_confirmacionRecibido(String historicodocumento_id_confirmacionRecibido) {
        this.historicodocumento_id_confirmacionRecibido = historicodocumento_id_confirmacionRecibido;
    }

    public String getHistoricodocumento_fechaConfirmacion_historicoDocumento() {
        return historicodocumento_fechaConfirmacion_historicoDocumento;
    }

    public void setHistoricodocumento_fechaConfirmacion_historicoDocumento(String historicodocumento_fechaConfirmacion_historicoDocumento) {
        this.historicodocumento_fechaConfirmacion_historicoDocumento = historicodocumento_fechaConfirmacion_historicoDocumento;
    }

    public String getEstadohistorico_id_estadoHistorico() {
        return estadohistorico_id_estadoHistorico;
    }

    public void setEstadohistorico_id_estadoHistorico(String estadohistorico_id_estadoHistorico) {
        this.estadohistorico_id_estadoHistorico = estadohistorico_id_estadoHistorico;
    }

    public String getEstadohistorico_descripcion_estadoHistorico() {
        return estadohistorico_descripcion_estadoHistorico;
    }

    public void setEstadohistorico_descripcion_estadoHistorico(String estadohistorico_descripcion_estadoHistorico) {
        this.estadohistorico_descripcion_estadoHistorico = estadohistorico_descripcion_estadoHistorico;
    }

    public String getConfirmacionrecibido_id_confirmacionRecibido() {
        return confirmacionrecibido_id_confirmacionRecibido;
    }

    public void setConfirmacionrecibido_id_confirmacionRecibido(String confirmacionrecibido_id_confirmacionRecibido) {
        this.confirmacionrecibido_id_confirmacionRecibido = confirmacionrecibido_id_confirmacionRecibido;
    }

    public String getConfirmacionrecibido_descripcion_confirmacionRecibido() {
        return confirmacionrecibido_descripcion_confirmacionRecibido;
    }

    public void setConfirmacionrecibido_descripcion_confirmacionRecibido(String confirmacionrecibido_descripcion_confirmacionRecibido) {
        this.confirmacionrecibido_descripcion_confirmacionRecibido = confirmacionrecibido_descripcion_confirmacionRecibido;
    }

    public String getSede_id_sede() {
        return sede_id_sede;
    }

    public void setSede_id_sede(String sede_id_sede) {
        this.sede_id_sede = sede_id_sede;
    }

    public String getSede_nombre_sede() {
        return sede_nombre_sede;
    }

    public void setSede_nombre_sede(String sede_nombre_sede) {
        this.sede_nombre_sede = sede_nombre_sede;
    }

    public String getSede_id_estadoSede() {
        return sede_id_estadoSede;
    }

    public void setSede_id_estadoSede(String sede_id_estadoSede) {
        this.sede_id_estadoSede = sede_id_estadoSede;
    }

    public String getEstadosede_id_estadoSede() {
        return estadosede_id_estadoSede;
    }

    public void setEstadosede_id_estadoSede(String estadosede_id_estadoSede) {
        this.estadosede_id_estadoSede = estadosede_id_estadoSede;
    }

    public String getEstadosede_descripcion_estadoSede() {
        return estadosede_descripcion_estadoSede;
    }

    public void setEstadosede_descripcion_estadoSede(String estadosede_descripcion_estadoSede) {
        this.estadosede_descripcion_estadoSede = estadosede_descripcion_estadoSede;
    }

    public String getUsuario_id_usuario() {
        return usuario_id_usuario;
    }

    public void setUsuario_id_usuario(String usuario_id_usuario) {
        this.usuario_id_usuario = usuario_id_usuario;
    }

    public String getUsuario_nombre_usuario() {
        return usuario_nombre_usuario;
    }

    public void setUsuario_nombre_usuario(String usuario_nombre_usuario) {
        this.usuario_nombre_usuario = usuario_nombre_usuario;
    }

    public String getUsuario_apellido_usuario() {
        return usuario_apellido_usuario;
    }

    public void setUsuario_apellido_usuario(String usuario_apellido_usuario) {
        this.usuario_apellido_usuario = usuario_apellido_usuario;
    }

    public String getUsuario_mail_usuario() {
        return usuario_mail_usuario;
    }

    public void setUsuario_mail_usuario(String usuario_mail_usuario) {
        this.usuario_mail_usuario = usuario_mail_usuario;
    }

    public String getUsuario_id_estadoUsuario() {
        return usuario_id_estadoUsuario;
    }

    public void setUsuario_id_estadoUsuario(String usuario_id_estadoUsuario) {
        this.usuario_id_estadoUsuario = usuario_id_estadoUsuario;
    }

   
}
