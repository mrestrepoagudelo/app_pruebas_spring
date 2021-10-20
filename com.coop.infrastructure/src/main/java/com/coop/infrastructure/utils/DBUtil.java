package com.coop.infrastructure.utils;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coop.domain.exception.InternalErrorException;
import com.coop.domain.exception.ModelException;

@Component
public class DBUtil {
	
	@Autowired
	private EntityManager em;
	
	public Map<String,Object> findAll(SQL oSql, int pageNumber, int pageSize) throws InternalErrorException{
		List<Map<String,Object>> listaRetorno = new ArrayList<Map<String,Object>>();
		Query query;
		
		try {
			query = em.createNativeQuery(oSql.toString()); 
			query.setFirstResult((pageNumber) * pageSize); 
			query.setMaxResults(pageSize);
		    
	        NativeQueryImpl<Map<String, Object>> nativeQuery = (NativeQueryImpl) query;
	        nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
	        List<Map<String,Object>> results = nativeQuery.getResultList();
	       
			for (int i = 0; i < results.size(); i++) {
				Map<String, Object> mapRow = results.get(i);
				LinkedHashMap<String,Object> reg = new LinkedHashMap<>();
				
				for (Map.Entry<String, Object> entry : mapRow.entrySet()) {
				    String prop = CambioDeCaracteres.CaracteresProp(entry.getKey());
					Object value = entry.getValue();
					reg.put(prop,value);
				}
				listaRetorno.add(reg);
			}
        
		} catch (Exception e) {
			throw new InternalErrorException(e.getMessage());
		}
        
		int tatalRegistro = getNumeroRegistros(oSql.getSqlCount());
		double result = (double)tatalRegistro/(double)pageSize;
		int totalPages = (int) Math.ceil(result);
		
		Map<String,Object> mapResponse = new HashMap<>();
		mapResponse.put("pageNumber", pageNumber);
		mapResponse.put("pageSize", query.getMaxResults());
		mapResponse.put("totalPages", totalPages);
		mapResponse.put("list", listaRetorno);
		mapResponse.put("totalRegistros", tatalRegistro);
		return mapResponse;
	}
	
	public Map<String,Object> findAll(SQL oSql, Object[] parametros, Integer pageNumber, Integer pageSize) throws InternalErrorException {
		List<Map<String,Object>> listaRetorno = new ArrayList<Map<String,Object>>();
		Query query;
		
		try {
			query = em.createNativeQuery(oSql.toString());
			
			if(pageNumber != null && pageSize != null) {
				query.setFirstResult((pageNumber) * pageSize); 
				query.setMaxResults(pageSize);
			}
			
			if(parametros != null) {
				for(int i = 0; i < parametros.length; i++){
					query.setParameter(i+1, parametros[i]);
				}
			}
			
			NativeQueryImpl<Map<String, Object>> nativeQuery = (NativeQueryImpl) query;
			nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			List<Map<String,Object>> results = nativeQuery.getResultList();
			
			for (int i = 0; i < results.size(); i++) {
				Map<String, Object> mapRow = results.get(i);
				LinkedHashMap<String,Object> reg = new LinkedHashMap<>();
				
				for (Map.Entry<String, Object> entry : mapRow.entrySet()) {
				    String prop = CambioDeCaracteres.CaracteresProp(entry.getKey());
					Object value = entry.getValue();
					reg.put(prop,value);
				}
				listaRetorno.add(reg);
			}
			
		}
		catch (ModelException e) {
			throw new InternalErrorException(e);
		}
		
		Map<String,Object> mapResponse = new HashMap<>();
		
		int tatalRegistro = getNumeroRegistros(oSql.getSqlCount(), parametros);
		
		if(pageNumber != null && pageSize != null) {
			double result = (double)tatalRegistro/(double)pageSize;
			int totalPages = (int) Math.ceil(result);
			mapResponse.put("pageNumber", pageNumber);
			mapResponse.put("pageSize", query.getMaxResults());
			mapResponse.put("totalPages", totalPages);
		}
		
		mapResponse.put("totalRegistros", tatalRegistro);
		mapResponse.put("list", listaRetorno);
		return mapResponse;
	}
	
	public List<Map<String, Object>> genericSearch(String sql, Object[] parametros) throws InternalErrorException {
		List<Map<String,Object>> listaRetorno = new ArrayList<Map<String,Object>>();
		Query query;
		
		try {
			query = em.createNativeQuery(sql); 
			
			if(parametros != null) {
				for(int i = 0; i < parametros.length; i++){
					query.setParameter(i+1, parametros[i]);
				}
			}
			
			NativeQueryImpl<Map<String, Object>> nativeQuery = (NativeQueryImpl) query;
			nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			List<Map<String,Object>> results = nativeQuery.getResultList();
			
			for (int i = 0; i < results.size(); i++) {
				Map<String, Object> mapRow = results.get(i);
				LinkedHashMap<String,Object> reg = new LinkedHashMap<>();
				
				for (Map.Entry<String, Object> entry : mapRow.entrySet()) {
				    String prop = CambioDeCaracteres.CaracteresProp(entry.getKey());
					Object value = entry.getValue();
					reg.put(prop,value);
				}
				listaRetorno.add(reg);
			}
			
		}
		catch (ModelException e) {
			throw new InternalErrorException(e);
		}
		
		return listaRetorno;
	}
	
	public int getNumeroRegistros(String sql,Object[] parametros) throws InternalErrorException {
		Query query = em.createNativeQuery(sql);
		if(parametros != null) {
			for(int i = 0; i < parametros.length; i++){
				query.setParameter(i+1, parametros[i]);
			}
		}
		int count = ((BigInteger) query.getSingleResult()).intValue();
		return count;
	}

	public int getNumeroRegistros(String sql) throws InternalErrorException {
		Query query = em.createNativeQuery(sql);
		int count = ((BigInteger) query.getSingleResult()).intValue();
		return count;
	}
}
