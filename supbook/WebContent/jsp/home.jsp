<html>
<head>
	<title>SUPbook : the online student directory</title>
	<link type="text/css" href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" href="<%= request.getContextPath() %>/css/main.css" rel="stylesheet">
	<script src="<%= request.getContextPath() %>/js/jquery-3.2.1.min.js"></script>
    <script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>

</head>
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
            <form action="/post/submit" method="post">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Publication</h4>
                </div>
                <!--intégration fichier -->
                <div class="form-group">
                    <label for="imageInput">File input</label>
                    <input type="text" class="form-control-file" name="image" id="imageInput" aria-describedby="fileHelp">
                </div>
                <div class="form-group">
                    <textarea name="content" class="form-control" rows="5" id="comment"></textarea>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
                    <input type="submit" class="btn btn-primary" data-dismiss="modal" value="Publier">
                </div>
            </form>
		</div>
	</div>
</div>
<div class="modal-footer" id="mur">
	<textarea id="texte"></textarea>

	<input type="submit" value="Tester !" onclick="javascript:emule(document.getElementById('texte').value);" />
</div>


<script>

	//reload textarea
	$('#myModal').on('comment.bs.modal', function (e) {
		if (!data) return e.preventDefault() // stops modal from being shown
		else
		{

		}
	})
</script>