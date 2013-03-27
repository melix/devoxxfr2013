package com.example.live

import com.example.toto.Adder
import spock.lang.Specification

class MaSpec extends Specification {
    def "somme de deux nombres"() {
        given:
            def adder = new Adder()
        when:
            def x = adder.sum(y,z)
        then:
            x == 4
    }
}
