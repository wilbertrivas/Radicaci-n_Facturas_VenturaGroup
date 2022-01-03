<?php
    session_start();
    if (!isset($_SESSION["usuario_id"])) {
        header("location:index.php");
    }
    $usuario_id = $_SESSION["usuario_id"];
    $usuario_nombre = $_SESSION["usuario_nombre"];
    $usuario_apellido = $_SESSION["usuario_apellido"];
    echo '<?xml version="1.0" encoding="UTF-8"?>'
?>	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title></title>
		<style type="text/css">
			@import url("resources/css/style.css");
				.Estilo2 {color: #666666}
		</style>
	</head>
	
	<body>
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading"><h5>Actualmente se encuentra conectado: <strong><?php echo "".$usuario_nombre." ".$usuario_apellido; ?></strong></h5></div>
			<div class="panel-body">
				<table border='0' width='100%'>
					<td width="13%"><div align="center"><a href="recepcion.php" target="marco"><img src="resources/img/recibirDocumento.png" title="RECIBIR DOCUMENTOS" width="80"/></a></div></td><td width="20%"><div align="justify">RECIBIR DOCUMENTOS</div></td>
					<td width="13%"><div align="center"><a href="enviar.php" target="marco"><img src="resources/img/enviarDocumento.png" title="ENVIAR DOCUMENTOS" width="80"/></a></div></td><td width="20%"><div align="justify">ENVIAR DOCUMENTOS.</div></td>
				</table>
		  </div>
		</div>
	</body>
</html>
