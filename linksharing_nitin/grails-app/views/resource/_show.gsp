<li class="list-group-item" style="height:120px;">
    <div class="row">
        <div class="col-md-3"><ls:userImage userId="${resource.createdBy.id}" height="100" width="100"/></div>

        <div class="col-md-9">
            <div class="row"><g:link controller="user" action="profile"
                                     params="[id: resource.createdBy.id]">${resource.createdBy.name}</g:link>
                <inline class="text-muted">@${resource.createdBy.username} %{--${resource.dateCreated}--}%
                <g:formatDate format=" HH:mm dd/MM/yyyy" date="${resource.dateCreated}"/>
                </inline>
                <g:link controller="topic" action="show"
                        params="[topicId: resource.topic.id]">${resource.topic.name}</g:link>
            </div>

            <div class="row"><p>${resource.description}</p>
            </div>

            <div class="row">
                <div class="col-md-3">
                    <inline class="fa fa-facebook-square" style="font-size:15px"/>
                    <inline class="fa fa-tumblr" style="font-size:15px"/>
                    <inline class="fa fa-google-plus" style="font-size:15px"/>
                </div>

                <div class="col-md-9" style="text-align:right">
                    <ls:downloadOrView resourceId="${resource.id}"/>
                    <ls:markRead resource="${resource}"/>
                    <g:link controller="resource" action="show" params="[id: resource.id]">View Post</g:link>
                </div>
            </div>

        </div>

    </div>

</li>



