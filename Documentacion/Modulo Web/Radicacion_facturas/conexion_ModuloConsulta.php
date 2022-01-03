<?php
// Carga la configuración 


// Conexión con los datos del 'config.ini' 
$conexion = mysqli_connect("172.30.200.80","root","opp!2015","radicado_facturas_vg"); 

// Si la conexión falla, aparece el error 
if($conexion === false) { 
 echo 'Ha habido un error <br>'.mysqli_connect_error(); 
} else {
 echo '';
}
?>