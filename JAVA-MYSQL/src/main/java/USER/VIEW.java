/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package USER;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;  

/**
 *
 * @author ANJAN
 */
public class VIEW extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='../user.html'>Add New User</a>");  
        out.println("<h1>User List</h1>");  
          
        List<USER.USER_MODEL> list=USER.USERDAO.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>User Name</th><th>Password</th><th>Edit</th><th>Delete</th></tr>");  
        for(USER.USER_MODEL e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getuser()+"</td><td>"+e.getpass()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }


}
