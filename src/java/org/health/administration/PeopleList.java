/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.health.administration;

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
 * @author HP
 */
public class PeopleList extends SimpleTagSupport {

    private String table;
    private String where;
    private String displayformat;

    /**
     * Called by the container to invoke this tag.The implementation of this
 method is provided by the tag library developer, and handles all tag
 processing, body iteration, etc.
     * @throws jakarta.servlet.jsp.JspException
     */
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException ex){
             System.out.println(ex);
        }
        
        String retrieveQuery = "SELECT * FROM " + table + " ORDER BY date DESC";
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccine_tracker","root","");  
            Statement st= con.createStatement();
            
            //health centers results
            ResultSet r = st.executeQuery(retrieveQuery);
            
            if("table".equals(displayformat)){
                
                out.println("<table class='table'>"
                    + "<tr>"
                    + "<th>NIN</th>"
                    + "<th>FULL NAME</th>"
                    + "<th>BATCH NO</th>"
                    + "<th>REG.DATE</th>"
                    + "<th>TARGET DATE</th>"
                    + "<th>ACTION</th>"
                    + "</tr>");
                         
                    while(r.next()){
                        
                        out.println("<tr><td>"+r.getString("nin")+"</td>");
                        out.println("<td>"+r.getString("full_name")+"</td>");
                        out.println("<td>"+r.getString("batch_no")+"</td>");
                        out.println("<td>"+r.getString("date")+"</td>");
                        out.println("<td>"+r.getString("target_date")+"</td>");
                        out.println("<td><a type='button' class='btn btn-sm btn-primary' href='/vaccine_tracker_project_2/certificate.jsp?nin="+r.getString("nin")+"'>Certificate</a>");
        
                    }
                out.println("</table>");
            
                st.close();
                con.close();
                
            }else{
               
                out.println("<ol>");
                while(r.next()){
                        out.println("<li>");
                        out.println("<p>"+r.getString("nin")+"</p>");
                        out.println("<p>"+r.getString("full_name")+"</p>");
                        out.println("<p>"+r.getString("batch_n0")+"</p>");
                        out.println("<p>"+r.getString("date")+"</p>");
                        out.println("<p>"+r.getString("target_date")+"</p>");
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
