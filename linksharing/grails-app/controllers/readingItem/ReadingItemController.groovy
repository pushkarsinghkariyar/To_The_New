package readingItem

import user.User

class ReadingItemController {

    ReadingItemService readingItemService

    def index() {}

    def changeisRead() {

        if (readingItemService.changeIsRead(params))
            flash.message = "MARKED AS READ"
        else
            flash.error = "ERROR"
        redirect(controller: 'user', action: 'index')
    }
}
