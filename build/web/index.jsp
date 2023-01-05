<%-- 
    Document   : index
    Created on : 5 ม.ค. 2566, 8:17:03
    Author     : pakutsing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <%@ include file = "share/header.jsp" %>
    </head>
    <body>
        <%@ include file = "share/navbar.jsp" %>
        <div class="container">
            <div class="card mt-5 border-dark " >
                <div class="card-header bg-dark text-white ">
                    Featured
                </div>
                <div class="card-body">
                    <h5 class="card-title">Special title treatment</h5>
                    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                    <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
            </div>
        </div>
        
    </body>
    <footer>
        <%@ include file = "share/footer.jsp" %>
    </footer>
    <script>
        $( document ).ready(function() {
            $("#homepage").addClass("active");
        });
    </script>
</html>
