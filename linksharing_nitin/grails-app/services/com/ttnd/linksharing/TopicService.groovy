package com.ttnd.linksharing

import com.ttnd.linksharing.co.TopicSearchCO
import com.ttnd.linksharing.vo.TopicVO
import grails.transaction.Transactional

@Transactional
class TopicService {

    def serviceMethod() {

    }

    def search(TopicSearchCO co) {
        List<TopicVO> createdTopics = []

        if (co.id) {
            User user = co.getUser()

            List<Topic> topicList = Topic.createCriteria().list() {
                eq('createdBy.id', co.id)

                if (co.visibility)
                    eq('visibility', co.visibility)
            }

            topicList.each {
                topic -> createdTopics.add(new TopicVO(id: topic.id, name: topic.name, visibility: topic.visibility, createdBy: topic.createdBy))
            }

        }
        return createdTopics
    }
}
