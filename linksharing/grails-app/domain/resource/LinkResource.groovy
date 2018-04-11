package resource

import topic.Topic
import user.User

class LinkResource extends Resource{
    String url

    static constraints = {
        url(unique: true)
    }

    def deleteResource() {
        this.delete(flush: true)
        return true
    }
}
