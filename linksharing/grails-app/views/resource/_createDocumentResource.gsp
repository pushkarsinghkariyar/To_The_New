<div id="myModal4" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Share document</h4>
            </div>

            <div class="modal-body">
                <g:uploadForm class="form-horizontal" controller="DocumentResource" action="save">
                    <div class="form-group">
                        <label class="control-label col-sm-2">Document</label>

                        <div class="col-sm-10">
                            <input type="file" class="form-control" name="file">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2">Description:</label>

                        <div class="col-sm-10">
                            <textarea class="form-control" rows="5"
                                      name="documentResourceDescription" placeholder="Enter Description"></textarea>
                        </div>
                    </div>

                    <div class="dropdown col-lg-12">
                        <div class="col-lg-2">
                            <label clcass="control-label ">Topic:</label>

                        </div>

                        <div class="col-lg-10">
                            <select class="form-control " name="topicName">
                                <g:each in="${session.user.getUserTopics()}" var="topicList">
                                    <option value="${topicList}">${topicList}</option>
                                </g:each>
                            </select>
                        </div>

                    </div>

                    <div class="form-group">
                        <br>

                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Share</button>
                            <button type="button" class="btn btn-default"
                                    data-dismiss="modal">Close</button>

                        </div>
                    </div>
                </g:uploadForm>
            </div>

        </div>

    </div>

</div>