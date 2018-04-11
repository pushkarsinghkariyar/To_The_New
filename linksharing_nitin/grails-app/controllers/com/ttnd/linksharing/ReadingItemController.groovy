package com.ttnd.linksharing

import grails.converters.JSON

class ReadingItemController {

    def changeIsRead(Long id) {
        Map json = [:]
        ReadingItem readingItem = ReadingItem.read(id)
        json.status = readingItem.isRead
        if (ReadingItem.executeUpdate("""
             update ReadingItem set isRead=:isRead where id=:id""",
                [isRead: !readingItem.isRead, id: readingItem.id])) {
            json.message = "ReadingItem changed"
            json.status = !json.status
        } else {
            json.error = "Error Updating reading item."

        }

        render json as JSON
    }
}
