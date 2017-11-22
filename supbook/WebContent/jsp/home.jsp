<html>
<head>
	<title>SUPbook : the online student directory</title>
	<link type="text/css" href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" href="<%= request.getContextPath() %>/css/main.css" rel="stylesheet">
    <script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
    <script src="<%= request.getContextPath() %>/js/jquery-3.2.1.min.js"></script>
</head>
<body style="height: 100%">
    <div class="container-fluid">
        <%--mettre les fonctionnalité du menu du haut (barre de recherche, profil, deconnection..)--%>
        <div class="row header">
        </div>
        <%--contenu en dessous du menu   --%>
        <div class="row contenu " >
            <%--partie gauche avec liste d'ami--%>
            <div class="col-md-2 liste_ami" *>
                <div class="row col-md-12 titre_liste_ami">
                    <span>Liste d'ami</span>
                    <button>ajout</button>
                </div>
            </div>
                <%--partie centre avec le fil de publication--%>
            <div class="col-md-8 publication">
                <span>test</span>
            </div>
                <%--partie droite avec les sugestion et les amis--%>
            <div class="col-md-2 suggestion">

            </div>
        </div>
    </div>
<body>
	<table>
		<tr>
			<td valign="top">
			<h1>BackOffice SUPBook</h1>
		</td>
		<td>
			<form action="${pageContext.request.contextPath}/HomeServlet" method="post">
				<textarea rows="1" cols="50" title="SearchBar">Search FirstName, LastName </textarea>
				<button type="button">Search</button>
			</form>
		</td>
		<a href="<%= request.getContextPath() %>/user/logout">Logout</a><br>
        <a href="<%= request.getContextPath() %>/wall">My wall</a>
	</tr>
</table>
</body>
</html>


<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
	Publier
</button>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel">Publication</h4>
			</div>
			<!--intégration fichier -->
			<div class="form-group">
				<label for="exampleInputFile">File input</label>
				<input type="file" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp">
			</div>
			<div class="form-group">
				<textarea class="form-control" rows="5" id="comment"></textarea>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
				<button id="publish" type="button" class="btn btn-primary"onClick="history.go(0)" VALUE="Refresh">Publier</button>
			</div>
		</div>
	</div>
</div>



<script>

	//reload textarea
	$('#publish').click(function() {
		//if (!data) return e.preventDefault() // stops modal from being shown
		//else
			var toto = $('#comment').val();
			console.log(toto);
			$('#comment').val("");
			$("texte").html($(toto));
	});

</script>