package de.mvolleys.box.db.repo

import de.mvolleys.box.db.repo.jpa.QuoteJpaRepository
import org.springframework.beans.factory.annotation.Autowired

class QuoteRepository{

    @Autowired
    private lateinit var jpaRepo: QuoteJpaRepository

}
