package com.amsproject;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.Callable;

import com.ibm.mq.MQC;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;

public class QdepthHealth implements Callable<HashMap<String,List<QdepthCheck>>>{
	HashMap<String,List<QdepthCheck>> qhm = new HashMap<String,List<QdepthCheck>>();
	String qkey;
	public QdepthHealth(HashMap<String,List<QdepthCheck>> qhm,String qkey)
	{
		this.qhm= qhm;
		this.qkey = qkey;
	}

	public HashMap<String, List<QdepthCheck>> call() throws Exception {
		try
		{
			List<QdepthCheck> lis =null;
			lis = qhm.get(qkey);
			for (QdepthCheck item: lis)
			{
				   String qManager=item.getQueuemanager();
			       int port_num= item.getPort();
			       String hostname=item.getQhost();
			       String channel=item.getQueuechannel();
			       String qname=item.getQueuename();
			       
			       System.out.println("Connecting to queue manager: " + qManager);
		           Hashtable<String, Object> mqconn = new Hashtable<String, Object>();
		           mqconn.put(MQC.TRANSPORT_PROPERTY, MQC.TRANSPORT_MQSERIES_CLIENT);
		       		mqconn.put(MQC.HOST_NAME_PROPERTY, hostname);
		       		mqconn.put(MQC.CHANNEL_PROPERTY, channel);
		       		mqconn.put(MQC.PORT_PROPERTY, port_num);
		       		
		       		MQQueueManager qMgr = new MQQueueManager(qManager, mqconn);
		            if(qMgr != null)
					{
		            	MQQueue q3 = qMgr.accessQueue(qname,MQC.MQOO_INPUT_AS_Q_DEF | MQC.MQOO_OUTPUT | MQC.MQOO_INQUIRE);
						if(q3 != null)
						{	
							System.out.println("Entered This loop");
							MQQueue a = qMgr.accessQueue(q3.getResolvedQName(),MQC.MQOO_INPUT_AS_Q_DEF | MQC.MQOO_OUTPUT | MQC.MQOO_INQUIRE);
							System.out.println("some value"+a.getCurrentDepth());
							item.setQdepth(a.getCurrentDepth());
							
						}
						
					}

			}
			
			
			return qhm;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	

}
