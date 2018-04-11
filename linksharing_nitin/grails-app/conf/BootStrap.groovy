import com.ttnd.linksharing.*

class BootStrap {


    def bootstrapService

    def init = { servletContext ->
        /*List<User> users = createUsers()
        List<Topic> topics = createTopics(users)
        List<Resource> resources = addResources(topics)
        List<Subscription> subscriptions = subscribeTopics(users, topics)
        List<ReadingItem> readingItems = createReadingItems()
        List<ResourceRating> resourceRatings = createResourceRating()
        */
        List<User> users = bootstrapService.createUsers()
        List<Topic> topics = bootstrapService.createTopics(users)
        List<Resource> resources = bootstrapService.addResources(topics)
        List<Subscription> subscriptions = bootstrapService.subscribeTopics(users, topics)
        List<ReadingItem> readingItems = bootstrapService.createReadingItems()
        List<ResourceRating> resourceRatings = bootstrapService.createResourceRating()
    }

    List<User> createUsers() {
        List<User> users = []
        if (User.count() == 0) {
            User admin = new User(email: "admin@gmail.com", username: "sysAdmin", password: DefaultPassword.DEFAULT_PASSWORD,
                    firstName: "Nitin", lastName: "Kumar Singh", admin: true, active: true, confirmPassword: DefaultPassword.DEFAULT_PASSWORD)

            if (admin.save(flush: true, failOnError: true)) {
                users.add(admin)
                log.info "User: ${admin} has been successfully saved"
            } else {
                log.error "Error saving: User ${admin}"
            }

            User user = new User(email: "normalUser@gmail.com", username: "normalUser", password: DefaultPassword.DEFAULT_PASSWORD,
                    firstName: "Nitish", lastName: "Singh", admin: false, active: true, confirmPassword: DefaultPassword.DEFAULT_PASSWORD)

            if (user.save(flush: true, failOnError: true)) {
                users.add(user)
                log.info "User: ${user} has been successfully saved"
            } else {
                log.error "Error saving: User ${user}"
            }

        }
        users
    }

    List<Topic> createTopics(List<User> users) {
        List<Topic> topics = []
        if (Topic.count() == 0) {
            5.times {
                Topic topic = new Topic(name: "TopicOfUser1:" + it, createdBy: users[0], visibility: Visibility.PUBLIC)
                if (topic.save(failOnError: true, flush: true)) {
                    topics.add(topic)
                    users[0].addToTopics(topic)
                    log.info "Topic: ${topic} saved successfully"

                } else {
                    log.error "Error saving Topic: ${topic}"
                }
            }
            5.times {
                Topic topic = new Topic(name: "TopicOfUser2:" + it, createdBy: users[1], visibility: Visibility.PUBLIC)
                if (topic.save(failOnError: true, flush: true)) {
                    topics.add(topic)
                    users[1].addToTopics(topic)
                    log.info "Topic: ${topic} saved successfully"

                } else {
                    log.error "Error saving Topic: ${topic}"
                }
            }
        }
        topics
    }


    List<Resource> addResources(List<Topic> topics) {
        List<Resource> resources = []
        if (Resource.count() == 0) {

            topics.each {
                Resource documentResource = new DocumentResource(filePath: "~/nitin/abc.docx", createdBy: it.createdBy,
                        description: "Topic: ${it}", topic: it)
                if (documentResource.save(flush: true, failOnError: true)) {
                    log.info "First DOCUMENT RESOURCE saved for topic Topic:${it}"
                } else {
                    log.error "Error Saving Document Resource ${documentResource.errors.allErrors}"
                }
                resources.add(documentResource)
                it.addToResources(documentResource)
                it.createdBy.addToResources(documentResource)
                documentResource = new DocumentResource(filePath: "~/nitin/abc1.docx", createdBy: it.createdBy,
                        description: "Topic : ${it}", topic: it)
                if (documentResource.save(flush: true, failOnError: true)) {
                    log.info "Second DOCUMENT RESOURCE saved for topic Topic:${it}"
                } else {
                    log.error "Error Saving Document Resource ${documentResource.errors.allErrors}}"
                }
                resources.add(documentResource)
                it.addToResources(documentResource)
                it.createdBy.addToResources(documentResource)
                Resource linkResource = new LinkResource(url: "http://www.google.com/image", createdBy: it.createdBy,
                        description: "First LINK Resource FOR TOPIC:${it}", topic: it)
                if (linkResource.save(flush: true, failOnError: true)) {
                    log.info "First LINK RESOURCE saved for topic Topic:${it}"
                } else {
                    log.error "Error Saving LINK Resource ${linkResource.errors.allErrors}"
                }
                resources.add(linkResource)
                it.addToResources(linkResource)
                it.createdBy.addToResources(linkResource)
                linkResource = new LinkResource(url: "http://www.google.com/pictures", createdBy: it.createdBy,
                        description: "Second LINK Resource FOR TOPIC:${it}", topic: it)
                if (linkResource.save(flush: true, failOnError: true)) {
                    log.info "Second LINK RESOURCE saved for topic Topic:${it}"
                } else {
                    log.error "Error Saving LINK Resource ${linkResource.errors.allErrors}"
                }
                resources.add(linkResource)
                it.addToResources(linkResource)
                it.createdBy.addToResources(linkResource)
            }
        }
        resources
    }

