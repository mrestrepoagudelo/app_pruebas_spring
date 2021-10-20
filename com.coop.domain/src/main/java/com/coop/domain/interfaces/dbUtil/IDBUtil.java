package com.coop.domain.interfaces.dbUtil;

import java.util.List;
import java.util.Map;

import com.coop.domain.exception.InternalErrorException;

public interface IDBUtil {
	List<Map<String, Object>> genericSearch(String sql, Object[] parametros) throws InternalErrorException;
}
