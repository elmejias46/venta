package com.itx.gestionVentas.repository;

import java.util.List;

import com.itx.gestionVentas.entities.Venta;

public interface VentaRepositoryCustom {
	
	List<Venta> findVentasByFilter(String fechaAplicacion, String identificadorProducto, String identificadorCadena);
	
}