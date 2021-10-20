package com.coop.infrastructure.repository.resources_view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coop.domain.exception.InternalErrorException;
import com.coop.infrastructure.utils.DBUtil;

@Component
public class ResourcesViewIpm implements IResourcesView{
	
	@Autowired
	private DBUtil dbUtil;
	
	@Override
	public List<Map<String, Object>> getList(String recurso) throws InternalErrorException {
		
		if("TipoIdentificacion".equalsIgnoreCase(recurso)){
			return dbUtil.genericSearch("SELECT * FROM TIPO_IDENTIFICACION", new Object[] {});
		}
		
		else if("Persona".equalsIgnoreCase(recurso)){
			return dbUtil.genericSearch("SELECT ID_PERSONA, CONCAT(`NOMBRES`, ' | ', `NUMERO_IDENTIFICACION`) AS NOMBRES FROM PERSONA ", new Object[] {});
		}
		
		else if("Perfil".equalsIgnoreCase(recurso)){
			return dbUtil.genericSearch("SELECT * FROM PERFIL WHERE NOMBRE_PERFIL <> 'ADMON'", new Object[] {});
		}
		
		else if("Activo".equalsIgnoreCase(recurso)){
			List<Map<String, Object>> listaCombo = new ArrayList<Map<String,Object>>();
			Map<String, Object> comboActivo = new HashMap<String, Object>();
			
			comboActivo.put("id","S");
			comboActivo.put("value","S");
			listaCombo.add(comboActivo);
			
			comboActivo = new HashMap<String, Object>(); 
			comboActivo.put("id","N");
			comboActivo.put("value","N");
			
			listaCombo.add(comboActivo);

			return listaCombo;
		}
		
		throw new InternalErrorException(new IllegalArgumentException("ERROR INTERNO (DEBE CREAR LA LISTA CON CÓDIGO' "+recurso+"' EN VistaHelper)"));
	}
}
