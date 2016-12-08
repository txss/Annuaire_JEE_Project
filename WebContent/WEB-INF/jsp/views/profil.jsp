<%@ include file="/WEB-INF/jsp/templates/header.jsp" %>
<%@ include file="/WEB-INF/jsp/templates/nav_bar.jsp" %>


<div class="container">

	<h3>Bonjour ${pers.firstName}!</h3>
	
	<h5>Vos informations personnel: <a href="edit"><span class="glyphicon glyphicon-pencil"></span></a></h5>

	 <table id="infos_perso">
	 	<tr>
		 	<td>Nom:</td>
		 	<td>${pers.lastName}</td>
	 	</tr>
	 	<tr>
		 	<td>Prénom:</td>
		 	<td>${pers.firstName}</td>
	 	</tr>
	 	<tr>
		 	<td>Date de naissance:*</td>
		 	<td>${pers.birthDate}</td>
	 	</tr>
	 	<tr>
		 	<td>Groupe:</td>
		 	<td>${pers.idGroup}</td>
	 	</tr>
	 	<tr>
		 	<td>Email:*</td>
		 	<td>${pers.email}</td>
	 	</tr>
	 	<tr>
		 	<td>Site internet:</td>
		 	<td>${pers.webSite}</td>
	 	</tr>
	 </table>
	 
	<small class="errors help-block">Les informations avec une étoile (*) ne sont pas visible par les personnes extérieur à l'annuaire.</small>
</div>	  
	 
<%@ include file="/WEB-INF/jsp/templates/footer.jsp" %>