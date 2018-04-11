<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Resource Show | Post</title>
    <meta name="layout" content="main">
</head>

<body>

<div class="container">
    <div class="col-md-6">

        <div class="panel panel-primary">
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-3"><ls:userImage userId="${resource.createdBy.id}" height="100"
                                                        width="100"/></div>

                    <div class="col-md-4"><div class="row">${resource.createdBy}</div>

                        <div class="row text-muted">@${resource.createdBy.username}</div>
                    </div>

                    <div class="col-md-5" style="text-align:center"><div class="row"><g:link controller="topic"
                                                                                             action="show"
                                                                                             params="[topicId: resource.topic.id]">
                        ${resource.topic.name}</g:link>
                    </div>

                        <div class="row text-muted">${resource.dateCreated}</div>

                        <div class="row">

                            <g:if test="${session.user}">
                                <g:form controller="resourceRating" action="save">
                                    <g:hiddenField name="resourceId" value="${resource.id}"/>
                                    <g:select name="rating" from="[1, 2, 3, 4, 5]" accesskey="${it}"/>
                                    <g:submitButton value="Rate" name="submit">Rate</g:submitButton>
                                </g:form>
                            </g:if>

                        </div>
                    </div>
                </div>

                <div class="row"><p style="margin:10px">
                    ${resource.description}
                </p>

                </div>

                <div class="row"><div class="col-md-3">
                     <inline class="fa fa-facebook-square" style="font-size:25px">
                         <inline class="fa fa-tumblr" style="font-size:25px">
                             <inline class="fa fa-google-plus" style="font-size:25px">
                </div>

                    <div class="col-md-9" style="text-align:right">
                        <ls:downloadOrView resourceId="${resource.id}"/>
                        <g:if test="${session.user}">
                            <a href="#editLink" data-toggle="modal" data-target="#editLink"
                               title="Send Invitation">Edit</a>

                            <g:render template="editLinkResource" model="[resource: resource]"/>
                            <ls:canDeleteResource resourceId="${resource.id}"/>
                        </g:if>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <div class="col-md-6">
        <ls:trendingTopics/>
    </div>

</div>

</body>
</html>