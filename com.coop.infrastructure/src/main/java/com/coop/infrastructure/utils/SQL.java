package com.coop.infrastructure.utils;

import java.util.ArrayList;
import java.util.List;

import com.coop.domain.exception.InternalErrorException;

public class SQL {
	private StringBuffer sbSelect = new StringBuffer();
	private StringBuffer sbFrom = new StringBuffer();
	private StringBuffer sbResto = new StringBuffer();
	private List<String> listaWhere = new ArrayList<String>();
	private List<String> listProperties = new ArrayList<String>();
	List<Object> listaParametros = new ArrayList<Object>();

	public void select(String sql) {
		if(sbSelect.length() == 0){
			sbSelect.append("SELECT " + sql);
		}
		else{
			sbSelect.append(" "+"," + sql);
		}
	} 
	
	public void from(String sql) {
		sbFrom.append(" "+sql);
	} 
	
	public void where(String sql){
		listaWhere.add(sql);
	}
	
	public void where(String sql, String parametro, @SuppressWarnings("rawtypes") Class tipo) throws InternalErrorException{
		if(!InputUtil.esVacio(parametro)){
			listaWhere.add(sql);
			String param = getOperator(sql, parametro);
			listaParametros.add(InputUtil.getValorTipoDato(tipo,param));
		}
	}
	
	private String getOperator(String sql, String parametro) {
		String param = parametro;
		if(sql.contains("LIKE")) {
			param = "%"+param+"%";
		}
		return param;
	}
	
	public void resto(String sql) {
		sbResto.append(" "+sql);
	}
	
	public String getSqlCount() {
		String where = getWhere();
		return "SELECT COUNT(1)" + " " + "FROM" + " " + sbFrom.toString() + " " +  where + " " + sbResto.toString();
	}
	
	public String toString(){
		String where = getWhere();
		return sbSelect.toString() + " " + "FROM" + " " + sbFrom.toString() + " " + where + " " + sbResto.toString();
	}
	
	public Object[] getParametros(){
		return listaParametros.toArray();
	}
	
	public List<String> getProperties(){
		return listProperties;
	}
	
	private String getWhere() {
		if(listaWhere.size()==0)
			return "";
		
		StringBuffer respuesta = new StringBuffer();
		for(int i = 0; i < listaWhere.size(); i++){
			
			String parte = listaWhere.get(i).trim();
			if(i==0){
				respuesta.append(" "+"WHERE "+parte);
			}
			else{
				respuesta.append(" "+"AND "+parte);
			}
		}
		return respuesta.toString();
	}
	
}
