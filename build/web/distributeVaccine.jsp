<%-- 
    Document   : distributeVaccine
    Created on : Dec 5, 2021, 11:22:45 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="WEB-INF/custom_select_tag.tld" prefix="vaccination" %>

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
        <title>Distribute</title>
    </head>
    <body>
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <a class="navbar-brand" href="vaccines.jsp">&lAarr; Back</a>
      </nav>
      <div class="container">
          <div class="row">
              <div class="col-md-6 mr-auto ml-auto">
                    <center><h3>DISTRIBUTE VACCINE</h3></center>
                    <form action="distributeVc.jsp" method="post">
                        <label>Vaccine</label><br>
                        <select name="vc_id" class="form-control">
                            <vaccination:select table="vaccine" displayformat="list" />
                        </select><br>
                        <label>Health Center</label><br>
                        <select name="hc_id" class="form-control">
                            <vaccination:select table="health_centre" displayformat="list" />
                        </select><br>
                        <label>Dozzes</label><br>
                        <input class="form-control" type="number" name="dozzes" required=""><br>
                        <input type="submit" class="btn btn-sm btn-secondary" value="Save">
                    </form>
              </div>
          <//div>
      </div>     
    </body>
</html>
