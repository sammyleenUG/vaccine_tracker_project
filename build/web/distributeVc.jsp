<%-- 
    Document   : distributeVc
    Created on : Dec 5, 2021, 11:25:18 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="WEB-INF/distribute_tag.tld" prefix="vaccination" %>

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
          <a class="navbar-brand" href="distributeVaccine.jsp">&lAarr; Back</a>
        </nav>
        <div class="container">
          <div class="row">
              <div class="col-md-10 mr-auto ml-auto">
                  <p></p>
                  
                  <vaccination:insert
                      table="hc_vc"
                      where='<%= request.getParameter("vc_id") %>'
                      values='<%= request.getParameter("hc_id") + "\',\'" + request.getParameter("vc_id") + "\',\'" + request.getParameter("dozzes") %>'
                      dozzes='<%= request.getParameter("dozzes") %>'
                  />
              </div>
          <//div>
      </div>
        
    </body>
</html>