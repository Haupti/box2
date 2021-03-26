package de.mvolleys.box.db.repo

import de.mvolleys.box.db.model.QuoteEntity
import de.mvolleys.box.db.repo.jpa.QuoteJpaRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataJpaTest
class QuoteJpaRepositoryTest @Autowired constructor(private val quoteRepository: QuoteJpaRepository) {

    private lateinit var quote: QuoteEntity

    @BeforeEach
    fun init() {
        quote = QuoteEntity("author", "quote", 0L)
    }

    @Test
    fun repositorySavesData() {
        val length: Int = quoteRepository.findAll().count()

        quoteRepository.save(quote)

        assertThat(quoteRepository.findAll().count()).isEqualTo(length + 1)
    }

    @Test
    fun repositoryLoadsDataCorrectly() {
        quoteRepository.save(quote)

        assertThat(quoteRepository.findAll().toList()).contains(quote)
    }

    private fun <T> MutableIterable<T>.count(): Int {
        var count: Int = 0
        for (element in this) {
            count += 1
        }
        return count
    }
}
