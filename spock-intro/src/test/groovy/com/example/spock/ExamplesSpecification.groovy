package com.example.spock

import spock.lang.Specification
import spock.lang.Unroll

//@Ignore
class ExamplesSpecification extends Specification {

    @Unroll("La somme de #x et #y vaut #sum")
    def "la somme de deux nombres"() {
        given:
        def blurp = new Examples()

        expect:
        blurp.sum(x, y) == sum

        where:
        x | y || sum
        1 | 1 || 2
        1 | 2 || 3
        2 | 2 || 5
        3 | 3 || 6

    }

    def "simulation d'une exception"() {
        given: "a mock of the File#exists method"
        def blurp = new Examples()
        def file = Mock(constructorArgs: [''], File)
        file.exists() >> { throw new RuntimeException("Simulate exception") }

        when: "we check if the file exists"
        blurp.exists(file)

        then: "an IOException is thrown"
        def e = thrown(IOException)
        e.message == 'Simulate exception'

    }

    def "mock and ordering"() {
        given:
        def source = ["a", "b", "c", "a"]
        def dest = Mock(List)
        when:
        source.each {
            dest << it
        }
        then:
        1 * dest.add("a")
        then:
        1 * dest.add("b")
        then:
        1 * dest.add("c")
        then:
        1 * dest.add("a")
    }

    def "test old value"() {
        given:
        int x = 1
        when:
        x++
        then:
        x == old(x) + 1
    }

    def "test scoping"() {
        given:
        def o = new Object()
        expect:
        println(System.identityHashCode(o))
        where:
        x << (0..10)
    }
}