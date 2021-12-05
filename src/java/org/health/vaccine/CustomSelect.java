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
public class CustomSelect extends SimpleTagSupport {

    private String table;
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
            int x = 1;
            
            if("health_centre".equals(table)){
                       
                while(r.next()){     
                    out.println("<option value='"+r.getString("id")+"'>"+r.getString("name")+"</option>");
                }
               
                st.close();
                con.close();
                
            }else{
                
                while(r.next()){     
                    out.println("<option value='"+r.getString("id")+"'>"+r.getString("type")+"</option>");
                }

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

    public void setDisplayformat(String displayformat) {
        this.displayformat = displayformat;
    }
    
}
