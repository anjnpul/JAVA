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

/**
 *
 * @author ANJAN
 */
public class ViewData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<a href='index.html'>Add New Data</a>");
        out.println("<h1>Record List</h1>");

        List<data> list = DataAccess.getAllData();

        out.print("<table border='1' width='100%'");
        out.print("<tr><th>ID</th><th>PROJECT</th><th>REF: NO.</th><th>DATE</th><th>ACCOUNT</th><th>PAID TO / FOR</th><th>AMOUNT</th><th>REMARKS</th><th>Edit</th><th>Delete</th></tr>");  
        for (data e : list) {
            out.print("<tr><td>" + e.getID() + "</td><td>" + e.getPROJ() + "</td><td>" + e.getREF() +"</td><td > "+e.getDATE()+" </td><td>"+e.getACC()+ "</td><td>" + e.getPARTY() + "</td><td>" + e.getAMT() + "</td><td>" + e.getREM() + "</td><td> <a href ='EditServlet?id="+e.getID()+"'>edit</a> </td><td> <a href ='DeleteServlet?id="+e.getID()+"'>delete</a></td> </tr>");  
        }  
        out.print("</table>");
        out.close();
    }
}
