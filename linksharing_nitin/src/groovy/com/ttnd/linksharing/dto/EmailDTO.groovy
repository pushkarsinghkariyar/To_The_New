package com.ttnd.linksharing.dto

import grails.validation.Validateable

@Validateable
class EmailDTO {
    List<String> to
    String subject
    String view
    String content
    Map model

    static constraints = {
        model(nullable: true)
    }
}
