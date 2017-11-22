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
</body>
</html>