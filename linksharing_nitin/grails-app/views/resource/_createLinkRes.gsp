<div class="modal fade" id="sharelink" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="sharelinktitle">Share Link</h4>
            </div>

            <div class="modal-body">
                <g:form controller="linkResource" action="save" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="control-label col-sm-2">Link:</label>

                        <div class="col-sm-10">
                            <g:textField type="text" name="url" class="form-control" placeholder="Enter Link"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2">Descriptor:</label>

                        <div class="col-sm-10">
                            <g:textArea name="description" class="form-control" rows="5"></g:textArea>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2">Topic:</label>

                        <div class="col-sm-10">
                            <ls:showSubscribedTopics/>

                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        <g:submitButton name="submit" formaction="/linkResource/save" type="submit"
                                        class="btn btn-primary">Save</g:submitButton>
                    </div>
                </g:form>
            </div>

        </div>
    </div>
</div>













