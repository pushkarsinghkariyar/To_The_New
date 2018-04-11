<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main">
</head>

<body>

<div class="container-fluid">

    <div class="col-md-5">

        <ls:trendingTopics/>

        <ls:topPosts/>

    </div>

    <div class="col-md-7">
        <div class="panel panel-primary">

            <div class="panel-heading" style="height:50px"><div class="col-md-4">Resources</div>

            </div>

            <div class="panel-body">
                <g:each in="${resources}" var="resource">
                    <g:render template="/resource/show" model="[resource: resource]"/>
                </g:each>

            </div>

            <div class="pagination"><g:paginate total="${total}" next="next" prev="previous"
                                                maxsteps="${resources.size()}"
                                                controller="login"
                                                action="globalSearch" max="${co.max}" offset="${co.offset}"
                                                params="[q: co.q]"/></div>
        </div>

    </div>

</div>

</body>
</html>