package com.flf

import spock.lang.Specification

class GreetingTest extends Specification {

    def 'Nobody greeting'() {
        given: '<Nobody>'
        def name

        when: 'greet nobody'
        def result = Greeting.greet(name)

        then: 'Is greeted as "Hello, my friend."'
        result == "Hello, my friend."
    }

    def 'Bob greeting'() {
        given: 'Bob'
        def name = "Bob"

        when: 'greet Bob'
        def result = Greeting.greet(name)

        then: 'Bob is greeted as "Hello, Bob."'
        result == "Hello, Bob."
    }

    def 'JERRY shout greeting'() {
        given: 'JERRY'
        def name = "JERRY"

        when: 'greet JERRY'
        def result = Greeting.greet(name)

        then: 'JERRY is shout greeted as "HELLO JERRY!"'
        result == "HELLO JERRY!"
    }

    def 'Two people greeting'() {
        given: 'Jill & Jane'
        def firstPersonName = "Jill"
        def secondPersonName = "Jane"

        when: 'greet them'
        def result = Greeting.greet(firstPersonName, secondPersonName)

        then: 'They are greeted as "Hello, Jill and Jane."'
        result == "Hello, Jill and Jane."
    }

    def 'Several people greeting'() {
        given: 'Amy, Brian & Charlotte'
        def firstPersonName = "Amy"
        def secondPersonName = "Brian"
        def thirdPersonName = "Charlotte"

        when: 'greet them'
        def result = Greeting.greet(firstPersonName, secondPersonName, thirdPersonName)

        then: 'They are greeted as "Hello, Amy, Brian, and Charlotte."'
        result == "Hello, Amy, Brian, and Charlotte."
    }

    def 'Several people with normal and a shouting greetings'() {
        given: 'Amy, Brian & Charlotte'
        def firstPersonName = "Amy"
        def secondPersonName = "BRIAN"
        def thirdPersonName = "Charlotte"

        when: 'greet them'
        def result = Greeting.greet(firstPersonName, secondPersonName, thirdPersonName)

        then: 'They are greeted as "Hello, Amy and Charlotte. AND HELLO BRIAN!"'
        result == "Hello, Amy and Charlotte. AND HELLO BRIAN!"
    }

    def 'Several people with normal and shouting greetings'() {
        given: 'Amy, Brian & Charlotte'
        def firstPersonName = "Amy"
        def secondPersonName = "BRIAN"
        def thirdPersonName = "Charlotte"
        def fourthPersonName = "JERRY"

        when: 'greet them'
        def result = Greeting.greet(firstPersonName, secondPersonName, thirdPersonName, fourthPersonName)

        then: 'They are greeted as "Hello, Amy and Charlotte. AND HELLO BRIAN AND JERRY!"'
        result == "Hello, Amy and Charlotte. AND HELLO BRIAN AND JERRY!"
    }

    def 'A lot of people with normal and shouting greetings'() {
        given: 'Amy, Brian & Charlotte'
        def firstPersonName = "Amy"
        def secondPersonName = "BRIAN"
        def thirdPersonName = "JILL"
        def fourthPersonName = "Charlotte"
        def fifthPersonName = "BOB"
        def sixthPersonName = "JERRY"
        def seventhPersonName = "Jane"

        when: 'greet them'
        def result = Greeting.greet(firstPersonName, secondPersonName, thirdPersonName, fourthPersonName, fifthPersonName, sixthPersonName, seventhPersonName)

        then: 'They are greeted as "Hello, Amy, Charlotte, and Jane. AND HELLO BRIAN, JILL, BOB AND JERRY!'
        result == "Hello, Amy, Charlotte, and Jane. AND HELLO BRIAN, JILL, BOB AND JERRY!"
    }

    def 'Comma separated names greetings'() {
        given: 'Bob, "Charlie, Dianne"'
        def firstPersonName = "Bob"
        def nextPersonNames = "Charlie, Dianne"

        when: 'greet them'
        def result = Greeting.greet(firstPersonName, nextPersonNames)

        then: 'They are greeted as "Hello, Bob, Charlie, and Dianne.'
        result == "Hello, Bob, Charlie, and Dianne."
    }
}
