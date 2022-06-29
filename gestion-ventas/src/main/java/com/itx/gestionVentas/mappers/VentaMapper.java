package com.itx.gestionVentas.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.itx.gestionVentas.dtos.ResponseVentaDto;
import com.itx.gestionVentas.entities.Venta;

@Mapper(componentModel="spring")
public interface VentaMapper {
	
	List<ResponseVentaDto> VentasToResponsesVentaDtos(List<Venta> venta);

}