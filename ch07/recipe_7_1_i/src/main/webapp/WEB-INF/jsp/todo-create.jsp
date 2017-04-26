<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Message Post</title>
    <link type="text/css" rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.10/semantic.min.css">
</head>

<body>
<div class="ui container">
    <h4>New Todo</h4>
    <c:url value="/todos" var="uri"/>
    <form:form method="POST" modelAttribute="todo" action="${uri}" class="ui form">
        <fieldset>
            <legend>Todo</legend>
            <div class="field">
                <label>Todo</label>
                <form:input path="description"/>
            </div>
            <div class="field">
                <label>Completed</label>
                <form:checkbox path="completed" />
            </div>
            <button class="ui primary button">Send <i class="send icon"></i></button>
        </fieldset>
    </form:form>
</div>
</body>
</html>
