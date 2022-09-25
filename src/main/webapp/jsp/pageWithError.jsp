<%--
    Document: JSP Page with errors
    Author: Serj C.
--%>

<html xmlns:jsp="http://xmlns.jcp.org/JSP/Page" xmlns:c="jakarta.tags.core">

    <jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
    <jsp:directive.page errorPage="errorPage.jsp"/>

    <head>
        <title>Handling JSP Errors</title>
    </head>
    <body>
        <h1>There is an error on this page</h1>
        <p>
            This will produce an error:
            <jsp:scriptlet>
                if (request.getParameter("param").equals("value")) {
                    System.out.println("test");
                }
            </jsp:scriptlet>
        </p>
    </body>
</html>
