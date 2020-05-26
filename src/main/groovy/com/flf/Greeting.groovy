package com.flf

import groovy.transform.CompileStatic

//@CompileStatic
class Greeting {

    private static String normalGreet( List names ) {
        def greeting
        switch (names.size()) {
            case 1:
                greeting = "Hello, ${names[0]}."
                break
            case 2:
                greeting = "Hello, ${names[0]} and ${names[1]}."
                break
            case { it > 2 }:
                greeting = 'Hello'
                names.each {
                    if ( it == names.last() ) {
                        greeting += ", and ${it}."
                    } else {
                        greeting += ", ${it}"
                    }
                }
                break
        }
        return greeting
    }

    private static String shoutGreet( List names ) {
        def greeting
        switch (names.size()) {
            case 1:
                greeting = "HELLO ${names[0]}!"
                break
            case 2:
                greeting = "HELLO ${names[0]} AND ${names[1]}!"
                break
            case { it > 2 }:
                greeting = 'HELLO '
                names.eachWithIndex { it, i ->
                    switch (i) {
                        case { i == names.size() - 1 }:
                            greeting += "AND ${it}!"
                            break
                        case { i == names.size() - 2 }:
                            greeting += "${it} "
                            break
                        default:
                            greeting += "${it}, "
                            break
                    }
                }
                break
        }
        return greeting
    }

    public static String greet( String... names ) {
        if ( names == null ) { return "Hello, my friend." }

        def normalNames = []
        def shoutNames = []
        def splitNames = names*.split(', ').flatten()
        splitNames.each {
            if ( it == it.toUpperCase() ) {
                shoutNames.add( it )
            }
            else{
                normalNames.add( it )
            }
        }

        if (normalNames && !shoutNames) { return normalGreet( normalNames ) }
        if (!normalNames && shoutNames) { return shoutGreet( shoutNames ) }
        if (normalNames && shoutNames) { return "${normalGreet( normalNames )} AND ${shoutGreet( shoutNames )}" }
    }
}