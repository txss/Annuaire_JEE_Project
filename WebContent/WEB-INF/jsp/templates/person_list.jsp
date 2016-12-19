
<c:if test="${personnes != null}">
	<ul style="list-style-type: square">
		<c:forEach items="${personnes}" var="person">
			<li><a href="/Annuaire/actions/person/show_person?id=${person.id}">${person.lastName} ${person.firstName} </a></li>
		</c:forEach>
	</ul>
</c:if>
