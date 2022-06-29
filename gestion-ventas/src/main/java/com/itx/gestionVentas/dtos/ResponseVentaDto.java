package com.itx.gestionVentas.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ResponseVentaDto {
		
	private String identificadorProducto;
	
	private String identificadorCadena;
	
	private String tarifaAplicar;
	
	private String fechasAplicacion;
	
	private String precioFinalAplicar;
	

}
