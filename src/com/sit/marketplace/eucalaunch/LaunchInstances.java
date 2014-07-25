package com.sit.marketplace.eucalaunch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sit.marketplace.params.EucalyptusParams;
import com.xerox.amazonws.ec2.Jec2;
import com.xerox.amazonws.ec2.LaunchConfiguration;
import com.xerox.amazonws.ec2.ReservationDescription;
import com.xerox.amazonws.ec2.ReservationDescription.Instance;

public class LaunchInstances extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Jec2 connection = new Jec2(EucalyptusParams.getInstance().getAwsAccessKeyId(), 
				EucalyptusParams.getInstance().getSecretAccessKey(), false, 
				EucalyptusParams.getInstance().getClcHost(), EucalyptusParams.getInstance().getClcPort());
		connection.setResourcePrefix("/services/Eucalyptus"); 
		connection.setSignatureVersion(1);
		
		LaunchConfiguration lc = new LaunchConfiguration(EucalyptusParams.getInstance().getEmi(), 
				Integer.parseInt(request.getParameter("num")), Integer.parseInt(request.getParameter("num")));
		lc.setKeyName(EucalyptusParams.getInstance().getPrivateKey());
		List<String> secGrp = new ArrayList<String>();
		secGrp.add(EucalyptusParams.getInstance().getSecurityGroup());
		lc.setSecurityGroup(secGrp);
		
		try 
		{
			ReservationDescription resDesc =  connection.runInstances(lc);
			for(Instance instance : resDesc.getInstances()){
				response.getWriter().println(instance.getInstanceId());	
			}			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			response.getWriter().println("Error in creating instances");
			response.getWriter().println(e);
		}
	}
}
