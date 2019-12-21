/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author Anjan
 */
public class MyServlet extends HttpServlet {
    Connection conn=null;
    
    public MyServlet(){
        conn=MYSQL_CONNECT.ConnectDB();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           try
           {
               String _userName = request.getParameter("txtUser");
               String _passWord = request.getParameter("txtPass");
               if (_userName != null)
               {
                   String Query = "select * from user where user=? and pass=?";
                   PreparedStatement psm = conn.prepareStatement(Query);
                   psm.setString (1, _userName);
                   psm.setString(2, _passWord);
                   ResultSet rs=psm.executeQuery();
                   if (rs.next())
                   {
                       response.sendRedirect("welcome.html");
                   }
                   else{
                       out.println("Login Failed! Please try again");
                   }
               }
           }
           catch (Exception ex){
               out.println(ex.getMessage());
           }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
