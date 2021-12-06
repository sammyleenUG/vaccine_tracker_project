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
public class Certificate extends SimpleTagSupport {

    private String table;
    private String where;

    /**
     * Called by the container to invoke this tag.The implementation of this
 method is provided by the tag library developer, and handles all tag
 processing, body iteration, etc.
     * @throws jakarta.servlet.jsp.JspException
     * @throws java.io.IOException
     */
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException ex){
             System.out.println(ex);
        }
        
        String retrieveQuery = "SELECT p.*,h.name as hc_name,v.type as vc_name"
                + " FROM " + table + " AS p"
                + " LEFT JOIN health_centre h "
                + " ON p.health_centre_id = h.id"
                + " LEFT JOIN vaccine v "
                + " ON p.vaccine_id = v.id"
                + " WHERE nin = " + where;
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccine_tracker","root","");  
            Statement st= con.createStatement();
            
            //health centers results
            ResultSet r = st.executeQuery(retrieveQuery);
            
           
                
          
                    while(r.next()){
                        
                        out.println("<div class=\"card-header\">\n" + r.getString("full_name")+
"                              \n" +
"                        </div>\n" +
"                        <div class=\"card-body\">\n" +
"                            <h5 class=\"card-title\">NIN: " + r.getString("full_name")+ "</h5>\n" +
"                            <p class=\"card-text\">" + r.getString("hc_name")+ "</p>\n" +
"                            <p class=\"card-text\">" + r.getString("vc_name")+ "</p>\n" +
"                            <a href=\"#\" class=\"btn btn-primary\">Print</a>\n" +
"                        </div>");
        
                    }
                
            
                st.close();
                con.close();
                
            
            
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
    
}
