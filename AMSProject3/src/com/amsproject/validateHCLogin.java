package com.amsproject;

import java.io.*;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

@WebServlet("/validateHCLogin")
public class validateHCLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String Mfile=null;  
    public validateHCLogin() {
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String submitType = request.getParameter("HEALTH CHECKUP");
		String dname="domname";
		String aname = "applname";
		int n1 = 0;
		int n11=0;
		PrintWriter out = response.getWriter();
		//if(submitType.equalsIgnoreCase("HEALTH CHECKUP"))
		//{
		try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Mfile="Domains";
            Document doc = docBuilder.parse (new File("C:\\Users\\Sri_harshitha_Muttav\\Desktop\\AMS\\Domains.xml"));
            // normalize text representation
            doc.getDocumentElement ().normalize ();
            NodeList domainslist = doc.getElementsByTagName("Domain");
            int domcount = domainslist.getLength();
            request.setAttribute("domncount",Integer.toString(domcount));
            for(int temp=0; temp<domainslist.getLength() ; temp++){
            	n1++;
    			int n2 = n1;
    			String dname2=dname+ Integer.toString(n2);
                Node domNode = domainslist.item(temp);
                if(domNode.getNodeType() == Node.ELEMENT_NODE){
                    Element domele = (Element)domNode;
                    request.setAttribute(dname2,domele.getElementsByTagName("Name").item(0).getTextContent()); 
                    Mfile=domele.getElementsByTagName("Name").item(0).getTextContent();
                    Document doc1 = docBuilder.parse (new File("C:\\Users\\Sri_harshitha_Muttav\\Desktop\\AMS\\"+domele.getElementsByTagName("Name").item(0).getTextContent()+".xml"));
                    doc1.getDocumentElement ().normalize ();
                    NodeList applslist = doc1.getElementsByTagName("Application");
                    int applcount = applslist.getLength();
                    request.setAttribute(dname2+"applcount",Integer.toString(applcount));
                    n11=0;
                    for(int temp1=0; temp1<applslist.getLength(); temp1++){
                    	n11++;
                    	int n3 = n11;
                    	String aname2=aname+ Integer.toString(n3);
                    	Node applNode = applslist.item(temp1);
                    	if(applNode.getNodeType() == Node.ELEMENT_NODE){
                    		Element applele = (Element)applNode;
                    		request.setAttribute(dname2+aname2,applele.getElementsByTagName("Description").item(0).getTextContent());
                    	}// end of if loop
                    	
                    }// end of loop of temp1 variable
                }//end of if clause
            }//end of for loop of temp variable
            
           RequestDispatcher rd1 = request.getRequestDispatcher("HealthCheckReport.jsp");
    	   rd1.forward(request, response);

        }catch (SAXParseException err) {
        out.println ("** Parsing error" + ", line " 
             + err.getLineNumber () + ", uri " + err.getSystemId ());
        out.println(" " + err.getMessage ());

        }catch (SAXException e) {
        Exception x = e.getException ();
        ((x == null) ? e : x).printStackTrace ();

        }catch (Throwable t) {
        	t.printStackTrace ();
        	out.print(Mfile+" file doesn't exists");
        }
		
		
		//}
		
		
		
	}

}
