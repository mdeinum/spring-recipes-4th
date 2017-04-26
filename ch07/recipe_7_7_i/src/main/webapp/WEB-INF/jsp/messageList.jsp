<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Message List</title>
</head>

<body>
<h2>Welcome! <security:authentication property="name" /></h2>

<security:authentication property="authorities" var="authorities" />
<ul>
    <c:forEach items="${authorities}" var="authority">
        <li>${authority.authority}</li>
    </c:forEach>
</ul>
<hr />

<c:forEach items="${todos}" var="todo">
    <table>
        <tr>
            <td>Author</td>
            <td>${todo.author}</td>
        </tr>
        <tr>
            <td>Title</td>
            <td>${todo.title}</td>
        </tr>
        <tr>
            <td>Body</td>
            <td>${todo.body}</td>
        </tr>
        <tr>
            <td colspan="2">
                <a href="messageDelete?messageId=${todo.id}">Delete</a>
            </td>
        </tr>
    </table>
    <hr />
</c:forEach>
<a href="messagePost.htm">Post</a>
</body>
</html>
