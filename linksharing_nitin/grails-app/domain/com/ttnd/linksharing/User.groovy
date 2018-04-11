package com.ttnd.linksharing

import com.ttnd.linksharing.co.SearchCO
import com.ttnd.linksharing.co.UserSearchCO
import com.ttnd.linksharing.vo.UserVO

class User {
    String email
    String username
    String password
    String firstName
    String lastName
    Boolean admin = false
    Boolean active = true
    Byte[] photo
    String confirmPassword
    Date dateCreated
    Date lastUpdated

    static hasMany = [topics         : Topic, subscriptions: Subscription, readingItems: ReadingItem, resources: Resource,
                      resourceRatings: ResourceRating]

    static transients = ['name', 'confirmPassword', 'subscribedTopics',]

    List<Topic> getSubscribedTopics() {
        Subscription.createCriteria().list {
            projections {
                property('topic')
            }
            eq('user', this)
        }
    }

    String getName() {
        return [firstName, lastName].findAll { it }.join(" ")
    }


    static constraints = {
        email(unique: true, email: true, blank: false)
        username(blank: false, unique: true)
        password(blank: false, minSize: 5)
        firstName(blank: false)
        lastName(blank: false)
        photo(nullable: true)
        admin(nullable: true, bindable: false)
        active(nullable: true)
        confirmPassword(bindable: true, nullable: true, blank: true, validator: { val, obj ->
            if (val != obj.password) {
                return 'com.ttnd.linksharing.User.confirmPassword.validator'
            }
        })


    }

    static mapping = {
        photo(sqlType: 'longBlob')
        sort(id: "desc")
    }

    static namedQueries = {
        search { UserSearchCO co ->
            if (co?.active != null) {
                eq('active', co.active)
            }
            if (co?.q) {
                or {
                    ilike('firstName', "%${co.q}%")
                    ilike('lastName', "%${co.q}%")
                    ilike('email', "%${co.q}%")
                    ilike('username', "%${co.q}%")
                }
            }
            eq('admin', false)
        }

    }

    String toString() {
        "Username: ${username}"
    }

    List<ReadingItem> fetchReadingItems(SearchCO co) {
        ReadingItem.createCriteria().list([max: co.max, offset: co.offset]) {
            eq('user', this)
        }
    }

    Boolean canDeleteResource(Long resourceId) {
        Resource resource = Resource.get(resourceId)
        (resource.createdBy?.id == this.id || this.admin)
    }


    Integer getScore(Long resourceId) {
        ResourceRating resourceRating = ResourceRating.findByUserAndResource(this, Resource.get(resourceId))
        resourceRating.score
    }

    Boolean isSubscribed(Long topicId) {
        Subscription.createCriteria().get {
            projections {
                property('topic.id')
            }
            eq('topic.id', topicId)
            eq('user', this)
        } as boolean
    }

    Subscription getSubscription(Long topicId) {
        Subscription.findByUserAndTopic(this, Topic.get(topicId))
    }

    Boolean isCreatorOf(Topic topic) {
        this == topic.createdBy
    }


    static List<UserVO> getNormalUsers(SearchCO co) {
        List<UserVO> users = []
        User.findAllByAdminNotEqual(true, [sort: co.sort, order: co.order]).each {
            users.add(new UserVO(id: it.id, email: it.email, username: it.username, password: it.password, firstName: it.firstName, lastName: it.lastName, active: it.active))
        }
        users
    }

    public User saveInstance() {
        this.validate()
        if (this.hasErrors()) {
            log.error("User has validation errors : ${this.errors}")
            return null
        }
        this.save(flush: true)
        log.info "${this} saved successfully"

        return this
    }


    List<Resource> unreadResources() {
        ReadingItem.createCriteria().list {
            projections {
                property('resource')
            }
            eq('user', this)
            eq('isRead', false)
        }
    }


}

