/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import model.data;
import dao.DataAccess;
import com.google.gson.Gson;

/**
 *
 * @author ANJAN
 */
public class ViewData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        List<data> list = DataAccess.getAllData();
        Gson gson = new Gson();
        String data = gson.toJson(list);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(data);
        out.flush();
    }
}
