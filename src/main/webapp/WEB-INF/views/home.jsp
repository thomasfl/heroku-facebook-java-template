<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
	<ul>
		<li><a href="<c:url value="/signout" />">Sign Out</a></li>
	</ul>
	<h3>Velkommen til huspris</h3>
	<ul>
		<li>Navn: <c:out value="${firstName}"/> <c:out value="${middelName}"/> <c:out value="${lastName}"/></li>
		<li>Epost: <c:out value="${email}"/></li>
		<li>Kj�nn: <c:out value="${gender}"/></li>
	</ul>
	
	<h3>Your Facebook Friends</h3>
	<ul>
	<c:forEach items="${friends}" var="friend">
		<li><img src="http://graph.facebook.com/<c:out value="${friend.id}"/>/picture" align="middle"/><c:out value="${friend.name}"/></li>
	</c:forEach>
	</ul>	
	</body>
</html>