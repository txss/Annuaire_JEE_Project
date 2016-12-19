<%@ include file="/WEB-INF/jsp/templates/header.jsp" %>
<%@ include file="/WEB-INF/jsp/templates/nav_bar.jsp" %>


<div class="container lister">
	<h3>R�sultat de votre recherche (${time}):</h3>
	<c:if test="${personnes == null}">
		<p>Aucun r�sultat trouv�.</p>
	</c:if>
 	<%@ include file="/WEB-INF/jsp/templates/person_list.jsp" %>
</div>	  
	  
<%@ include file="/WEB-INF/jsp/templates/footer.jsp" %>