package com.ttnd.linksharing

import com.ttnd.linksharing.co.TopicSearchCO

class Subscription {
    User user
    Seriousness seriousness = Seriousness.SERIOUS
    Date dateCreated
    Date lastUpdated

    static belongsTo = [topic: Topic, user: User]

    static constraints = {
        user(unique: 'topic')
    }


    static namedQueries = {
        search { TopicSearchCO co ->
            if (co?.q) {
                'topic' {
                    ilike('name', "%${co.q}%")
                }
            }

            if (co?.id) {
                eq('user.id', co.id)
            }


        }

    }
}
