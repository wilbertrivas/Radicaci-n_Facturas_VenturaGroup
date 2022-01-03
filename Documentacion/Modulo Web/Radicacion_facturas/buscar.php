<?php
//Archivo de conexión a la base de datos
require('conexion_ModuloConsulta.php');

//Variable de búsqueda
$consultaBusqueda = $_POST['valorBusqueda'];

//Filtro anti-XSS
$caracteres_malos = array("<", ">", "\"", "'", "/", "<", ">", "'", "/");
$caracteres_buenos = array("& lt;", "& gt;", "& quot;", "& #x27;", "& #x2F;", "& #060;", "& #062;", "& #039;", "& #047;");
$consultaBusqueda = str_replace($caracteres_malos, $caracteres_buenos, $consultaBusqueda);
$usuario_id = $_SESSION["usuario_id"];
//Variable vacía (para evitar los E_NOTICE)
$mensaje = "";


//Comprueba si $consultaBusqueda está seteado
if (isset($consultaBusqueda)) {
	session_start();
	//Selecciona todo de la tabla mmv001 
	//donde el nombre sea igual a $consultaBusqueda, 
	//o el apellido sea igual a $consultaBusqueda, 
	//o $consultaBusqueda sea igual a nombre + (espacio) + apellido
	$consulta = mysqli_query($conexion, "SELECT 
											d.id_documento,
											d.numFactura_documento,	
											d.observacion_documento,
											p.nit_proveedor,
											p.nombre_proveedor
										FROM documento d 
											 INNER JOIN radicado_facturas_vg.proveedor p  ON d.nit_proveedor = p.nit_proveedor 					
																
	WHERE d.numFactura_documento  LIKE '%$consultaBusqueda%' 
	OR d.nit_proveedor LIKE '%$consultaBusqueda%' OR d.id_documento LIKE '%$consultaBusqueda%' OR p.nombre_proveedor LIKE '%$consultaBusqueda%' LIMIT 1");

	//Obtiene la cantidad de filas que hay en la consulta
	$filas = mysqli_num_rows($consulta);

	//Si no existe ninguna fila que sea igual a $consultaBusqueda, entonces mostramos el siguiente mensaje
	if ($filas === 0) {
		$mensaje = "<p>No hay ningún usuario con ese nombre y/o apellido</p>";
	} else {
		//Si existe alguna fila que sea igual a $consultaBusqueda, entonces mostramos el siguiente mensaje
		echo 'Resultados para <strong>'.$consultaBusqueda.'</strong>';
		$usuario_id = $_SESSION["usuario_id"];
		//La variable $resultado contiene el array que se genera en la consulta, así que obtenemos los datos y los mostramos en un bucle
		$mensaje .='<table class="table">';
		while($resultados = mysqli_fetch_array($consulta)) {
			$Doc_id_documento = $resultados['id_documento'];
			$Doc_numFactura_documento = $resultados['numFactura_documento'];
			$Doc_nit_proveedor = $resultados['nit_proveedor'];
			$Doc_nombre_proveedor = $resultados['nombre_proveedor'];
			
			$listadoUsuario='';
			$consultaUsuario = mysqli_query($conexion, "SELECT * FROM radicado_facturas_vg.usuario WHERE id_estadoUsuario=1");
			$filasUsuario = mysqli_num_rows($consultaUsuario);
			if ($filasUsuario === 0) {
				$listadoUsuario = "";
			}else{
				
				while($resultadosUsuario = mysqli_fetch_array($consultaUsuario)) {
					$idUsuario = $resultadosUsuario['id_usuario'];
					$nombreUsuario=$resultadosUsuario['nombre_usuario'];
					$apellidoUsuario=$resultadosUsuario['apellido_usuario'];
					$listadoUsuario.='<option value="'.$idUsuario.'"> '.$nombreUsuario.' '.$apellidoUsuario.'</option>';
				}
			}	
			//Output
			$mensaje .= '
						<tr><td><strong>ID </strong></td>
							<td><strong>NUM FACTURA </strong></td>
							<td><strong>NIT_PROVEEDOR </strong></td>
							<td><strong>NOMBRE_PROVEEDOR </strong></td>
							<td><strong>USUARIO </strong></td>		
						</tr>
						<tr>
							<td>'.$Doc_id_documento.'</td>
							<td>'.$Doc_numFactura_documento.'</td>
							<td>'.$Doc_nit_proveedor.'</td>
							<td>'. $Doc_nombre_proveedor.'</td>
							<td><select id="idUsuarioDestino" name="idUsuarioDestino"'.$listadoUsuario.'</select></td>
						<tr>
						<tr>
							<td width="30%"><strong>OBSERVACI&Oacute;N</strong></td>
                                <td colspan=3><TEXTAREA  id="observacion" NAME="observacion"  placeholder="Digite la direcci&oacute;" ROWS="2" COLS="10"> </TEXTAREA>
							</td>
						</tr>
						<tr><td></td><td></td><td><input  type="submit" value="ENVIAR" class="button" /><td></tr>';

		};
		$mensaje .='</table>
								<input type="hidden" name="Doc_id_documento" value="'.$Doc_id_documento.'" />
								<input type="hidden" name="usuario_id" value="'.$usuario_id.'" />';
		//Fin while $resultados
		//<td><a href="control.php?action=enviar&idDocumento=<'.$Doc_id_documento.'&usuario_registra='.$usuario_id.'"> <img src="resources/img/confirmar.png" title="EnviarDocumento" align="middle" /></a></td>	
	}; //Fin else $filas

};//Fin isset $consultaBusqueda

//Devolvemos el mensaje que tomará jQuery
echo $mensaje;
?>