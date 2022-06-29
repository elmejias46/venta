package com.itx.gestionVentas.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itx.gestionVentas.dtos.RequestVentasDto;
import com.itx.gestionVentas.dtos.ResponseVentaDto;
import com.itx.gestionVentas.services.VentaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequestMapping("/venta")
@RequiredArgsConstructor
public class VentaController<T> {
	
	private final VentaService ventasService;
	
	@GetMapping
    public ResponseEntity<?> get(RequestVentasDto parametros) {
    	
        log.info("GET /ventas - " + parametros.toString());
        
        List<ResponseVentaDto> ventas = ventasService.get(parametros);
        
        ResponseEntity<?> response;
        
        if (!ventas.isEmpty()) {
        	response = ResponseEntity.ok(ventas);
        	log.info("GET /ventas - Ventas recuperadas: " + ventas.size());
        } else {
        	response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se han encontrado ventas con esos criterios");
        	log.info("GET /ventas - No se han encontrado ventas con esos criterios");
        }     
                
        return response;
    } 

}
