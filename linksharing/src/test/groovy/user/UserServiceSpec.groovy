package user

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import readingItem.ReadingItem
import resource.DocumentResource
import resource.Resource
import spock.lang.Specification
import spock.lang.Unroll
import user.User
import user.UserService



class UserServiceSpec extends Specification {

    private User user = Mock()
    private Resource resource = Mock()
    private UserService userService = Mock()

    @Unroll
    void "test getUnreadResources method"() {
        given:
        List<Resource> unreadresources = [new DocumentResource()]
        user.getUnReadResources() >> { return unreadresources }


        expect:
        user.resources.size() <= unreadresources.size()
    }

}


