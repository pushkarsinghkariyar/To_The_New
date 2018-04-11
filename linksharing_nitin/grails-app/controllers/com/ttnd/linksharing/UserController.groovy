package com.ttnd.linksharing

import com.ttnd.linksharing.co.*
import com.ttnd.linksharing.vo.TopicVO
import com.ttnd.linksharing.vo.UserVO

class UserController {

    def assetResourceLocator
    def topicService
    def subscriptionService

    def index(SearchCO co) {
        User user = session.user
        co.max = co.max ?: 5
        co.offset = co.offset ?: 0
        def total = ReadingItem.countByUser(user)
        render(view: "dashboard", model: [subscribedTopics: user?.getSubscribedTopics(),
                                          readingItems    : user?.fetchReadingItems(co), total: total, co: co])
    }


    def image(Long userId) {
        User user = User.get(userId)
        byte[] photo
        if (!user?.photo) {
            photo = assetResourceLocator.findAssetForURI('user.png').byteArray

        } else {
            photo = user.photo
        }
        OutputStream out = response.getOutputStream()
        out.write(photo)
        out.flush()
        out.close()
    }

    def userValidate() {
        render !User.countByUsername(params.username) as Boolean

    }

    def emailValidate() {
        render !User.countByEmail(params.email) as Boolean
    }

    def profile(ResourceSearchCO resourceSearchCO) {
        User user = User.get(resourceSearchCO.id)
        if (session.user) {
            if (!(session.user.admin || (session.user.equals(User.load(resourceSearchCO.id))))) {
                resourceSearchCO.visibility = Visibility.PUBLIC
            }

        } else {
            resourceSearchCO.visibility = Visibility.PUBLIC
        }

        List<Resource> resources = Resource.search(resourceSearchCO).list()
        render view: 'profile', model: [user: user, resources: resources]

    }

    def topics(Long id) {
        TopicSearchCO co = new TopicSearchCO(id: id)
        User user = User.get(session.user?.id)
        if (session.user) {
            if (!(session.user.admin || user == User.get(id))) {
                co.visibility = Visibility.PUBLIC
            }
        } else {
            co.visibility = Visibility.PUBLIC
        }
        List<TopicVO> topicVOs = topicService.search(co)
        render(template: "/topic/list", model: [topics: topicVOs])
    }

    def subscriptions(Long id) {
//        List<TopicVO> createdTopics = []
        TopicSearchCO topicSearchCO = new TopicSearchCO(id: id)

        if (session.user) {
            if (!(session.user.admin || session.user.equals(User.load(id)))) {
                topicSearchCO.visibility = Visibility.PUBLIC
            }

        } else {
            topicSearchCO.visibility = Visibility.PUBLIC
        }

        List<TopicVO> subscribedTopics = subscriptionService.search(topicSearchCO)
        render template: "/topic/list", model: [topics: subscribedTopics]
    }

    def list(UserSearchCO co) {
        if (session.user.admin) {
            List<UserVO> normalUsers = []
            co.offset = co.offset ?: 0
            co.max = co.max ?: 1
            def total = User.countByAdmin(false)
            List<User> users = User.search(co).list([max: co.max, offset: co.offset, sort: co.sort, order: co.order])
            users.each {
                normalUsers.add(new UserVO(id: it.id, username: it.username, firstName: it.firstName, lastName: it.lastName, email: it.email, active: it.active))
            }
            render view: "list", model: [users: normalUsers, total: total, co: co]
        } else {
            flash.error = "permission denied"
            redirect controller: "user", action: "index"
        }
    }


    def toggleActive(Long id) {
        User user = User.get(id)
        if (user && !user.admin) {
            user.active = !user.active
            user.save(validate: false, flush: true)
            flash.message = "Activation status changed"
        } else {
            flash.error = "Permission denied"
        }
        redirect(controller: "user", action: "list")
    }


    def showEditProfile() {
        render(view: "edit", model: [user: session.user])
    }


    def save(UserCO co) {
        User user = User.findByEmail(co.email)
        if (user) {
            user.firstName = co.firstName
            user.lastName = co.lastName
            co.photo = request.getFile('photo').bytes
            if (co.photo) {
                user.photo = co.photo
            }
            user.confirmPassword = user.password
            if (user.save(flush: true)) {
                flash.message = "Profile updated successfully"
                session.user = user
            } else {
                flash.error = "Error updating profile"
            }
        } else {
            flash.error = "User Not Found"
        }
        redirect(controller: "user", action: "showEditProfile")
    }


    def updatePassword(UpdatePasswordCO co) {
        User user = co.getUser()
        if (user.password == co.oldPassword) {
            co.validate()
            if (co.hasErrors()) {
                flash.error = "Errors in form"
            } else {
                user.password = co.password
                user.confirmPassword = co.password
                if (user.save(flush: true)) {
                    flash.message = "Password changed successfully"
                    session.user = user
                } else {
                    flash.error = "Error in updating password"
                }
            }

        } else {
            flash.error = "Old Password do not match!"
        }
        redirect(controller: "user", action: "showEditProfile")
    }
}

