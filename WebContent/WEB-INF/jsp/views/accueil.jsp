<%@ include file="/WEB-INF/jsp/templates/header.jsp" %>
<%@ include file="/WEB-INF/jsp/templates/nav_bar.jsp" %>

	  <p>Hello. Benjamin</p>
	 <!-- <img src="/images/amu_logo.png" /> -->
	  	<p>
		Greetings, it is now
		<c:out value="${now}" default="None" />
	</p>
<%@ include file="/WEB-INF/jsp/templates/footer.jsp" %>