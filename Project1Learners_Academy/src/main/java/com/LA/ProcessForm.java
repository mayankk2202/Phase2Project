package com.LA;

import java.io.*;
import javax.servlet.*;

public class ProcessForm extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    public ProcessForm() {
        super();
    }

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String sbasic1 = req.getParameter("fname");
		String sbasic2 = req.getParameter("lname");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<html><body>");
		out.print("Full Name: "+sbasic1+" "+sbasic2+"<br>");
		out.print("<body><html>");		
	}

}
