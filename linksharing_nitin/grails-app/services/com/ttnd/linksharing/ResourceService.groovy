package com.ttnd.linksharing

import com.ttnd.linksharing.co.ResourceSearchCO
import grails.transaction.Transactional

@Transactional
class ResourceService {

    def search(ResourceSearchCO co) {
        Resource.search(co).list()

    }
}
