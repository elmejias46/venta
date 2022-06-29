package com.itx.gestionVentas.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class VentaDto {
	
	@NotNull
	private Long brandId;
	
	@NotNull
	private LocalDateTime fechaCompra;
		
	@NotNull
	private LocalDateTime startDate;
	
	@NotNull
	private LocalDateTime endDate;
	
	@NotNull
	private Long priceList;
	
	@NotNull
	private Long productId;
	
	@NotNull
	private Long priority;
	
	@NotNull
	private Double price;
		
	@NotNull
	private String curr;
	
}
