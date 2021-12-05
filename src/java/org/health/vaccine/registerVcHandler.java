/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package org.health.vaccine;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author USER
 */
public class registerVcHandler extends SimpleTagSupport {

    private String table;
    private String where;
    private String values;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        
        //attempting to import driver class
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException ex){
             System.out.println(ex);
        }
        
        try {
            //connecting to database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccine_tracker","root","");  
            
            String insert_query = "INSERT INTO "+table+"(type,total_dozzes) VALUES('" + values + "')";
            //executing query
            PreparedStatement st = con.prepareStatement(insert_query);
            
            
            st.executeUpdate();
                
            out.println("<div class=\"alert alert-success\" role=\"alert\">\n" +values+
                " registered successfully!\n" +
                "</div>");
            
            
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

    public void setValues(String values) {
        this.values = values;
    }
    
}
