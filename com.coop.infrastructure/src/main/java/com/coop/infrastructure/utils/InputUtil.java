package com.coop.infrastructure.utils;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.coop.domain.exception.InternalErrorException;
import com.coop.domain.exception.ModelException;

public class InputUtil {

	public static String getStringOVacio(String sTmp) {
		if(sTmp==null)
			return "";
		return sTmp.toString();
	}
	
	public static String getStringONull(String sTmp) {
		if(sTmp==null||sTmp.trim().length()==0)
			return null;
		return sTmp.trim();
	}

	public static boolean esVacio(String sTmp) {
		return sTmp==null||sTmp.trim().length()==0;
	}

	public static String getStringMerge(String nuevo,String actual) throws InternalErrorException {
		if(!InputUtil.esVacio(nuevo)){
			return "null".equalsIgnoreCase(nuevo)?null:nuevo;
		}
		return actual;
	}

	public static Date getDateMerge(String nuevo,Date actual) throws InternalErrorException {
		if(!InputUtil.esVacio(nuevo)){
			return "null".equalsIgnoreCase(nuevo)?null:InputUtil.getDate(nuevo);
		}
		return actual;
	}
	
	public static Date getDate(String sTmp) throws InternalErrorException {
		if(esVacio(sTmp)) return null;
		try {
			String dateFormat = "yyyy-MM-dd";
			return new java.sql.Date(new SimpleDateFormat(dateFormat).parse(sTmp).getTime());
		} catch (ParseException e) {
			throw new InternalErrorException(e);
		}
	}
	
	public static Timestamp getTimestampMerge(String nuevo,Timestamp actual) throws InternalErrorException {
		if(!InputUtil.esVacio(nuevo)){
			return "null".equalsIgnoreCase(nuevo)?null:InputUtil.getTimestamp(nuevo);
		}
		return actual;
	}
	public static Timestamp getTimestamp(String sTmp) throws InternalErrorException {
		if(esVacio(sTmp))return null;
		try {
			if(sTmp.indexOf(" ")<0) {
				sTmp += " 00:00:00";
			}
			String dateFormat = "yyyy-MM-dd HH:mm:ss";
			return new java.sql.Timestamp(new SimpleDateFormat(dateFormat).parse(sTmp).getTime());
		} catch (ParseException e) {
			throw new InternalErrorException(e);
		}
	}

	public static Long getLong(String sTmp) {
		return (sTmp==null || sTmp.length()==0)?null:new Long(sTmp.trim());
	}
	
	public static Long getLongMerge(String nuevo,Long actual) {
		if(!InputUtil.esVacio(nuevo)){
			return "null".equalsIgnoreCase(nuevo)?null:InputUtil.getLong(nuevo);
		}
		return actual;
	}

	public static Long getLong(String sTmp,boolean obligatorio) throws ModelException {
		if (sTmp==null || sTmp.length()==0)
			throw new ModelException("Atributo obligatorio");
		else
			return new Long(sTmp.trim());
	}

	public static Integer getInteger(String sTmp) {
		return (sTmp==null || sTmp.length()==0)?null:new Integer(sTmp.trim());
	}
	
	public static Integer getIntegerMerge(String nuevo,Integer actual) {
		if(!InputUtil.esVacio(nuevo)){
			return "null".equalsIgnoreCase(nuevo)?null:InputUtil.getInteger(nuevo);
		}
		return actual;
	}

	public static BigDecimal getBigDecimal(String sTmp) {
		return (sTmp==null || sTmp.trim().length()==0)?null:new BigDecimal(sTmp.trim());
	}
	
	public static BigDecimal getBigDecimalMerge(String nuevo,BigDecimal actual) {
		if(!InputUtil.esVacio(nuevo)){
			return "null".equalsIgnoreCase(nuevo)?null:InputUtil.getBigDecimal(nuevo);
		}
		return actual;
	}
	
	public static String getSiNo(String value) {
		return "S".equalsIgnoreCase(value)?"S":"N";
	}

	public static Object getValorTipoDato(Class tipoDato,String valor) throws InternalErrorException {
		
		if(tipoDato.equals(BigDecimal.class)){
			return getBigDecimal(valor);
		}
		else if(tipoDato.equals(String.class)){
			return getStringONull(valor);
		}
		else if(tipoDato.equals(Integer.class)){
			return getInteger(valor);
		}
		else if(tipoDato.equals(Long.class)){
			return getLong(valor);
		}
		else if(tipoDato.equals(java.sql.Date.class)){
			return getDate(valor);
		}
		else if(tipoDato.equals(Timestamp.class)){
			return getTimestamp(valor);
		}
		throw new InternalErrorException(new IllegalArgumentException("Tipo de dato no reconocido "+tipoDato+""));
	}

}
