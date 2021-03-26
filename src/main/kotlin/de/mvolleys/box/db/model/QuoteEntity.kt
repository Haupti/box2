package de.mvolleys.box.db.model

import javax.persistence.*

@Entity
class QuoteEntity(
    @Column(nullable = false) var author: String,
    @Column(nullable = false) var quote: String,
    @Id @GeneratedValue var id: Long){
}
