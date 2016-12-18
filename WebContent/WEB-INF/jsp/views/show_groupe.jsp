<%@ include file="/WEB-INF/jsp/templates/header.jsp"%>
<%@ include file="/WEB-INF/jsp/templates/nav_bar.jsp"%>


<div class="container">

	<h1>Annuaire d'Aix-Marseille Université</h1>
	
	<a href="" onclick="javascript:window.history.go(-1)" class="noStyle gras"><span class="glyphicon glyphicon-chevron-left"></span>Retour</a>
	
	<h4>${group.name}</h4>
	<p>Id du groupe: ${group.id}</p>

	<h3>Personnes présente dans le groupe:</h3>
    <%@ include file="/WEB-INF/jsp/templates/person_list.jsp" %>

</div>	  
	  
<%@ include file="/WEB-INF/jsp/templates/footer.jsp" %>