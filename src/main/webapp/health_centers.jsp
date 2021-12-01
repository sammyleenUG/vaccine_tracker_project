<%-- 
    Document   : health_centers
    Created on : Dec 1, 2021, 8:36:52 AM
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
        <title>Health Centers</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <a class="navbar-brand" href="health_centers.jsp">VACCINE TRACKER</a>
        </nav>
        <div class="container">
            <div class="row">
               <div class="col-md-10 mr-auto ml-auto">
                <center>
                    <h5 id="loading-msg">LOADING, PLEASE WAIT</h5>
                </center>
                <center>
                    <h1>HEALTH CENTER LIST</h1>
                    <a type="button" class="btn btn-sm btn-secondary" href="register_hc.jsp">New Health Center</a>
                </center>
                <center style="color:black;" >
                    <p>
                    <% 
                       if(request.getAttribute("success") != null){
                          out.println(request.getAttribute("success")); 
                       }
                    %>
                    </p>
                </center>
                <table class="table">
                    <tr>
                        <th></th>
                        <th>Health Center</th>
                        <th>Location</th>
                        <th>Bookings</th>
                    </tr>
                    <jsp:include page="/HealthCenters" /> 
                </table>
              </div>
            </div>
        </div>
                
        <script>
           $(window).on('load', function () {
              $('#loading-msg').hide();
           })
        </script>
                
    </body>
</html>
