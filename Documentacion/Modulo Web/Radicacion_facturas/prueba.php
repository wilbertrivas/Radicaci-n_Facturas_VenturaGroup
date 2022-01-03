<?php	
    function conectar() {
		require_once("conexion.php");
		return $enlace;
	}

		$enlace = conectar();
	
		$sqlValidarEstadoDocumento = "SELECT id_estadoDocumento FROM `radicado_facturas_vg`.`documento` WHERE `id_documento`='3006' AND id_estadoDocumento=2;";
		$resultValidarEstadoDocumento = mysql_query($sqlValidarEstadoDocumento) or die("La consulta fall&oacute;: " . mysql_error());
		$rowValidarEstadoDocumento = mysql_fetch_array($resultValidarEstadoDocumento);
		$valorEstadoDocumento=0;
		if(mysql_num_rows($resultValidarEstadoDocumento)>0) {
			$valorEstadoDocumento= $rowValidarEstadoDocumento["id_estadoDocumento"];
			echo $rowValidarEstadoDocumento['id_estadoDocumento'];
		}
		if($valorEstadoDocumento==2){//Si el estado del documento =2 quiere decir que fue anulado por tal motivo no se desactiva el estado con valor de 0
			echo "hola";
		}else{//Como el estado esta activo provedemos a inactivar en vista que no está anulado
			//$sqlCambiarEstadoDocumento="UPDATE radicado_facturas_vg.documento SET id_estadoDocumento = '0' WHERE documento.id_documento = '$idDocumento';";
			//mysql_query($sqlCambiarEstadoDocumento)or die("La consulta fall&oacute;: " . mysql_error());
			echo "voy a actualizar";
			echo ".".$valorEstadoDocumento;
		}				
		mysql_close($enlace);
		
					    
?>

?>