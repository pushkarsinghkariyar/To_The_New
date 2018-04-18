package linksharing

import co.TrendingTopicsCO
import grails.gorm.transactions.Transactional
import resource.Resource
import topic.Topic
import user.User
import vo.ResourceVO
import vo.TopPostsVO
import vo.TopicVO
import vo.TrendingTopicsVO

@Transactional
class SearchService {

    def serviceMethod() {

    }

    def showSearchResults(String searchObject, User user) {
        List<Topic> topicList = Topic.findAllByNameIlike("%${searchObject}%")

        List<TopicVO> searchResults = []
        if (topicList) {
            topicList.each {
                searchResults.add(new TopicVO(topicId: it.id, topicName: it.name, topicVisibility: it.visibility,
                        ownerName: it.createdBy.getName(), ownerUsername: it.createdBy.username,
                        subscriptionCount: it.subscriptions.size(), resourcesCount: it.resources.size()))
            }
        }
        List<Resource> resources = []
        topicList.each {
            Resource.findAllByTopic(it).each {resources.add(it)}
        }
        List<ResourceVO> resourceList = []
        Boolean isLink
        resources.each {
            if (it.class == resource.LinkResource) {
                isLink = true
            } else {
                isLink = false
            }
            resourceList.add(new ResourceVO(resourceId: it.id, topicId: it.topic.id, resourceDescription: it.description,
                    ownerName: it.createdBy.getName(), ownerUsername: it.createdBy.username, topicName: it.topic.name,isLink: isLink))
        }


        List<TopPostsVO> topPostsList = Resource.getTopPost()

        List<TrendingTopicsVO> trendingTopicsList = []

        if (user)
            trendingTopicsList = Topic.getTrendingTopics(new TrendingTopicsCO(sessionUser: user))
        else
            trendingTopicsList = Topic.getTrendingTopics(new TrendingTopicsCO(sessionUser: null))

        Map map = [searchResults: searchResults, topPostsList: topPostsList, trendingTopicsList: trendingTopicsList,resourceList:resourceList]

        return map
    }
}
