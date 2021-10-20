package com.coop.infrastructure.repository.resources_view;

import java.util.List;
import java.util.Map;

public interface IResourcesView{
	public List<Map<String, Object>> getList(String recurso);
}
