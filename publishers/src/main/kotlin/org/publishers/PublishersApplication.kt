package org.publishers

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@SpringBootApplication
@EnableJpaRepositories("org.publishers.repositories")
class PublishersApplication

fun main(args: Array<String>) {
	runApplication<PublishersApplication>(*args)
}
