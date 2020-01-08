package controller.data;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Data;
import model.DataAccess;

/**
 * Servlet implementation class DataCrud
 */
public class DataCrud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String ACT = req.getParameter("ACT");

        if (ACT.equals("ADD")) {
            String REF = req.getParameter("REF");
            String DATE = req.getParameter("DATE");
            String ACC = req.getParameter("ACC");
            String ACCTP = req.getParameter("ACCTP");
            String PARTY = req.getParameter("PARTY");
            String PARTYTP = req.getParameter("PARTYTP");
            String AMT = req.getParameter("AMT");
            String REM = req.getParameter("REM");
            String PROJ = req.getParameter("PROJ");

            Data e = new Data();
            e.setREF(REF);
            e.setDATE(DATE);
            e.setACC(ACC);
            e.setACCTP(ACCTP);
            e.setPARTY(PARTY);
            e.setPARTYTP(PARTYTP);
            e.setAMT(AMT);
            e.setREM(REM);
            e.setPROJ(PROJ);
            int status = DataAccess.save(e);
            String msg = "ANJAN";
            if (status > 0) {
                msg = "Data Saved Successfully";
            } else {
                msg = "Error in Data Saving";
            }
            resp.getWriter().write(msg);
        }
        
        if (ACT.equals("EDIT")) {
            String msg = "JHULE";
            String sid=req.getParameter("ID");  
            int id=Integer.parseInt(sid);  
            String REF = req.getParameter("REF");
            String DATE = req.getParameter("DATE");
            String ACC = req.getParameter("ACC");
            String ACCTP = req.getParameter("ACCTP");
            String PARTY = req.getParameter("PARTY");
            String PARTYTP = req.getParameter("PARTYTP");
            String AMT = req.getParameter("AMT");
            String REM = req.getParameter("REM");
            String PROJ = req.getParameter("PROJ");

            
            Data e = new Data();
            e.setREF(REF);
            e.setDATE(DATE);
            e.setACC(ACC);
            e.setACCTP(ACCTP);
            e.setPARTY(PARTY);
            e.setPARTYTP(PARTYTP);
            e.setAMT(AMT);
            e.setREM(REM);
            e.setPROJ(PROJ);
            e.setID(id);
            int status = DataAccess.upddata(e);
            if (status > 0) {
                msg = "Data Saved Successfully";
            } else {
                msg = "Error in Data Saving";
            }
            resp.getWriter().write(msg);
        }
        
        if (ACT.equals("DEL")) {
        	String sid=req.getParameter("ID");  
            int id=Integer.parseInt(sid);
            String msg = "JHULE";
            int status= DataAccess.deldata(id); 
            if (status > 0) {
                msg = "Data Deleted Successfully";
            } else {
                msg = "Error in Data Saving";
            }
            resp.getWriter().write(msg);
        }
	}
}
