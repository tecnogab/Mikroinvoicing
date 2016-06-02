<?PHP
SELECT t_clientes.nombre_cli, t_domicilios.barrio_dom, t_domicilios.calle_dom, AsText(t_domicilios.coordenadas_dom) 
FROM t_domicilios, t_clientes WHERE t_domicilios.id_cli = t_clientes.id_cli AND t_domicilios.id_cli = 3
?>