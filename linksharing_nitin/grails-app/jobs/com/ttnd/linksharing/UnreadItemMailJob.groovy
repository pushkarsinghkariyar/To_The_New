package com.ttnd.linksharing



class UnreadItemMailJob {
    def userService
    static triggers = {
        // simple repeatInterval: 5000l // execute job once in 5 seconds
        cron cronExpression: "0 0 1 ? * 2"
    }

    def execute() {
        userService.sendUnreadItemsMail()
    }
}
