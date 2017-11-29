package com.flf

import com.flf.*

class GreetingTest extends GroovyTestCase {

    void testGreeting() {
        assertToString(Greeting.greet("Bob"), "Hello, Bob.")
    }

    void testNullGreeting() {
        assertToString(Greeting.greet(null), "Hello, my friend.")
    }

    void testShoutGreeting() {
        assertToString(Greeting.greet("JERRY"), "HELLO JERRY!")
    }

    void testTwoGreetings() {
        assertToString(Greeting.greet("Jill", "Jane"), "Hello, Jill and Jane.")
    }

    void testMultipleGreetings() {
        assertToString(Greeting.greet("Amy", "Brian", "Charlotte"), "Hello, Amy, Brian, and Charlotte.")
    }

    void testMultipleMixedGreetings() {
        assertToString(Greeting.greet("Amy", "BRIAN", "Charlotte"), "Hello, Amy and Charlotte. AND HELLO BRIAN!")
    }

    void testMultiplesMixedGreetings() {
        assertToString(Greeting.greet("Amy", "BRIAN", "Charlotte", "JERRY"), "Hello, Amy and Charlotte. AND HELLO BRIAN AND JERRY!")
    }

    void testALotOfMixedGreetings() {
        assertToString(Greeting.greet("Amy", "BRIAN", "JILL", "Charlotte", "BOB", "JERRY", "Jane"), "Hello, Amy, Charlotte, and Jane. AND HELLO BRIAN, JILL, BOB AND JERRY!")
    }

    void testCommaSeparatedGreetings() {
        assertToString(Greeting.greet("Bob", "Charlie, Dianne"), "Hello, Bob, Charlie, and Dianne.")
    }
}