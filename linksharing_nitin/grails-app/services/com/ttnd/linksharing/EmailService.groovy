package com.ttnd.linksharing

import com.ttnd.linksharing.dto.EmailDTO
import grails.transaction.Transactional
import org.springframework.web.context.request.RequestContextHolder

@Transactional
class EmailService {
    def groovyPageRenderer
    def mailService
    def grailsApplication
    /*
     void sendMail(EmailDTO emailDTO) {
         def content
         if (emailDTO.model.newPassword)
             content = groovyPageRenderer.render(template: "/email/password", model: [newPassword: emailDTO.model.newPassword])
         else
             content = groovyPageRenderer.render(template: "/email/invite", model: [topicId: emailDTO.model.id, hostURL: emailDTO.model.hostURL])

         mailService.sendMail {
             to emailDTO.to
             subject emailDTO.subject
             html content
         }
     }
    */

    def sendMail(EmailDTO emailDTO) {
        mailService.sendMail {
            to emailDTO.to.toArray()
            subject emailDTO.subject
            if (emailDTO.content) {
                html emailDTO.content
            } else {
                body(view: emailDTO.view, model: emailDTO.model)
            }
        }
    }

    def invite(Long id, String email) {
        Topic topic = Topic.get(id)
        User user = User.findByEmail(email)
        if (topic && user) {
            def session = getSession()
            EmailDTO emailDto = new EmailDTO()
            emailDto.to = []
            emailDto.to.add(email)
            emailDto.subject = "Topic Invitation"
            emailDto.content = groovyPageRenderer.render(template: "/topic/invite", model: [userName: session.user.firstName, topicName: topic.name, email: email, topicId: topic.id, base: grailsApplication.config.grails.serverBaseURL])

            if (sendMail(emailDto)) {
                return true
            }
        } else {
            return false

        }
    }

    def getSession() {
        RequestContextHolder.currentRequestAttributes().getSession()
    }

    def sendUnreadResourcesMail(User user, List<Resource> unreadResources) {
        EmailDTO emailDTO = new EmailDTO(
                to: [user.email],
                subject: "You have unread items",
                content: groovyPageRenderer.render(template: '/resource/unreadResources', model: [user           : user,
                                                                                                 unreadResources: unreadResources])
        )
        sendMail(emailDTO)
    }

}
