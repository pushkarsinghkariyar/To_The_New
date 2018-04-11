<%@ page import="com.ttnd.linksharing.Visibility" %>
<div class="modal fade" id="createtopic" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="createtopicTitle">Create Topic</h4>
            </div>

            <div class="modal-body">
                <g:form class="form-horizontal" controller="topic" action="topicSave" role="form">
                    <div class="form-group">
                        <label class="control-label col-sm-2">Topic Name:</label>

                        <div class="col-sm-10">
                            <g:textField class="form-control" name="topicName" placeholder="Enter Topic Name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2">Topic:</label>

                        <div class="col-sm-10">
                            <g:select class="form-control" name="visibility" from="${Visibility.values()}"
                                      style="height:100px,width:50px"/>

                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        <g:submitButton formaction="/topic/topicSave" type="submit" name="submit" id="createTopicBtn"
                                        value="save"
                                        class="btn btn-primary"/>
                    </div>
                %{--
                                    <g:actionSubmit value="Save" formaction="/topic/topicSave" name="submit"
                                                    class="btn btn-primary"/>--}%
                </g:form>
            </div>

        </div>
    </div>
</div>