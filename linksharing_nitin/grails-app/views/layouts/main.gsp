<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Grails"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <asset:stylesheet src="application.css"/>
    <asset:javascript src="jquery-2.2.1.min.js"/>
    <asset:stylesheet src="bootstrap.min.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    %{--<asset:stylesheet src="font-awesome.min.css"/>--}%
    <asset:javascript src="bootstrap.min.js"/>
    <asset:javascript src="application.js"/>
    %{--<asset:javascript src="jquery.validate.js"/>--}%
    <asset:javascript src="jquery.validate.min.js"/>
    <asset:javascript src="additional-methods.min.js"/>

    <g:layoutHead/>
</head>

<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/" style="font-family:trajan pro;font-weight:bold;">Link Sharing<span><img
                    src="/home/nitin/Projects/linksharing/grails-app/assets/images/icon.png"
                    style="height:30px;width:30px"></span></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <g:form class="navbar-form navbar-left" role="search" controller="login" action="globalSearch">
                <div class="form-group">
                    <g:textField type="text" name="q" class="form-control" style="align:center;"
                                 placeholder="Search"/>
                </div>
                <g:submitButton name="submit" type="submit" class="btn btn-default">Submit</g:submitButton>
            </g:form>

            <g:if test="${session.user}">

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#createtopic" data-toggle="modal" data-target="#createtopic" title="Create Topic"><span
                            class="fa fa-comment" style="font-size:20px;"></span></a></li>
                    <li><a href="#invitation" data-toggle="modal" data-target="#invitation"
                           title="Send Invitation"><span
                                class="glyphicon glyphicon-envelope" style="font-size:20px"></span></a></li>
                    <li><a href="#sharelink" data-toggle="modal" data-target="#sharelink" title="Create Resource"><span
                            class="glyphicon glyphicon-link" style="font-size:20px"></span></a></li>
                    <li><a href="#sharedoc" data-toggle="modal" data-target="#sharedoc " title="Share Document"><span
                            class="fa fa-file" style="font-size:20px"></span></a></li>


                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">
                            <span class="glyphicon glyphicon-user"
                                  style="font-size:20px;color:black;"></span>${session.user.username} <span
                                class="caret"></span></a>
                        <ul class="dropdown-menu">
                            %{--<li><g:link controller="user" action="profile"
                                        params="[id: session.user.id]">Profile</g:link></li>--}%
                            <li><g:link controller="user" action="list">Users</g:link></li>
                            <li><g:link controller="user" action="showEditProfile">Edit Profile</g:link></li>
                            <li role="separator" class="divider"></li>
                            <li><g:link controller="login" action="logout">Logout</g:link></li>
                        </ul>
                    </li>
                </ul>
                <g:render template="/topic/create"/>
                <g:render template="/resource/createDocRes"/>
                <g:render template="/resource/createLinkRes"/>
                <g:render template="/topic/email"/>
            </g:if>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>





<g:if test="${flash.message}">
    <div class="alert alert-success alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
        ${flash.message}
    </div>

</g:if>

<g:if test="${flash.error}">
    <div class="alert alert-danger alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
        ${flash.error}
    </div>

</g:if>

<div class="json" role="alert" style="display:none"></div>


<g:layoutBody/>

</body>

</html>
