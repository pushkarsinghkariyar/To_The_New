package com.ttnd.linksharing

import com.ttnd.linksharing.dto.EmailDTO
import grails.gsp.PageRenderer
import grails.plugin.mail.MailService
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.springframework.mail.SimpleMailMessage
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(EmailService)
@Mock([User, Topic, Subscription])
class EmailServiceSpec extends Specification {

    private MailService mailService = Mock()
    private PageRenderer renderer = Mock()

    void setup() {
        mailService.sendMail(*_) >> new SimpleMailMessage()
        service.mailService = mailService
    }

    void "test mail Service"() {

        when:
        service.sendMail(new EmailDTO())

        then:
        1 * mailService.sendMail(*_)

    }

    @Unroll
    void "test invite"() {
        setup:
        service.metaClass.getSession = {
            [user: [firstName: "asdf"]]
        }
        service.metaClass.sendMail = { s ->
            return true
        }
        service.groovyPageRenderer = renderer
        renderer.render(*_) >> "1234"
        mailService.sendMail(*_) >> true
        service.mailService = mailService
        List<Topic> topics = [new Topic().save(false), new Topic().save(false)]
        List<User> users = [new User(email: "1234").save(false), new User(email: "2345").save(false)]

        expect:
        service.invite(1, "34434334") == false
        service.invite(10, "1234") == false
        service.invite(10, "123sdfghjk4") == false
        service.invite(1, "1234") == true
    }


}
