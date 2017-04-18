package com.webosoft.common;

import java.io.Serializable;

import com.mongodb.BasicDBObject;

public class ServiceResponse implements Serializable {

	private static final long serialVersionUID = 2605943725016101351L;

	private Object data;
	private String status;
	private String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ServiceResponse [data=" + data + ", status=" + status + "]";
	}

}
