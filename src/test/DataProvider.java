package test;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
 
/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/Servlet")
public class DataProvider extends HttpServlet {
    private static final long serialVersionUID = 1L;
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	final GsonBuilder gsonBuilder = new GsonBuilder();
	    gsonBuilder.registerTypeAdapter(Container.class, new GsonAdapter());
	    final Gson gson = gsonBuilder.create();
	    
        response.setContentType("text/html");
        Container container = new Container();
        container.setX(13);
        container.setY(37);
        response.getWriter().print(gson.toJson(container, Container.class));
    }
 
}