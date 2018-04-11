<div class="modal fade" id="forgotpassword" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="forgotPasswordTitle">Forgot Password</h4>
            </div>

            <div class="modal-body">
                <g:form class="form-horizontal" controller="login" action="forgotPassword" name="forgotPasswordForm"
                        role="form">
                    <div class="form-group">
                        <label class="control-label col-sm-2">E-mail Id:</label>

                        <div class="col-sm-10">
                            <g:textField class="form-control" name="emailId" id="emailId" placeholder="Enter email address"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-offset-6 col-md-6">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                            <g:submitButton type="submit" name="submit" value="save" class="btn btn-primary"/>
                        </div>
                    </div>
                </g:form>
            </div>

        </div>
    </div>
</div>