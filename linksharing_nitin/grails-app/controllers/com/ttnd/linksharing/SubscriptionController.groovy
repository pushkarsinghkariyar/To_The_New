package com.ttnd.linksharing

import grails.converters.JSON

class SubscriptionController {

    def index() {}

    def save(Integer id) {
        Map jsonObject = [:]
        Subscription subscription = new Subscription(user: User.get(session.user.id), topic: Topic.get(id))
        if (subscription.save(flush: true)) {
//            flash.message = "Subscription saved successfully"
            jsonObject.message = "Subscription saved successfully"
        } else {
//            flash.error = subscription.errors.allErrors.collect { message(error: it) }.join(", ")
            jsonObject.error = subscription.errors.allErrors.collect { message(error: it) }.join(", ")

        }
        redirect(controller: 'user', action: 'index')

    }

    def update(Integer id, String serious) {
        Map jsonObject = [:]
        Subscription subscription = Subscription.findByUserAndTopic(session.user, Topic.get(id))
        if (subscription && serious) {
            if (Seriousness.getEnum(serious) != null) {
                subscription.seriousness = Seriousness.getEnum(serious)
                if (subscription.save(flush: true, failOnError: true)) {
//                    render "Subscription saved successfully"
                    jsonObject.message = "Subscription saved successfully"

                } else {
//                    render "Error saving subscription"
                    jsonObject.error = "Error saving subscription"
                }
            } else {
//                render "Proper Seriousness string not provided"
                jsonObject.error = "Proper Seriousness string not provided"

            }

        } else {
//            render "Subscription not found Or seriousness not found"
            jsonObject.error = "Subscription not found Or seriousness not found"
        }
        render jsonObject as JSON
    }

    def delete(Integer id) {
        Subscription subscription = Subscription.load(id)
        if (subscription.topic.createdBy.id != session.user.id) {
            if (subscription) {
                subscription.delete(flush: true)
                flash.message = "Subscription deleted"
            } else {
                flash.error = "Error: Subscription not found"
            }
        } else {
            flash.error = "Creator can not delete subscription"
        }


        redirect(controller: 'user', action: 'index')
    }


}