    List<Subscription> subscribeTopics(List<User> users, List<Topic> topics) {
        List<Subscription> subscriptions = []
        users.each { user ->
            topics.each { topic ->
                if (topic.createdBy != user) {

                    Subscription subscription = new Subscription(user: user, seriousness: Seriousness.VERY_SERIOUS, topic: topic)
                    if (subscription.save(flush: true, failOnError: true)) {
                        subscriptions.add(subscription)
                        topic.addToSubscriptions(subscription)
                        user.addToSubscriptions(subscription)
                        log.info "Subscription saved for Topic : ${topic} and User: ${user}"
                    } else {
                        log.error "ERROR: Topic : ${topic} and User: ${user} subscription unsuccessful"
                    }

                }

            }

        }
        subscriptions
    }

    /* List<ReadingItem> createReadingItems() {
         List<ReadingItem> readingItems = []
         List<User> users = User.list()
         users.each { user ->
             user.subscriptions.each { subscription ->
                 subscription.topic.resources.each { resource ->
                     if (resource.createdBy != user && !user.readingItems?.contains(resource)) {
                         ReadingItem readingItem = new ReadingItem(user: user, isRead: false, resource: resource)
                         if (readingItem.save(flush: true, failOnError: true)) {
                             user.addToReadingItems(readingItem)
                             readingItems.add(readingItem)
                             log.info "${readingItem} saved successfully for user ${user} and resource ${resource}"
                             readingItems.add(readingItem)
                         } else {
                             log.error "Error saving reading item: ${readingItem} for user: ${user} and resource: ${resource}"
                         }
                     }

                 }

             }
         }
         readingItems
     }*/

    List<ReadingItem> createReadingItems() {
        List<ReadingItem> readingItems = []
        List<User> users = User.list()
        users.each { user ->
            user.subscriptions.each { subscription ->
                subscription.topic.resources.each { resource ->
                    if (resource.createdBy != user && !user.readingItems?.contains(resource)) {
                        ReadingItem readingItem = new ReadingItem(user: user, isRead: false, resource: resource)
                        if (readingItem.save(flush: true, failOnError: true)) {
                            user.addToReadingItems(readingItem)
                            readingItems.add(readingItem)
                            log.info "${readingItem} saved successfully for user ${user} and resource ${resource}"
                            readingItems.add(readingItem)
                        } else {
                            log.error "Error saving reading item: ${readingItem} for user: ${user} and resource: ${resource}"
                        }
                    }

                }

            }
        }
        readingItems
    }

    List<ResourceRating> createResourceRating() {
        List<ResourceRating> resourceRatings = []
        List<User> users = User.list()
        users.each { user ->
            user.readingItems.each { readingItem ->
                if (!readingItem.isRead) {
                    ResourceRating resourceRating = new ResourceRating(user: user, score: 3, resource: readingItem.resource)
                    if (resourceRating.save(flush: false, failOnError: true)) {
                        resourceRatings.add(resourceRating)
                        user.addToResourceRatings(resourceRating)
                        log.info "Resource Rating for ${user} and resource:${readingItem.resource} created successfully"
                    } else {
                        log.error "Error Saving Resource Rating for ${user} and resource:${readingItem.resource}"
                    }
                }

            }

        }
        resourceRatings
    }

    def destroy = {
    }
}
