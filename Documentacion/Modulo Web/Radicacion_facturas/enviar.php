<?php
	function conectar() {
		require_once("conexion_ModuloConsulta.php");
		return $enlace;
	}
    session_start();
    if (!isset($_SESSION["usuario_id"])) {
        header("location:index.php");
    }else{
		$usuario_id = $_SESSION["usuario_id"];
		$usuario_nombre = $_SESSION["usuario_nombre"];
		$usuario_apellido = $_SESSION["usuario_apellido"];
		echo '<?xml version="1.0" encoding="UTF-8"?>'?>	
		<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
		<html xmlns="http://www.w3.org/1999/xhtml">
			<head>
				<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" <meta charset="utf-8"/>
				<title></title>
				<style type="text/css">
					@import url("resources/css/style.css");
						.Estilo2 {color: #666666}
				</style>
				<script src="js/jquery-1.9.1.min.js"></script>
				<script>
					$(document).ready(function() {
						$("#resultadoBusqueda").html('<p>..........</p>');
					});
					function buscar() {
						var textoBusqueda = $("input#busqueda").val();		 
						 if (textoBusqueda != "") {
							$.post("buscar.php", {valorBusqueda: textoBusqueda}, function(mensaje) {
								$("#resultadoBusqueda").html(mensaje);
							 }); 
						 } else { 
							$("#resultadoBusqueda").html('<p>..........</p>');
						};
					};
				</script>
			</head>
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
			<body>
				<div class="panel panel-default">
					  <div class="panel-heading">
						<h5>Actualmente se encuentra conectado: <strong><?php echo "".$usuario_nombre." ".$usuario_apellido;?></strong><a href="control.php?action=atras"> <img src="resources/img/atras.png" title="Atras" align="middle" /></a> </h5>
						<form accept-charset="utf-8" method="POST" action="control.php">
							<table class="table">
							<!--input type="text" class="form-control" placeholder="Search for..."-->
							<tr><input type="text" class="form-control" name="busqueda" id="busqueda" value="" placeholder="Ingrese Num. Factura" maxlength="30" autocomplete="off" onKeyUp="buscar();" /></tr>
							<div id="resultadoBusqueda"></div>
							<input type="hidden" name="action" value="enviar" />
							</table>
						</form>
					  </div>	 
				</div>      
			</body>
		</html> <?php 
	} 
?>

