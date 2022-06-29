package com.itx.gestionVentas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itx.gestionVentas.entities.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer>, VentaRepositoryCustom {
	
}