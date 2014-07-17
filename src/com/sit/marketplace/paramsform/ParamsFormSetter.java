package com.sit.marketplace.paramsform;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sit.marketplace.params.Params;

public class ParamsFormSetter extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Double> paramsMap = Params.getInstance().getParamsMap();
		for(String key : paramsMap.keySet()){
			String valueString = request.getParameter(key);
			double value;
			try{
				value = Double.parseDouble(valueString);
				Params.getInstance().getParamsMap().put(key, value);
			}catch(Exception e){
				System.out.println("NumberFormatException for the param " + key);
			}
		}
        response.sendRedirect("Params.jsp");
    }
}
