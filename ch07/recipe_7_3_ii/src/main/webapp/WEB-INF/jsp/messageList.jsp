<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Message List</title>
</head>

<body>
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
