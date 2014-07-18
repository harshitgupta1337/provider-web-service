<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sit.marketplace.params.EucalyptusParams" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cloud Marketplace - Eucalyptus parameters tuning</title>
</head>
<body>
The current parameters are : <br><br>
Current clcHost : <%= EucalyptusParams.getInstance().getClcHost()%><br>
Current clcPort : <%= EucalyptusParams.getInstance().getClcPort()%><br>
Current awsAccessKeyId : <%= EucalyptusParams.getInstance().getAwsAccessKeyId()%><br> 
Current secretAccessKey : <%= EucalyptusParams.getInstance().getSecretAccessKey()%><br>
Current emi : <%= EucalyptusParams.getInstance().getEmi()%><br>
Current securityGroup : <%= EucalyptusParams.getInstance().getSecurityGroup()%><br>
<br><br><br><br>
Enter the new parameters :
<form method="post" action="updateEucalyptusParams" name="UpdateEucalyptusParamsForm">
Enter new clcHost : <input name="clcHost" value="<%=EucalyptusParams.getInstance().getClcHost()%>">  <br>
Enter new clcPort : <input name="clcPort" value="<%=EucalyptusParams.getInstance().getClcPort()%>">  <br>
Enter new awsAccessKeyId : <input name="awsAccessKeyId" value="<%=EucalyptusParams.getInstance().getAwsAccessKeyId()%>">  <br>
Enter new secretAccessKey : <input name="secretAccessKey" value="<%=EucalyptusParams.getInstance().getSecretAccessKey()%>">  <br>
Enter new emi : <input name="emi" value="<%=EucalyptusParams.getInstance().getEmi()%>">  <br>
Enter new securityGroup : <input name="securityGroup" value="<%=EucalyptusParams.getInstance().getSecurityGroup()%>">  <br>
<button value="UpdateEucalyptusParams" name="UpdateEucalyptusParams">Update Eucalyptus Parameters</button>&nbsp;<button value="Reset" name="Reset" type="reset">Reset</button><br>
</form>

</body>
</html>