package org.publishers.models

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "publishers")
data class Publisher(
        @Id
        val id: UUID = UUID.randomUUID(),

        @Column(nullable = false)
        val name: String,

        val active: Boolean = true,

        val created_at: LocalDateTime = LocalDateTime.now(),

        @OneToOne
        @JoinColumn(name = "group_id")
        val group: Group? = null
)