package com.itx.gestionVentas.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class RequestVentasDto {
	
	private String fechaAplicacion;
	
	private String identificadorProducto;
	
	private String identificadorCadena;

}
