<?php session_start(); ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title></title>
		<style type="text/css">
			@import url("resources/css/style.css");
				.Estilo2 {color: #666666}
		</style>		
			<script>
			function validarFor() {
				if(document.getElementById('login').value=="") {
					alert("[Dato Obligatorio]: Por favor diligencie su Nombre de Usuario.");
					document.getElementById("login").focus();
					return;
				}
				else if(document.getElementById('password').value=="") {
					alert("[Dato Obligatorio]: Por favor diligencie una Contraseña de Usuario.");
					document.getElementById("password").focus();
					return;				
				}
				else {

				}
			}	
		</script>
	</head>
	<body>
		<form action="control.php" method="post" name="frmlogeo">
			<input type="hidden" name="action" value="validarse">

			<fieldset>
				<legend>INICIAR SESI&Oacute;N</legend>
				<table align="center" border="0">

					<tr><td colspan="3">&nbsp;</td></tr>
					<tr><td colspan="2"><div align="center"><strong>LOGIN DE LA APLICACI&Oacute;N</strong></td> </tr>
					<tr>
						<td><strong>Usuario:</strong></td>
						<td><input type="text" name="login" id="login" size="30" class="login"/></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td><strong>Contrase&ntilde;a:</strong></td>
						<td><input type="password" name="password" id="password" size="30" class="password"/></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2"><div align="right"><input type="submit" name="submit1" onclick="validarFor()" id="submit1" value="Ingresar" class="button" /></div></td>
						<td><img src="resources/img/comunes/Candado.gif" title="Inicie sesi&oacute;n"/></td>
					</tr>
					<tr><td colspan="3">&nbsp;</td></tr>
				</table>
				<div align="center">				
				</div>
			</fieldset>
			<br /><br /><hr /><br /><br />
		</form>
		<script>
			document.getElementById("login").focus();
		</script>
	</body>
</html>
