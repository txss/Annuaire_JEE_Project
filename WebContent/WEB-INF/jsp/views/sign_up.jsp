<%@ include file="/WEB-INF/jsp/templates/header.jsp"%>
<%@ include file="/WEB-INF/jsp/templates/nav_bar.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="container">

	<div class="col-md-offset-3 col-md-8">
	
		<small class="errors help-block">${error}</small>
		 
		<form:form method="POST" commandName="personne">
			<table>
			    <form:hidden path="id" value="null"/>
			    <tr>
			        <td><label for="firstName">Prénom:</label></td>
			        <td>
			        	<div class="form-group">
			        		<form:input path="firstName" class="form-control"/>
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
			        		<form:input path="lastName" class="form-control"/>
			        	</div>
			        </td>
			        <td>
			        	<small class="errors help-block"><form:errors path="lastName" cssClass="error" /></small>
			        </td>
			    </tr>
			    <form:hidden path="birthDate" value="null"/>
			    <tr>
			        <td><label for="email">Email:*</label></td>
			        <td>
			        	<div class="form-group">
			        		<form:input path="email" class="form-control"/>
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
			        		<form:input path="webSite" class="form-control" />
			        	</div>
			        </td>
			        <td>
			        	<small class="errors help-block"><form:errors path="webSite" cssClass="error" /></small>
			        </td>
			    </tr>
			    <form:hidden path="idGroup" value="null"/>
			    <tr>
			        <td><label for="password">Mot de passe:*</label></td>
			        <td>
						<div class="form-group has-feedback pwdGroup">
							<label class="control-label" for="pwd"></label>
							<form:password path="passWord" class="form-control" placeholder="Mot de passe" id="pwd" onkeyup="verifPwd()"/>
						</div>
			        </td>
			        <td>
			        	<small class="errors help-block"><form:errors path="passWord" cssClass="error" /></small>
			        </td>
			    </tr>
			    <tr>
			        <td><label for="passwordConf">Confirmer mot de passe:*</label></td>
			        <td>
			        	<div class="form-group has-feedback pwdGroup">
			        		<label class="control-label" for="confirm"></label>
			        		<input type="password" class="form-control" id="confirm" onkeyup="verifPwd()">
			        	</div>
			        </td>
			    </tr>
			    <tr>
					<td colspan="3">
						<button id="btnSubmit" class="btn btn-primary btn-block" type="submit" >S'inscrire</button>
					</td>
				</tr>
			    </table>
		</form:form>
		
		<small class="errors help-block">Les informations avec une étoile (*) ne sont pas visible par les personnes extérieur à l'annuaire.</small>
	</div>
	
</div>
	  
<script>
	function verifPwd(){
		var pwd =  $( "#pwd").val();
		var confirm = $( "#confirm").val();
		
		if (pwd == confirm){
			$( ".resultConf" ).remove();
			$( "#pwd" ).after('<span class="glyphicon glyphicon-ok form-control-feedback resultConf"></span>' );
			$( "#confirm" ).after('<span class="glyphicon glyphicon-ok form-control-feedback resultConf"></span>' );
			$( ".pwdGroup" ).removeClass( "has-error" ).addClass( "has-success" );
			$( "#confMessage" ).remove();
			$( "#btnSubmit" ).removeAttr( "disabled" );
		}
		
		if (pwd != confirm){
			$( ".resultConf" ).remove();
			$( "#confMessage" ).remove();
			$( "#pwd" ).after('<span class="glyphicon glyphicon-remove form-control-feedback resultConf"></span>' );
			$( "#confirm" ).after('<span class="glyphicon glyphicon-remove form-control-feedback resultConf"></span>' );
			$( "#confirm" ).after('<small id="confMessage" class="errors help-block">Le mot de passe est différent</small>');
			$( ".pwdGroup" ).removeClass( "has-success" ).addClass( "has-error" );
			$( "#btnSubmit" ).attr( 'disabled', "disabled" );
		}
	}

</script>
	  
<%@ include file="/WEB-INF/jsp/templates/footer.jsp" %>