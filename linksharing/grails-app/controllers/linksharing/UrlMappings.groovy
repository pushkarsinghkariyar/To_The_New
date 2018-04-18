package linksharing

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "login", action: "index")
        "/topic/changeVisibility"(controller: 'topic', action: 'changeVisibility', method: 'POST')
        "/subscription/changeSeriousness"(controller: 'subscription', action: 'changeSeriousness', method: 'POST')
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
