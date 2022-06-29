package com.itx.gestionVentas.services;

import java.util.List;

import com.itx.gestionVentas.dtos.RequestVentasDto;
import com.itx.gestionVentas.dtos.ResponseVentaDto;

public interface VentaService {
	
	List<ResponseVentaDto> get(RequestVentasDto parametros);

}
