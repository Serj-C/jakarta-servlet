<%--
    Document: JSP Page with Java code
    Author: Serj C.
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%! Date currDate = null; %>
<% currDate = new Date(); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page with Java code</title>
    </head>
    <body>
        <h1>JSP Page with Java code</h1>
        <br/>
        <p>
            The current date and time is: <%= currDate %>
        </p>
    </body>
</html>
