package org.publishers.models

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "groups")
data class Group(
        @Id
        val id: UUID = UUID.randomUUID(),

        @Column(nullable = false)
        val name: String,

        val created_at: LocalDateTime = LocalDateTime.now()
)

