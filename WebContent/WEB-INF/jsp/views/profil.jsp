<%@ include file="/WEB-INF/jsp/templates/header.jsp"%>
<%@ include file="/WEB-INF/jsp/templates/nav_bar.jsp"%>


<div class="container">
	<div class="row">
		<h3>Bonjour ${pers.firstName}!</h3>

		<h5>
			Vos informations personnel: <a href="edit"><span
				class="glyphicon glyphicon-pencil"></span></a>
		</h5>

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
					<td><a href="${pers.webSite}">${pers.webSite}</a></td>
				</tr>
			</c:if>
		</table>

		<small class="errors help-block">Les informations avec une
			étoile (*) ne sont pas visible par les personnes extérieur à
			l'annuaire.</small>
	</div>

	<div class="row">
		<a href="/Annuaire/actions/group/add_group" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span> Ajouter un groupe </a>
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#confirmErase"><span class="glyphicon glyphicon-remove" style="color: red;"></span> Effacer mon compte</button>
	</div>
	
</div>

<div class="modal fade" tabindex="-1" role="dialog" id="confirmErase">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">Suppression du compte</h4>
			</div>
			<div class="modal-body">
				<div class="alert alert-warning" role="alert">
					<span class="glyphicon glyphicon-warning-sign"
						style="color: orange;"></span>
						Cette action sera définitive et ne pourra être annulée.
				</div>
				<p>Vous etes sur le point de supprimer toute les informations
					vous concernant de l'annuaire.</p>
				
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
				<a href="delete" class="btn btn-danger">Effacer mes données</a>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<script type="text/javascript">
	$('#confirmErase').on('shown.bs.modal', function() {
	})
</script>


<%@ include file="/WEB-INF/jsp/templates/footer.jsp"%>