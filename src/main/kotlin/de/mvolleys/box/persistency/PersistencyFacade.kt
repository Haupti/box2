package de.mvolleys.box.persistency

import java.io.File
import java.io.FileNotFoundException


const val COUNTER_FILENAME: String = "counter.txt"
const val NUMBER_IDENTIFIER: String = "n: "

fun increaseAndGetPersistentCounter(): Int {
    val persistentCounter: Int = increaseByOne(readPersistentCounter())
    savePersistentCounter(persistentCounter)
    return persistentCounter
}

fun readPersistentCounter(): Int {
    return try {
        convertToInt(File(COUNTER_FILENAME).bufferedReader().use { it.readText() }.replace(NUMBER_IDENTIFIER,""))
    } catch (e: FileNotFoundException) {
        createFile()
        0
    }
}

fun convertToInt(readText: String): Int {
    return if (readText.isBlank()) 0 else readText.toInt()
}

fun createFile() {
    File(COUNTER_FILENAME).createNewFile()
    File(COUNTER_FILENAME).bufferedWriter().use { out -> out.write(NUMBER_IDENTIFIER+"0") }
}

fun savePersistentCounter(persistentCounter: Int) {
    File(COUNTER_FILENAME).bufferedWriter().use { out -> out.write(NUMBER_IDENTIFIER+persistentCounter.toString()) }
}

fun increaseByOne(number: Int): Int {
    return number + 1
}


