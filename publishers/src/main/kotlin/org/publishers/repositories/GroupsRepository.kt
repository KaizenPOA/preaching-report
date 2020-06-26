package org.publishers.repositories

import org.publishers.models.Group
import org.springframework.data.repository.CrudRepository
import java.util.*

interface GroupsRepository : CrudRepository<Group, UUID> {
    override fun findAll(): List<Group>
    override fun findById(id: UUID): Optional<Group>
    fun save(group: Group): Group
    fun findByName(name: String): List<Group>
}