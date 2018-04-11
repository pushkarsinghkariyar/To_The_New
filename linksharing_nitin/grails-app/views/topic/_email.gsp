<div class="modal fade" id="invitation" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="invitationtitle">Send Invitation</h4>
            </div>

            <div class="modal-body">
                <g:form controller="topic" action="invite" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="control-label col-sm-2">Email Id:</label>

                        <div class="col-sm-10">
                            <g:textField type="email" class="form-control" id="email" name="email"
                                         placeholder="Enter email"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2">Topic:</label>

                        <div class="col-sm-10">

                            <ls:showSubscribedTopics/>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <g:submitButton type="submit" name="submit" value="invite"
                                        class="btn btn-primary">Submit</g:submitButton>
                    </div>
                </g:form>
            </div>

        </div>
    </div>
</div>