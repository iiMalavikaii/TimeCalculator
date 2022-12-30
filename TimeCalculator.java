package TimeCalcAssignment;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
	//import java.util.*;
	import java.util.TimeZone;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
	public class TimeCalculator extends HttpServlet{
	    
		public void doPost(HttpServletRequest rq,HttpServletResponse rp) throws IOException{
			try {
				  String country = (String) rq.getParameter("country");
			      PrintWriter output=rp.getWriter();
			      SimpleDateFormat s = new SimpleDateFormat("dd MMM yyyy HH:mm:ss z");
				  s.setTimeZone(TimeZone.getTimeZone(country));
				  String Time = s.format(Calendar.getInstance().getTime());
	              RequestDispatcher rd = rq.getRequestDispatcher("/index.html");
	        	  rd.include(rq, rp);
	              output.println("<div>"+"<h1 class=\"time_box\">"+Time+"</h1>"+"</div>");
			}
	        catch(Exception ee){
	                        System.out.println(ee);
	    }
	   }
	}
