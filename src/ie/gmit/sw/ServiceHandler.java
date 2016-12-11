package ie.gmit.sw;

import java.io.*;
import java.rmi.Naming;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServiceHandler extends HttpServlet {
	
	private static final long serialVersionUID = 777L;
	
	private String remoteHost = null;
	private static long jobNumber = 0;
	
	//declare the inQueue which is a LinkedList
	private LinkedList<CreateObject> inQueue = new LinkedList<CreateObject>();
	
	//declare the outQueue which is a map containing jobNumber and resultator
	private Map<String, Resultator> outQueue = new ConcurrentHashMap<String, Resultator>();

	public void init() throws ServletException {
		ServletContext ctx = getServletContext();
		remoteHost = ctx.getInitParameter("RMI_SERVER"); //Reads the value from the <context-param> in web.xml
		random(); //call random num generator for jobNumber
	}
	
	//generate a random number for the jobNumber
	public void random(){
		 Random generator = new Random();
		 jobNumber = generator.nextInt(34567890) + 10000; //set lowest of 10000
		 //System.out.println(jobNumber);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		 boolean isProcessed = false;
		
		//Initialise some request variables with the submitted form info. These are local to this method and thread safe...
		String algorithm = req.getParameter("cmbAlgorithm");
		String s = req.getParameter("txtS");
		String t = req.getParameter("txtT");
		String taskNumber = req.getParameter("frmTaskNumber");


		out.print("<html><head><title>Distributed Systems Assignment</title>");		
		out.print("</head>");		
		out.print("<body>");
		
		if (taskNumber == null){
			taskNumber = new String("T" + jobNumber);
			jobNumber++;
			
			//create an object to add to the linked list
			CreateObject obj = new CreateObject();
			 
			//set each variable
			obj.setAlgorithm(algorithm);
			obj.setTaskNumber(taskNumber);
			obj.setS(s);
			obj.setT(t);
			
			StringServiceImpl ss = new StringServiceImpl();
			
			//Add job to in-queue
			inQueue.add(obj);
			//print out inQueue to show object id
			System.out.println(inQueue);
			
			//new instance of resultator
			Resultator result = new ResultatorImpl();
			//add the tasknumber and Resultator to the map(outQueue)
			outQueue.put(taskNumber, result);
		}else{
			//Check out-queue for finished job
			Resultator result = outQueue.get(taskNumber);
			
			//check if the task is complete
			if(result != null && result.isProcessed() && result.getResult() != null){
				//output the result to the user
				System.out.println(result.getResult());
				//remove the task from the map when it is complete
				outQueue.remove(taskNumber);
			}
		}
		
		
		
		out.print("<H1>Processing request for Job#: " + taskNumber + "</H1>");
		out.print("<div id=\"r\"></div>");
		
		out.print("<font color=\"#993333\"><b>");
		out.print("RMI Server is located at " + remoteHost);
		out.print("<br>Algorithm: " + algorithm);		
		out.print("<br>String <i>s</i> : " + s);
		out.print("<br>String <i>t</i> : " + t);
		out.print("<br>This servlet should only be responsible for handling client request and returning responses. Everything else should be handled by different objects.");
		out.print("Note that any variables declared inside this doGet() method are thread safe. Anything defined at a class level is shared between HTTP requests.");				
		out.print("</b></font>");

		out.print("<P> Next Steps:");	
		out.print("<OL>");
		out.print("<LI>Generate a big random number to use a a job number, or just increment a static long variable declared at a class level, e.g. jobNumber.");	
		out.print("<LI>Create some type of an object from the request variables and jobNumber.");	
		out.print("<LI>Add the message request object to a LinkedList or BlockingQueue (the IN-queue)");			
		out.print("<LI>Return the jobNumber to the client web browser with a wait interval using <meta http-equiv=\"refresh\" content=\"10\">. The content=\"10\" will wait for 10s.");	
		out.print("<LI>Have some process check the LinkedList or BlockingQueue for message requests.");	
		out.print("<LI>Poll a message request from the front of the queue and make an RMI call to the String Comparison Service.");			
		out.print("<LI>Get the <i>Resultator</i> (a stub that is returned IMMEDIATELY by the remote method) and add it to a Map (the OUT-queue) using the jobNumber as the key and the <i>Resultator</i> as a value.");	
		out.print("<LI>Return the result of the string comparison to the client next time a request for the jobNumber is received and the <i>Resultator</i> returns true for the method <i>isComplete().</i>");	
		out.print("</OL>");	
		
		out.print("<form name=\"frmRequestDetails\">");
		out.print("<input name=\"cmbAlgorithm\" type=\"hidden\" value=\"" + algorithm + "\">");
		out.print("<input name=\"txtS\" type=\"hidden\" value=\"" + s + "\">");
		out.print("<input name=\"txtT\" type=\"hidden\" value=\"" + t + "\">");
		out.print("<input name=\"frmTaskNumber\" type=\"hidden\" value=\"" + taskNumber + "\">");
		out.print("</form>");								
		out.print("</body>");	
		out.print("</html>");	
		
		out.print("<script>");
		out.print("var wait=setTimeout(\"document.frmRequestDetails.submit();\", 10000);");
		out.print("</script>");
				
		//You can use this method to implement the functionality of an RMI client
		try {
			//connect to rmi
				StringService service = (StringService) Naming.lookup("rmi://localhost:2016/stringService");
				Resultator result = service.compare(t, s, algorithm);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		//
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
 	}
}