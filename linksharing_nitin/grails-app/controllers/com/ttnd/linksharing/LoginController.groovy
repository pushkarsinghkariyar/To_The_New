package com.ttnd.linksharing

import com.ttnd.linksharing.co.ResourceSearchCO
import com.ttnd.linksharing.co.UserCO
import com.ttnd.linksharing.dto.EmailDTO

class LoginController {
    def emailService

    def index() {
        if (session?.user) {
            forward(controller: "user", action: "index")
        } else {
            render(view: "login", model: [recentPosts: Resource.getRecentShares()])
        }
        return false
    }

    def loginhandler(String username, String password) {
        User user = User.findByUsername(username)
        if (user && user.password == password) {
            if (user.active) {
                session["user"] = user
                redirect(controller: 'user', action: 'index')
            } else {
                flash.error = "Your account is not Active"
            }
        } else {
            flash.error = "User not found"
            redirect(controller: "login", action: "index")
        }
    }

    def logout() {
        session.invalidate()
        forward(controller: "login", action: "index")
    }

    def register(UserCO co) {
        co.photo = request.getFile('photo').bytes
        User user = new User()
        user.properties = co.properties
        if (user.save(flush: true)) {
            flash.message = "User Registration is successful"
            session.user = user

        } else {
            flash.error = user.errors.allErrors.collect { message(error: it) }.join(",")
        }
        forward(controller: 'login', action: 'index')
    }

    def forgotPassword(String emailId) {
        User user = User.findByEmail(emailId)
        if (user) {
            if (user.active) {
                EmailDTO emailDTO = new EmailDTO()
                emailDTO.to = []
                emailDTO.to.add(emailId)
                emailDTO.subject = "Forgot password"
                String newPassword = Utility.generatePassword()
                emailDTO.view = "/email/_password"
                emailDTO.model = [newPassword: newPassword]
                user.password = newPassword
                user.confirmPassword = newPassword
                if (user.saveInstance()) {

                    emailService.sendMail(emailDTO)
                    flash.message = "Mail sent with new password."
                } else {
                    flash.error = "Mail could not be sent."
                }
            } else {
                flash.error = "The user account corresponding to the entered email address is inactive."
            }
        } else {
            flash.error = "The email id doesn't belong to a registered user."
        }

        redirect(controller: "login", action: "index")
    }

    def globalSearch(ResourceSearchCO co) {
        Integer max = co.max ?: 5
        Integer offset = co.offset ?: 0
        if (!session.user) {
            co.visibility = Visibility.PUBLIC
        }
        List<Resource> resources = Resource.globalSearch(co).list([max: max, offset: offset])
        Integer total = resources.totalCount
        render(view: "/global/globalSearch", model: [resources: resources, co: co, total: total])

    }

}

