package com.ttnd.linksharing

import com.ttnd.linksharing.co.ResourceSearchCO
import com.ttnd.linksharing.vo.RatingInfoVO

abstract class Resource {
    User createdBy
    String description
    Date dateCreated
    Date lastUpdated

    static transients = ['ratingInfo']
    static belongsTo = [topic: Topic]
    static hasMany = [ratings: ResourceRating, readingItems: ReadingItem]

    RatingInfoVO getRatingInfo() {
        List result = ResourceRating.createCriteria().get {
            projections {
                count('score')
                avg('score')
                sum('score')
            }
            resource {
                eq('id', this.id)
            }
        }
        new RatingInfoVO(totalVotes: result[0], averageScore: result[1], totalScore: result[1])


    }

    static constraints = {
        description(blank: false)
    }

    static mapping = {
        description(type: 'text')

    }

    static namedQueries = {
        search { ResourceSearchCO co ->
            if (co?.q) {
                ilike('description', "%${co.q}%")
            }

            if (co?.topicId) {
                topic {
                    eq('id', co.topicId)
                    eq('visibility', co.visibility)
                }
            }
            if (co?.id) {
                eq('createdBy.id', co.id)
            }
        }

        globalSearch { ResourceSearchCO co ->
            if (co?.q) {
                ilike('description', "%${co.q}%")
            }

            if (co?.visibility) {
                'topic' {
                    or {
                        eq('visibility', co.visibility)
                        ilike('name', "%${co.q}%")
                    }
                }
            }
        }

    }

    static List<Resource> topPost() {
        List resourceIds = ResourceRating.createCriteria().list {
            projections {
                property('resource.id')
            }
            groupProperty('resource.id')
            count('resource.id', 'resourceCount')
            order('resourceCount', 'desc')
            maxResults(5)
        }

        List<Resource> resources = Resource.getAll(resourceIds)
        return resources
    }

    static List<Resource> getRecentShares() {
        List<Resource> shares = Resource.createCriteria().list() {
            createAlias('topic', 't')
            eq('t.visibility', Visibility.PUBLIC)
            order('lastUpdated', 'desc')
            maxResults 5
        }
        shares
    }


    Boolean resourceType() {
        this.instanceOf(DocumentResource)
    }

    Boolean canViewedBy(User user) {
        this.topic.canViewedBy(user)
    }

    def deleteResource() {
        log.info "Resource Deleted"
    }

    static List usersWithUnreadResources() {
        ReadingItem.createCriteria().listDistinct {
            projections {
                property('user')
            }
            eq('isRead', false)
        }
    }

}
