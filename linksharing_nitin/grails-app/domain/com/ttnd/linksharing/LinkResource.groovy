package com.ttnd.linksharing

class LinkResource extends Resource {
    String url
    static constraints = {
        url(url: true, blank: false)
    }

    String toString() {
        "Link Resource url: ${url}"
    }

    def deleteResource() {
        this.delete(flush: true)
        return true
    }
}
