<%-- 
    Document   : regperson
    Created on : Dec 6, 2021, 8:38:56 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="WEB-INF/people_tag.tld" prefix="vaccination" %>

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
        <title>Register person</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <a class="navbar-brand" href="register_person.jsp">&lAarr; Back</a>
        </nav>
        <div class="container">
          <div class="row">
              <div class="col-md-10 mr-auto ml-auto">
                  <p></p>
           
                  <vaccination:insert 
                      table="people"
                      values='<%= request.getParameter("nin") + "\',\'" + request.getParameter("name")  + "\',\'" + request.getParameter("email") + "\',\'" + request.getParameter("hc_id") + "\',\'" + request.getParameter("batch") + "\',\'" + request.getParameter("vc_id")  + "\',\'" + request.getParameter("tdate") %>'
                  />
              </div>
          <//div>
      </div>
        
    </body>
</html>