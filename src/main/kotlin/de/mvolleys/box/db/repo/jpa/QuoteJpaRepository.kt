package de.mvolleys.box.db.repo.jpa

import de.mvolleys.box.db.model.QuoteEntity
import org.springframework.data.repository.CrudRepository

interface QuoteJpaRepository : CrudRepository<QuoteEntity, Long> {
    override fun findAll(): List<QuoteEntity>
}
