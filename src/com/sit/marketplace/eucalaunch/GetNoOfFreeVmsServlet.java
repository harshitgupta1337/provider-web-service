package com.sit.marketplace.eucalaunch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetNoOfFreeVmsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String[] cmd = {"/bin/sh", "-c", "euca-describe-availability-zones verbose | grep m1.small"};
		Process process = Runtime.getRuntime().exec(cmd);
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String output = reader.readLine();
		int index = output.indexOf(" / ");
		response.getWriter().print(output.substring(index-4, index));
    }
}