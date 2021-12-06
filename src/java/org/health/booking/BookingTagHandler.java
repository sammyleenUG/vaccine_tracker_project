/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.health.booking;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author cnsub
 */
public class BookingTagHandler extends SimpleTagSupport {

    private String table;
    private String values;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            String[] arr = values.split(",");
            try{
                Class.forName("com.mysql.jdbc.Driver");
                try{
                
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccine_tracker","root","");
                    Statement st = con.createStatement();
                    if(arr.length>1){
                    out.println(table);
                    st.execute("insert into "+table+"(name,date,time,place)values('"+arr[0]+"','"+arr[1]+"','"+arr[2]+"','"+arr[3]+"');");
                    }
                }catch (SQLException ex){
                out.println("Error"+ ex.getMessage());
                }
            
            }catch (ClassNotFoundException ex){
              out.println("Error"+ex.getMessage());
            }
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in BookingTagHandler tag", ex);
        }
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setValues(String values) {
        this.values = values;
    }
    
}
