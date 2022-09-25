<%--
    Document: JSP Page
    Author: Serj C.
--%>

<% @page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="dateBean" scope="application" class="org.example.beans.DateBean"/>
        <h1>This is a JSP Page</h1>
        <br/>
        <p>
            The current date and time is: ${dateBean.currentDate}
        </p>
    </body>
</html>
