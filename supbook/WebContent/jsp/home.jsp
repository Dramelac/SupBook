<html>
<head>
	<title>SUPbook : the online student directory</title>
	<link type="text/css" href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" href="<%= request.getContextPath() %>/css/main.css" rel="stylesheet">
    <script src="<%= request.getContextPath() %>/js/jquery-3.2.1.min.js"></script>
    <script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
</head>
<body style="height: 100%">
    <div class="container-fluid">
        <%--mettre les fonctionnalité du menu du haut (barre de recherche, profil, deconnection..)--%>
        <div class="row header">
            <form action="${pageContext.request.contextPath}/HomeServlet" method="post">
                <textarea rows="1" cols="50" title="SearchBar">Search FirstName, LastName </textarea>
                <button type="button">Search</button>
                <a href="<%= request.getContextPath() %>/user/logout">Logout</a><br>
                <a href="<%= request.getContextPath() %>/wall">My wall</a>
            </form>
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
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#publicationModal">
                    Publier
                </button>
            </div>
                <%--partie droite avec les sugestion et les amis--%>
            <div class="col-md-2 suggestion">

            </div>
        </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="publicationModal" tabindex="-1" role="dialog" aria-labelledby="publicationModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="publicationModalLabel">Publication</h4>
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
                    <button id="publish" type="button" class="btn btn-primary">Publier</button>
                </div>
            </div>
        </div>
    </div>




    <script>
        //clear textarea
        $('#publicationModal').on('show.bs.modal', function () {
            $("#comment").val("")
        })

        $(document).on('click', '#publish', function () {
            $("#comment").val()
        })


    </script>
</body>
</html>





