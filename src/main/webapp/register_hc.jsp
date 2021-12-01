<%-- 
    Document   : register_hc
    Created on : Dec 1, 2021, 7:34:51 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Register Health Center</title>
    </head>
    <body>
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <a class="navbar-brand" href="health_centers.jsp">&lAarr; Back</a>
      </nav>
      <div class="container">
          <div class="row">
              <div class="col-md-6 mr-auto ml-auto">
                    <center><h1>REGISTER HEALTH CENTER HERE</h1></center>
                    <center style="color:red">
                        <% 
                          if(request.getAttribute("error") != null){
                            out.println(request.getAttribute("error")); 
                          }
                        %>
                    </center>
                    <form action="register_hc" method="post">
                        <label>Health Center</label><br>
                        <input class="form-control" type="text" name="name"><br>
                        <label>Location</label><br>
                        <input class="form-control" type="text" name="location"><br>
                        <input type="submit" class="btn btn-sm btn-secondary">
                    </form>
              </div>
          <//div>
      </div>
        
    </body>
</html>
