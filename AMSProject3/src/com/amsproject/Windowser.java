package com.amsproject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public class Windowser implements Callable<HashMap<String,List<ServiceStatusVo>>>{
	HashMap<String,List<ServiceStatusVo>> hm = new HashMap<String,List<ServiceStatusVo>>();
	String usernm;
	String pas;
	String key;
	public Windowser(HashMap<String,List<ServiceStatusVo>> hm,String usernm,String pas,String key) {
		this.hm = hm;
		this.usernm=usernm;
		this.pas=pas;
		this.key = key;
	}

	public HashMap<String, List<ServiceStatusVo>> call() throws Exception {
		try
		{
		//Set<String> keys = hm.keySet();
		//for(String key: keys){
			System.out.println("Key Value"+key);
			Runtime.getRuntime().exec("net use \\\\"+key+" /delete");
			Process p2=Runtime.getRuntime().exec("Net Use \\\\"+key+" "+pas+" /User:"+usernm);
			InputStream is2 = p2.getInputStream();
		    InputStreamReader isr2 = new InputStreamReader(is2);
		    BufferedReader br2 = new BufferedReader(isr2);

		    String line2;
		    String scOutput2 = "";

		    // Append the buffer lines into one string
		    while ((line2 = br2.readLine()) != null) {
		        scOutput2 +=  line2 + "\n" ;
		        System.out.println("command line statement"+line2);
		    }
		    
		    //System.out.println(scOutput2);
		    if ((scOutput2.contains("The command completed successfully")))
		    {
		    	/*List<ServiceStatusVo> lis =null;
		    			lis = hm.get(key);
		    	for (ServiceStatusVo item: lis) {
		    		System.out.println(lis.size());
				   	System.out.println("From hm"+item.getService());
				    //System.out.println(item.getStatus());*/
					Process p=Runtime.getRuntime().exec("sc \\\\"+key+" query state=all");
					InputStream is = p.getInputStream();
	        	    InputStreamReader isr = new InputStreamReader(is);
	        	    BufferedReader br = new BufferedReader(isr);

	        	    String line;
	        	    String output;
	        	    String scOutput = "";

	        	    List<ServiceStatusVo> lis =null;
	    			lis = hm.get(key);
	    			for (ServiceStatusVo item: lis)
	    			{
	    				item.setAstatus("Unknown Service");
	    			}
	        	    // Append the buffer lines into one string
	        	    while ((line = br.readLine()) != null) {
	        	        scOutput +=  line + "\n" ;
		    			for (ServiceStatusVo item: lis)
		    			{
		    				if(line.contains(item.getService()))
		    				{
		    					//System.out.println(line);
		    					int i=0;
		    					for(i=0;i<3;i++)
		    					{
		    						line=br.readLine();
		    						scOutput+=line+"\n";
		    						if(i==2 && line.contains("STATE"))
		    						{
		    							//System.out.println("There"+line);
		    							if (line.contains("RUNNING"))
		    							{
		    		        	            item.setAstatus("RUNNING");  
		    							}
		    							else
		    							{
		    								item.setAstatus("STOPPED");  	
		    							}
		    						}
		    					}//i for loop
		    				}//if 
	        	        	
	        	        }//item for loop
	        	    }//while loop
	        	    if(!(scOutput.contains("STATE")))
	        	    {
	        	    	for (ServiceStatusVo item: lis)
		    			{
		    				item.setAstatus("Not Connected");
		    			}
	        	    	
	        	    }
	        	    Runtime.getRuntime().exec("net use \\\\"+key+" /delete");
	        	    return hm;
		    	}/*     
					
	        	    // Append the buffer lines into one string
	        	    while ((line1 = br1.readLine()) != null) {
	        	        scOutput1 +=  line1 + "\n" ;
	        	    }

	        	    if (scOutput1.contains("START_TYPE")) {
	        	        if (scOutput1.contains("DISABLED")) {
	        	            output1 = "DISABLED";
	        	        } else if(scOutput1.contains("DEMAND_START")){
	        	            output1="DEMAND_START";
	        	        }else{
	        	        	output1="AUTO_START";
	        	        }
	        	    } else {
	        	        output1="Unknown Service";
	        	    }
	        	   // request.setAttribute(x2+fname2+"stype"+x,output1);
	        	    item.setStarttype("from call method"+output1);
	        	   System.out.println(item.getStarttype());
				 
			 }//for loop inside run
		    }*/
		    else
		    {
		    	return null;
		    }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	}

	


