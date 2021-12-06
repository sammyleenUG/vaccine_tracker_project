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
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author USER
 */
public class DistributeVaccine extends SimpleTagSupport {

    private String table;
    private String where;
    private String values;
    private String dozzes;

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
        
        //substract value of dozzes in vaccine table
        
        
        
        try {
            //connecting to database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccine_tracker","root",""); 
            
            String insert_query = "INSERT INTO "+table+"(hc_id,vc_id,dozzes) VALUES('" + values + "')";
            //executing query
            PreparedStatement st = con.prepareStatement(insert_query);
            st.executeUpdate();
            
            
            //updating value of total dozzes
            Statement st2= con.createStatement();
            
            //health centers results
            ResultSet r = st2.executeQuery("SELECT * FROM vaccine WHERE id = " + where);
            
            int newValue = 0;
                
            while(r.next()){
                        
                newValue =   r.getInt("total_dozzes") - Integer.valueOf(dozzes);
            }
            
            String update_query = "UPDATE vaccine SET total_dozzes = " + newValue + " WHERE id =" + where;
            //executing query
            PreparedStatement st3 = con.prepareStatement(update_query);
            st3.executeUpdate();
               
            out.println("<div class=\"alert alert-success\" role=\"alert\">\n" +
                " Distrution succesful!\n" +
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
    
    public void setDozzes(String dozzes) {
        this.dozzes = dozzes;
    }
    
}
