<%-- 
    Document   : register_hc_handler
    Created on : Dec 5, 2021, 11:21:56 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="WEB-INF/health_center_tag.tld" prefix="vaccination" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
         <!-- bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"></script>
        <script src="https://use.fontawesome.com/a042e00ef5.js"></script>
        <title>Register</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <a class="navbar-brand" href="register_health_center.jsp">&lAarr; Back</a>
        </nav>
        <div class="container">
          <div class="row">
              <div class="col-md-10 mr-auto ml-auto">
                  <p></p>
                  
                  <vaccination:insert 
                      table="health_centre"
                      values='<%= request.getParameter("name") + "\',\'" + request.getParameter("location") %>'
                  />
              </div>
          <//div>
      </div>
        
    </body>
</html>
