package com.ttnd.linksharing.vo

import com.ttnd.linksharing.User
import com.ttnd.linksharing.Visibility

class TopicVO {
    Integer id
    String name
    Visibility visibility
    Integer count
    User createdBy

    String toString() {
        "Id:${id},Name:${name},Visibilty:${visibility},Count:${count},User:${createdBy.name}"
    }
}
