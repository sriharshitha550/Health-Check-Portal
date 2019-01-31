package com.amsproject;

public class QdepthCheck {
	private int threshold;
	private String queuename;
	private int port;
	private String queuechannel;
	private String queuemanager;
	private String qhost;
	private int Qdepth;
	private String qregion;
	public String getQregion() {
		return qregion;
	}
	public void setQregion(String qregion) {
		this.qregion = qregion;
	}
	public int getQdepth() {
		return Qdepth;
	}
	public void setQdepth(int qdepth) {
		Qdepth = qdepth;
	}
	public int getThreshold() {
		return threshold;
	}
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	public String getQueuename() {
		return queuename;
	}
	public void setQueuename(String queuename) {
		this.queuename = queuename;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getQueuechannel() {
		return queuechannel;
	}
	public void setQueuechannel(String queuechannel) {
		this.queuechannel = queuechannel;
	}
	public String getQueuemanager() {
		return queuemanager;
	}
	public void setQueuemanager(String queuemanager) {
		this.queuemanager = queuemanager;
	}
	public String getQhost() {
		return qhost;
	}
	public void setQhost(String qhost) {
		this.qhost = qhost;
	}
	
	

}
