<%@ include file="/WEB-INF/view/jspf/taglib.jspf" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<form:form method="post" modelAttribute="user" action="${contextPath}/user/checkRegistration">
    Email : <form:input path="email" type="text" /><br/>
    <form:errors path="email" /><br/>
    Phone number:<form:input path="phoneNumber" type="text" /><br/>
    <form:errors path="phoneNumber" /><br/>
    Password:<form:input path="password" type="password"/><br/>
    ${requestScope.passwordEmpty}<br>
    ${requestScope.invalidSize}<br>
    repeat pas:<input  name="repeat_password" type="password" /><br/>
    ${requestScope.passwordsNotEquals}<br>
    ${requestScope.repeatPasswordEmpty}<br>
    date of b:<form:input path="dateOfBirth"/>
    <form:errors path="dateOfBirth" /><br/>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
