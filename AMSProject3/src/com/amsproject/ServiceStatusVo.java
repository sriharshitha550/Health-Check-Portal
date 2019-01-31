package com.amsproject;

public class ServiceStatusVo {
private String appl;
private String service;
private String exstatus;
private String astatus;
private String Starttype;
private String Region;


public String getRegion() {
	return Region;
}
public void setRegion(String region) {
	Region = region;
}
public String getAppl() {
	return appl;
}
public void setAppl(String appl) {
	this.appl = appl;
}
public String getStarttype() {
	return Starttype;
}
public void setStarttype(String starttype) {
	Starttype = starttype;
}
public String getExstatus() {
	return exstatus;
}
public void setExstatus(String exstatus) {
	this.exstatus = exstatus;
}
public String getAstatus() {
	return astatus;
}
public void setAstatus(String astatus) {
	this.astatus = astatus;
}
public String getService() {
	return service;
}
public void setService(String service) {
	this.service = service;
}
}
