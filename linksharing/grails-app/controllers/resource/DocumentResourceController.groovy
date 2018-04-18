package resource

import topic.Topic

class DocumentResourceController {

    ResourceService resourceService

    def index() {}

    def save() {
        def file = params.file
        if (!file) {
            flash.message = "File cannot be empty"
        } else {
            DocumentResource documentInstance = new DocumentResource()
            documentInstance.fileName = file.originalFilename
            documentInstance.filepath = grailsApplication.config.uploadFolder + documentInstance.fileName
            documentInstance.createdBy = session.user
            documentInstance.description = params.documentResourceDescription
            println("about to find topic >>>>>>>>>>>>>>>>>>>>>>>>>>>")
            Topic newtopic = Topic.findByName(params.topicNameDocument)
            println("topic found : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>. $newtopic")
            documentInstance.topic = newtopic
            file.transferTo(new File(documentInstance.filepath))
            println("about to save document >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
            if(documentInstance.save(flush:true)){
                log.info("Document Saved Successfully : $documentInstance")
                println "filepath >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +  documentInstance.filepath
            }else{
                log.error("Unable to Save : $documentInstance")
                documentInstance.errors.allErrors.each {println it}
            }
        }
        redirect(controller: 'user', action: 'index')
    }

    def list() {
        params.max = 10
        [documentInstanceList: DocumentResource.list(params), documentInstanceTotal: DocumentResource.count()]
    }
}