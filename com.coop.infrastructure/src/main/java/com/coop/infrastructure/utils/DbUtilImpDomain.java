package com.coop.infrastructure.utils;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.coop.domain.exception.InternalErrorException;
import com.coop.domain.interfaces.dbUtil.IDBUtil;

public class DbUtilImpDomain implements IDBUtil{
	
	@Autowired
	private IDBUtil dbUtil;
	
	@Override
	public List<Map<String, Object>> genericSearch(String sql, Object[] parametros) throws InternalErrorException {
		return dbUtil.genericSearch(sql, parametros);
	}

}
