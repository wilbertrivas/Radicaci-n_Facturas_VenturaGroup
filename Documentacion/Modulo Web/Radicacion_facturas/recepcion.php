<?php
	function conectar() {
		require_once("conexion.php");
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
					<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
					<title></title>
					<style type="text/css">
						@import url("resources/css/style.css");
							.Estilo2 {color: #666666}
					</style>
			</head>
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
			<body>

				<div class="panel panel-default">
					  <!-- Default panel contents -->
					  <div class="panel-heading">
					 
					  
					  <h5>Actualmente se encuentra conectado: <strong><?php echo "".$usuario_nombre." ".$usuario_apellido; ?></strong><a href="control.php?action=atras"> <img src="resources/img/atras.png" title="Atras" align="middle" /></a> </h5>
					  </div>
				
					  <table class="table">
					  
							<?php
								$enlace = conectar();	
								$sql = "SELECT 
											 h.id_historicoDocumento, 
											 h.id_documento, 
											 h.fechaRegistro_historicoDocumento, 
											 d.numFactura_documento, 
											 p.nit_proveedor, 
											 p.dig_proveedor, 
											 p.nombre_proveedor, 
											 e.nombre_empresa, 
											 h.usuarioRegistro_historicoDocumento, 
											 h.usuarioDestino_historicoDocumento 
											 FROM radicado_facturas_vg.documento d 
												 INNER JOIN radicado_facturas_vg.historicoDocumento h  ON h.id_documento = d.id_documento 
												 INNER JOIN radicado_facturas_vg.proveedor p  ON p.nit_proveedor = d.nit_proveedor 
												 INNER JOIN radicado_facturas_vg.empresa e  ON e.nit_empresa = d.nit_empresa 
											 WHERE h.id_estadoHistorico = 2 AND h.usuarioDestino_historicoDocumento='".$usuario_id."' AND h.id_confirmacionRecibido=0             
											 LIMIT 500;";
								$result = mysql_query($sql) or die("La consulta fall&oacute;: " . mysql_error());?>
							<tr>
								<!--<td>ID HISTORICO</td> <td>ID DOCUMENTO</td> --><td><strong>FECHA REGISTRO</strong></td><td><strong>NUM FACTURA</strong></td> <td><strong>NIT PROVEEDOR</strong></td> <td><strong>NOMBRE PROVEEDOR</strong></td> <td><strong>NOMBRE EMPRESA</strong></td> <td><strong>USUARIO ORIGEN</strong></td> <td><strong>USUARIO DESTINO</strong></td><td><strong>CONFIRMAR RECIBIDO</strong></td><td><strong>RECHAZAR RECIBIDO</strong></td>
							</tr><?php 
								while($row = mysql_fetch_array($result)) {
									//echo "<tr> <td>".$row["id_historicoDocumento"]."</td> <td>".$row["id_documento"]."</td> <td>".$row["fechaRegistro_historicoDocumento"]."</td><td>".$row["numFactura_documento"]."</td> <td>".$row["nit_proveedor"]."</td> <td>".$row["nombre_proveedor"]."</td> <td>".$row["nombre_empresa"]."</td> <td>".$row["usuarioRegistro_historicoDocumento"]."</td> <td>".$row["usuarioDestino_historicoDocumento"]."</td>";
									echo "<tr><td>".$row["fechaRegistro_historicoDocumento"]."</td><td>".$row["numFactura_documento"]."</td> <td>".$row["nit_proveedor"]."</td> <td>".$row["nombre_proveedor"]."</td> <td>".$row["nombre_empresa"]."</td> <td>".$row["usuarioRegistro_historicoDocumento"]."</td> <td>".$row["usuarioDestino_historicoDocumento"]."</td>";
									 ?>
									 <td><a href="control.php?idHistorico=<?php echo $row["id_historicoDocumento"];?>&idDocumento=<?php echo $row["id_documento"];?>&action=confirmarRecibido"> <img src="resources/img/confirmar.png" title="Confirmar Recibido" align="middle" /></a></td> 	
									 <td><a href="control.php?idHistorico=<?php echo $row["id_historicoDocumento"];?>&idDocumento=<?php echo $row["id_documento"];?>&action=rechazarRecibido"> <img src="resources/img/rechazar.png" title="Rechazar Recibido" align="middle" /></a></td> 
									 </tr>	
								<?php } ?>
					  </table>
				</div>      
			</body>
		</html> <?php 
	} 

?>
