<%@include file="templates/includes.jsp" %>
<h2><fmt:message key="spring.webproject.bodycontent" bundle="${Msgs}"/></h2>
<h3><c:out value="${springWebProjectObject}"></c:out></h3>

<form action="loginPage.spring" method="post">
	<input type="text" name="username" />
	<input type="password" name="password" />
	<input type="submit" value="Login"/>
</form>