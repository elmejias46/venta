package com.itx.gestionVentas;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itx.gestionVentas.controllers.VentaController;
import com.itx.gestionVentas.dtos.RequestVentasDto;
import com.itx.gestionVentas.entities.Venta;
import com.itx.gestionVentas.repository.VentaRepository;

@WebMvcTest(VentaController.class)
public class VentaControllerTest<T> {
	
	@Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    VentaRepository ventaRepository;
    
    private final RequestVentasDto request = null;
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss"); 
    
    Venta VENTA_1 = new Venta(1L, LocalDateTime.parse("2020-06-14-00.00.00", formatter), LocalDateTime.parse("2020-12-31-23.59.59", formatter), 1L, 35455L, 0L, 35.50D, "EUR");
    Venta VENTA_2 = new Venta(1L, LocalDateTime.parse("2020-06-14-15.00.00", formatter), LocalDateTime.parse("2020-06-14-18.30.00", formatter), 2L, 35455L, 1L, 25.45D, "EUR");
    Venta VENTA_3 = new Venta(1L, LocalDateTime.parse("2020-06-15-00.00.00", formatter), LocalDateTime.parse("2020-06-15-11.00.00", formatter), 3L, 35455L, 1L, 30.50D, "EUR");
    Venta VENTA_4 = new Venta(1L, LocalDateTime.parse("2020-06-15-16.00.00", formatter), LocalDateTime.parse("2020-12-31-23.59.59", formatter), 4L, 35455L, 1L, 38.95D, "EUR");
    
    @Test
    public void test1() throws Exception {

        Mockito.when(ventaRepository.findVentasByFilter("2020-06-14-10.00.00", "35455", "1" ));
    	
        mockMvc.perform(MockMvcRequestBuilders
                .get("/venta")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    public void test2() throws Exception {

        Mockito.when(ventaRepository.findVentasByFilter("2020-06-14-16.00.00", "35455", "1" ));
    	
        mockMvc.perform(MockMvcRequestBuilders
                .get("/venta")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    public void test3() throws Exception {

        Mockito.when(ventaRepository.findVentasByFilter("2020-06-14-21.00.00", "35455", "1" ));
    	
        mockMvc.perform(MockMvcRequestBuilders
                .get("/venta")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    public void test4() throws Exception {

        Mockito.when(ventaRepository.findVentasByFilter("2020-06-15-10.00.00", "35455", "1" ));
    	
        mockMvc.perform(MockMvcRequestBuilders
                .get("/venta")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    public void test5() throws Exception {

        Mockito.when(ventaRepository.findVentasByFilter("2020-06-16-21.00.00", "35455", "1" ));
    	
        mockMvc.perform(MockMvcRequestBuilders
                .get("/venta")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
   

}
