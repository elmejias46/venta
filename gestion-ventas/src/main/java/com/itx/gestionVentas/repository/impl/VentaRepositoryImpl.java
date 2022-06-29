package com.itx.gestionVentas.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.itx.gestionVentas.entities.Venta;
import com.itx.gestionVentas.repository.VentaRepositoryCustom;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class VentaRepositoryImpl implements VentaRepositoryCustom {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<Venta> findVentasByFilter(String fechaAplicacion, String identificadorProducto, String identificadorCadena) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Venta> cq = cb.createQuery(Venta.class);
	    
	    Root<Venta> venta = cq.from(Venta.class);
	    List<Predicate> predicates = new ArrayList<>();
	    
	    if ( !StringUtils.isEmpty(fechaAplicacion) ) {
	        predicates.add(cb.equal(venta.get("fechaAplicacion"), fechaAplicacion));
	    }
	    
	    if ( !StringUtils.isEmpty(identificadorProducto) ) {
	        predicates.add(cb.equal(venta.get("identificadorProducto"), identificadorProducto));
	    }
	    
	    if ( !StringUtils.isEmpty(identificadorCadena) ) {
	        predicates.add(cb.equal(venta.get("identificadorCadena"), identificadorCadena));
	    }
	    
	    cq.where(predicates.toArray(new Predicate[0]));

	    return entityManager.createQuery(cq).getResultList();
		
	}	

}