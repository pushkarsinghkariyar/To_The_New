package com.ttnd.linksharing

import grails.transaction.Transactional

@Transactional
class UserService {
    def emailService

    def sendUnreadItemsMail() {
        getUsersWithUnreadItems().each { user ->
            emailService.sendUnreadResourcesMail(user, getUnreadResources(user))
        }
    }

    List<User> getUsersWithUnreadItems() {
        return Resource.usersWithUnreadResources()
    }

    List<Resource> getUnreadResources(User user) {
        return user.unreadResources()
    }
}
