package com.sit.marketplace.params;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sit.marketplace.jsonutils.ParamsGsonAdapter;

public class DisplayParams extends HttpServlet {
    private static final long serialVersionUID = 1L;
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	final GsonBuilder gsonBuilder = new GsonBuilder();
	    gsonBuilder.registerTypeAdapter(Map.class, new ParamsGsonAdapter());
	    final Gson gson = gsonBuilder.create();
	    
        response.setContentType("text/html");
        
        response.getWriter().print(gson.toJson(Params.getInstance().getParamsMap(), Map.class));
    }
}