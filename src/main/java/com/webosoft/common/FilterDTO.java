package com.webosoft.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FilterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6182364135836099833L;

	private int page = -1;
	private int pageSize = -1;
	private Map<String, Object> extraParameter = new HashMap<String, Object>();
	private Map<String, Object> search = new HashMap<String, Object>();
	private Map<String, String> sort = new LinkedHashMap<String, String>();
	private List<String> fields = new ArrayList<String>();

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Map<String, Object> getExtraParameter() {
		return extraParameter;
	}

	public void setExtraParameter(Map<String, Object> extraParameter) {
		this.extraParameter = extraParameter;
	}

	public Map<String, Object> getSearch() {
		return search;
	}

	public void setSearch(Map<String, Object> search) {
		this.search = search;
	}

	public Map<String, String> getSort() {
		return sort;
	}

	public void setSort(Map<String, String> sort) {
		this.sort = sort;
	}

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}

}
