/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.health.health;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "HealthCenters", urlPatterns = {"/HealthCenters"})
public class HealthCenters extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String retrieveQuery = "SELECT * FROM health_centre ORDER BY id DESC";
        
        PrintWriter out = response.getWriter();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException ex){
             System.out.println(ex);
        }
        
      
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccine_tracker","root","");  
            Statement st= con.createStatement();
            
            //health centers results
            ResultSet r = st.executeQuery(retrieveQuery);
            int x = 1;
            while(r.next()){
               out.println("<tr><td>"+x+"</td>");
               out.println("<td>"+r.getString("name")+"</td>");
               out.println("<td>"+r.getString("location")+"</td>");
               out.println("<td>"+number_of_bookings(r.getInt("id"))+"</td>");
               out.println("<td><a href='/vaccine_tracker_project/delete_hc?id="+r.getString("id")+"'>Drop</a></td></tr>");
               x++;
            }
            
            st.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public int number_of_bookings(int hc_id){
        int number  = 0;          
        String query = "SELECT COUNT(id) AS total_bookings " +
                   "FROM booking " +   
                   "WHERE health_center_id = " + hc_id;
        
       
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccine_tracker","root","");  
            Statement st= con.createStatement();
            
            //health centers results
            ResultSet r = st.executeQuery(query);
            while(r.next()){
                number  = r.getInt("total_bookings");
            }
            
            st.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return number;
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
