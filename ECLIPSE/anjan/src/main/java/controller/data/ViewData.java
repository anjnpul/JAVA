package controller.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Data;
import model.DataAccess;


public class ViewData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        List<Data> list = DataAccess.getAllData();
        Gson gson = new Gson();
        String data = gson.toJson(list);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(data);
        out.flush();
	}
}
