package invitation

import grails.plugins.mail.MailService
import topic.Topic

class InvitationController {

    MailService mailService

    def sendMail() {
        println("printing params : " + params)
        println "InvitationController sendMail >> " + params.recieverEmail
        println "InvitationController bean >> " + mailService

        //

        mailService.sendMail {
            to "${params.recieverEmail}"
            subject "Regarding Invitation For Topic : ${params.topicName}"
            text """Hey checkout this interesting topic I came across. 
<a href = "http://localhost:8080/subscription/subscribeThroughEmail')}">Click Here</a>
"""
        }
        flash.message= "invitation send successfully"
        redirect(controller: 'user', action: 'index')
    }
}
