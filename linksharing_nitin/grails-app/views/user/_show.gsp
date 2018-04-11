<li class="list-group-item" style="height:150px;">
    <div class="panel-body">
        <div class="row">
            <div class="col-md-3">%{--<img src="user.png" height="80" width="80">--}%
            <ls:userImage userId="${user.id}" height="100" width="100"/>
            </div>

            <div class="col-md-9">
                <div class="row"><h4><%=user.name%></h4></div>

                <div class="row">
                    <div class="col-md-6 text-muted">@<%=user.username%></div>

                </div>

                <div class="row">
                    <div class="col-md-6">Subscriptions</div>

                    <div class="col-md-6">Posts</div>
                </div>

                <div class="row">

                    <div class="col-md-6"><ls:subscriptionCount userId="${user.id}"/></div>

                    <div class="col-md-6"><ls:topicCount userId="${user.id}"/></div>
                </div>

            </div>
        </div>
    </div>
</li>