package com.ttnd.linksharing

class ReadingItem {
    User user
    Boolean isRead
    Date dateCreated
    Date lastUpdated

    static belongsTo = [resource: Resource]

    static constraints = {
        resource(unique: 'user')
    }

    String toString() {
        "User:${user.firstName},Read:${isRead}"
    }
}
