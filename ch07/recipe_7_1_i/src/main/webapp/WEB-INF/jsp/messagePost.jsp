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
    <h4>New Message</h4>
    <c:url value="/messages" var="uri"/>
    <form:form method="POST" modelAttribute="message" action="${uri}" class="ui form">
        <fieldset>
            <div class="field">
                <label>Subject</label>
                <form:input path="title"/>
            </div>
            <div class="field">
                <label>Body</label>
                <form:textarea path="body" rows="4"/>
            </div>
            <button class="ui primary button">Send <i class="send icon"></i></button>
        </fieldset>
    </form:form>
</div>
</body>
</html>
