package de.mvolleys.box.rest

import de.mvolleys.box.db.model.QuoteEntity
import de.mvolleys.box.db.repositories.QuoteRepository
import org.springframework.http.ResponseEntity
import de.mvolleys.box.persistency.increaseAndGetPersistentCounter
import org.springframework.web.bind.annotation.*

@CrossOrigin(originPatterns = ["http://*:*"])
@RestController
class MainController(val quoteRepository: QuoteRepository) {

    @GetMapping("/REST")
    fun restInfo(): ResponseEntity<String> {
        return ResponseEntity.ok().body(infoResponse)
    }

    @GetMapping("/counter")
    fun persistenz(): ResponseEntity<String> {
        val persistentCounter: Int = increaseAndGetPersistentCounter()
        return ResponseEntity.ok().body("this endpoint was called $persistentCounter times.")
    }

    @GetMapping("/quotes")
    fun getAllQuotes() : List<QuoteEntity> {
        return quoteRepository.findAll().toList()
    }

    @PostMapping("/quotes")
    fun addQuote(@RequestBody quote: QuoteEntity) {
        quoteRepository.save(quote)
    }
}


