Hello,<b>${user.name}</b><br>
You have following unread items:<br>
<table border="1px">

    <tr>
        <th>S.No.</th>
        <th>From Topic</th>
        <th>Creator</th>
    </tr>

    <g:each var="resource" in="${unreadResources}" status="i">
        <tr>
            <td>${i + 1}</td>
            <td><b>${resource.topic}</b></td>
            <td class="text-muted">@${resource.topic.createdBy.username}</td>
        </tr>
    </g:each>

</table>
