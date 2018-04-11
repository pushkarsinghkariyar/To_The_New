<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Welcome</title>
    <meta name="layout" content="main"/>
</head>

<body>
<div class="container">
    %{--Column 1--}%
    <div class="col-md-5">

        <div class="row">
            <g:render template="/user/show" model="[user: session?.user]"/>
        </div><br>
        %{--show subscribed topics of user--}%

        <div class="row">

            <div class="panel panel-primary" id="subscribedTopicDiv">
                <div class="panel-heading">
                    <h3 class="panel-title">Subscribed Topics</h3>
                </div>

                <g:each var="topic" in="${subscribedTopics}">
                    <g:render template="/topic/show" model="[topic: topic]"/>
                </g:each>

            </div>

        </div>


        <ls:trendingTopics/>

    </div>

    %{--Column2--}%
    <div class="col-md-7">

        <g:render template="inbox" model="[readingItems: readingItems]"/>

        <div class="pagination">
            <g:paginate total="${total}" next="next" prev="previous" maxsteps="${readingItems.size()}"
                        controller="user"
                        action="index" max="${co.max}" offset="${co.offset}"/>
        </div>
    </div>

</div>

</body>
</html>