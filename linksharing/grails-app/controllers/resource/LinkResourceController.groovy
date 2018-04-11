package resource

import topic.Topic

class LinkResourceController {

    ResourceService resourceService

    def index() {}

    def save() {
        params.createdBy=session.user
        if(resourceService.saveLinkResource(params)){
            flash.message = "LINK RESOURCE SAVED"
        }
        else{
            flash.message = "ERROR"
        }
        redirect(controller: 'user', action: 'index')
    }
}
