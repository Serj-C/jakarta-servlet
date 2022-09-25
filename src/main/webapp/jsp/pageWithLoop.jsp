<%--
    Document: JSP Page with loop
    Author: Serj C.
--%>

<html xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
    xmlns:c="jakarta.tags.core">

    <jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
    <jsp:useBean id="authorBean" scope="session" class="org.example.beans.AuthorBean"/>

    <head>
        <title>Looping Through Database Records within a Page</title>
    </head>
    <body>
        <h1>Authors</h1>
        <p>
            The authors are printed below.
        </p>
        <table border="1">
            <tr><th>First Name</th><th>Last Name</th></tr>
            <c:forEach var="author" items="${authorBean.authorList}">
                <tr>
                    <td><c:out value="${author.first}"/></td>
                    <td><c:out value="${author.last}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
