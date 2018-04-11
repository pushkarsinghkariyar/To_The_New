package com.ttnd.linksharing

import com.ttnd.linksharing.co.ResourceSearchCO
import grails.converters.JSON

class TopicController {
    def emailService

    def index() {}

    def show(ResourceSearchCO co) {
        Topic topic = Topic.read(co.topicId)
        def total
        co.max = co.max ?: 2
        co.offset = co.offset ?: 0

        if (topic) {
            if (topic.visibility == Visibility.PUBLIC) {
                co.visibility = Visibility.PUBLIC
                List<Resource> resources = Resource.search(co).list([max: co.max, offset: co.offset])
                total = resources.totalCount
                render(view: '/topic/topicShow', model: [topic: topic, resources: resources, total: total, co: co])

            } else {
                if (topic.subscriptions?.user?.contains(session['user'])) {
                    List<Resource> resources = Resource.search(co).list([max: co.max, offset: co.offset])
                    total = resources.totalCount
                    render(view: '/topic/topicShow', model: [topic: topic, resources: resources, total: total, co: co])
                } else {
                    redirect(controller: 'login', action: 'index')
                    flash.error = "Error: Subscription not found"
                }
            }
        } else {
            redirect(controller: 'login', action: 'index')
            flash.error = "Error: Topic does not exist"
        }

    }

    def topicSave(String name, String visibility) {
        Map json = [:]
        User user = session.user
        Topic topic = Topic.findOrCreateByCreatedByAndName(user, name)
        topic.visibility = Visibility.getEnum(visibility)
        if (topic.save(flush: true)) {
            json.message = "${topic} saved Successfully"
            flash.message = "${topic} saved Successfully"
        } else {
            json.error = "Error saving ${topic} Not saved"
            flash.error = "Error saving ${topic} Not saved"
        }
        render json as JSON
    }


    def topicDelete(Long id) {

        Topic topic = Topic.get(id)
        User user = session.user

        if (topic) {
            if (user.admin || (topic.createdBy.id == user.id)) {
                topic.delete(flush: true)
                flash.message = "Topic Deleted"
            } else {
                flash.error = "Topic not accessible"
            }
        } else {
            flash.error = "Topic not accessible"

        }

        redirect(controller: 'login', action: 'index')
    }


    def invite(Long topic, String email) {
        if (topic && email) {
            if (emailService.invite(topic, email)) {
                flash.message = "Invitation Sent"
            } else {
                flash.error = "Invitation Not Sent"
            }
        }
        redirect(controller: 'login', action: 'index')
    }


    def join(Long id) {
        Topic topic = Topic.get(id)
        if (topic && session.user) {
            Subscription subscription = new Subscription(user: session.user, topic: topic)

            if (subscription.validate()) {
                subscription.save(flush: true)
                flash.message = "You have subscribed to this topic successfully."
            } else {
                flash.error = "Failure. Could not subscribe to the topic."
            }
        }
        redirect(controller: "login", action: "index")
    }

    def titleUpdate(Topic topic, String name) {
        Map json = [:]
        if (name) {
            topic.name = name
        }
        if (topic.save(flush: true)) {
            json.message = "Topic Name Updated"
        } else {
            json.error = "Unable to update topic name"
        }
        render json as JSON
    }
}
