<?php
	$servername = "172.30.200.80";
	$database = "radicado_facturas_vg";
	$username = "root";
	$password = "opp!2015";
	// Create connection
	$enlace = mysql_connect($servername, $username, $password, $database);
	// Check connection
	if (!$enlace) {
	    die("Connection failed: " . mysql_connect_error());
	}else{
	}

	
?>
