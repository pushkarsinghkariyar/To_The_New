<div class="panel panel-primary">

    <div class="panel-heading" style="height:50px"><div class="col-md-4">Inbox</div>

        <div class="col-md-offset-2 col-md-6" style="text-align:left">
        </div>
    </div>


    <g:each in="${readingItems}" var="readingItem">
        <g:render template="/resource/show" model="[resource: readingItem.resource]"/>
    </g:each>
</div>
