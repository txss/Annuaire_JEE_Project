<%@ include file="/WEB-INF/jsp/templates/header.jsp"%>
<%@ include file="/WEB-INF/jsp/templates/nav_bar.jsp"%>


<div class="container">

	<h1>Annuaire d'Aix-Marseille Université</h1>
	
	<a href="" onclick="javascript:window.history.go(-1)" class="noStyle gras"><span class="glyphicon glyphicon-chevron-left"></span>Retour</a>
 	<table id="infos_per">
	 	<tr>
		 	<td>Nom:</td>
		 	<td>${showPers.lastName}</td>
	 	</tr>
	 	<tr>
		 	<td>Prénom:</td>
		 	<td>${showPers.firstName}</td>
	 	</tr>
	 	<c:if test="${user != null}">
			<tr>
			 	<td>Date de naissance:</td>
			 	<td>${showPers.birthDate}</td>
	 		</tr>
		</c:if>
	 	<tr>
		 	<td>Groupe:</td>
		 	<td>${showPers.idGroup}</td>
	 	</tr>
	 	<c:if test="${user != null}">
			<tr>
			 	<td>Email:</td>
			 	<td>${showPers.email}</td>
		 	</tr>
		</c:if>
	 	<tr>
		 	<td>Site internet:</td>
		 	<td><a href="${showPers.webSite}">${showPers.webSite}</a></td>
	 	</tr>
	 </table>

</div>	  
	  
<%@ include file="/WEB-INF/jsp/templates/footer.jsp" %>