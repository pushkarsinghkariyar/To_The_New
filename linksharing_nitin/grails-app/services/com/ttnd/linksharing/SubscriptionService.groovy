package com.ttnd.linksharing

import com.ttnd.linksharing.co.TopicSearchCO
import grails.transaction.Transactional

@Transactional
class SubscriptionService {

//to get subscribed topics of user
    def search(TopicSearchCO co) {
        if (co.id) {
            User user = co.getUser()
            return user.getSubscribedTopics()
        }
    }
}
