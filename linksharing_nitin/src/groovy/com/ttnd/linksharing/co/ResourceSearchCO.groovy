package com.ttnd.linksharing.co

import com.ttnd.linksharing.User
import com.ttnd.linksharing.Visibility

class ResourceSearchCO extends SearchCO {
    Long topicId
    Long id
    Visibility visibility

    User getUser() {
        User.get(id)
    }

}
