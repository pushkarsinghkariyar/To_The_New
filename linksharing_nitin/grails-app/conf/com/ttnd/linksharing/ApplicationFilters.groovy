package com.ttnd.linksharing

class ApplicationFilters {

    def filters = {
        all(controller: '*', action: '*') {
            before = {
                log.info "Logging params: " + params
                log.info "UserAgent : " + request.getHeader("User-Agent")
                log.info "Controller Name: " + controllerName
                log.info "Resourc Name: " + actionName
                log.info "Logging params (REMOTE ADDRESS): " + request.remoteAddr
                log.info "Character Encoding: " + request.characterEncoding
            }
        }

        loginCheck(controller: '*', action: 'save|delete|update|changeIsRead|join|topicSave|topicDelete' +
                '|invite|titleUpdate') {
            before = {
                if (!session.user) {
                    redirect(controller: "login", action: "index")
                    return false
                }
            }

        }

        userIndexcheck(controller: 'user', action: 'index|toggleActive|showEditProfile|updatePassword') {
            before = {

                if (!session.user) {
                    redirect(controller: "login", action: "index")
                    return false
                }
            }
        }


        consoleCheck(controller: "console", action: "*") {
            before = {

                if (!(session.user?.admin)) {
                    println "inside console"
                    redirect(controller: "login", action: "index")
                    return false
                }
            }

        }

    }
}

