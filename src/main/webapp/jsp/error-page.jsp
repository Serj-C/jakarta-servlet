<%--
    Document: JSP Error Page
    Author: Serj C.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Error Page</title>
    </head>
    <body>
        <h1>Error Encountered</h1>
        <br/>
        <br/>
        <p>
            The application has encountered the following error:
            <br/>
            <fmt:message key="ServerError"/>: ${pageContext.errorData.statusCode}
        </p>
    </body>
</html>
