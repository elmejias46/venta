package com.itx.gestionVentas.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRICES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
	
	@Column(name = "BRAND_ID", nullable = false)
	private Long brandId;
	
	@Column(name = "START_DATE", nullable = false)
	private LocalDateTime startDate;
	
	@Column(name = "END_DATE", nullable = false)
	private LocalDateTime endDate;
	
	@Column(name = "PRICE_LIST", nullable = false)
	private Long priceList;
	
	@Column(name = "PRODUCT_ID", nullable = true)
	private Long productId;
	
	@Column(name = "PRIORITY", nullable = true)
	private Long priority;
	
	@Column(name = "PRICE", nullable = true)
	private Double price;
	
	@Column(name = "CURR", nullable = true)
	private String curr;
	
}
