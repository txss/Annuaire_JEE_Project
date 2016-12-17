
<c:if test="${personnes != null}">
	<ul style="list-style-type: square">
		<c:forEach items="${personnes}" var="person">
			<li><a href="/Annuaire/actions/person/show_person?id=${person.id}">${person.lastName} ${person.firstName} </a></li>
		</c:forEach>
	</ul>
</c:if>

<c:if test="${personnes == null}">
	<p>Il n'y a aucune personne dans l'annuaire pour moment..</p><br/>
	<p>Soyez la permiére: <a herf="/Annuaire/actions/login/sign_up">sign_up</a></p>
</c:if>