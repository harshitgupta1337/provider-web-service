package com.sit.marketplace.eucalaunch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sit.marketplace.params.EucalyptusParams;
import com.xerox.amazonws.ec2.EC2Exception;
import com.xerox.amazonws.ec2.Jec2;
import com.xerox.amazonws.ec2.ReservationDescription;

public class DescribeInstanceStatus extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String instanceId = request.getParameter("instanceId");
		Jec2 connection = new Jec2(EucalyptusParams.getInstance().getAwsAccessKeyId(), 
				EucalyptusParams.getInstance().getSecretAccessKey(), false, 
				EucalyptusParams.getInstance().getClcHost(), EucalyptusParams.getInstance().getClcPort());
		connection.setResourcePrefix("/services/Eucalyptus"); 
		connection.setSignatureVersion(1);
		List<ReservationDescription> resDesc = null;
		try {
			resDesc = connection.describeInstances(new ArrayList<String>(){{add(instanceId);}});
			response.getWriter().println(resDesc.get(0).getInstances().get(0).getState().toUpperCase());
		} catch (EC2Exception e) {
			e.printStackTrace();
		}
	}

}
