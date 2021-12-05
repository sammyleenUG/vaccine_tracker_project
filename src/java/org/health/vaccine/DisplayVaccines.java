/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package org.health.vaccine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 *
 * @author USER
 */
public class DisplayVaccines extends SimpleTagSupport {

    private String table;
    private String where;
    private String displayformat;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException ex){
             System.out.println(ex);
        }
        
        String retrieveQuery = "SELECT * FROM " + table + " ORDER BY id DESC";
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccine_tracker","root","");  
            Statement st= con.createStatement();
            
            //health centers results
            ResultSet r = st.executeQuery(retrieveQuery);
            
            if("table".equals(displayformat)){
                
                out.println("<table class='table'>"
                    + "<tr>"
                    + "<th>ID</th>"
                    + "<th>TYPE</th>"
                    + "<th>TOTAL DOZZES</th>"
                    + "<th>DATE ADDED</th>"
                    + "</tr>");
                         
                    while(r.next()){
                        
                        out.println("<tr><td>"+r.getString("id")+"</td>");
                        out.println("<td>"+r.getString("type")+"</td>");
                        out.println("<td>"+r.getString("total_dozzes")+"</td>");
                        out.println("<td>"+r.getString("date")+"</td>");
        
                    }
                out.println("</table>");
            
                st.close();
                con.close();
                
            }else{
               
                out.println("<ol>");
                while(r.next()){
                        out.println("<li>");
                        out.println("<p>"+r.getString("id")+"</p>");
                        out.println("<p>"+r.getString("type")+"</p>");
                        out.println("<p>"+r.getString("total_dozzes")+"</p>");
                        out.println("<p>"+r.getString("date")+"</p>");
                        out.println("</li>");
                }
                out.println("</ol>");
                st.close();
                con.close();
            }
            
            
        } catch (SQLException ex) {
            out.println(ex);
        }
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public void setDisplayformat(String displayformat) {
        this.displayformat = displayformat;
    }
    
}
