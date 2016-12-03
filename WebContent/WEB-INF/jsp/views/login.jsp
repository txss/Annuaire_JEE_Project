<%@ include file="/WEB-INF/jsp/templates/header.jsp" %>

<h3>Connectez vous pour utiliser l'application</h3>

<div class="container" id="login_panel">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h4 class="text-center login-title">Annuaire AMU</h1>
            <div class="account-wall">
                <form class="form-signin" url="">
	                <input type="text" class="form-control" placeholder="Email" required autofocus>
	                <input type="password" class="form-control" placeholder="Password" required>
	                <button class="btn btn-lg btn-primary btn-block" type="submit">Se connecter</button>
                </form>
            </div>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/jsp/templates/footer.jsp" %>