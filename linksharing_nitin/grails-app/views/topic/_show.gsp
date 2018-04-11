<%@ page import="com.ttnd.linksharing.Visibility" %>

<div class="panel-body topicBox">
    <div class="row">
        <div class="col-md-3"><ls:userImage userId="${topic.createdBy.id}" height="100" width="100"/></div>

        <div class="col-md-9">
            <div class="row"><h4>
                <g:link controller="topic" action="show"
                        params="[topicId: topic.id]"><%=topic.name%></g:link>
                (<%=topic.visibility%>)</h4>

                <div style="display: none" class="edit">

                    <g:textField name="name" value="${topic.name}" class="editTextBox"/>
                    <g:hiddenField name="topic.id" value="${topic.id}" class="editTopicId"/>
                    <g:submitButton value="submit" type="submit" name="save${topic.id}"
                                    class="btn btn-primary btn-sm editTitleSave">Save</g:submitButton>
                    <button value="cancel" type="submit"
                            class="btn btn-primary btn-sm editTitleCancel">Cancel</button>

                </div>
            </div>

            <div class="row">
                <div class="col-md-6 text-muted">@<%=topic.createdBy.username%></div>

                <div class="col-md-6"><ls:showSubscribe topicId="${topic.id}"/></div>
            </div>

            <div class="row">
                <div class="col-md-6">Subscriptions</div>

                <div class="col-md-6">Posts</div>
            </div>


            <div class="row">

                <div class="col-md-6"><ls:subscriptionCount topicId="${topic.id}"/></div>

                <div class="col-md-6"><ls:resourceCount topicId="${topic.id}"/></div>
            </div>


            <div class="row">

                <div class="col-md-12">
                    <ls:showSeriousness topicId="${topic.id}" userId="${session.user?.id}"/>

                    <ls:canUpdateTopic topicId="${topic.id}" userId="${session.user?.id}">
                        <ls:showVisibility topicId="${topic.id}"/>
                        <span class="fa fa-pencil-square-o editButton" style="font-size: 25px"></span>
                        <g:link controller="topic" action="topicDelete"
                                params="[id: topic.id]"><span class="fa fa-trash"
                                                              style="font-size: 25px"></span></g:link>
                    </ls:canUpdateTopic>

                </div>

            </div>

        </div>
    </div>
</div>

<hr>