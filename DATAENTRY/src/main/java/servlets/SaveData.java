/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.DataAccess;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import model.data;

/**
 *
 * @author Anjan
 */
public class SaveData extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String REF = req.getParameter("REF");
        String DATE = req.getParameter("DATE");
        String ACC = req.getParameter("ACC");
        String ACCTP = req.getParameter("ACCTP");
        String PARTY = req.getParameter("PARTY");
        String PARTYTP = req.getParameter("PARTYTP");
        String AMT = req.getParameter("AMT");
        String REM = req.getParameter("REM");
        
        data e = new data();
        e.setREF(REF);
        e.setDATE(DATE);
        e.setACC(ACC);
        e.setACCTP(ACCTP);
        e.setPARTY(PARTY);
        e.setPARTYTP(PARTYTP);
        e.setAMT(AMT);
        e.setREM(REM);
        out.println(REF);
        out.println(DATE);
        out.println(ACC);
        out.println(ACCTP);
        out.println(PARTY);
        out.println(PARTYTP);
        out.println(AMT);
        out.println(REM);
          
        out.close();
    }

}
