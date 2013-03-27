package com.example.spock

import geb.spock.GebSpec
import spock.lang.Ignore

//@Ignore
class WebSpecification  extends GebSpec {
    def "Check the Groovy website"() {
        when: "we open the root page"
            go '/'
        then: "the title contains Groovy"
            title =~ 'Groovy'

        when: "we click the download link"
            $('a', href: contains('Download')).click()

        then: "the title of the page contains Download"
            title =~ "Download"
        and: "a link to Groovy 2.1.2 is found"
            $('h3', id: 'Download-Groovy212').text() == 'Groovy 2.1.2'
    }
}
