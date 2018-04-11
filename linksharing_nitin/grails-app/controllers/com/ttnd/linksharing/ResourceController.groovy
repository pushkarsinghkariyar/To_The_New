package com.ttnd.linksharing

import com.ttnd.linksharing.co.ResourceSearchCO

class ResourceController {
    def grailsApplication

    def index() {
    }

    def delete(Long id) {

        User user = session.user
        if (user.canDeleteResource(id)) {
            Resource resource = Resource.load(id)
            try {
                if (resource.deleteResource()) {
                    flash.message = "Resource deleted Successfully"
                } else {
                    flash.error = "Resource not deleted"
                }

            } catch (Exception e) {
                log.error "Error : ${e.message}"
                render "Resource can't be deleted"
            }
        } else {
            flash.error = "Resource deletion not allowed"
        }
        redirect(uri: '/')
    }


    def search(ResourceSearchCO co) {
        //todo: null check
        if (co.q) {
            co.visibility = Visibility.PUBLIC
            List<Resource> resources = Resource.search(co).list()
            if (resources) {
                render resources
            } else {
                render "No Resources Found"
            }
        }
    }

    def show(Long id) {
        Resource resource = Resource.get(id)
        if (resource.canViewedBy(session.user)) {
            render(view: "resourceShow", model: [resource: resource])
        } else {
            render "Unauthorized Access"
        }
    }

    def addToReadingItems(Resource resource) {

        ReadingItem readingItem
        Topic topic = resource.topic
        List<User> subscribedUsers = topic.getSubscribedUsers()
        subscribedUsers.each { user ->
            if (user.id == resource.createdBy.id) {
                readingItem = new ReadingItem(user: user, resource: resource, isRead: true)
            } else {
                readingItem = new ReadingItem(user: user, resource: resource, isRead: false)
            }
            if (readingItem.save(flush: true)) {
                log.info "ReadingItem added successfully"
            }

        }


    }
}
