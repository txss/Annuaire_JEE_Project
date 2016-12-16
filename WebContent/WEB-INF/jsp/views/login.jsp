<%@ include file="/WEB-INF/jsp/templates/header.jsp" %>
<%@ include file="/WEB-INF/jsp/templates/nav_bar.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3>Connectez vous pour utiliser l'application</h3>

<div class="container" id="login_panel">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h4 class="text-center login-title">Annuaire AMU</h4>
            
             <c:if test="${success == true}">
           		<div class="alert alert-success centre" role="alert">
					<small class="errors"><span class="glyphicon glyphicon-ok" style="color:orange;"></span> Votre compte a bien été crée.</small>
				</div>
			</c:if>
            
            <c:if test="${erase == true}">
           		<div class="alert alert-success centre" role="alert">
					<small class="errors"><span class="glyphicon glyphicon-ok" style="color:orange;"></span> Votre compte a bien étais supprimé.</small>
				</div>
			</c:if>
            
            <c:if test="${erreur == true}">
           		<div class="alert alert-danger centre" role="alert">
					<small class="errors"><span class="glyphicon glyphicon-warning-sign" style="color:orange;"></span> Identifiant ou mot de passe incorect.</small>
				</div>
			</c:if>
            
            <div class="account-wall">
                
                <form:form method="POST" commandName="login">
				    <table>
				    <tr>
				        <td><label for="email">Email:</label></td>
				        <td>
				        	<div class="form-group">
				        		<form:input path="email" class="form-control" placeholder="Email"/>
				        	</div>
				        </td>
				        <td>
				        	<small class="errors help-block"><form:errors path="email" cssClass="error" /></small>
				        </td>
				    </tr>
				    <tr>
				        <td><label for="password">Password:</label></td>
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
							<button class="btn btn-primary btn-block" type="submit">Se connecter</button>
						</td>
					</tr>
				    </table>
				</form:form>
				<a href="sign_up">Sign up</a>
            </div>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/jsp/templates/footer.jsp" %>