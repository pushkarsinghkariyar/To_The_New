<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Register</h3>
    </div>

    <div class="panel-body">
        <g:uploadForm class="form-horizontal" controller="login" action="register" name="registerForm">
            <div class="form-group">
                <label class="control-label col-sm-3">First name *</label>

                <div class="col-sm-9">
                    <g:textField class="form-control" placeholder="First Name" name="firstName"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-3" for="email">Last name *</label>

                <div class="col-sm-9">
                    <g:textField class="form-control" placeholder="Last Name" name="lastName"/>

                </div>
            </div>


            <div class="form-group">
                <label class="control-label col-sm-3" for="email">Email *</label>

                <div class="col-sm-9">
                    <g:field type="email" class="form-control" placeholder="Email Id" name="email"/>

                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-3" for="email">Username *</label>

                <div class="col-sm-9">
                    <g:textField class="form-control" placeholder="User Name" name="username"/>
                    %{-- <div class="alert-danger">
                         <g:fieldError bean="${user}" field="username"></g:fieldError>
                     </div>--}%
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-3">Password:</label>

                <div class="col-sm-9">
                    <g:field type="password" id="password" class="form-control" placeholder="Password" name="password"/>

                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-3">Confirm Password:</label>

                <div class="col-sm-9">
                    <g:field type="password" class="form-control" placeholder="Password" name="confirmPassword"/>
                </div>
            </div>


            <div class="form-group">
                <label class="control-label col-sm-3" >Photo:</label>

               <input type="file" name="photo" id="photo" class="btn btn-primary col-md-offset-2"/>
                </span>
                </div>
    <div class="form-group">
                <div class="col-sm-offset-3 col-sm-10">
            <g:submitButton name="submit" value="Register and Login"
                            type="submit" class="btn btn-default">Submit</g:submitButton>
            </div>
        </div>

        </g:uploadForm>
    </div>

</div>