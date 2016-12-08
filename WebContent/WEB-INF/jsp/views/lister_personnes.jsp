<%@ include file="/WEB-INF/jsp/templates/header.jsp" %>
<%@ include file="/WEB-INF/jsp/templates/nav_bar.jsp" %>


<div class="container">
	<h3>Personnes presente dans l'annuaire</h3>
    <ul style="list-style-type: square">
	    <c:forEach items="${personnes}" var="person">
	        <li><a href="">${person.firstName} ${person.lastName}</a></li>
	    </c:forEach>
	</ul>
</div>	  
	  
<%@ include file="/WEB-INF/jsp/templates/footer.jsp" %>