<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>User Login</title>
    <meta name="layout" content="main"/>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <!--First Column-->
        <div class="container-fluid col-lg-6">
            <!-- Recent Shares -->
            <div class="panel panel-primary">

                <div class="panel-heading">Recent Posts

                </div>

                <g:each var="resource" in="${recentPosts}">
                    <g:render template="/resource/show" model="[resource: resource]"/>
                </g:each>

            </div>




            <!--  Recent Shares-->

            <!-- Top Posts -->

            <ls:topPosts/>
            <!--  Top Posts-->

        </div>

        <!--Second Column-->

        <div class="container-fluid col-lg-6">

            <g:render template="/user/login"/>

            <g:render template="/user/register"/>

        </div>
    </div>
</div>

</body>
</html>