package topic

import vo.TopicVO

class TopicController {

    TopicService topicService

    def index() {}

    def show() {
        Long topicId = new Long(params.id)
        def infoMap = topicService.getCompleteTopicInfo(topicId)
        if (infoMap) {
            render(view: 'show', model: [topicVO     : infoMap.topicVO, subscribedUserList: infoMap.subscribedUserList,
                                         resourceList: infoMap.resourceList])
        } else {
            render("SOMETHING WENT WRONG")
        }
    }

    def save() {
        Topic newtopic = new Topic(createdBy: session.user, name: params.topicName, visibility: params.topicVisibility)
        if (!newtopic.save(flush: true)) {
            log.error("Error while saving- $newtopic")
            newtopic.errors.allErrors.each { println it }
            flash.error = "TOPIC NOT SAVED"
        } else {
            log.info("Saved Successfully : $newtopic")
            flash.message = "TOPIC SAVED SUCCESSFULLY"
            session.user.addToTopics(newtopic)
            flash.message = "SUCCESSFULLY SAVED"
            //session.user.save(flush: true)
        }
        redirect(controller: 'user', action: 'index')


    }

    def delete() {
        Topic proxytopic = Topic.load(params.topicId)
        if (!proxytopic) {
            flash.error = "NO SUCH TOPIC IN OUR DATABASE"
            render("NO SUCH TOPIC IN OUR DATABASE")
        } else {
            proxytopic.discard()
            proxytopic.delete(flush: true)
            //render("DELETED SUCCESSFULLY")
            redirect(controller: 'user', action: 'index')
        }
    }

    def changeName(){
        if(topicService.editTopicName(params)){
            flash.message = "Topic Name Changed Successfully"
        }else{
            flash.error= "Error Changing Topic Name"
        }
        redirect(controller: 'user',action: 'index')
    }

    def changeVisibility(){
        println "TopicController.changeVisibility"
        println "data ::" + params
        if(topicService.changeVisibility(params)){
            flash.message = "Updated"
        }else{
            flash.error = "Unable to Update"
        }
        redirect(controller: 'user', action: 'editProfile')
    }

}
