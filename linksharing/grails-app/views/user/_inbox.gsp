<%@ page import="co.SearchCO" %>
<div class="col-lg-6">
    <div class="panel panel-primary ">
        <div class="panel-heading">Inbox</div>
        <g:each in="${unReadResourcesList}" var="unReadResources">
            <div class="panel-body">
                <div class="col-lg-12">
                    <div class="col-sm-3">
                        <ls:userImage username="${unReadResources.ownerUsername}" height="100" width="100"/>
                    </div>

                    <div class="col-lg-9">
                        <p>${unReadResources.ownerName}  <span
                                style="color: darkgray">@${unReadResources.ownerUsername}</span>
                            <span class="pull-right"
                                  style="margin-right: 0px;color: #007efc;font-size: small"><a href="${createLink(controller: 'topic', action: 'show',id: unReadResources.topicId)}">${unReadResources.topicName}</a></span>
                        </p>

                        <p>${unReadResources.resourceDescription}</p>

                        <i class="fa fa-facebook-official fa-lg" aria-hidden="true"></i>
                        <i class="fa fa-google fa-lg" aria-hidden="true"></i>
                        <i class="fa fa-twitter fa-lg" aria-hidden="true"></i>
                        <span class="pull-right" style="margin-right: 0px;color: #007efc">
                            <g:if test="${unReadResourcesList.isLink}">
                                <a href="${createLink(controller: 'resource',action: 'showLink', id:unReadResources.resourceId)}" controller="download" action="index"
                                   style="color: #007efc">View Link</a>
                            </g:if>
                            <g:else>
                                <a href="${createLink(controller: 'resource',action: 'downloadDocument', id:unReadResources.resourceId)}" controller="download" action="index"
                                   style="color: #007efc">Download</a>
                            </g:else>
                            <g:link controller="readingItem" action="changeisRead" params="${[id:unReadResources.readingItemId]}">Mark Read</g:link>
                            <a href="${createLink(controller:'resource',action:'showPost',id:unReadResources.resourceId)}">View Post</a>
                        </span>

                    </div>
                </div>
            </div>
        </g:each>
    </div>

</div>