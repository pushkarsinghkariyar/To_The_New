package resource

import enumeration.Visibility
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll
import topic.Topic
import user.User
/*
//@TestFor(LinkResourceController)
//@Mock([ApplicationFilters, LinkResource, Resource, User])
class LinkResourceControllerSpec extends Specification {

    @Unroll
    void "testing application filter on Resource delete action"() {
        given:
        LinkResource linkResource = new LinkResource()
        when:
        withFilters(action: "save") {
            controller.save(linkResource)
        }
        then:
        response.redirectedUrl == "/"

    }

    @Unroll
    void "testing update"() {
        given:
        LinkResource linkResource = new LinkResource(description: "1223")
        linkResource.save()
        Long id = 1
        String description = "1223"
        when:
        controller.update(id, description)

        then:
        response.redirectedUrl == "/resource/show"
        flash.error == "Failed to update  Resource"

    }


    def "check save link resource failure"() {

        given:
        User user = new User(id: 1)
        Topic topic = new Topic(id: 1, createdBy: user)
        Resource linkresource = new LinkResource(description: "link resource",
                createdBy: user, topic: topic, url: "https://www.googlealkfdg/")

        when:
        controller.save(linkresource)

        then:
        flash.error == "Error saving resource"
        response.redirectedUrl == "/"

    }

    @Unroll
    def "check link resource success"() {

        given:
        User user = new User(email: "pushkar.singh@tothenew.com", username: "pushkar", password: DefaultPassword.DEFAULT_PASSWORD,
                firstName: "pushkar", lastName: "singh", admin: true, active: true, confirmPassword: DefaultPassword.DEFAULT_PASSWORD)
        user.save(flush: true)
        session["user"] = user

        and:
        Topic topic = new Topic(name: "topic", visibility: Visibility.PUBLIC, createdBy: user)
        topic.save(flush: true)

        and:
        Resource linkresource = new LinkResource(description: "link resource",
                createdBy: user, topic: topic, url: "https://www.google.com")

        when:
        controller.save(linkresource)

        then:
        flash.message == "Resource saved Successfully"
        response.redirectedUrl == "/"

    }

}*/