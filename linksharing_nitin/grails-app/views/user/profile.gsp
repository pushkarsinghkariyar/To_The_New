<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main"/>
    <script>
        $(document).ready(function () {
            $.ajax({
                url: "/user/topics",
                data: {
                    id: $('#userId').val()
                },
                success: function (result) {
                    $('#topicsPanel').html(result);
                }
            });

            $.ajax({
                url: "/user/subscriptions",
                data: {id: $("#userId").val()},
                success: function (result) {
                    $('#subscribedTopics').html(result)
                }
            });


        });
    </script>
</head>

<body>
<div class="container">
    <div class="col-md-5">
        <g:render template="show" model="[user: user]"></g:render>
        <g:hiddenField name="userId" value="${user.id}"/>
        <br>

        <div class="panel panel-primary">
            <div class="panel-heading">Topics</div>

            <div class="panel-body">
                <div id="topicsPanel"></div>
            </div>
        </div>

        <div class="panel panel-primary">
            <div class="panel-heading">Subscriptions</div>

            <div id="12" class="panel-body">
                <div id="subscribedTopics"></div>
            </div>
        </div>

    </div>

    <div class="col-md-7">
        <div class="panel panel-primary">
            <div class="panel-heading">Posts</div>

            <div class="panel-body">
                <g:each in="${resources}" var="resource">
                    <g:render template="/resource/show" model="[resource: resource]"/>
                </g:each>

            </div>
        </div>

    </div>
</div>

</body>
</html>