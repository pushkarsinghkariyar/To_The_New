package com.ttnd.linksharing

class ResourceRatingController {

    def index() {}

    def save(Integer rating, Long resourceId) {
        render "RatingCalled" + rating
        User user = session.user
        Resource resource = Resource.get(resourceId)
        ResourceRating resourceRating = ResourceRating.findByUserAndResource(user, resource) ?: new ResourceRating(user: user, resource: resource)
        resourceRating.score = rating
        if (resourceRating.save(flush: true)) {
            render "Rating Saved"
        } else {
            render "Error In Rating"
        }

    }
}
