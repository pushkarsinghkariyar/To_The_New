package com.ttnd.linksharing

import com.ttnd.linksharing.constants.Constants

class DocumentResource extends Resource {
    String filePath
    String contentType
    String fileName
    static transients = ['contentType', 'fileName']

    static constraints = {
        filePath(filePath: true, blank: false)
        contentType(matches: Constants.DOCUMENT_CONTENT_TYPE)
    }

    String toString() {
        "Document Resource filepath: ${filePath}"
    }

    String getFileName() {
        filePath.substring(filePath.lastIndexOf('/'))
    }

    def deleteResource() {
        String path = this.filePath
        Boolean status = new File(path).delete()
        if (status) {
            this.delete(flush: true)
            return true
        }
        return false
    }


}
