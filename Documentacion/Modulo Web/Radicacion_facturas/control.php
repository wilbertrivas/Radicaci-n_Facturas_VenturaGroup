<?php	
    $action = $_REQUEST["action"];
    switch($action) {				
        case "validarse":
            $next = validarse();
            header("location:".$next);
            break;	
		case "confirmarRecibido":
            $next = confirmarRecibido();
            header("location:".$next);
            break;
			
		case "rechazarRecibido":
            $next = rechazarRecibido();
            header("location:".$next);
            break;			
		case "enviar":
            $next = enviar();
            header("location:".$next);
            break;
			
		case "atras":
            $next = atras();
            header("location:".$next);
            break;
		
			
        case "salir":
            $next = salir();
            header("location:".$next);
            break;    
        default: header("location:panel.php");
    }

	function conectar() {
		require_once("conexion.php");
		return $enlace;
	}
	function salir() {
            session_start();
            $login = $_SESSION["user_id"];
            if (isset($login)) {
                $enlace = conectar();
                session_destroy();
                return "index.php";
            } else {
                return "index.php";
            }
	}
	function atras() {
        return "panel.php";    
	}
	
	function validarse(){
		session_start();
		$enlace = conectar();	
		//Se recibe el login y password
		$login = $_REQUEST["login"];
		$password = $_REQUEST["password"];	  
		$servidor_LDAP = "dominio.goib.com";
		$servidor_dominio = "goib.com";
		$ldap_dn = "dc=goib,dc=com";
		$usuario_LDAP = $login;
		$contrasena_LDAP = $password;
		
		$conectado_LDAP = ldap_connect($servidor_LDAP);
		ldap_set_option($conectado_LDAP, LDAP_OPT_PROTOCOL_VERSION, 3);
		ldap_set_option($conectado_LDAP, LDAP_OPT_REFERRALS, 0);			
		if($conectado_LDAP){			
			$autenticado_LDAP = ldap_bind($conectado_LDAP,  $usuario_LDAP . "@" . $servidor_dominio, $contrasena_LDAP);
			if ($autenticado_LDAP){			
				$_SESSION["user_id"]=$login;
				//print_r($_SESSION);
				//echo "conecto";
				//consulta para saber si es admon - tipusuario
				
				$sql = "SELECT id_usuario, nombre_usuario, apellido_usuario, mail_usuario,id_estadoUsuario
				FROM radicado_facturas_vg.usuario
				WHERE id_usuario='".$login."' AND id_estadoUsuario= 1"; 
				$result = mysql_query($sql);
				$row = mysql_fetch_array($result);
				if(mysql_num_rows($result)>0) {
					$_SESSION["usuario_id"]=$row['id_usuario'];
					$_SESSION["usuario_nombre"]=$row['nombre_usuario'];
					$_SESSION["usuario_apellido"]=$row['apellido_usuario'];
					$_SESSION["mail_usuario"]=$row['mail_usuario'];
					$_SESSION["id_estadoUsuario"]=$row['id_estadoUsuario'];
					//mysql_close($enlace);
					//echo $_SESSION["usuario_id"];
					return "panel.php";		
					//return "recepcion.php";		
				}else{
					//mysql_close($enlace);
					//echo "No conecto";
					$_SESSION["errors"] = "Por favor verifique su usuario y contraseña, los datos ingresados No son correctos o su usuario no existe";
					return "login.php";
				}	
			}else{
				//echo "No conecto";
				$_SESSION["errors"] = "Por favor verifique su usuario y contraseña, los datos ingresados No son correctos o su usuario no existe";
				return "login.php";
			}
		}else{
			echo "repailas";
		}                    			
	}
		
		
		
		
		
		/*//########################
		session_start();
		$enlace = conectar();	
		//Se recibe el login y password
		$login = $_REQUEST["login"];
		$password = $_REQUEST["password"];								
		$sql = "SELECT id_usuario, nombre_usuario, apellido_usuario, mail_usuario,id_estadoUsuario
				FROM radicado_facturas_vg.usuario
				WHERE id_usuario='".$login."' AND id_estadoUsuario= 1"; 
		$result = mysql_query($sql);
		$row = mysql_fetch_array($result);
		if(mysql_num_rows($result)>0) {
			$_SESSION["usuario_id"]=$row['id_usuario'];
			$_SESSION["usuario_nombre"]=$row['nombre_usuario'];
			$_SESSION["usuario_apellido"]=$row['apellido_usuario'];
			$_SESSION["mail_usuario"]=$row['mail_usuario'];
			$_SESSION["id_estadoUsuario"]=$row['id_estadoUsuario'];
			mysql_close($enlace);
			echo $_SESSION["usuario_id"];
			return "panel.php";		
		}else{
			mysql_close($enlace);
			return "login.php";
		}	*/
	
	function confirmarRecibido() {
		if (!isset($_SESSION["idHistorico"])) {
			$idHistorico = $_REQUEST["idHistorico"];
			$idDocumento = $_REQUEST["idDocumento"];
			$enlace = conectar();
			$sql = "SELECT id_historicoDocumento,id_documento FROM radicado_facturas_vg.historicoDocumento WHERE id_historicoDocumento='$idHistorico' AND id_documento='$idDocumento' ";
			$result = mysql_query($sql) or die("La consulta fall&oacute;: " . mysql_error());
			$row = mysql_fetch_array($result);
			if(mysql_num_rows($result)>0) {
				$sql="UPDATE 
						radicado_facturas_vg.historicoDocumento 
						SET id_estadoHistorico = '3',id_confirmacionRecibido = '1' 
						WHERE historicoDocumento.id_historicoDocumento = '".$idHistorico."' AND `historicoDocumento`.`id_documento` = '".$idDocumento."';";
						
				mysql_query($sql)or die("La consulta fall&oacute;: " . mysql_error());
				
				$sqlValidar = "SELECT * FROM radicado_facturas_vg.historicoDocumento WHERE id_documento='$idDocumento' AND id_estadoHistorico='2';";
				$resultValidar = mysql_query($sqlValidar) or die("La consulta fall&oacute;: " . mysql_error());
				$rowValidar = mysql_fetch_array($resultValidar);
				$contador=0;
				if(mysql_num_rows($resultValidar)>0) {
					$contador= $contador+1;
				}
				if($contador == 0){//si contador == 0 quiere decir que no hay documentos pendientes por recibir por lo que podemos cambiar id_estadoDocumento=0;
					$sqlValidarEstadoDocumento = "SELECT id_estadoDocumento FROM `radicado_facturas_vg`.`documento` WHERE `id_documento`='$idDocumento';";
					$resultValidarEstadoDocumento = mysql_query($sqlValidarEstadoDocumento) or die("La consulta fall&oacute;: " . mysql_error());
					$rowValidarEstadoDocumento = mysql_fetch_array($resultValidarEstadoDocumento);
					$valorEstadoDocumento=0;
					if(mysql_num_rows($resultValidarEstadoDocumento)>0) {
						$valorEstadoDocumento= $rowValidarEstadoDocumento['id_estadoDocumento'];
						//echo $rowValidarEstadoDocumento['id_estadoDocumento'];
					}
					if($valorEstadoDocumento!=2){//Si valorEstadoDocumento==2 quiere decir que el documento esta Anulado y no se puede inactivar con 0, si !=2 quiere decir que el documento esta activo y procedemos a Inactivar con 0
						$sqlCambiarEstadoDocumento="UPDATE radicado_facturas_vg.documento SET id_estadoDocumento = '0' WHERE documento.id_documento = '$idDocumento';";
						mysql_query($sqlCambiarEstadoDocumento)or die("La consulta fall&oacute;: " . mysql_error());	
					}				
					mysql_close($enlace);
					return "recepcion.php";
				}else{
					mysql_close($enlace);
					return "recepcion.php";
				}	
			}			    
		}
	}
	function rechazarRecibido() {
		if (!isset($_SESSION["idHistorico"])) {
			$idHistorico = $_REQUEST["idHistorico"];
			$idDocumento = $_REQUEST["idDocumento"];
			$enlace = conectar();
			$sql = "SELECT id_historicoDocumento,id_documento FROM radicado_facturas_vg.historicoDocumento WHERE id_historicoDocumento='$idHistorico' AND id_documento='$idDocumento' ";
			$result = mysql_query($sql) or die("La consulta fall&oacute;: " . mysql_error());
			$row = mysql_fetch_array($result);
			if(mysql_num_rows($result)>0) {
				$sql="UPDATE 
						radicado_facturas_vg.historicoDocumento 
						SET id_estadoHistorico = '4',id_confirmacionRecibido = '3' 
						WHERE historicoDocumento.id_historicoDocumento = '".$idHistorico."' AND `historicoDocumento`.`id_documento` = '".$idDocumento."';";
						
				mysql_query($sql)or die("La consulta fall&oacute;: " . mysql_error());
				
				$sqlValidar = "SELECT * FROM radicado_facturas_vg.historicoDocumento WHERE id_documento='$idDocumento' AND id_estadoHistorico='2';";
				$resultValidar = mysql_query($sqlValidar) or die("La consulta fall&oacute;: " . mysql_error());
				$rowValidar = mysql_fetch_array($resultValidar);
				$contador=0;
				if(mysql_num_rows($resultValidar)>0) {
					$contador= $contador+1;
				}
				if($contador == 0){//si contador == 0 quiere decir que no hay documentos pendientes por recibir por lo que podemos cambiar id_estadoDocumento=0;
					$sqlValidarEstadoDocumento = "SELECT id_estadoDocumento FROM `radicado_facturas_vg`.`documento` WHERE `id_documento`='$idDocumento';";
					$resultValidarEstadoDocumento = mysql_query($sqlValidarEstadoDocumento) or die("La consulta fall&oacute;: " . mysql_error());
					$rowValidarEstadoDocumento = mysql_fetch_array($resultValidarEstadoDocumento);
					$valorEstadoDocumento=0;
					if(mysql_num_rows($resultValidarEstadoDocumento)>0) {
						$valorEstadoDocumento= $rowValidarEstadoDocumento['id_estadoDocumento'];
						//echo $rowValidarEstadoDocumento['id_estadoDocumento'];
					}
					if($valorEstadoDocumento!=2){//Si valorEstadoDocumento==2 quiere decir que el documento esta Anulado y no se puede inactivar con 0, si !=2 quiere decir que el documento esta activo y procedemos a Inactivar con 0
						$sqlCambiarEstadoDocumento="UPDATE radicado_facturas_vg.documento SET id_estadoDocumento = '0' WHERE documento.id_documento = '$idDocumento';";
						mysql_query($sqlCambiarEstadoDocumento)or die("La consulta fall&oacute;: " . mysql_error());	
					}				
					mysql_close($enlace);
					return "recepcion.php";
				}else{
					mysql_close($enlace);
					return "recepcion.php";
				}	
			}			    
		}
	}
	function enviar() {		
		if (isset($_POST["usuario_id"])) {
			$documento_ID = $_POST["Doc_id_documento"];
			$usuario_QuienEnvia = $_POST["usuario_id"];
			$usuario_QuienRecibe = $_POST["idUsuarioDestino"];
			$Documento_Observacion = $_POST["observacion"];	


			$enlace = conectar();
			$sql = "INSERT INTO `radicado_facturas_vg`.`historicoDocumento`"
                ."(`id_historicoDocumento`, `id_documento`, `usuarioRegistro_historicoDocumento`,`usuarioDestino_historicoDocumento`, `observacion_historicoDocumento`, `fechaRegistro_historicoDocumento`,
				   `id_estadoHistorico`,`id_confirmacionRecibido`) VALUES (NULL,'".$documento_ID."','".$usuario_QuienEnvia."','".$usuario_QuienRecibe."','".$Documento_Observacion."',(select now()),'2','0');";
		
			mysql_query($sql) or die("La consulta fall&oacute;: " . mysql_error());
			$sqlCambiarEstadoDocumento="UPDATE `radicado_facturas_vg`.`documento` SET `id_estadoDocumento` = '1' WHERE `documento`.`id_documento` = '".$documento_ID."';";
			mysql_query($sqlCambiarEstadoDocumento)or die("La consulta fall&oacute;: " . mysql_error());	
			mysql_close($enlace);
			return "enviar.php";				
		}
	}
 
?>