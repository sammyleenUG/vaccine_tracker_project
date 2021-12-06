<%-- 
    Document   : booking
    Created on : 3 Dec 2021, 20:51:37
    Author     : cnsub
--%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://org.com" prefix="vaccination" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <!-- bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"></script>
        <script src="https://use.fontawesome.com/a042e00ef5.js"></script>
        <title>booking</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <a class="navbar-brand" href="index.html">&lAarr; Back</a>
        </nav>
        <div class="container">
          <div class="row">
              <div class="col-md-6 mr-auto ml-auto">
                <h1>Welcome,<br/> fill out the form below to make a booking</h1>
       
                <form action="/vaccineTracker/BookingServlet" method="post">
           
                    <label>Name:</label><br>
                    <input class="form-control" type="text" name="name" /></br>
           
                    <label>date Booked:</label><br>
                    <input class="form-control" type="date" name="date"/> </br>
            
                    <label>time Booked:</label><br>
                    <input class="form-control" type="time" name="time"/></br>
            
                    <label>place of Preference</label><br>
              
                    <select name="hc" class="form-control">
                        <option value="kampala">Kampala HC</option>
                        <option value="lira">Liira HC</option>
                        <option value="mbarara">Mbarara HC</option>
                        <option value="soroti">Soroti HC</option>
                    </select><br>
               
               
                   <input class="btn btn-sm btn-secondary" type="submit" name="submit" value="send"/>
           
                </form>
               <div>
             <div>
            <div>
                
           <hr>
        <%
        String name =request.getParameter("name");
            String date =request.getParameter("date");
             String time =request.getParameter("time");
              String hc =request.getParameter("hc");
        %>
        <vaccination:insert table="booking" values="${name},${date},${time},${hc}"/>
            
        
    </body>
</html>
