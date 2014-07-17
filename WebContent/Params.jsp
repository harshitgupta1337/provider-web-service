<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sit.marketplace.params.Params" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cloud Marketplace - Parameters tuning</title>
</head>
<body>
The current parameters are : <br>
<%for(String key : Params.getInstance().getParamsMap().keySet()){%>
	<%=key + " : " +  Params.getInstance().getParamsMap().get(key)%><br>
<% }%>
<br><br><br><br>
Enter the new parameters :
<form method="post" action="updateParams" name="UpdateParamsForm">
<%for(String key : Params.getInstance().getParamsMap().keySet()){%>
 Enter new <%=key %> : <input name="<%=key %>" value="<%=Params.getInstance().getParamsMap().get(key)%>">  <br>
 <% }%>
<button value="UpdateParams" name="UpdateParams">Update Parameters</button>&nbsp;<button value="Reset" name="Reset" type="reset">Reset</button><br>
</form>
</body>
</html>