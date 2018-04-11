package com.ttnd.linksharing

//import com.ttnd.linksharing.ApplicationFilters
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ResourceController)
@Mock([ApplicationFilters])
class ResourceControllerSpec extends Specification {
    @Unroll
    void "testing application filter on Resource delete action"() {
        given:
        Long id = 1
        when:
        withFilters(action: "delete") {
            controller.delete(id)
        }
        then:
        response.redirectedUrl == "/"

    }


}
