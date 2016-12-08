<%@ include file="/WEB-INF/jsp/templates/header.jsp"%>
<%@ include file="/WEB-INF/jsp/templates/nav_bar.jsp"%>


<div class="container">

	<h1>Annuaire d'Aix-Marseille Université</h1>
	
	<a href="" onclick="javascript:window.history.go(-1)" class="noStyle gras"><span class="glyphicon glyphicon-chevron-left"></span>Retour</a>
	
	<h4>${group.name}</h4>
	<p>Id du groupe: ${group.id}</p>

	<h3>Personnes présente dans le groupe:</h3>
    <ul style="list-style-type: square">
	    <c:forEach items="${showPersonInGroup}" var="person">
	        <li><a href="person?id=${person.id}">${person.firstName} ${person.lastName}</a></li>
	    </c:forEach>
	</ul>

</div>	  
	  
<%@ include file="/WEB-INF/jsp/templates/footer.jsp" %>