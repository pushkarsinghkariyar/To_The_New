package subscription

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll
import topic.Topic
import user.User

@TestFor(SubscriptionController)
@Mock(Subscription)
class SubscriptionControllerSpec extends Specification {

    @Unroll
    void "test creator can not delete his subscription"() {

        given:
        Topic topic = new Topic(createdBy: new User())
        session.user = new User(id: 1)
        List<Subscription> subscriptions = [new Subscription(topic: topic).save(validate: false)]
        Subscription.metaClass.delete = { Map map ->
            return "true"
        }

        when:
        controller.delete(1)

        then:
        flash.error == "Creator can not delete subscription"
    }
}