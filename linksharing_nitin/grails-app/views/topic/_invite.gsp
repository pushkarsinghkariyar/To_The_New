<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <asset:javascript src="jquery.js"/>
    <asset:javascript src="bootstrap.min.js"/>
    <asset:stylesheet src="bootstrap.min.css"/>
</head>
<body>
<div style="text-align: center">
    <div class="container">
        <div class="col-md-12">
            <div class="row">
                <h1>Welcome To Linksharing</h1>
            </div>
            <div class="row">
                <h3>${userName} have invited you to view the topic ${topicName}</h3>
            </div>
            <div class="row">
                <g:createLink base = "${base}" controller="topic" action="join" params="[id: topicId]">Click here to
subscribe</g:createLink>
            </div>
        </div>
    </div>
</div>
</body>