package com.webosoft.notification;

import java.util.ArrayList;
import java.util.List;

public class EmailDTO {
	private String subject;
	private String body;
	private List<String> to = new ArrayList<String>();
	private List<String> cc = new ArrayList<String>();

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<String> getTo() {
		return to;
	}

	public void setTo(List<String> to) {
		this.to = to;
	}

	public List<String> getCc() {
		return cc;
	}

	public void setCc(List<String> cc) {
		this.cc = cc;
	}
}
