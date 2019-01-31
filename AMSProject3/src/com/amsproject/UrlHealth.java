package com.amsproject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

public class UrlHealth implements Callable<HashMap<String,List<UrlCheck>>>{
	HashMap<String,List<UrlCheck>> uhm = new HashMap<String,List<UrlCheck>>();
	String ukey;
	public UrlHealth(HashMap<String,List<UrlCheck>> uhm,String ukey)
	{
		this.uhm = uhm;
		this.ukey = ukey;
		
	}
	
	public HashMap<String, List<UrlCheck>> call() throws Exception {
		try
		{
			List<UrlCheck> lis =null;
			lis = uhm.get(ukey);
			for (UrlCheck item: lis)
			{
			int cod = getResponseCode(item.getUrl());
			if(cod == 200)
				item.setUstatus("Up");
			else if(cod == 302)
				item.setUstatus("Up");
			else
				item.setUstatus("Down");
			}
		return uhm;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static int getResponseCode(String urlString) throws MalformedURLException, IOException {
	    URL u = new URL(urlString); 
	    HttpURLConnection huc =  (HttpURLConnection)  u.openConnection(); 
	    huc.setRequestMethod("GET"); 
	    huc.connect(); 
	    return huc.getResponseCode();
	}
	

}
