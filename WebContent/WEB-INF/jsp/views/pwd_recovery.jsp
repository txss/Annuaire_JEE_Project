<%@ include file="/WEB-INF/jsp/templates/header.jsp"%>
<%@ include file="/WEB-INF/jsp/templates/nav_bar.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="container">

	<p>Entrez votre email pour récupérer votre mot de passe</p><br/>
	
	<div class="account-wall">
		<form:form method="POST" commandName="login">
			<table>
				<tr>
					<td><label for="email">Email:</label></td>
					<td>
						<div class="form-group">
							<form:input path="email" class="form-control" placeholder="Email" />
						</div>
					</td>
					<td><small class="errors help-block"><form:errors
								path="email" cssClass="error" /></small></td>
				</tr>
				<form:hidden path="passWord" value="Password"/>
				<tr>
					<td colspan="3">
						<button class="btn btn-primary btn-block" type="submit">Envoyer un email à cette adresse</button>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
	
</div>

<%@ include file="/WEB-INF/jsp/templates/footer.jsp"%>