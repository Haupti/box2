package de.mvolleys.box

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BoxApplication

fun main(args: Array<String>) {
    runApplication<BoxApplication>(*args)
}
