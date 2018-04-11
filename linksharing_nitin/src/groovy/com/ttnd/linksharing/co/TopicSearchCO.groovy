package com.ttnd.linksharing.co

import com.ttnd.linksharing.User
import com.ttnd.linksharing.Visibility

class TopicSearchCO extends SearchCO {
    Visibility visibility
    Long id

    User getUser() {
        User.get(id)
    }
}
