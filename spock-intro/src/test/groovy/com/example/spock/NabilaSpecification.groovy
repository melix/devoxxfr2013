package com.example.spock

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

//@Ignore
class NabilaSpecification extends Specification {

    def "Le monologue de Nabila"() {
        given:
        def p = new Nabila()

        expect:
        p.speak() == 'allo?'
    }

    def "Conversation avec Nabila"() {
        given:
        def nabila = new Nabila()
        def receiver = Mock(Person)
        def conversation = new Chatter(nabila, receiver)

        receiver.speak() >>> ['allo', "oui j'écoute", "je crois que vous faites erreur", null]

        when:
        conversation.start()

        then:
        1 * receiver.listen('allo?')
        then:
        1 * receiver.listen("non mais allo, quoi")
        then:
        1 * receiver.listen("t'es une fille t'as pas de shampoing")
        then:
        1 * _
        then:
        //1 * receiver.listen('toto')
        //1 * receiver.listen('allo?')
        //1 * receiver.listen("je sais pas vous me recevez?")
        //1 * receiver.listen("t'es une fille t'as pas de shampoing")
        //1 * receiver.listen("c'est comme si je te dis t'es une fille t'as pas de cheveux")
        then:
        0 * receiver./l(.+)n/(_)
    }

    @Unroll("Iteration #x")
    def "test scope"() {
        setup:
            def o = new Object()

        expect:
            println(System.identityHashCode(o))

        where:
            x << ["a","b","c"]
    }
}
