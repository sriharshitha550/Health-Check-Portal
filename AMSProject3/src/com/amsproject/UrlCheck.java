package com.amsproject;

public class UrlCheck {

	private String url;
	private String ustatus;
	private String Component;
	private String uregion;
	private String Appname;
	public String getAppname() {
		return Appname;
	}
	public void setAppname(String appname) {
		Appname = appname;
	}
	public String getUregion() {
		return uregion;
	}
	public void setUregion(String uregion) {
		this.uregion = uregion;
	}
	public String getComponent() {
		return Component;
	}
	public void setComponent(String component) {
		Component = component;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUstatus() {
		return ustatus;
	}
	public void setUstatus(String ustatus) {
		this.ustatus = ustatus;
	}
}
