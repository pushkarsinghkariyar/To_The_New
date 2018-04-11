<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit Profile</title>
    <meta name="layout" content="main"/>
    <script>
        $(document).ready(function () {
            $.ajax({
                url: "/user/topics",
                data: {
                    id: $('#userId').val()
                },
                success: function (result) {
                    $('#userTopics').html(result);
                }
            });


        });
    </script>
</head>

<body>

<div class="container-fluid">

    <div class="col-md-5">

        <g:render template="show"/>
        <br>

        <g:hiddenField name="userId" value="${user.id}"/>

        <div class="panel panel-primary">
            <div class="panel-heading">Topics</div>

            <div id="12" class="panel-body" style="overflow-y: auto;height: 370px">
                <div id="userTopics"></div>
            </div>
        </div>

    </div>


    <div class="col-md-7">
        %{--for change profile details--}%
        <div class="row">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Register</h3>
                </div>

                <div class="panel-body">
                    <g:uploadForm class="form-horizontal" controller="user" action="save">
                        <g:hiddenField name="email" id="email" value="${user.email}"/>
                        <div class="form-group">
                            <label class="control-label col-sm-3">First name *</label>

                            <div class="col-sm-9">
                                <g:textField class="form-control" value="${user.firstName}" name=" firstName"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-3">Last name *</label>

                            <div class="col-sm-9">
                                <g:textField class="form-control" value="${user.lastName}" name=" lastName"/>

                            </div>
                        </div>


                        <div class="form-group">
                            <label class="control-label col-sm-3">Username *</label>

                            <div class="col-sm-9">
                                <g:textField class="form-control" value="${user.username}" name="username"
                                             disabled="true"/>

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-3">Photo:</label>

                            <div class="col-sm-9">
                                <input type="file" name="photo" id="photo" class="btn btn-primary"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-10">
                                <g:submitButton name="submit" value="Update"
                                                type="submit" class="btn btn-default">Update</g:submitButton>
                            </div>
                        </div>

                    </g:uploadForm>
                </div>

            </div>
        </div>


        %{--for change password--}%
        <div class="row">

            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Change Password</h3>
                </div>

                <div class="panel-body">
                    <g:form class="form-horizontal" controller="user" action="updatePassword" name="changePassword">
                        <g:hiddenField name="id" value="${session.user.id}"/>
                        <div class="form-group">
                            <label class="control-label col-sm-3">Old Password:</label>

                            <div class="col-sm-9">
                                <g:field type="password" id="oldPassword" class="form-control"
                                         placeholder="Old Password"
                                         name="oldPassword"/>

                            </div>
                        </div>


                        <div class="form-group">
                            <label class="control-label col-sm-3">Password:</label>

                            <div class="col-sm-9">
                                <g:field type="password" id="password" class="form-control" placeholder="Password"
                                         name="password"/>

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-3">Confirm Password:</label>

                            <div class="col-sm-9">
                                <g:field type="password" class="form-control" placeholder="Password"
                                         name="confirmPassword"/>
                            </div>
                        </div>

                        <div class="col-sm-offset-3 col-sm-10">
                            <g:submitButton name="submit" value="Update"
                                            type="submit" class="btn btn-default">Update</g:submitButton>
                        </div>
                    </g:form>

                </div>
            </div>

        </div>

    </div>

</div>

</body>
</html>