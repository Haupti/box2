package de.mvolleys.box

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import de.mvolleys.box.persistency.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PersistencyFacade {

    @Test
    fun convertToIntParsesEmptyStringCorrectly() {
        assertThat(convertToInt("")).isEqualTo(0)
        assertThat(convertToInt(" ")).isEqualTo(0)
        assertThat(convertToInt("3")).isEqualTo(3)
        assertThat(convertToInt("9999999")).isEqualTo(9999999)
    }

    @Test
    fun readandwrite(){
        createFile()
        assertThat(readPersistentCounter()).isEqualTo(0)
        savePersistentCounter(1)
        assertThat(readPersistentCounter()).isEqualTo(1)
        increaseAndGetPersistentCounter()
        assertThat(readPersistentCounter()).isEqualTo(2)
    }
}
