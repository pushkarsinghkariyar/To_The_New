package com.ttnd.linksharing

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(LinksharingTagLib)
@Mock([Resource])
class LinksharingTagLibSpec extends Specification {

    @Unroll
    void "test trending topics tag"() {
        when:
        def tag = tagLib.trendingTopics()
        def rendered = render(template: '/topic/trendingTopics', model: [trendingTopics: Topic.getTrendingTopics()])

        then:
        tag == rendered


    }

    @Unroll
    void "test top posts topics tag"() {
        when:
        def tag = tagLib.trendingTopics()
        def rendered = render(template: '/resource/topPosts', model: [topPosts: Resource.topPost()])

        then:
        tag == rendered


    }
}
