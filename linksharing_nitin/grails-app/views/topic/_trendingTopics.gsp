<div class="row" id="trendingTopicDiv">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">Trending Topics</h3>
        </div>
        <g:each var="topic" in="${trendingTopics}">
            <g:render template="/topic/show" model="[topic: topic]"></g:render>

        </g:each>
    </div>
</div>