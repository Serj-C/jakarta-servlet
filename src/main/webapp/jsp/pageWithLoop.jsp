<%--
    Document: JSP Page with loop
    Author: Serj C.
--%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
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
            <thead>
                <tr><th>First Name</th><th>Last Name</th></tr>
            </thead>
            <tbody>
                <c:forEach var="author" items="${authorBean.authorList}">
                    <tr>
                        <td>${author.first}</td>
                        <td>${author.last}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
