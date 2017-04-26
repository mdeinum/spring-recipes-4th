<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Message List</title>
    <link type="text/css" rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.10/semantic.min.css">
</head>

<body>
<div class="ui container">
    <h4>Messages</h4>
    <table class="ui celled table">
        <thead>
        <tr>
            <th>Author</th>
            <th>Subject</th>
            <th>&nbsp;</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${messages}" var="message">
            <tr>
                <td>${message.author}</td>
                <td>${message.title}</td>
                <td>
                    <c:url value="/messages/${message.id}" var="url"/>
                    <form action="${url}" method="post">
                        <input type="hidden" name="_method" value="DELETE"/>
                        <button value="Delete" class="ui red icon button"><i class="remove circle icon"></i></button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="3">
                <a class="ui icon button" href="<c:url value="/messages/new"/>">New Message <i
                        class="add circle icon"></i></a>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
