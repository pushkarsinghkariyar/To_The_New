<div class="modal fade" id="sharedoc" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="sharedocTitle">Share Document</h4>
            </div>

            <div class="modal-body">
                <g:form controller="documentResource" action="save" class="form-horizontal"
                        enctype="multipart/form-data">
                    <div class="form-group">
                        <label class="control-label col-sm-2">Select Document:</label>


                        <div class="col-sm-4">
                            <input type="file" name="documentResource" class="btn btn-primary"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="Descriptor">Description:</label>

                        <div class="col-sm-10">
                            <g:textArea name="description" class="form-control" rows="5" id="descriptor"></g:textArea>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2">Topic:</label>

                        <div class="col-sm-10">
                            <ls:showSubscribedTopics/>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default"
                                data-dismiss="modal">Cancel</button>
                        <g:submitButton name="submit" type="submit"
                                        class="btn btn-primary"
                                        formaction="/documentResource/save">Save</g:submitButton>
                    </div>
                </g:form>
            </div>

        </div>
    </div>
</div>