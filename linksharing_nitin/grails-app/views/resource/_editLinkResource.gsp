<div class="modal fade" id="editLink" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="sharelinktitle">Edit Link</h4>
            </div>

            <div class="modal-body">
                <g:form controller="linkResource" action="update" class="form-horizontal" role="form">

                    <div class="form-group">
                        <label class="control-label col-sm-2">Descriptor:</label>

                        <div class="col-sm-10">
                            <g:textArea name="description" class="form-control" value="${resource.description}"
                                        rows="5"></g:textArea>
                            <g:hiddenField name="id" value="${resource.id}"></g:hiddenField>
                        </div>
                    </div>

                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <g:submitButton name="submit" formaction="/linkResource/update" type="submit"
                                    class="btn btn-primary">Save</g:submitButton>
                </g:form>
            </div>

        </div>
    </div>
</div>













