package org.publishers.repositories

import org.publishers.models.Publisher
import org.springframework.data.repository.CrudRepository
import java.util.*

interface PublishersRepository : CrudRepository<Publisher, UUID> {
    override fun findAll(): List<Publisher>
    override fun findById(id: UUID): Optional<Publisher>
    fun findByName(name: String): List<Publisher>
    fun save(publisher: Publisher): Publisher
}
