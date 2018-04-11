<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Panel title</h3>
    </div>

    <div class="panel-body">
        <g:form class="form-horizontal" controller="login" action="loginhandler" role="form" name="loginForm">
            <div class="form-group">
                <label class="control-label col-sm-3">Username:</label>

                <div class="col-sm-9">
                    <g:textField name="username" class="form-control" id="username"
                                 placeholder="Enter Username"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-3">Password:</label>

                <div class="col-sm-9">
                    <g:passwordField name="password" type="password" class="form-control" id="password"
                                     placeholder="Enter Password"/>
                </div>
            </div>


            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-6">

                    <a href="#forgotpassword" data-toggle="modal" data-target="#forgotpassword">Forgot Password</a>
                    <g:submitButton name="submit" value="login" formaction="/login/loginhandler"
                                    type="submit" class="btn btn-default">Submit</g:submitButton>
                </div>
            </div>

        </g:form>
    </div>
</div>

<g:render template="/user/forgotPassword"/>