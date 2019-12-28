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

/**
 *
 * @author ANJAN
 */
public class EditServlet2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("name");  
        String password=request.getParameter("password");    
          
        USER.USER_MODEL e=new USER.USER_MODEL();  
        e.setId(id);  
        e.setName(name);  
        e.setPassword(password);   
          
        int status=USER.USERDAO.update(e);  
        if(status>0){  
            response.sendRedirect("VIEW");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }

}
