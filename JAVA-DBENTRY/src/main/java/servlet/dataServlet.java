/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import db.connect_db;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author ANJAN
 */
public class dataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            int status = 0;
            Connection con = connect_db.ConnectDB();
            PreparedStatement ps = con.prepareStatement("insert into DATA(REF, DATE, ACC, ACCTP, PARTY, PARTYTP, AMT, REM, PROJ) values (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, request.getParameter("REF"));
            ps.setString(2, request.getParameter("DATE"));
            ps.setString(3, request.getParameter("ACC"));
            ps.setString(4, request.getParameter("ACCTP"));
            ps.setString(5, request.getParameter("PARTY"));
            ps.setString(6, request.getParameter("PARTYTP"));
            ps.setString(7, request.getParameter("AMT"));
            ps.setString(8, request.getParameter("REM"));
            ps.setString(9, request.getParameter("PROJ"));
            status = ps.executeUpdate();
            if (status > 0) {
                out.print("<p>Record saved successfully!</p>");
                request.getRequestDispatcher("index.html").include(request, response);
            } else {
                out.println("Sorry! unable to save record");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
