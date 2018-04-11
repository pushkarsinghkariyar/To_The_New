<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Users</title>
    <meta name="layout" content="main">

</head>

<body>
<div class="panel panel-default panel-primary">
    <div class="panel-heading">
        <div class="row">
            <div class="col-md-3">
                Users
            </div>


            <div class="col-md-8">
                <g:form name="adminUsersSearchForm" class="form-inline" controller="user" action="list">
                    <div class="form-group col-md-3">
                        <div class="input-group">
                            <select name="active" id="active" class="btn btn-primary">
                                <option value="${null}">All users</option>
                                <option value="${true}">Active users</option>
                                <option value="${false}">Inactive users</option>
                            </select>
                        </div>
                    </div>

                    <div class="col-md-6"  pull-right>
                        <g:textField name="q" type="text" class="form-control" id="q" placeholder="Search"/>
                        <button type="submit" name="submit" value="submit" class="btn btn-primary">Search</button>

                    </div>
                </g:form>
            </div>

        </div>
    </div>

    <div class="panel-body">
        <div>
            <table class="table table-condensed table-hover">
                <thead>
                <tr>
                    <g:sortableColumn property="id" title="Id"/>
                    <g:sortableColumn property="username" title="UserName"/>
                    <g:sortableColumn property="email" title="email"/>
                    <g:sortableColumn property="firstName" title="FirstName"/>
                    <g:sortableColumn property="lastName" title="LastName"/>
                    <g:sortableColumn property="active" title="Active"/>
                    <th>Manage</th>
                </tr>
                </thead>

                <g:each in="${users}" var="user">
                    <g:if test="${user.active}">
                        <g:set var="alertClass" value="alert alert-success"/>
                    </g:if>
                    <g:else>
                        <g:set var="alertClass" value="alert alert-danger"/>
                    </g:else>


                    <tr class="${alertClass}">
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.active}</td>
                        <td>
                            <g:if test="${user.active}">
                                <g:link controller="user" action="toggleActive"
                                        params="[id: user.id]">Deactivate</g:link>
                            </g:if>

                            <g:else>
                                <g:link controller="user" action="toggleActive"
                                        params="[id: user.id]">Activate</g:link>
                            </g:else>

                        </td>
                    </tr>

                </g:each>

            </table>

            <div class="pagination">
                <g:paginate controller="user" action="list" max="${co.max}" offset="${co.offset}" next="next"
                            prev="previous" maxsteps="${users.size()}" total="${total}"></g:paginate>
            </div>

        </div>
    </div>
</div>
</body>
</html>