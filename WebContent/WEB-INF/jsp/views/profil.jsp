<%@ include file="/WEB-INF/jsp/templates/header.jsp" %>
<%@ include file="/WEB-INF/jsp/templates/nav_bar.jsp" %>


<div class="container">
	<div class="row">
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
		 	<c:if test="${pers.birthDate != ''}">
				<tr>
				 	<td>Date de naissance:*</td>
				 	<td>${pers.birthDate}</td>
			 	</tr>
			</c:if>
		 	<c:if test="${pers.idGroup != ''}">
				<tr>
				 	<td>Groupe:</td>
				 	<td>${gr.getName()}</td>
			 	</tr>
			</c:if>
		 	<tr>
			 	<td>Email:*</td>
			 	<td>${pers.email}</td>
		 	</tr>
		 	<c:if test="${pers.webSite != ''}">
				<tr>
				 	<td>Site internet:</td>
				 	<td>${pers.webSite}</td>
		 		</tr>
			</c:if>
		 </table>
		 
		<small class="errors help-block">Les informations avec une étoile (*) ne sont pas visible par les personnes extérieur à l'annuaire.</small>
	</div>
	
	<div class="row">
		<p>Ajouter un groupe <a href="/Annuaire/actions/group/add_group"><span class="glyphicon glyphicon-plus"></span></a></p>
	</div></div>	  
	 
<%@ include file="/WEB-INF/jsp/templates/footer.jsp" %>