package com.sit.marketplace.paramsform;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sit.marketplace.params.EucalyptusParams;

public class EucalyptusParamsFormSetter extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String clcHost;
		int clcPort;
		String awsAccessKeyId;
		String secretAccessKey;
		String emi;
		String securityGroup;
		String privateKey;
		
		try{
			clcHost = request.getParameter("clcHost");
			clcPort = Integer.parseInt(request.getParameter("clcPort"));
			awsAccessKeyId = request.getParameter("awsAccessKeyId");
			secretAccessKey = request.getParameter("secretAccessKey");
			emi = request.getParameter("emi");
			securityGroup = request.getParameter("securityGroup");
			privateKey = request.getParameter("privateKey");
			if(clcHost == "" || awsAccessKeyId == "" || secretAccessKey == "" || emi == "" || securityGroup == "" || privateKey == ""){
				response.getWriter().println("One of the parameters was empty");
			} else {
				EucalyptusParams.getInstance().setAwsAccessKeyId(awsAccessKeyId);
				EucalyptusParams.getInstance().setClcHost(clcHost);
				EucalyptusParams.getInstance().setClcPort(clcPort);
				EucalyptusParams.getInstance().setEmi(emi);
				EucalyptusParams.getInstance().setSecretAccessKey(secretAccessKey);
				EucalyptusParams.getInstance().setSecurityGroup(securityGroup);
				EucalyptusParams.getInstance().setPrivateKey(privateKey);
				response.sendRedirect("EucalyptusParams.jsp");
			}
			
		}catch(Exception e){
			response.getWriter().println(e);
		}
    }
}