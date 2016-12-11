<%@ include file="/WEB-INF/jsp/templates/header.jsp" %>
<%@ include file="/WEB-INF/jsp/templates/nav_bar.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<div class="container">
	<a href="" onclick="javascript:window.history.go(-1)" class="noStyle gras"><span class="glyphicon glyphicon-chevron-left"></span>Retour</a>
	<h5>Ajouter un groupe</h5>
		 <form:form method="POST" commandName="groupPersonnes">
				    <table>
				    <tr>
				        <td><label for="name">Nom:</label></td>
				        <td>
				        	<div class="form-group">
				        		<form:input path="name" class="form-control" placeholder="Nom"/>
				        	</div>
				        </td>
				        <td>
				        	<small class="errors help-block"><form:errors path="name" cssClass="error" /></small>
				        </td>
				    </tr>
				    <tr>
						<td colspan="3">
							<button class="btn btn-primary btn-block" type="submit">Enregistrer</button>
						</td>
					</tr>
				    </table>
				</form:form>
	
	</div>	  
	 
<%@ include file="/WEB-INF/jsp/templates/footer.jsp" %>