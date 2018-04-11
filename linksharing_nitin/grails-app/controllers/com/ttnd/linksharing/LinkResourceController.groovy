package com.ttnd.linksharing

class LinkResourceController extends ResourceController {

    def index() {}

    def save(LinkResource resource) {
        //todo: user null check
        User user = session.user
        resource.createdBy = user
        if (resource.save(flush: true)) {
            addToReadingItems(resource)
            flash.message = "Resource saved Successfully"
        } else {
            flash.error = "Error saving resource"
        }
        redirect(controller: "login", action: "index")

    }

    def update(Long id, String description) {
        Resource resource = Resource.get(id)
        if (description) {
            resource.description = description
        }
        if (resource.save(flush: true)) {
            flash.message = "Resource Updated Successfully"
        } else {

            flash.error = "Failed to update  Resource"
        }
        redirect(controller: "resource", action: "show", params: [id: id])
    }
}
