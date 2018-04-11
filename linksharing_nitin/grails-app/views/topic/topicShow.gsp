<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Topic Details</title>
    <meta name="layout" content="main"/>
</head>

<body>

<div class="container">

    <div class="col-md-5">

        <div class="row">
            <div>

                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Topic: ${topic.name}</h3>
                    </div>

                    <g:render template="/topic/show" model="[topic: topic]"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div>
                <div class="panel panel-primary">

                    <div class="panel-heading">Subscribers

                    </div>

                    <g:each var="user" in="${topic.getSubscribedUsers()}">
                        <g:render template="/user/show" model="[user: user]"/>
                    </g:each>

                </div>

            </div>

        </div>

    </div>


    <div class="col-md-7">

        %{--Panel for posts with a search box--}%


        <div class="panel panel-primary">

            <div class="panel-heading" style="height:50px"><div class="col-md-2">Posts</div>

                <div class="col-md-offset-4 col-md-6" style="text-align:left">
                    <g:form action="show" controller="topic" class="search-form">
                        <div class="form-inline">
                            <g:textField name="q" class="form-control"
                                         placeholder="Description String"/>
                            <g:hiddenField name="topicId" value="${topic.id}"/>
                            <g:submitButton name="submit" value="find" formaction="/topic/show"
                                            type="submit" class="btn btn-default">Find</g:submitButton>
                        </div>

                    </g:form>
                </div>
            </div>


            <g:each var="resource" in="${resources}">
                <g:render template='/resource/show' model="[resource: resource]"/>
            </g:each>
            <div class="pagination">
                <g:paginate total="${total}" maxsteps="${resources.size()}" next="next" prev="prev" max="${co.max}"
                            offset="${co.offset}"
                            action="show" controller="topic" params="[topicId: topic.id]"/>
            </div>
        </div>

    </div>

</div>

</body>
</html>