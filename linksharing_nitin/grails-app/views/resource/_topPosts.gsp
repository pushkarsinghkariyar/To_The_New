<div class="panel panel-primary">

    <div class="panel-heading" style="height:50px"><div class="col-md-8">Top Posts</div>
    </div>
    <g:each var="resource" in="${topPosts}">
        <g:render template="/resource/show" model="[resource: resource]"/>
    </g:each>
</div>