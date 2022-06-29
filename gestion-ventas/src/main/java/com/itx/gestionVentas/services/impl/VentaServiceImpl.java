package com.itx.gestionVentas.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itx.gestionVentas.dtos.RequestVentasDto;
import com.itx.gestionVentas.dtos.ResponseVentaDto;
import com.itx.gestionVentas.entities.Venta;
import com.itx.gestionVentas.mappers.VentaMapper;
import com.itx.gestionVentas.repository.VentaRepository;
import com.itx.gestionVentas.services.VentaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class VentaServiceImpl implements VentaService {
	
	private final VentaRepository ventasRepository;
	
	private final VentaMapper mapper;
	
	public List<ResponseVentaDto> get(RequestVentasDto parametros) {
		
		//Extraemos valores de las enumeraciones
		String fechaAplicacion = (null != parametros.getFechaAplicacion())?parametros.getFechaAplicacion().toString():null;
		String identificadorProducto = (null != parametros.getIdentificadorProducto())?parametros.getIdentificadorProducto().toString():null;
		String identificadorCadena = (null != parametros.getIdentificadorCadena())?parametros.getIdentificadorCadena().toString():null;
		
		List<Venta> ventas = ventasRepository.findVentasByFilter(fechaAplicacion, identificadorProducto, identificadorCadena);
		
		var ventasToResponsesVentaDtos = mapper.VentasToResponsesVentaDtos(ventas);
		
		return ventasToResponsesVentaDtos;
		
	}	

}
