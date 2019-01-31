package com.amsproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

@WebServlet("/HealthReport")
public class HealthReport extends HttpServlet{

	private static final long serialVersionUID = 1L;
	HashMap<String,List<ServiceStatusVo>> hm=null;
	HashMap<String,List<UrlCheck>> uhm = null;
	HashMap<String,List<QdepthCheck>> qhm = null;
	private static  String usernm = null;
	private static String pas=null;
	private static String Mifile = null;
	private static int gcount=0;
	private static int rcount = 0;
	private static int ugcount=0;
	private static int urcount = 0;
	private static int mgcount=0;
	private static int mrcount = 0;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String submitType = request.getParameter("Submit");
		if(submitType != null)
		{
		session.setAttribute("submitt",submitType);
		}
		String s= (String)session.getAttribute("submitt");
		 int n1=0;
		 int qn1=0;
		String fname="sernames";
		if(s.equalsIgnoreCase("Submit"))
		{
			System.out.print("Entered");
			if(null == session.getAttribute("username"))
			{
			String dom = request.getParameter("dom");
			String user = request.getParameter("user");
			pas = request.getParameter("pass");
			usernm = dom+"\\"+user;
			}
			else
			{
				pas = (String)session.getAttribute("password");
				usernm = (String)session.getAttribute("username");
			}
			List<String> list =   (List<String>)session.getAttribute("appl");
			//z request.setAttribute("applcount",Integer.toString(list.size()));
			String[] array = new String[list.size()];
			int index = 0;
			for (Object value : list) {
			  array[index] = (String) value;
			  index++;
			}
				
			File fXmlFile;
			File ufxmlFile;
			File qfxmlFile;
			hm = new HashMap<String,List<ServiceStatusVo>>();
			uhm = new HashMap<String,List<UrlCheck>>();
			qhm = new HashMap<String,List<QdepthCheck>>();
			//System.out.print("Appliaction size"+list.size());
			for(int i=0;i<list.size();i++)
			{
					String x2=Integer.toString(i);	
					try {
						Mifile = array[i]+"_Services.xml";
						fXmlFile = new File("C:\\Users\\Sri_harshitha_Muttav\\Desktop\\AMS\\"+array[i]+"_Services.xml");
						DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
						DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
						Document doc = dBuilder.parse(fXmlFile);	
						
						doc.getDocumentElement().normalize();	
						NodeList nList = doc.getElementsByTagName("TASK");//change Hardcode value
						/* */
						for (int temp = 0; temp < nList.getLength(); temp++) {
							n1++;
			    			int n2 = n1;
			    			String fname2=fname+ Integer.toString(n2);
							Node nNode = nList.item(temp);			
							if (nNode.getNodeType() == Node.ELEMENT_NODE) {
								Element eElement = (Element) nNode;
								//request.setAttribute(x2+fname2+"server",eElement.getElementsByTagName("Server").item(0).getTextContent());
								//request.setAttribute(fname2+"count",eElement.getElementsByTagName("service").getLength());
								int x1 = eElement.getElementsByTagName("service").getLength();
								request.setAttribute(x2+fname2+"count",x1);
								int num =0;
								for(int temp1=0;temp1<eElement.getElementsByTagName("service").getLength();temp1++)
								{
									num++;
									String x=Integer.toString(num);
								String sname =eElement.getElementsByTagName("service").item(temp1).getAttributes().getNamedItem("name").getNodeValue();
								String host = eElement.getElementsByTagName("service").item(temp1).getAttributes().getNamedItem("host").getNodeValue();
								String estat = eElement.getElementsByTagName("service").item(temp1).getAttributes().getNamedItem("expectedstatus").getNodeValue();
								String region = eElement.getElementsByTagName("service").item(temp1).getAttributes().getNamedItem("Region").getNodeValue();
								System.out.println(sname);
								ServiceStatusVo vo =new ServiceStatusVo();
								vo.setService(sname);
								vo.setExstatus(estat);
								vo.setAppl(array[i]);
								vo.setRegion(region);
								List<ServiceStatusVo> ssv = new ArrayList<ServiceStatusVo>(); 
								ssv.add(vo);
								List<ServiceStatusVo> previousValue = hm.get(host);
								//out.print(previousValue);
								if(previousValue != null) 
								{
									previousValue.add(vo);
									hm.put(host,previousValue);
									
								}
								else
									hm.put(host,ssv);
								
								}//temp1 for loop(Nbr of services)
							}//if loop
						}//temp for loop
						String urlkey= null;
						Mifile=array[i]+"_URLs.xml";
						ufxmlFile = new File("C:\\Users\\Sri_harshitha_Muttav\\Desktop\\AMS\\"+array[i]+"_URLs.xml");
						DocumentBuilderFactory udbFactory = DocumentBuilderFactory.newInstance();
						DocumentBuilder udBuilder = udbFactory.newDocumentBuilder();
						Document udoc = udBuilder.parse(ufxmlFile);
						udoc.getDocumentElement().normalize();	
						NodeList unList = udoc.getElementsByTagName("URL");
						for(int utemp=0;utemp<unList.getLength();utemp++)
						{
							Node unNode = unList.item(utemp);			
							if (unNode.getNodeType() == Node.ELEMENT_NODE) {
								Element eElement = (Element) unNode;
								String url = eElement.getTextContent();
								String Component =eElement.getAttributes().getNamedItem("Component").getNodeValue();
								String uregion = eElement.getAttributes().getNamedItem("Region").getNodeValue();
								System.out.println("Component:"+Component);
								UrlCheck u = new UrlCheck();
								u.setUrl(url);
								u.setComponent(Component);
								u.setUregion(uregion);
								u.setAppname(array[i]);
								List<UrlCheck> ul = new ArrayList<UrlCheck>(); 
								ul.add(u);
								urlkey = array[i]+uregion;
								List<UrlCheck> previousValue = uhm.get(urlkey);
								//out.print(previousValue);
								if(previousValue != null) 
								{
									previousValue.add(u);
									uhm.put(urlkey,previousValue);
									
								}
								else
									uhm.put(urlkey,ul);
								
							}

						}//utemp for loop
						Mifile=array[i]+"_MQs.xml";
						qfxmlFile = new File("C:\\Users\\Sri_harshitha_Muttav\\Desktop\\AMS\\"+array[i]+"_MQs.xml");
						DocumentBuilderFactory qdbFactory = DocumentBuilderFactory.newInstance();
						DocumentBuilder qdBuilder = qdbFactory.newDocumentBuilder();
						Document qdoc = qdBuilder.parse(qfxmlFile);
						qdoc.getDocumentElement().normalize();	
						NodeList qnList = qdoc.getElementsByTagName("TASK");
						
						for (int qtemp = 0; qtemp < qnList.getLength(); qtemp++) {
							System.out.println("Entered 3");
							Node qnNode = qnList.item(qtemp);			
							if (qnNode.getNodeType() == Node.ELEMENT_NODE) {
								Element eElement = (Element) qnNode;
								for(int qtemp1=0;qtemp1<eElement.getElementsByTagName("MQ").getLength();qtemp1++)
								{
								String threshold =eElement.getElementsByTagName("MQ").item(qtemp1).getAttributes().getNamedItem("threshold").getNodeValue();
								String queuename = eElement.getElementsByTagName("MQ").item(qtemp1).getAttributes().getNamedItem("queuename").getNodeValue();
								String port = eElement.getElementsByTagName("MQ").item(qtemp1).getAttributes().getNamedItem("port").getNodeValue();
								String queuechannel = eElement.getElementsByTagName("MQ").item(qtemp1).getAttributes().getNamedItem("queuechannel").getNodeValue();
								String queuemanager = eElement.getElementsByTagName("MQ").item(qtemp1).getAttributes().getNamedItem("queuemanager").getNodeValue();
								String host = eElement.getElementsByTagName("MQ").item(qtemp1).getAttributes().getNamedItem("host").getNodeValue();
								String qregion = eElement.getElementsByTagName("MQ").item(qtemp1).getAttributes().getNamedItem("Region").getNodeValue();
								QdepthCheck q = new QdepthCheck();
								q.setThreshold(Integer.parseInt(threshold));
								System.out.println("threshold:"+threshold);
								System.out.println(queuename);
								q.setQueuename(queuename);
								q.setPort(Integer.parseInt(port));
								System.out.println("Port:"+port);
								q.setQueuechannel(queuechannel);
								q.setQueuemanager(queuemanager);
								q.setQhost(host);
								q.setQregion(qregion);
								List<QdepthCheck> qc = new ArrayList<QdepthCheck>(); 
								qc.add(q);
								List<QdepthCheck> previousValue = qhm.get(array[i]);
								//out.print(previousValue);
								if(previousValue != null) 
								{
									previousValue.add(q);
									qhm.put(array[i],previousValue);
									
								}
								else
									qhm.put(array[i],qc);

								}
							}
							
						}
						
					}catch(Exception e)
					{
						System.out.println(Mifile+" file is not found");	
					}
			} // i for loop(Nbr of applications)
			ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(hm.size());
			List<Future<HashMap<String,List<ServiceStatusVo>>>> res = new ArrayList();
	        Set<String> keys = hm.keySet();
			for(String key: keys){
			System.out.println(key);
	        Windowser w = new Windowser(hm,usernm,pas,key);
	        Future<HashMap<String,List<ServiceStatusVo>>> result = executor.submit(w);
	        w = null;
	        res.add(result);
			}
			for(Future<HashMap<String,List<ServiceStatusVo>>> future:res)
			{
				try{
					if(future.get() == null)
					{
						request.setAttribute("error","With the given credentials not able to access server, Please check Credentials...!");
						RequestDispatcher rd=request.getRequestDispatcher("Healthchecklogin.jsp");
	        	    	rd.forward(request, response);								}
					//System.out.println("Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
					while(!(future.isDone()))
					{
						
					}
				
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
				
			}//for loop	
			
			if(null == session.getAttribute("username"))
			{
			session.setAttribute("username",usernm);
			session.setAttribute("password",pas);
			}
			Set<String> keys1 = hm.keySet();
			String[] array1 = new String[keys1.size()];
			int temp=0;
			gcount=0;
			rcount=0;
			for(String key1:keys1)
			{
				array1[temp]=key1;
				temp++;
				List<ServiceStatusVo> lis =null;
    			lis = hm.get(key1);
    			request.setAttribute(key1+"count",lis.size());
    			int i=0;
    			for (ServiceStatusVo item: lis)
    			{
    				i++;
    				String x =Integer.toString(i);
    				request.setAttribute(key1+x+"Appl",item.getAppl());
    				request.setAttribute(key1+x+"Service",item.getService());
    				request.setAttribute(key1+x+"Astatus",item.getAstatus());
    				request.setAttribute(key1+x+"Exstatus",item.getExstatus());
    				if(((String)request.getAttribute(key1+x+"Exstatus")).equals(((String)request.getAttribute(key1+x+"Astatus"))))
    					gcount++;
    				else
    					rcount++;
    				request.setAttribute(key1+x+"Region",item.getRegion());
    				
    			}

			}
			request.setAttribute("keys",array1);
			request.setAttribute("gcount",gcount);
			request.setAttribute("rcount",rcount);
			
			
			executor.shutdown();
			ThreadPoolExecutor uexecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(uhm.size());
			List<Future<HashMap<String,List<UrlCheck>>>> ures = new ArrayList();
			Set<String> ukeys =uhm.keySet();
			ugcount=0;
			urcount=0;
			for(String key:ukeys) {
				System.out.println(key);
				UrlHealth uo = new UrlHealth(uhm,key);
				Future<HashMap<String,List<UrlCheck>>> uresult =uexecutor.submit(uo);
				uo=null;
				ures.add(uresult);
			}
			for(Future<HashMap<String,List<UrlCheck>>> future:ures)
			{
				try
				{
					while(!(future.isDone()))
					{
						
					}
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
			}
			
			Set<String> ukeys1 = uhm.keySet();
			String[] uarray1 = new String[ukeys1.size()];
			int utemp=0;
			mgcount=0;
			mrcount=0;
			for(String ukey1:ukeys1)
			{
				uarray1[utemp]=ukey1;
				utemp++;
				List<UrlCheck> lis =null;
    			lis = uhm.get(ukey1);
    			request.setAttribute(ukey1+"count",lis.size());
    			int i=0;
    			for (UrlCheck item: lis)
    			{
    				i++;
    				String x =Integer.toString(i);
    				request.setAttribute(ukey1+x+"Url",item.getUrl());
    				request.setAttribute(ukey1+x+"uregion",item.getUregion());
    				request.setAttribute(ukey1+x+"component",item.getComponent());
    				request.setAttribute(ukey1+x+"Status",item.getUstatus());
    				request.setAttribute(ukey1+x+"Appname", item.getAppname());
    				if(request.getAttribute(ukey1+x+"Status").equals("Up"))
    					ugcount++;
    				else
    					urcount++;
    			}
			}
			request.setAttribute("ukeys",uarray1);
			request.setAttribute("ugcount",ugcount);
			request.setAttribute("urcount",urcount);
			uexecutor.shutdown();
			ThreadPoolExecutor qexecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(qhm.size());
			List<Future<HashMap<String,List<QdepthCheck>>>> qres = new ArrayList();
			Set<String> qkeys =qhm.keySet();
			for(String key:qkeys) {
				System.out.println(key);
				QdepthHealth qo = new QdepthHealth(qhm,key);
				Future<HashMap<String, List<QdepthCheck>>> qresult =qexecutor.submit(qo);
				qo=null;
				qres.add(qresult);
			}
			for(Future<HashMap<String,List<QdepthCheck>>> future:qres)
			{
				try
				{
					while(!(future.isDone()))
					{
						
					}
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
			}
			
			Set<String> qkeys1 = qhm.keySet();
			String[] qarray1 = new String[qkeys1.size()];
			int qtemp=0;
			for(String qkey1:qkeys1)
			{
				qarray1[qtemp]=qkey1;
				qtemp++;
				List<QdepthCheck> lis =null;
    			lis = qhm.get(qkey1);
    			request.setAttribute(qkey1+"countq",lis.size());
    			int i=0;
    			for (QdepthCheck item: lis)
    			{
    				i++;
    				String x =Integer.toString(i);
    				
    				request.setAttribute(qkey1+x+"qhost",item.getQhost());
    				request.setAttribute(qkey1+x+"qmanager",item.getQueuemanager());
    				request.setAttribute(qkey1+x+"qchannel",item.getQueuechannel());
    				request.setAttribute(qkey1+x+"qport",item.getPort());
    				request.setAttribute(qkey1+x+"qname",item.getQueuename());
    				request.setAttribute(qkey1+x+"threshold",item.getThreshold());
    				request.setAttribute(qkey1+x+"Qdepth",item.getQdepth());
    				request.setAttribute(qkey1+x+"qregion",item.getQregion());
    				int iithold = (int)request.getAttribute(qkey1+x+"threshold");
    				int iiqdepth =(int)request.getAttribute(qkey1+x+"Qdepth");
    				if(iiqdepth < iithold)
    					mgcount++;
    				else
    					mrcount++;
    				

    					
    					
    			}
			}
			request.setAttribute("qkeys",qarray1);
			request.setAttribute("mgcount",mgcount);
			request.setAttribute("mrcount",mrcount);
			qexecutor.shutdown();
			
			RequestDispatcher rd1=request.getRequestDispatcher("Status.jsp");
			rd1.forward(request, response);	
		}//if loop
	}// do post method loop
}//class loop
