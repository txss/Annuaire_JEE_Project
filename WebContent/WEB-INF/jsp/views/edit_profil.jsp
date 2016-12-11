<%@ include file="/WEB-INF/jsp/templates/header.jsp" %>
<%@ include file="/WEB-INF/jsp/templates/nav_bar.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<a href="" onclick="javascript:window.history.go(-1)" class="noStyle gras"><span class="glyphicon glyphicon-chevron-left"></span>Retour</a>
	<h5>Modifier vos informations personnel</h5>
	
	 <small class="errors help-block">${error}</small>
	 
	 <form:form method="POST" commandName="personne">
				    <table>
				    <form:hidden path="id" value="${pers.id}"/>
				    <tr>
				        <td><label for="firstName">Prénom:</label></td>
				        <td>
				        	<div class="form-group">
				        		<form:input path="firstName" class="form-control" value="${pers.firstName}"/>
				        	</div>
				        </td>
				        <td>
				        	<small class="errors help-block"><form:errors path="firstName" cssClass="error" /></small>
				        </td>
				    </tr>
				    <tr>
				        <td><label for="lastName">Nom:</label></td>
				        <td>
				        	<div class="form-group">
				        		<form:input path="lastName" class="form-control" value="${pers.lastName}"/>
				        	</div>
				        </td>
				        <td>
				        	<small class="errors help-block"><form:errors path="lastName" cssClass="error" /></small>
				        </td>
				    </tr>
				    <tr>
				        <td><label for="birthDate">Date de naissance:(JJ/MM/AA):*</label></td>
				        <td>
				        	<div class="form-group">
				        		<form:input path="birthDate" class="form-control" value="${pers.birthDate}"/>
				        	</div>
				        </td>
				        <td>
				        	<small class="errors help-block"><form:errors path="birthDate" cssClass="error" /></small>
				        </td>
				    </tr>
				    <tr>
				        <td><label for="email">Email:*</label></td>
				        <td>
				        	<div class="form-group">
				        		<form:input path="email" class="form-control" value="${pers.email}"/>
				        	</div>
				        </td>
				        <td>
				        	<small class="errors help-block"><form:errors path="email" cssClass="error" /></small>
				        </td>
				    </tr>
				    <tr>
				        <td><label for="webSite">Site web:</label></td>
				        <td>
				        	<div class="form-group">
				        		<form:input path="webSite" class="form-control" value="${pers.webSite}"/>
				        	</div>
				        </td>
				        <td>
				        	<small class="errors help-block"><form:errors path="webSite" cssClass="error" /></small>
				        </td>
				    </tr>
				    <tr>
				        <td><label for="idGroup">Groupe:</label></td>
				        <td>
				        	<div class="form-group">
           						<form:select path="idGroup" multiple="false" class="form-control">
	           						<c:if test="${pers.idGroup != ''}">
	           							<form:option value="${pers.idGroup}" label="${pers.idGroup}" />
									</c:if>
									<c:if test="${pers.idGroup == ''}">
	           							<form:option value="" label="--- Select ---" />
									</c:if>
						            <form:options items="${groupList}" />
						        </form:select>
				        	</div>
				        </td>
				        <td>
				        	<small class="errors help-block"><form:errors path="idGroup" cssClass="error" /></small>
				        </td>
				    </tr>
				    <tr>
				        <td colspan="3">
							Entrez votre mot de passe pour valider les modifications.
						</td>
				    </tr>
				    <tr>
				        <td><label for="password">Password:*</label></td>
				        <td>
				        	<div class="form-group">
				        		<form:password path="passWord" class="form-control" placeholder="Password"/>
				        	</div>
				        </td>
				        <td>
				        	<small class="errors help-block"><form:errors path="passWord" cssClass="error" /></small>
				        </td>
				    </tr>
				    <tr>
						<td colspan="3">
							<button class="btn btn-primary btn-block" type="submit">Enregistrer</button>
						</td>
					</tr>
				    </table>
				</form:form>
	 
	<small class="errors help-block">Les informations avec une étoile (*) ne sont pas visible par les personnes extérieur à l'annuaire.</small>
</div>	  
	 
<%@ include file="/WEB-INF/jsp/templates/footer.jsp" %>