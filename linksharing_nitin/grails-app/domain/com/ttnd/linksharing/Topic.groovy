package com.ttnd.linksharing

import com.ttnd.linksharing.vo.TopicVO

class Topic {
    String name
    User createdBy
    Date dateCreated
    Date lastUpdated
    Visibility visibility

    static hasMany = [subscriptions: Subscription, resources: Resource]

    static transients = ['subscribedTopics']

    static constraints = {
        name(blank: false, unique: 'createdBy')
        visibility(nullable: false)
    }

    static mapping = {
        sort name: "asc"
    }

    def afterInsert() {
        Topic.withNewSession {
            Subscription subscription = new Subscription(user: this.createdBy, topic: this, seriousness: Seriousness.VERY_SERIOUS)
            subscription.save(flush: true)
            log.info "Subscription saved Successfully for owner of topic."
        }

    }


    static List<TopicVO> getTrendingTopics() {
        List<TopicVO> trendingTopics = []
        Resource.createCriteria().list {
            projections {
                createAlias('topic', 't')
                groupProperty('t.id')
                property('t.name')
                property('t.visibility')
                count('t.id', 'topicCount')
                property('t.createdBy')
            }

            order('topicCount', 'desc')
            order('t.name', 'asc')
            maxResults(5)
        }?.each {
            trendingTopics.add(new TopicVO(id: it[0], name: it[1], visibility: it[2], count: it[3], createdBy: it[4]))
        }

        trendingTopics
    }

    List<User> getSubscribedUsers() {
        Subscription.createCriteria().list {
            projections {
                property('user')
            }
            eq('topic.id', this.id)
        }
    }


    String toString() {
        return "${name}"

    }

    Boolean isPublic() {
        visibility == Visibility.PUBLIC
    }

    Boolean canViewedBy(User user) {
        (user?.admin || this.isPublic() || Subscription.findByUserAndTopic(user, this))
    }

}
