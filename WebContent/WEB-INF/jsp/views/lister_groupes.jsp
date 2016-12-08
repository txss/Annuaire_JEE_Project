<%@ include file="/WEB-INF/jsp/templates/header.jsp" %>
<%@ include file="/WEB-INF/jsp/templates/nav_bar.jsp" %>


<div class="container">
	<h3>Groupes de l'annuaire</h3>
    <ul style="list-style-type: square">
	    <c:forEach items="${groupes}" var="grp">
	        <li><a href="">${grp.name}</a></li>
	    </c:forEach>
	</ul>
</div>

<%@ include file="/WEB-INF/jsp/templates/footer.jsp" %>