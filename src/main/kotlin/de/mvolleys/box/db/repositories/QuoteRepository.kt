package de.mvolleys.box.db.repositories

import de.mvolleys.box.db.model.QuoteEntity
import org.springframework.data.repository.CrudRepository

interface QuoteRepository : CrudRepository<QuoteEntity, Long>
