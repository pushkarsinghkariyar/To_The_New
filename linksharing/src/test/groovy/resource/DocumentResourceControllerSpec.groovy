package resource

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll
import topic.Topic
/*
//@TestFor(DocumentResourceController)
//@Mock([ApplicationFilters, DocumentResource, Resource])
class DocumentResourceControllerSpec extends Specification {

    @Unroll
    void "testing application filter on Resource delete action"() {
        given:
        DocumentResource documentResource = new DocumentResource()
        when:
        withFilters(action: "save") {
            controller.save(documentResource)
        }
        then:
        response.redirectedUrl == "/"

    }

    @Unroll
    void "testing download document resource"() {
        given:
        Long id = 2
        DocumentResource documentResource = new DocumentResource(topic: new Topic(), createdBy: new User(), description: "123")
        documentResource.save()
        when:
        controller.download(id)

        then:
        flash.error == "Resource not found"

    }


}*/