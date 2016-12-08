<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<a class="navbar-brand" href="accueil">Aix-Marseille Université</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<c:if test="${user != null}">
					<li><a href="profil">Mon profil</a></li>
				</c:if>
				
				<li><a href="person_List">Liste des personnes</a></li>
				<li><a href="groups_List">Liste des groupes</a></li>
			</ul>
			<form class="navbar-form navbar-left">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">Rechercher</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${user == null}">
					<li><a href="login/sign_in">Se connecter</a></li>
				</c:if>
				<c:if test="${user != null}">
					<li><a href="login/logout">Deconnecter</a></li>
				</c:if>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
