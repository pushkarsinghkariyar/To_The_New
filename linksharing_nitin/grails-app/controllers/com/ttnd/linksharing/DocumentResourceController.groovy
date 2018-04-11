package com.ttnd.linksharing

import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile


class DocumentResourceController extends ResourceController {


    def index() {}

    @Transactional
    def save(DocumentResource documentResource) {
        UUID fileName = UUID.randomUUID()
        //user File.separator instead of '/'
        String path = "${grailsApplication.config.linksharing.documents.folderPath}/${fileName}"
        documentResource.filePath = path
        documentResource.createdBy = session.user
        MultipartFile file = params.documentResource
        File directoryStructure = new File(grailsApplication.config.linksharing.documents.folderPath)
        if (!directoryStructure.exists()) {
            directoryStructure.mkdirs()
        }

        File savedFile = new File(path)
        documentResource.contentType = file.contentType
        documentResource.validate()
        if (documentResource.errors.getFieldError('contentType')) {
            flash.error = "Please upload pdf file"
        } else {
            file.transferTo(savedFile)
            if (documentResource.save(flush: true)) {
                flash.message = "Document saved in database"
                addToReadingItems(documentResource)

            } else {
                flash.error = "could not save document resource"
            }
            redirect(controller: 'user', action: 'index')
        }

    }


    def download(Long resourceId) {
        DocumentResource documentResource = Resource.get(resourceId)
        if (documentResource) {
            File file = new File(documentResource.filePath)
            if (file.exists()) {
                byte[] orderPDF = file.getBytes()
                response.setHeader("Content-disposition", "attachment; filename=" + (file.name?.contains('.pdf' ?
                        file.name : file.name + '.pdf')))
                response.contentLength = orderPDF.length
                response.contentType = 'application/pdf'
                response.outputStream << orderPDF
            } else {
                flash.error = "File doesnot exist on disk"
            }
        } else {
            flash.error = "Resource not found"
        }

    }

}
