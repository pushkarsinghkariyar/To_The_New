package com.ttnd.linksharing


class ResourceRating {
    User user
    Integer score
    Date dateCreated
    Date lastUpdated

    static belongsTo = [resource: Resource]
    static constraints = {
        score(range: 1..5)
        resource(unique: 'user')

    }
}
